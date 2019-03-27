package com.example.snake;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout mainLinear = findViewById(R.id.main_linear);
        Field field = new Field(25, mainLinear, getApplicationContext());

    }
}


//        setOnClickListener()
//        switch(view.getId())  {
//            case  R.id.button1: // идентификатор "@+id/button1"
//                showAlertDialog();
//                break;
//	...
//        }