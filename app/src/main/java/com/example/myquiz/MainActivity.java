package com.example.myquiz;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import android.widget.Button;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button startBtn1=  findViewById(R.id.button2);
        final Button startBtn2=  findViewById(R.id.button1);
        //To open true/false quiz
        startBtn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent1 =new Intent(MainActivity.this, MCQ.class);
                startActivity(intent1);
            }
        });
        //to open multiple choice quiz
        startBtn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent2 =new Intent(MainActivity.this, TF.class);
                startActivity(intent2);
            }
        });
    }
}