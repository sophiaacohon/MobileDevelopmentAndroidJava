package com.ph.edu.usc.exercise3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    EditText edUsername, edPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        edUsername = (EditText)findViewById(R.id.edusername);
        edPassword = (EditText)findViewById(R.id.edpassword);
        btnLogin = (Button)findViewById(R.id.btnlogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = "admin";
                String pass = "admin";

                if (edUsername.getText().toString().equals(user) && edPassword.getText().toString().equals(pass)) {
                    Toast.makeText(LoginActivity.this, "Successfully Login", Toast.LENGTH_SHORT).show();
                    Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(mainIntent);
                } else {
                    Toast.makeText(LoginActivity.this, "Username and Password Incorrect.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}