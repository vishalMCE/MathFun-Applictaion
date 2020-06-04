package com.vishal.vishalsinghmcedtu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class PlayActivity extends AppCompatActivity {

    ListView listView;

    public MediaPlayer mediaPlayer;
    String mTitle[] = {"गेम 1", "गेम 2", "गेम 3", "गेम 4", "गेम 5", "गेम 6", "गेम 7", "गेम 8", "गेम 9", "गेम 10"};
    String mDescription[] = {"मैट्रिक्स का खेल", "दिमाग का खेल", "नंबर का खेल 1", "नंबर का खेल 2", "3 अंकों का खेल 1", "2 नंबर का खेल", "उम्र की भविष्यवाणी का खेल", "3 अंकों का खेल 2", "3 अंकों का खेल 3", "नंबर का खेल 3"};
    int images[] = {R.drawable.game, R.drawable.game, R.drawable.game, R.drawable.game, R.drawable.game, R.drawable.game, R.drawable.game, R.drawable.game, R.drawable.game, R.drawable.game};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        this.setTitle("  प्ले");

        listView = findViewById(R.id.listView);
        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.plauy);
        mediaPlayer = MediaPlayer.create(PlayActivity.this, R.raw.bacgroundaudio);
        mediaPlayer.start();

    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter (Context c, String title[], String description[], int imgs[]) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;

        }


        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView);

            // now set our resources on views
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);

            LayoutInflater inflater = getLayoutInflater();
            ImageButton button = row.findViewById(R.id.bt);
            button.setOnClickListener(new android.view.View.OnClickListener() {
                public void onClick(View v) {
                    if (position == 0) {
                        Intent intent = new Intent(PlayActivity.this, Game1.class);
                        startActivity(intent);
                    }
                    if (position ==  1) {
                        Intent intent = new Intent(PlayActivity.this, Game2.class);
                        startActivity(intent);
                    }
                    if (position ==  2) {
                        Intent intent = new Intent(PlayActivity.this, Game3.class);
                        startActivity(intent);
                    }
                    if (position ==  3) {
                        Intent intent = new Intent(PlayActivity.this, Game4.class);
                        startActivity(intent);
                    }
                    if (position ==  4) {
                        Intent intent = new Intent(PlayActivity.this, Game5.class);
                        startActivity(intent);
                    }
                    if (position ==  5) {
                        Intent intent = new Intent(PlayActivity.this, Game6.class);
                        startActivity(intent);
                    }
                    if (position ==  6) {
                        Intent intent = new Intent(PlayActivity.this, Game7.class);
                        startActivity(intent);
                    }
                    if (position ==  7) {
                        Intent intent = new Intent(PlayActivity.this, Game8.class);
                        startActivity(intent);
                    }
                    if (position ==  8) {
                        Intent intent = new Intent(PlayActivity.this, Game9.class);
                        startActivity(intent);
                    }
                    if (position ==  9) {
                        Intent intent = new Intent(PlayActivity.this, Game10.class);
                        startActivity(intent);
                    }
                }
            });
            return row;
        }
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
