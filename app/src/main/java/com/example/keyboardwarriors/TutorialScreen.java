package com.example.keyboardwarriors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class TutorialScreen extends AppCompatActivity {


    TextView d_text;
    EditText user_input;
    ImageButton s_check, n_check;

    Random r;

    String [] words_list = {"all\n" +
                            "am\n" +
                            "and\n" +
                            "at\n" +
                            "ball\n" +
                            "be\n" +
                            "bed\n" +
                            "big\n" +
                            "book\n" +
                            "box\n" +
                            "boy\n" +
                            "but\n" +
                            "came\n" +
                            "can\n" +
                            "car\n" +
                            "cat\n" +
                            "come\n" +
                            "cow\n" +
                            "dad\n" +
                            "day\n" +
                            "did\n" +
                            "do\n" +
                            "dog\n" +
                            "fat\n" +
                            "for\n" +
                            "fun\n" +
                            "get\n" +
                            "go\n" +
                            "good\n" +
                            "got\n" +
                            "had\n" +
                            "hat\n" +
                            "he\n" +
                            "hen\n" +
                            "here\n" +
                            "him\n" +
                            "his\n" +
                            "home\n" +
                            "hot\n" +
                            "I\n" +
                            "if\n" +
                            "in\n" +
                            "into\n" +
                            "is\n" +
                            "it\n" +
                            "its\n" +
                            "let\n" +
                            "like\n" +
                            "look\n" +
                            "man\n" +
                            "may\n" +
                            "me\n" +
                            "mom\n" +
                            "my\n" +
                            "no\n" +
                            "not\n" +
                            "of\n" +
                            "oh\n" +
                            "old\n" +
                            "on\n" +
                            "one\n" +
                            "out\n" +
                            "pan\n" +
                            "pet\n" +
                            "pig\n" +
                            "play\n" +
                            "ran\n" +
                            "rat\n" +
                            "red\n" +
                            "ride\n" +
                            "run\n" +
                            "sat\n" +
                            "see\n" +
                            "she\n" +
                            "sit\n" +
                            "six\n" +
                            "so\n" +
                            "stop\n" +
                            "sun\n" +
                            "ten\n" +
                            "the\n" +
                            "this\n" +
                            "to\n" +
                            "top\n" +
                            "toy\n" +
                            "two\n" +
                            "up\n" +
                            "us\n" +
                            "was\n" +
                            "we\n" +
                            "will\n" +
                            "yes\n" +
                            "you"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        d_text = (TextView) findViewById(R.id.display_text);

        user_input = (EditText) findViewById(R.id.input_text);

        s_check = (ImageButton) findViewById(R.id.submit);
        n_check = (ImageButton) findViewById(R.id.new_word);

       /* s_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        n_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        */




    }
}


