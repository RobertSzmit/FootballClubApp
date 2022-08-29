package com.example.footballclubapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    EditText registerEmail, registerPassword;
    Button registerBtn;
    TextView alreadyHaveAnAccount;

    FirebaseAuth mAuth;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerEmail = findViewById(R.id.register_email);
        registerPassword = findViewById(R.id.register_password);
        registerBtn = findViewById(R.id.register_btn);
        alreadyHaveAnAccount = findViewById(R.id.already_have_and_account);

        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        alreadyHaveAnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = registerEmail.getText().toString().trim();
                String password = registerPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    registerEmail.setError(getString(R.string.comm));
                } else if (TextUtils.isEmpty(password)) {
                    registerPassword.setError(getString(R.string.comm2));
                } else if (password.length() < 6) {
                    Toast.makeText(RegisterActivity.this, R.string.comm3, Toast.LENGTH_SHORT).show();
                } else {
                    registerUser (email, password);
                }
            }
        });
    }

    private void registerUser(String email, String password) {
        progressDialog.setTitle(getString(R.string.comm4));
        progressDialog.show();

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    progressDialog.dismiss();
                    startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                    Toast.makeText(RegisterActivity.this, getString(R.string.comm5), Toast.LENGTH_SHORT).show();
                } else {
                    progressDialog.dismiss();
                    Toast.makeText(RegisterActivity.this, getString(R.string.comm6), Toast.LENGTH_SHORT).show();
                }

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                Toast.makeText(RegisterActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT ).show();
            }
        });
    }
}