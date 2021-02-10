package com.example.keyboardwarriors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TutorialScreen extends AppCompatActivity {

    EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final String[] MyWords = {"Final", "Way", "Exit"};

        text = findViewById(R.id.pass_text);

        final EditText  text = (EditText) findViewById(R.id.pass_text);
        text.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_MEDIA_NEXT)) {
                    // Perform action on key press
                    Toast.makeText(TutorialScreen.this, text.getText(), Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });






    }

}


