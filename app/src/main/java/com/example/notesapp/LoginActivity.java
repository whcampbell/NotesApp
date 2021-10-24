package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String userKey = "username";

        SharedPreferences sp = getSharedPreferences("com.example.notesapp", Context.MODE_PRIVATE);

        if (!sp.getString(userKey, "").equals("")) {
            goToMain(sp.getString(userKey, ""));
        } else {
            setContentView(R.layout.activity_login);
        }

    }

    public void LoginClick(View view) {
        EditText userText = (EditText) findViewById(R.id.username);
        EditText passText = (EditText) findViewById(R.id.password);

        TextView textview = (TextView) findViewById(R.id.textView);

        if (userText.getText().toString().equals("") || passText.getText().toString().equals("")) {
            textview.setText("Username or Password Incorrect");
            userText.setText("");
            passText.setText("");
        } else {
            SharedPreferences sp = getSharedPreferences("com.example.notesapp", Context.MODE_PRIVATE);
            sp.edit().putString("username", userText.getText().toString()).apply();
            goToMain(userText.getText().toString());
        }

    }

    public void goToMain(String s) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("user", s);
        startActivity(intent);
    }

}