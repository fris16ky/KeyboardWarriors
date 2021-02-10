package com.example.keyboardwarriors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

public class OptionScreen extends AppCompatActivity {

    ImageButton back2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_option_screen);

        back2 = (ImageButton) findViewById(R.id.back2);
        back2.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View view){
                startActivity(new Intent(getApplicationContext(), TitleScreen.class));
                finish();
            }
        });





    }

}
