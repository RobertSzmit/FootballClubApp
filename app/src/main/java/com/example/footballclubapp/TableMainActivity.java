package com.example.footballclubapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class TableMainActivity extends AppCompatActivity {

    RecyclerView recView2;
    TableAdapter tableAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_main);

        recView2 = findViewById(R.id.recView2);
        recView2.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<TableModel> options =
                new FirebaseRecyclerOptions.Builder<TableModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("table"), TableModel.class)
                        .build();

        tableAdapter = new TableAdapter(options);
        recView2.setAdapter(tableAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        tableAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        tableAdapter.stopListening();
    }
}