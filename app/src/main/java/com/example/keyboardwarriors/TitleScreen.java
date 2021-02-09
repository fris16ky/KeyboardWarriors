package com.example.keyboardwarriors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class TitleScreen extends AppCompatActivity {



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_title_screen);




    }

    public void ToStartGame(View view){
        Intent game = new Intent(this, GameScreen.class);
        startActivity(game);

    }
    public void ToOptionScreen(View view){
        Intent game = new Intent(this, OptionScreen.class);
        startActivity(game);

    }

}
