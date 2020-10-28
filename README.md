# Project 2 - *Simple Tweet*

**Simple Tweet** is an Android app that allows a user to view their Twitter timeline and post a new tweet. The app utilizes [Twitter REST API](https://dev.twitter.com/rest/public).

Time spent: **10** hours spent in total

## User Stories

The following functionality has been implemented:

- [x] User can **compose and post a new tweet**
  - [x] User can click a “Compose” icon in the Action Bar on the top right
  - [x] User can then enter a new tweet and post this to twitter
  - [x] User is taken back to home timeline with **new tweet visible** in timeline
  - [x] Newly created tweet should be manually inserted into the timeline and not rely on a full refresh
  - [x] User can **see a counter with total number of characters left for tweet** on compose tweet page
  - [x] User can **sign in to Twitter** using OAuth login
  - [x]	User can **view tweets from their home timeline**
  - [x] User is displayed the username, name, and body for each tweet
  - [x] User is displayed the relative timestamp for each tweet "8m", "7h"
  - [x] User can refresh tweets timeline by pulling down to refresh


## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='https://github.com/kat-kime/SimpleTweet/blob/main/tweetwalk2.gif' title='Video Walkthrough' width='500' alt='Video Walkthrough' />

<img src='https://github.com/kat-kime/SimpleTweet/blob/main/tweetwalk.gif' title='Video Walkthrough' width='500' alt='Video Walkthrough' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).


## Open-source libraries used

- [Android Async HTTP](https://github.com/codepath/CPAsyncHttpClient) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Android

## License

    Copyright 2020 Kat Kime

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
