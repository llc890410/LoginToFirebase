package com.example.loginfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ChangePasswordActivity extends AppCompatActivity {

    private static final String TAG = "ChangePasswordActivity";

    EditText etNewPassword,etTypeAgain;
    Button btnSubmit;

    String newPassword;
    String typeAgain;

    FirebaseUser user;

    Boolean check = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        etNewPassword = findViewById(R.id.etNewPassword);
        etTypeAgain = findViewById(R.id.etTypeAgain);
        btnSubmit = findViewById(R.id.btnSubmit);

        user = FirebaseAuth.getInstance().getCurrentUser();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newPassword = etNewPassword.getText().toString();
                typeAgain = etTypeAgain.getText().toString();

                check = true;

                if (newPassword.length() < 6) {
                    Toast.makeText(ChangePasswordActivity.this,
                            "Password length should be more than or equal to 6",Toast.LENGTH_LONG).show();
                    Log.d(TAG,"Password length is not more than or equal to 6");
                    check = false;
                }

                if (!newPassword.equals(typeAgain)){
                    Toast.makeText(ChangePasswordActivity.this,
                            "Password is not equal",Toast.LENGTH_LONG).show();
                    Log.d(TAG,"Password is not equal");
                    check = false;
                }

                if (check) {
                        user.updatePassword(newPassword)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(ChangePasswordActivity.this,
                                            "Change Password Successful",Toast.LENGTH_SHORT).show();
                                    Log.d(TAG, "Change Password Successful");
                                    Log.d(TAG, "New password:"+newPassword);

                                    Intent intent = new Intent();
                                    intent.setClass(ChangePasswordActivity.this, LoginActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            });
                } else {
                    etNewPassword.setText("");
                    etTypeAgain.setText("");
                }

            }
        });

    }
}