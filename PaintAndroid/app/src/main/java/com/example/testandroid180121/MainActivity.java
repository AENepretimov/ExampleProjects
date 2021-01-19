package com.example.testandroid180121;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private AppCompatButton btn_red,
            btn_green,
            btn_blue,
            btn_back,
            btn_clear;
    private MyDraw myDraw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_red = findViewById(R.id.btn_red);
        btn_green = findViewById(R.id.btn_green);
        btn_blue = findViewById(R.id.btn_blue);
        btn_back = findViewById(R.id.btn_back);
        btn_clear = findViewById(R.id.btn_clear);

        myDraw = findViewById(R.id.md_drawSpace);

        MyLis myLis = new MyLis();
        btn_red.setOnClickListener(myLis);
        btn_green.setOnClickListener(myLis);
        btn_blue.setOnClickListener(myLis);
        btn_back.setOnClickListener(myLis);
        btn_clear.setOnClickListener(myLis);

    }

    class MyLis implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.btn_red:
                    myDraw.setColor(getResources().getColor(R.color.red));
                    break;
                case R.id.btn_green:
                    myDraw.setColor(getResources().getColor(R.color.green));
                    break;
                case R.id.btn_blue:
                    myDraw.setColor(getResources().getColor(R.color.blue));
                    break;
                case R.id.btn_back:
                    myDraw.back();
                    break;
                case R.id.btn_clear:
                    myDraw.clear();
                    break;
            }

        }
    }


}