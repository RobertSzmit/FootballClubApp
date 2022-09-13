package com.example.footballclubapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
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
    Button news_btn, table_btn, trips_btn, terms_btn, team_btn, chat_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();
        logout = findViewById(R.id.logout_btn);
        news_btn = findViewById(R.id.news_btn);
        table_btn = findViewById(R.id.table_btn);
        trips_btn = findViewById(R.id.trips_btn);
        terms_btn = findViewById(R.id.terms_btn);
        team_btn = findViewById(R.id.team_btn);
        chat_btn = findViewById(R.id.chat_btn);

        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.green)); // status bar

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

        table_btn.setOnClickListener(new View.OnClickListener() { // table activity
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TableMainActivity.class));
            }
        });

        terms_btn.setOnClickListener(new View.OnClickListener() {  // terms activity
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TermsMainActivity.class));
            }
        });

        team_btn.setOnClickListener(new View.OnClickListener() { // team activity
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TeamMainActivity.class));
            }
        });

        trips_btn.setOnClickListener(new View.OnClickListener() { // maps (trips) activity
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MapsActivity.class));
            }
        });

        chat_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivityChat.class));
            }
        });

    }
}

