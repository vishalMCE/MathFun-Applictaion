package com.vishal.vishalsinghmcedtu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Game4 extends AppCompatActivity {

    Button button;
    public MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game4);
        setTitle("गेम 4");

        mediaPlayer = MediaPlayer.create(Game4.this, R.raw.game3);
        mediaPlayer.start();

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                Intent intent = new Intent(Game4.this,Game4_final.class);
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
