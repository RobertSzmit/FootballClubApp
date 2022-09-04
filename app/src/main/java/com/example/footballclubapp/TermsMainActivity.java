package com.example.footballclubapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class TermsMainActivity extends AppCompatActivity {

    RecyclerView recView3;
    TermsAdapter termsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_main);

        recView3 = findViewById(R.id.recView3);
        recView3.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<TermsModel> options =
                new FirebaseRecyclerOptions.Builder<TermsModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("terms"), TermsModel.class)
                        .build();

        termsAdapter = new TermsAdapter(options);
        recView3.setAdapter(termsAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        termsAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        termsAdapter.stopListening();
    }
}