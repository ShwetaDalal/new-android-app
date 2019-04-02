package com.example.shweta.youtubeplayer;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import com.google.android.youtube.player.YouTubeStandalonePlayer;


public class StandaloneActivity extends Activity implements View.OnClickListener
{

    private String GOOGLE_API_KEY = "AIzaSyDVy6qjPhfrosP4Z6IZnzQSCrV9zi4qlvE";
    //private String YOUTUBE_VIDEO_ID1 = "EknEIzswvC0";
    private String YOUTUBE_VIDEO_ID ="YiRPt4vrSSw";
    private String YOUTUBE_PLAYLIST_ID= "PLS1QulWo1RIbb1cYyzZpLFCKvdYV_yJ-E";
    private Button btnPlayVideo;
    private  Button btnPlayplaylist;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        btnPlayplaylist= (Button) findViewById(R.id.btnPlayList);
        btnPlayVideo= (Button) findViewById(R.id.btnVideo);
        btnPlayVideo.setOnClickListener(this);
        btnPlayplaylist.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent= null;
        switch (v.getId()){
            case R.id.btnVideo:
               // intent = YouTubeStandalonePlayer.createVideoIntent(this,GOOGLE_API_KEY,YOUTUBE_VIDEO_ID);
                intent = new Intent((StandaloneActivity.this), YoutubeActivity.class);
                break;
            case R.id.btnPlayList:
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this,GOOGLE_API_KEY,YOUTUBE_PLAYLIST_ID);

                break;
            default:
        }

        if(intent!= null){
            startActivity(intent);
        }
    }
}

