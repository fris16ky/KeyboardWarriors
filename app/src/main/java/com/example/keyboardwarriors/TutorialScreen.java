package com.example.keyboardwarriors;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import pl.droidsonroids.gif.GifImageView;

public class TutorialScreen extends AppCompatActivity {


    TextView tv_score;
    int score = 0;
    int health = 3;

    public int counter = 10;
    @TargetApi(Build.VERSION_CODES.ECLAIR_0_1)
    TextView d_text;
    TextView countText;
    EditText user_input;
    ImageButton s_check;
    ImageButton btn_tut;
    GifImageView heart1, heart2, heart3;
    GifImageView enemies;



    String currentWord;

    Random r;

    String[] words_list = {"all",
            "am",
            "and",
            "at",
            "ball",
            "be",
            "bed",
            "big",
            "book",
            "box",
            "boy",
            "but",
            "came",
            "can",
            "car",
            "cat",
            "come",
            "cow",
            "dad",
            "day",
            "did",
            "do",
            "dog",
            "fat",
            "for",
            "fun",
            "get",
            "go",
            "good",
            "got",
            "had",
            "hat",
            "he",
            "hen",
            "here",
            "him",
            "his",
            "home",
            "hot",
            "if",
            "in",
            "into",
            "is",
            "it",
            "its",
            "let",
            "like",
            "look",
            "man",
            "may",
            "me",
            "mom",
            "my",
            "no",
            "not",
            "of",
            "oh",
            "old",
            "on",
            "one",
            "out",
            "pan",
            "pet",
            "pig",
            "play",
            "ran",
            "rat",
            "red",
            "ride",
            "run",
            "sat",
            "see",
            "she",
            "sit",
            "six",
            "so",
            "stop",
            "sun",
            "ten",
            "the",
            "this",
            "to",
            "top",
            "toy",
            "two",
            "up",
            "us",
            "was",
            "we",
            "will",
            "yes",
            "you"};


    private Integer spawn[] = {R.drawable.goblin1idle,
            R.drawable.wraith1idle,
            R.drawable.golem1idle,
            R.drawable.golem2idle,
            R.drawable.golem3idle,
            R.drawable.golem4idle,
            R.drawable.golem5idle,
            R.drawable.golem6idle,
    };
    private int currImage = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);



        d_text = (TextView) findViewById(R.id.display_text);
        tv_score = (TextView) findViewById(R.id.tv_score);
        user_input = (EditText) findViewById(R.id.input_text);
        s_check = (ImageButton) findViewById(R.id.submit);
        btn_tut = (ImageButton) findViewById(R.id.tut_script);
        heart1 = (GifImageView) findViewById(R.id.heart1);
        heart2 = (GifImageView) findViewById(R.id.heart2);
        heart3 = (GifImageView) findViewById(R.id.heart3);
        enemies = (GifImageView) findViewById(R.id.enemy);

    btn_tut.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(getApplicationContext(), TutorialPopup.class);
            startActivity(i);
        }
    });


        r = new Random();
        tutorial_game();
        setInitialImage();


        s_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user_input.getText().toString().equalsIgnoreCase(currentWord)) {
                    user_input.getText().clear();
                        currImage = r.nextInt(1);
                        if (currImage == 1) {
                            currImage = r.nextInt(1);;
                        }
                        setCurrentImage();
                        tutorial_game();
                    score++;
                    tv_score.setText("SCORE: " + score);

                    if(score == 3){
                        startActivity(new Intent(getApplicationContext(), EasyMode.class));
                        finish();
                    }


                }
                else if (!(user_input.getText().toString().equalsIgnoreCase(currentWord))) {
                    MediaPlayer error;
                    error = MediaPlayer.create(getApplicationContext(), R.raw.newerrornoise);
                            error.start();
                    health--;

                }
                if (health == 2) {
                    heart3.setVisibility(View.INVISIBLE);


                }
                else if (health == 1) {
                    heart2.setVisibility(View.INVISIBLE);
            }
                else if (health ==0) {
                    heart1.setVisibility(View.INVISIBLE);
                    startActivity(new Intent(getApplicationContext(), GameOver.class));
        }
            }
        });

    }

    private String Display(String word) {
        List<String> letters = Arrays.asList(word.split(""));
        String display = "";
        for (String letter : letters) {
            display += letter;
        }
        return display;

    }

    private void tutorial_game() {
        currentWord = words_list[r.nextInt(words_list.length)];
        d_text.setText(Display(currentWord));
        user_input.getText().clear();
    }

    private void setInitialImage(){
        setCurrentImage();
    }

        private void setCurrentImage() {
            final GifImageView imageView = (GifImageView) findViewById(R.id.enemy);
            imageView.setImageResource(spawn[currImage]);
        }


}