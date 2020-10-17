package com.codepath.apps.restclienttemplate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.codepath.apps.restclienttemplate.models.Tweet;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;

public class TimelineActivity extends AppCompatActivity {
    public static final String TAG = "TimelineActivity";
    TwitterClient client;
    RecyclerView rvTweets;
    List<Tweet> tweets;
    TweetAdapter adapter;
    SwipeRefreshLayout swipeContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        client = TwitterApplication.getRestClient(this);

        swipeContainer = findViewById(R.id.swipeContainer);
        // Configure the refreshing colors
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);


        // Adding swipe listener
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Log.d(TAG, "Fetching new data");
                populateHomeTimeline();
            }
        });

        // Find the recycler view
        rvTweets = findViewById(R.id.rvTweets);

        // Initialize the list of tweets and adapter
        tweets = new ArrayList<>();
        adapter = new TweetAdapter(this, tweets);

        // REcycler view setup; layout manager and adapter
        rvTweets.setAdapter(adapter);
        rvTweets.setLayoutManager(new LinearLayoutManager(this));

        populateHomeTimeline();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // If the menu id is the compose id, that means it was tapped
        if (item.getItemId() == R.id.compose) {
            // Menu item has been tapped

            // Navigate to the compose item section
            Intent intent = new Intent(this, ComposeActivity.class);
            startActivity(intent);
            // We also want to get activity back from what was composed
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void populateHomeTimeline() {
        client.getHomeTimeline(new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                Log.i(TAG, "On Success\n" + json.toString());

                JSONArray jsonArray = json.jsonArray;
                try {
                    adapter.clear();
                    adapter.addAll(Tweet.fromJsonArray(jsonArray));
                    swipeContainer.setRefreshing(false);
                } catch (JSONException e) {
                    Log.d(TAG, "Error when parsing json");
                    e.printStackTrace();
                }

                // Create a tweet - i feel like "add all" comes into play
                // Somehow get json array
                // Use tweet method fromJsonArray to create a list of tweets

            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
                Log.i(TAG, "On Failure", throwable);


            }
        });
    }
}