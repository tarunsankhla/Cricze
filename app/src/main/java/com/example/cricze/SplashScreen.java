package com.example.cricze;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {
    ImageView splashImage;
    Animation animationview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getSupportActionBar().hide();
        splashImage = (ImageView)findViewById(R.id.splash_image);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this,MainActivity.class));
                finish();
            }
        },3000);
    }

    @Override
    protected void onStart() {
        super.onStart();
        animationview = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
        splashImage.setVisibility(View.VISIBLE);
        splashImage.startAnimation(animationview);
    }
}