package com.example.vizsgaremek;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class Register extends AppCompatActivity {

    TextInputEditText textInputEditTextLastname, textInputEditTextFirstname, textInputEditTextEmail, textInputEditTextPassword;
    Button registerButton;
    TextView textViewLogin;
    ProgressBar progressBar;
    RegisterUser registerUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registerUser = new RegisterUser();

        textInputEditTextLastname = findViewById(R.id.lastname);
        textInputEditTextFirstname = findViewById(R.id.firstname);
        textInputEditTextEmail = findViewById(R.id.email);
        textInputEditTextPassword = findViewById(R.id.password);

        registerButton = findViewById(R.id.registerButton);

        textViewLogin = findViewById(R.id.loginText);

        progressBar = findViewById(R.id.progress);

        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User user = new User(String.valueOf(textInputEditTextLastname.getText())
                        ,String.valueOf(textInputEditTextFirstname.getText())
                        ,String.valueOf(textInputEditTextEmail.getText())
                        ,String.valueOf(textInputEditTextPassword.getText()));

                registerUser.putDataToDB(user,progressBar);

            }
        });
    }
}