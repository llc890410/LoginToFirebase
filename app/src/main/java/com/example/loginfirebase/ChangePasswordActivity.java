package com.example.loginfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ChangePasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        EditText etNewPassword = findViewById(R.id.etNewPassword);
        EditText etTypeAgain = findViewById(R.id.etTypeAgain);
        Button btnSubmit = findViewById(R.id.btnSubmit);
    }
}