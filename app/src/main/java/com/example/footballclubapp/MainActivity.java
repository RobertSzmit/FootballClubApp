package com.example.footballclubapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;
    private Button logout;
    Button news_btn;
    Button trips_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();
        logout = findViewById(R.id.logout_btn);
        news_btn = findViewById(R.id.news_btn);
        trips_btn = findViewById(R.id.trips_btn);


        logout.setOnClickListener(new View.OnClickListener() { // logout btn action
            @Override
            public void onClick(View view) {
                auth.signOut();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

        news_btn.setOnClickListener(new View.OnClickListener() { // news activity
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, NewsMainActivity.class));
            }
        });

        trips_btn.setOnClickListener(new View.OnClickListener() { // maps (trips) activity
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MapsActivity.class));
            }
        });

    }
}

