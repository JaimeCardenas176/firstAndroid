package com.example.jaime.practicando;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Bundle extras = getIntent().getExtras();
        String email = extras.getString("emailLogin");
        Boolean isLogged = extras.getBoolean("isLoggedIn");
    }
}
