package com.example.raketaalekseev;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private SoundPool soundPool;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView sunImageView = (ImageView) findViewById(R.id.sun);
        Animation sunRiseAnimation = AnimationUtils.loadAnimation(this, R.anim.sun_rise);
        sunImageView.startAnimation(sunRiseAnimation);
    }
    public void play(View v){
        if (player==null){
            player = MediaPlayer.create(this, R.raw.laser);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }
        player.start();
    }
    public void pause(View v){
        if(player!=null){
            player.pause();
        }
    }
    public void stop(View v){
        stopPlayer();
    }
    private void stopPlayer(){
        if(player !=null){
            player.release();
            player=null;
        }
    }
    @Override
    protected void onStop(){
        super.onStop();
        stopPlayer();
    }
}
