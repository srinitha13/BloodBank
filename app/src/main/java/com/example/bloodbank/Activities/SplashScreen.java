package com.example.bloodbank.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.bloodbank.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler handler =new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Intent intent =new Intent(SplashScreen.this,MainActivity.class);
                startActivity(new Intent(SplashScreen.this,RegisterActivity.class));
                finish();

            }
        },4000);
    }
}
