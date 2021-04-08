package com.example.keyboardwarriors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class BossTransitionMedium extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boss_transition_medium);


        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                    startActivity(new Intent(getApplicationContext(), MediumModeBoss.class));
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}