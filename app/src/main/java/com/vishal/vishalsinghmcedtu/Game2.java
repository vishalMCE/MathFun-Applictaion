 package com.vishal.vishalsinghmcedtu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

 public class Game2 extends AppCompatActivity {

     Button button;
     public MediaPlayer mediaPlayer;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);

        mediaPlayer = MediaPlayer.create(Game2.this, R.raw.game2);
        mediaPlayer.start();

        setTitle("गेम 2");
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 mediaPlayer.stop();
                 Intent intent = new Intent(Game2.this,Game2_final.class);
                 startActivity(intent);
             }
        });
    }

     @Override
     public void onBackPressed() {
         mediaPlayer.stop();
         super.onBackPressed();
     }

     @Override
     public boolean onSupportNavigateUp() {
         mediaPlayer.stop();
         return super.onSupportNavigateUp();
     }

     @Override
     protected void onUserLeaveHint() {
         mediaPlayer.stop();
         super.onUserLeaveHint();
     }
}
