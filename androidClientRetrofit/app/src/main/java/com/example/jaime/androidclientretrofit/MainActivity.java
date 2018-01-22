package com.example.jaime.androidclientretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GitHubClient client =
                ServiceGenerator.createService(GitHubClient.class);
    }
}
