package com.example.jaime.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import okhttp3.OkHttpClient;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String API_BASE_URL = "https://api.github.com/";

        OkHttpClient.Builder httpClient= new OkHttpClient.Builder();

        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .addConverterFactory(
                                GsonConverterFactory.create()
                        );

        Retrofit retrofit =
                builder
                        .client(
                                httpClient.build()
                        )
                        .build();

        GitHubClient client =  retrofit.create(GitHubClient.class);

        Call<List<GitHubRepo>> call = client.reposForUser("JaimeCardenas176");

        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(retrofit2.Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
               List<GitHubRepo> result = response.body();
                       int statusCode = response.code();

                       for (GitHubRepo repo : result) {
                           Log.i("Result", repo.getName());
                       }
            }

            @Override
            public void onFailure(retrofit2.Call<List<GitHubRepo>> call, Throwable t) {

            }

    });
    }
}
