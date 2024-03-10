package com.example.wifibasedattendancetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    Intent open;
    boolean login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        login = false;
        if (login){
            open = new Intent(SplashActivity.this, MainActivity.class);
        }else{
            open = new Intent(SplashActivity.this, LoginActivity.class);
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(open);
                finish();
            }
        }, 3000);

    }
}