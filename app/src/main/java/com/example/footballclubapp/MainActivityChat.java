package com.example.footballclubapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivityChat extends AppCompatActivity {

    Button sendBtn;
    EditText msgET, sendET;
    ListView listView;
    ArrayAdapter msgAdapter;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_chat);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message_chat");

        sendBtn = findViewById(R.id.sendBtn);
        sendET = findViewById(R.id.sendET);
        msgET = findViewById(R.id.msgET);
        listView = findViewById(R.id.listview);

        ArrayList<String> msgList = new ArrayList<String>();

        msgAdapter = new ArrayAdapter<String>(this,R.layout.list_item_chat, msgList);

        listView.setAdapter(msgAdapter);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String sender = sendET.getText().toString();
                String msg = msgET.getText().toString();

                if (msg.length()>0 && sender.length()>0) {

                    // msgAdapter.add(sender + "> " + msg);

                    myRef.push().setValue(sender + "> " + msg);

                    msgET.setText("");
                }
            }
        });

        LoadMsg();
    }

    private void LoadMsg() {

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                msgAdapter.add(snapshot.getValue().toString());

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}