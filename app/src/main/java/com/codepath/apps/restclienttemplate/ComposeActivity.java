package com.codepath.apps.restclienttemplate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ComposeActivity extends AppCompatActivity {
    public static final int MAX_TWEET_LENGTH = 140;

    EditText etCompose;
    Button btnTweet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);

        etCompose = findViewById(R.id.etCompose);
        btnTweet = findViewById(R.id.btnTweet);

        // Add a click listener to the button
        btnTweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Grab text
                String tweetContent = etCompose.getText().toString();

                if (tweetContent.isEmpty()) {
                    Toast.makeText(ComposeActivity.this, "Hey - looks like your tweet is empty!", Toast.LENGTH_LONG).show();
                    return;
                }
                else if (tweetContent.length() > MAX_TWEET_LENGTH) {
                    Toast.makeText(ComposeActivity.this, "Uh oh - your tweet is too long!", Toast.LENGTH_LONG).show();
                    return;
                }

                else {
                    Toast.makeText(ComposeActivity.this, tweetContent, Toast.LENGTH_LONG).show();
                }

                // Make an API call to Twitter to publish the tweet

            }
        });
    }
}