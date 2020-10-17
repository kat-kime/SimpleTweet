package com.codepath.apps.restclienttemplate.models;

import android.icu.text.RelativeDateTimeFormatter;

import com.codepath.apps.restclienttemplate.TimeFormatter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;


import java.util.ArrayList;
import java.util.List;

@Parcel
public class Tweet {
    public String body;
    public String createdAt;
    public User user;

    public Tweet() {
        // Creating empty constructor for Parcel
    }

    /*
        Takes a JSON object and creates a tweet
     */
    public static Tweet fromJson(JSONObject jsonObject) throws JSONException {
        Tweet tweet = new Tweet();
        tweet.body = jsonObject.getString("text");
        tweet.createdAt = jsonObject.getString("created_at");
        tweet.user = User.fromJson(jsonObject.getJSONObject("user"));

        return tweet;
    }

    /*
        Creates a list of tweets from the JSON array
     */
    public static List<Tweet> fromJsonArray(JSONArray jsonArray) throws JSONException {
        List<Tweet> tweets = new ArrayList<>();

        for (int i=0; i < jsonArray.length(); i++) {
            tweets.add(fromJson(jsonArray.getJSONObject(i)));
        }

        return tweets;
    }

    public String getBody() {
        return body;
    }

    public String getFormatedTimestamp() {
        return TimeFormatter.getTimeDifference(createdAt);
    }

    public User getUser() {
        return user;
    }
}
