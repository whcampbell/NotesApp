package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private NavigationBarView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView text = (TextView) findViewById(R.id.welcome);
        Intent intent = getIntent();
        String s = intent.getStringExtra("user");
        text.setText("Welcome "  + s);

        bottomNav = findViewById(R.id.bottomNav);
        bottomNav.setOnItemSelectedListener(bottomNavFunction);

    }

    private NavigationBarView.OnItemSelectedListener bottomNavFunction = new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.Logout :
                    SharedPreferences sp = getSharedPreferences("com.example.notesapp", Context.MODE_PRIVATE);
                    sp.edit().remove("username").apply();
                    backToLogin();
                    break;
                case R.id.Add :
                    break;
            }
            return true;
        }

    };

    public void backToLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

}