package com.bruk.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appsplashss);

        ImageView logo;

        logo = findViewById(R.id.imageView2);


        Handler eventHandler = new Handler();
        eventHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent myint = new Intent(SplashScreen.this, landingAct.class);

                startActivity(myint);
                finish();
            }
        }, 3500);


    }


    }
