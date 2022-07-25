package com.switcher.textswitcher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {


    //Global variables

    Button previous, next;
    TextSwitcher textSwitcher;
    int position = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialization of variables
        textSwitcher = findViewById(R.id.textSwitcherj);

        previous = findViewById(R.id.button);
        next = findViewById(R.id.btn_nextn);

        String[] ourText = {"This section contains general settings that can be used to change how Rainmeter behaves", "Contains basic information of the skin", "Variables declared here can be used later on between two # characters", "STYLES are used to centralize options", " Meters using styleLeftText will be left-aligned"};

        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {

                //create textview
                TextView textView = new TextView(getApplicationContext());
                textView.setTextSize(24);
                textView.setGravity(Gravity.CENTER);
                textView.setTextColor(Color.parseColor("#000000"));


//if needed to use typeface
                // Typeface typeface= ResourcesCompat.getFont(getApplicationContext(),R.font.);


                return textView;
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position< ourText.length-1){
                    position=position+1;
                    textSwitcher.setText(ourText[position]);
                }
            }
        });



        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position>0){
                    position=position-1;
                    textSwitcher.setText(ourText[position]);
                }
            }
        });
    }
}