package com.example.loginfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ChangePasswordActivity extends AppCompatActivity {

    EditText etNewPassword,etTypeAgain;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        etNewPassword = findViewById(R.id.etNewPassword);
        etTypeAgain = findViewById(R.id.etTypeAgain);
        btnSubmit = findViewById(R.id.btnSubmit);
    }
}