package com.example.keyboardwarriors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

public class GameScreen extends AppCompatActivity {


    ImageButton back;
    ImageButton tutorial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game_screen);


        back = (ImageButton) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View view){
                startActivity(new Intent(getApplicationContext(), TitleScreen.class));
                finish();
            }
        });

        tutorial = (ImageButton) findViewById(R.id.tutorial);
        tutorial.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View view){
                startActivity(new Intent(getApplicationContext(), TutorialScreen.class));
                finish();
            }
        });



    }
}
