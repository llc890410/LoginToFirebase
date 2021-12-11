package com.example.loginfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvUsername;
    Button btnChangePassword;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvUsername = findViewById(R.id.tvUsername);
        btnChangePassword = findViewById(R.id.btnChangePassword);

        Bundle bundle = getIntent().getExtras();
        email = bundle.getString("email");

        tvUsername.setText(email);

    }
}