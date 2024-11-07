package com.ph.edu.usc19103447.loginactivityfirebase;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    EditText ETUsername, ETPassword;
    Button loginBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();
        ETUsername = (EditText)findViewById(R.id.editTextUsername);
        ETPassword = (EditText)findViewById(R.id.editTextPassword);
        loginBtn = (Button)findViewById(R.id.registerbtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerNewUser();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void registerNewUser(){
        String username, password;
        username = ETUsername.getText().toString();
        password = ETPassword.getText().toString();
        firebaseAuth.createUserWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent loginSuccess = new Intent(MainActivity.this, lalalaActivity.class);
                    startActivity(loginSuccess);
                    Toast.makeText(MainActivity.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "WRONG USERNAME OR PASSWORD", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}