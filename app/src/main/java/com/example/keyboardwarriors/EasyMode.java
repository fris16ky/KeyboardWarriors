package com.example.keyboardwarriors;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import pl.droidsonroids.gif.GifImageView;



public class EasyMode extends AppCompatActivity {

    TextView tv_score;
    int score = 0;
    int health = 3;

    public int counter = 10;
    @TargetApi(Build.VERSION_CODES.ECLAIR_0_1)
    TextView d_text;
    TextView countText;
    EditText user_input;
    ImageButton s_check;
    GifImageView heart1, heart2, heart3;
    GifImageView enemies, enemies2;


    String currentWord;

    Random r;
//s
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


    private Integer spawn[] = {
            R.drawable.goblin1idle,
            R.drawable.goblin2idle,
            R.drawable.goblin3idle,
            R.drawable.reaper1idle,
            R.drawable.reaper2idle,
            R.drawable.reaper3idle,
            R.drawable.angel1idle,
            R.drawable.angel2idle,
            R.drawable.angel3idle,
            R.drawable.satyr1idle,
            R.drawable.satyr2idle,
            R.drawable.satyr3idle,
            R.drawable.wraith1idle,
            R.drawable.wraith2idle,
            R.drawable.wraith3idle,
            R.drawable.golem1idle,
            R.drawable.golem2idle,
            R.drawable.golem3idle,
            R.drawable.golem4idle,
            R.drawable.golem5idle,
            R.drawable.golem6idle,
    };

    private Integer attack[] = {
            R.drawable.goblin1attack,
            R.drawable.goblin2attack,
            R.drawable.goblin3attack,
            R.drawable.reaper1attack,
            R.drawable.reaper2attack,
            R.drawable.reaper3attack,
            R.drawable.angel1attack,
            R.drawable.angel2attack,
            R.drawable.angel3attack,
            R.drawable.satyr1attack,
            R.drawable.satyr2attack,
            R.drawable.satyr3attack,
            R.drawable.wraith1attack,
            R.drawable.wraith2attack,
            R.drawable.wraith3attack,
            R.drawable.golem1attack,
            R.drawable.golem2attack,
            R.drawable.golem3attack,
            R.drawable.golem4attack,
            R.drawable.golem5attack,
            R.drawable.golem6attack,


    };



