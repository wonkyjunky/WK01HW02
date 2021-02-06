package com.example.wk01hw02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.wk01hw02.Adapter.PostAdapter;
import com.example.wk01hw02.Models.Post;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;

public class PostActivity extends AppCompatActivity {

    public static final String ACTIVITY_LABEL = "POST_ACTIVITY_COM_WONKYU";
    public static final String ACTIVITY_LABEL2 = "POST_ACTIVITY_COM_WONKYU1";
    TextView tvTitle;
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    List<Post> posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        RecyclerView rvPosts = findViewById(R.id.rvPosts);
        posts = new ArrayList<>();

        String toastValue = getIntent().getStringExtra(ACTIVITY_LABEL);
        String userId = getIntent().getStringExtra(ACTIVITY_LABEL2);
        int mUserId = Integer.valueOf(userId);
        TextView tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setText("Welcome "+toastValue);

        final PostAdapter postAdapter = new PostAdapter(this, posts);
        rvPosts.setAdapter(postAdapter);

        rvPosts.setLayoutManager(new LinearLayoutManager(this));

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(BASE_URL+"users/"+userId+"/posts", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                JSONArray jsonObject = json.jsonArray;
                try {
                    JSONArray results = jsonObject;
                    posts.addAll(Post.fromJsonArray(results));
                    postAdapter.notifyDataSetChanged();

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {

            }
        });



    }

    public static Intent getIntent(Context context, String username, String userId){
        Intent intent = new Intent(context, PostActivity.class);

        intent.putExtra(PostActivity.ACTIVITY_LABEL, username);
        intent.putExtra(PostActivity.ACTIVITY_LABEL2, userId);


        return intent;
    }
}