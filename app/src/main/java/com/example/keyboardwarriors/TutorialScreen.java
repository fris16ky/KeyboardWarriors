package com.example.keyboardwarriors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TutorialScreen extends AppCompatActivity {


    TextView d_text;
    EditText user_input;
    ImageButton s_check, n_check;

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
            "him,",
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        d_text = (TextView) findViewById(R.id.display_text);

        user_input = (EditText) findViewById(R.id.input_text);

        s_check = (ImageButton) findViewById(R.id.submit);
        n_check = (ImageButton) findViewById(R.id.new_word);

        r = new Random();

        tutorial_game();

        s_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user_input.getText().toString().equalsIgnoreCase(currentWord)) {
                    s_check.setEnabled(false);
                    n_check.setEnabled(true);
                }
            }
        });
//hello
        n_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    tutorial_game();
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

    private void tutorial_game(){

        currentWord = words_list[r.nextInt(words_list.length)];
        d_text.setText(Display(currentWord));
        n_check.setEnabled(false);
        s_check.setEnabled(true);

    }
}