    private int currImage = 0;
    private int currAttack = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_mode);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);



        d_text = (TextView) findViewById(R.id.display_text);
        tv_score = (TextView) findViewById(R.id.tv_score);
        user_input = (EditText) findViewById(R.id.input_text);
        s_check = (ImageButton) findViewById(R.id.submit);
        heart1 = (GifImageView) findViewById(R.id.heart1);
        heart2 = (GifImageView) findViewById(R.id.heart2);
        heart3 = (GifImageView) findViewById(R.id.heart3);
        enemies = (GifImageView) findViewById(R.id.enemy);
        enemies2 = (GifImageView) findViewById(R.id.enemy2);


        r = new Random();
        tutorial_game();
        setInitialImage();
        setAttackingImage();
        final TextView Timer = findViewById(R.id.Timer);
        counter = 10;
        new CountDownTimer(1000000000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Timer.setText(String.valueOf(counter));
                if(counter == 0) {
                    counter = 11;
                    health--;

                    if (health == 2) {
                        heart3.setVisibility(View.INVISIBLE);
                        MediaPlayer error;
                        error = MediaPlayer.create(getApplicationContext(), R.raw.newerrornoise);
                        error.start();
                    }
                    else if (health == 1) {
                        heart2.setVisibility(View.INVISIBLE);
                        MediaPlayer error;
                        error = MediaPlayer.create(getApplicationContext(), R.raw.newerrornoise);
                        error.start();
                    }
                    else if (health == 0) {
                        heart1.setVisibility(View.INVISIBLE);
                        MediaPlayer error;
                        error = MediaPlayer.create(getApplicationContext(), R.raw.newerrornoise);
                        error.start();
                        startActivity(new Intent(getApplicationContext(), GameOver.class));
                    }

                }
                s_check.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (user_input.getText().toString().equalsIgnoreCase(currentWord)) {
                            user_input.getText().clear();
                            counter = 10;

                            currImage = r.nextInt(21);
                            if (currImage == 21) {
                                currImage = r.nextInt(21);;
                            }
                            setCurrentImage();
                            tutorial_game();
                            score++;
                            tv_score.setText("SCORE: " + score);

                        }
                        else if (!(user_input.getText().toString().equalsIgnoreCase(currentWord))) {
                            health--;
                            MediaPlayer error;
                            error = MediaPlayer.create(getApplicationContext(), R.raw.newerrornoise);
                            error.start();
                            setRealAttackingImage();



                            if(currImage == 0){
                                enemies.setVisibility(View.INVISIBLE);
                                enemies2.setVisibility(View.VISIBLE);

                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        enemies.setVisibility(View.VISIBLE);
                                        enemies2.setVisibility(View.INVISIBLE);
                                    }
                                }, 500);

                            }
                            if(currImage == 1){
                                enemies.setVisibility(View.INVISIBLE);
                                enemies2.setVisibility(View.VISIBLE);

                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        enemies.setVisibility(View.VISIBLE);
                                        enemies2.setVisibility(View.INVISIBLE);
                                    }
                                }, 500);

                            }if(currImage == 2){
                                enemies.setVisibility(View.INVISIBLE);
                                enemies2.setVisibility(View.VISIBLE);

                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        enemies.setVisibility(View.VISIBLE);
                                        enemies2.setVisibility(View.INVISIBLE);
                                    }
                                }, 500);

                            }if(currImage == 3){
                                enemies.setVisibility(View.INVISIBLE);
                                enemies2.setVisibility(View.VISIBLE);

                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        enemies.setVisibility(View.VISIBLE);
                                        enemies2.setVisibility(View.INVISIBLE);
                                    }
                                }, 500);

                            }if(currImage == 4){
                                enemies.setVisibility(View.INVISIBLE);
                                enemies2.setVisibility(View.VISIBLE);

                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        enemies.setVisibility(View.VISIBLE);
                                        enemies2.setVisibility(View.INVISIBLE);
                                    }
                                }, 500);

                            }if(currImage == 5){
                                enemies.setVisibility(View.INVISIBLE);
                                enemies2.setVisibility(View.VISIBLE);

                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        enemies.setVisibility(View.VISIBLE);
                                        enemies2.setVisibility(View.INVISIBLE);
                                    }
                                }, 500);

                            }if(currImage == 6){
                                enemies.setVisibility(View.INVISIBLE);
                                enemies2.setVisibility(View.VISIBLE);

                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        enemies.setVisibility(View.VISIBLE);
                                        enemies2.setVisibility(View.INVISIBLE);
                                    }
                                }, 500);

                            }if(currImage == 7){
                                enemies.setVisibility(View.INVISIBLE);
                                enemies2.setVisibility(View.VISIBLE);

                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        enemies.setVisibility(View.VISIBLE);
                                        enemies2.setVisibility(View.INVISIBLE);
                                    }
                                }, 500);

                            }if(currImage == 8){
                                enemies.setVisibility(View.INVISIBLE);
                                enemies2.setVisibility(View.VISIBLE);

                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        enemies.setVisibility(View.VISIBLE);
                                        enemies2.setVisibility(View.INVISIBLE);
                                    }
                                }, 500);

                            }if(currImage == 9){
                                enemies.setVisibility(View.INVISIBLE);
                                enemies2.setVisibility(View.VISIBLE);

                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        enemies.setVisibility(View.VISIBLE);
                                        enemies2.setVisibility(View.INVISIBLE);
                                    }
                                }, 500);

                            }if(currImage == 10){
                                enemies.setVisibility(View.INVISIBLE);
                                enemies2.setVisibility(View.VISIBLE);

                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        enemies.setVisibility(View.VISIBLE);
                                        enemies2.setVisibility(View.INVISIBLE);
                                    }
                                }, 500);

                            }if(currImage == 11){
                                enemies.setVisibility(View.INVISIBLE);
                                enemies2.setVisibility(View.VISIBLE);

                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        enemies.setVisibility(View.VISIBLE);
                                        enemies2.setVisibility(View.INVISIBLE);
                                    }
                                }, 500);

                            }if(currImage == 12){
                                enemies.setVisibility(View.INVISIBLE);
                                enemies2.setVisibility(View.VISIBLE);

                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        enemies.setVisibility(View.VISIBLE);
                                        enemies2.setVisibility(View.INVISIBLE);
                                    }
                                }, 500);

                            }if(currImage == 13){
                                enemies.setVisibility(View.INVISIBLE);
                                enemies2.setVisibility(View.VISIBLE);

                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        enemies.setVisibility(View.VISIBLE);
                                        enemies2.setVisibility(View.INVISIBLE);
                                    }
                                }, 500);

                            }if(currImage == 14){
                                enemies.setVisibility(View.INVISIBLE);
                                enemies2.setVisibility(View.VISIBLE);

                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        enemies.setVisibility(View.VISIBLE);
                                        enemies2.setVisibility(View.INVISIBLE);
                                    }
                                }, 500);

                            }if(currImage == 15){
                                enemies.setVisibility(View.INVISIBLE);
                                enemies2.setVisibility(View.VISIBLE);

                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        enemies.setVisibility(View.VISIBLE);
                                        enemies2.setVisibility(View.INVISIBLE);
                                    }
                                }, 500);

                            }if(currImage == 16){
                                enemies.setVisibility(View.INVISIBLE);
                                enemies2.setVisibility(View.VISIBLE);

                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        enemies.setVisibility(View.VISIBLE);
                                        enemies2.setVisibility(View.INVISIBLE);
                                    }
                                }, 500);

                            }if(currImage == 17){
                                enemies.setVisibility(View.INVISIBLE);
                                enemies2.setVisibility(View.VISIBLE);

                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        enemies.setVisibility(View.VISIBLE);
                                        enemies2.setVisibility(View.INVISIBLE);
                                    }
                                }, 500);

                            }if(currImage == 18){
                                enemies.setVisibility(View.INVISIBLE);
                                enemies2.setVisibility(View.VISIBLE);

                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        enemies.setVisibility(View.VISIBLE);
                                        enemies2.setVisibility(View.INVISIBLE);
                                    }
                                }, 500);

                            }if(currImage == 19){
                                enemies.setVisibility(View.INVISIBLE);
                                enemies2.setVisibility(View.VISIBLE);

                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        enemies.setVisibility(View.VISIBLE);
                                        enemies2.setVisibility(View.INVISIBLE);
                                    }
                                }, 500);

                            }if(currImage == 20){
                                enemies.setVisibility(View.INVISIBLE);
                                enemies2.setVisibility(View.VISIBLE);

                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        enemies.setVisibility(View.VISIBLE);
                                        enemies2.setVisibility(View.INVISIBLE);
                                    }
                                }, 500);

                            }if(currImage == 21){
                                enemies.setVisibility(View.INVISIBLE);
                                enemies2.setVisibility(View.VISIBLE);

                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        enemies.setVisibility(View.VISIBLE);
                                        enemies2.setVisibility(View.INVISIBLE);
                                    }
                                }, 500);

                            }




                        }
                        if (health == 2) {
                            heart3.setVisibility(View.INVISIBLE);
                        }
                        else if (health == 1) {
                            heart2.setVisibility(View.INVISIBLE);
                        }
                        else if (health == 0) {
                            heart1.setVisibility(View.INVISIBLE);

                            startActivity(new Intent(getApplicationContext(), GameOver.class));
                        }
                    }
                });
                counter--;
                //but this must also take away a heart. it already does check line 232
            }
            @Override
            public void onFinish() {
                //Timer2.setText("Help");
                //Timer2.start();
            }
        }.start();


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
    private void setAttackingImage(){
        setRealAttackingImage();
    }

    private void setRealAttackingImage() {
        final GifImageView imageView2 = (GifImageView) findViewById(R.id.enemy2);
        imageView2.setImageResource(attack[currAttack = currImage]);

    }
}