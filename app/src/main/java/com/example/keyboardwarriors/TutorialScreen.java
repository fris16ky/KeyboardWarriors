package com.example.keyboardwarriors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TutorialScreen extends AppCompatActivity {

    EditText pass_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_screen);

        final String[] MyWords = {"Final", "Way", "Exit"};

        pass_text = findViewById(R.id.pass_text);




    }

}


