package com.example.wk01hw02.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Post {


    int userId;
    String title;
    String body;

    // empty constructor needed by the Parceler library
    public Post() {}

    public Post(JSONObject jsonObject) throws JSONException {
        title = jsonObject.getString("title");
        userId = jsonObject.getInt("userId");
        body = jsonObject.getString("body");
    }

    public static List<Post> fromJsonArray(JSONArray postJsonArray) throws JSONException {
        List<Post> posts = new ArrayList<>();
        for(int i = 0; i < postJsonArray.length(); i++){
            posts.add(new Post(postJsonArray.getJSONObject(i)));
        }
        return posts;
    }

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
