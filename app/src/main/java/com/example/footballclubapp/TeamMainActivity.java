package com.example.footballclubapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class TeamMainActivity extends AppCompatActivity {

    RecyclerView recView4;
    TeamAdapter teamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_main);

        recView4 = findViewById(R.id.recView4);
        recView4.setLayoutManager(new LinearLayoutManager(this));

        getWindow().setStatusBarColor(ContextCompat.getColor(TeamMainActivity.this, R.color.dark_red));

        FirebaseRecyclerOptions<TeamModel> options =
                new FirebaseRecyclerOptions.Builder<TeamModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("players"), TeamModel.class)
                        .build();

        teamAdapter = new TeamAdapter(options);
        recView4.setAdapter(teamAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        teamAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        teamAdapter.stopListening();
    }
}