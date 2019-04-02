package com.example.shweta.youtubeplayer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubeStandalonePlayer;

import android.widget.TextView;


public class YoutubeActivity extends YouTubeBaseActivity
        implements YouTubePlayer.OnInitializedListener
{
    private String GOOGLE_API_KEY = "AIzaSyBZVbNSsdQZCX_yWFCHPQ_fQMcK4xf9hDk";
   // private String YOUTUBE_VIDEO_ID1 = "EknEIzswvC0";
    private String YOUTUBE_VIDEO_ID ="YiRPt4vrSSw";
    private Button like;
    private  Button dislike;
    TextView tvCounter;
    int counter = 0;
    TextView tvCounter1;
    int counter1 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player);
        youTubePlayerView.initialize(GOOGLE_API_KEY, this);
        tvCounter = findViewById(R.id.tvCounter);
        tvCounter1 = findViewById(R.id.tvCounter1);
        like= (Button) findViewById(R.id.like);
        dislike= (Button) findViewById(R.id.dislike);
        tvCounter.setText("0");
        tvCounter1.setText("0");
        like.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //Toast.makeText(YoutubeActivity.this, "Liked", Toast.LENGTH_LONG).show();
                counter = counter + 1;
                tvCounter.setText(String.valueOf(counter)+" Likes");
            }
        });
        dislike.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                //Toast.makeText(YoutubeActivity.this, "Disliked", Toast.LENGTH_LONG).show();
                counter1 = counter1 + 1;
                tvCounter1.setText(String.valueOf(counter1)+" Dislikes");
                Intent intent = null;
                if (counter1 > 10) {

                    switch (v.getId()) {
                        case R.id.dislike:
                            // intent = YouTubeStandalonePlayer.createVideoIntent(this,GOOGLE_API_KEY,YOUTUBE_VIDEO_ID);
                            intent = new Intent((YoutubeActivity.this),Deleted.class);
                            break;

                        default:
                    }



                }
                if (intent != null) {
                    startActivity(intent);
                }
            }

        });


    }







    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        Toast.makeText(this, "Initialized Youtube Player successfully", Toast.LENGTH_LONG).show();
        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
        youTubePlayer.setPlaybackEventListener(playbackEventListener);

        if(!wasRestored) {
            youTubePlayer.cueVideo(YOUTUBE_VIDEO_ID);

        }
        if (counter1>10){


        }

    }

    private YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
        @Override
        public void onPlaying() {
            Toast.makeText(YoutubeActivity.this,"Good, video is playing ok", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onPaused() {
            Toast.makeText(YoutubeActivity.this,"Video has paused", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onStopped() {


        }

        @Override
        public void onBuffering(boolean b) {

        }

        @Override
        public void onSeekTo(int i) {

        }
    };

    YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onLoading() {

        }

        @Override
        public void onLoaded(String s) {

        }

        @Override
        public void onAdStarted() {
            Toast.makeText(YoutubeActivity.this,"Click Ad now, make the video creator rich!", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onVideoStarted() {
            Toast.makeText(YoutubeActivity.this,"Video has started!", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onVideoEnded() {
            Toast.makeText(YoutubeActivity.this,"Thanks for watching!", Toast.LENGTH_LONG).show();

        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {

        }
    };

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "Failed to Initialize Youtube Player", Toast.LENGTH_LONG).show();
    }
}
