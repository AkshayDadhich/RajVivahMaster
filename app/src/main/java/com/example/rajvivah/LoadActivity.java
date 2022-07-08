package com.example.rajvivah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class LoadActivity extends AppCompatActivity {

    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        getSupportActionBar().hide();
        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent mainIntent;
                SharedPreferences preferences = getSharedPreferences("login", MODE_PRIVATE);
                Boolean check = preferences.getBoolean("flag", false);

                if(check){
                    mainIntent = new Intent(LoadActivity.this, MainActivity.class);
                }else
                {
                    mainIntent = new Intent(LoadActivity.this, LoginActivity.class);
                }


                startActivity(mainIntent);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}