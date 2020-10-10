package com.codepath.apps.restclienttemplate;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import java.util.List;

// Create Model
// Create ViewHolder
// Bind data
public class TweetAdapter extends RecyclerView.Adapter<TweetAdapter.ViewHolder>{
    Context context;
    List<Tweet> tweets;

    public TweetAdapter(Context context, List<Tweet> tweets) {
        this.context = context;
        this.tweets = tweets;
    }


    // Inflate the layout
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("TweetAdapter", "onCreateViewHolder");
        View tweetView = LayoutInflater.from(context).inflate(R.layout.item_tweet, parent, false);
        return new ViewHolder(tweetView);
    }

    // Inflate layout for each row
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("TweetAdapter", "onBindViewHolder");
        
        // Get tweet at position
        Tweet tweet = tweets.get(position);
        
        // Bind the tweet
        holder.bind(tweet);

    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }

    // Clean all elements in the recycler view
    public void clear() {
        tweets.clear();
        notifyDataSetChanged();
    }

    // Add list of items to our data set
    public void addAll(List<Tweet> tweetList) {
        tweets.addAll(tweetList);
        notifyDataSetChanged();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout container;
        ImageView profile;
        TextView screenName;
        TextView body;
        TextView time;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profile = itemView.findViewById(R.id.ivProfile);
            screenName = itemView.findViewById(R.id.tvScreenName);
            body = itemView.findViewById(R.id.tvBody);
            time = itemView.findViewById(R.id.tvTime);
        }

        // Setting the data to the views
        public void bind(Tweet tweet) {
            screenName.setText(tweet.user.getScreenName());
            body.setText(tweet.getBody());
            time.setText(tweet.getFormatedTimestamp());
            Glide.with(context).load(tweet.getUser().getProfileImageUrl()).into(profile);
        }
    }
}
