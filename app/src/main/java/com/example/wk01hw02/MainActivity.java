package com.example.wk01hw02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText etUsername = findViewById(R.id.etUserName);
        EditText etPassword = findViewById(R.id.etPassWord);
        Button btLogin = findViewById(R.id.btLogin);;

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String password = String.valueOf(etPassword.getText());
                String username = String.valueOf(etUsername.getText());
                if (!checkUsername(username)){
                    etUsername.setError("Invalid Username");
                }
                if (!checkPassword(password)){
                    etPassword.setError("Incorrect Password");
                }
                if (checkUsername(username) && checkPassword(password)){
                    nextActivity(v, username, getUserId(username));
                }
            }


        });



    }



    public void nextActivity(View view, String username, String userId){

        Intent intent = PostActivity.getIntent(getApplicationContext(), username, userId);

        startActivity(intent);
    }



    public static boolean checkUsername(String username){
        ArrayList<String> usernames = new ArrayList<String>();
        usernames.add("din_djarin");
        usernames.add("default");
        for (int i = 0; i < usernames.size(); i++){
            if (username.equals(usernames.get(i))){
                return true;
            }
        }
        return false;
    };

    public static boolean checkPassword(String password){
        ArrayList<String> passwords = new ArrayList<String>();
        passwords.add("baby_yoda_ftw");
        passwords.add("default");
        for (int i = 0; i < passwords.size(); i++){
            if (password.equals(passwords.get(i))){
                return true;
            }
        }
        return false;
    }

    public static String getUserId(String username){
        ArrayList<String> usernames = new ArrayList<String>();
        usernames.add("din_djarin");
        usernames.add("default");
        for (int i = 0; i < usernames.size(); i++){
            if (username.equals(usernames.get(i))){
                return Integer.toString(i+1);
            }
        }
        return null;
    }



}