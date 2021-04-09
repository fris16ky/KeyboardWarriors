package com.example.keyboardwarriors;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class TitleScreen extends AppCompatActivity {
    MediaPlayer Song;
    ImageButton start;
    ImageButton option;


    protected void onCreate(Bundle savedInstanceState) {
        Song = MediaPlayer.create(TitleScreen.this, R.raw.loopsong);
        Song.start();
        Song.setLooping(true);
        Song.start();
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_title_screen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);



        start = (ImageButton) findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener(){
            @Override
                public  void onClick(View view){
                startActivity(new Intent(getApplicationContext(), GameScreen.class));
                finish();
            }
        });

        option = (ImageButton) findViewById(R.id.option);
        option.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View view){
                startActivity(new Intent(getApplicationContext(), OptionScreen.class));
                finish();
            }
        });


    }
    public void onPause(){
        super.onPause();
        Song.release();
        finish();
    }
}
