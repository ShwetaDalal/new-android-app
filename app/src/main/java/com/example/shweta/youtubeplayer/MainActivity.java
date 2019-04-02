package com.example.shweta.youtubeplayer;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;


public class MainActivity extends Activity implements View.OnClickListener{

    private Button btnSingle;
    private  Button btnNext;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar;
        //toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        btnSingle = (Button) findViewById(R.id.btnPlayVideo);
        btnNext= (Button) findViewById(R.id.next);
        btnSingle.setOnClickListener(this);
        btnNext.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent= null;

        switch (v.getId()){
            case R.id.btnPlayVideo:
                intent = new Intent((MainActivity.this), YoutubeActivity.class);
                break;
            case R.id.next:
                intent = new Intent((MainActivity.this) , StandaloneActivity.class);
                break;
            default:
        }

        if(intent!= null){
            startActivity(intent);
        }
        }

    }

