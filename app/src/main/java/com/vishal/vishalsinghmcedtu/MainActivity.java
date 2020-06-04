package com.vishal.vishalsinghmcedtu;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;


import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    public Timer timer;

    private AppBarConfiguration mAppBarConfiguration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_play, R.id.nav_share,R.id.nav_linkedIn, R.id.nav_twitter, R.id.nav_gmail, R.id.nav_youtube)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_about){
            Intent intent = new Intent(this,AboutActivity.class);
            startActivity(intent);
        }
        else if(id == R.id.action_aboutDevloper){
            Intent intent = new Intent(this,AboutDeveloper.class);
            startActivity(intent);
        }
        else if(id == R.id.action_importantLink){
            Intent intent = new Intent(this,ImportantLink.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
//        drawerLayout.closeDrawer(GravityCompat.START);
        int id = item.getItemId();
        if (id == R.id.nav_home){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else if(id == R.id.nav_play){
            Intent intent ;
            intent = new Intent(this,PlayActivity.class);
            startActivity(intent);
        }
        else if(id == R.id.nav_share){
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT ,"https://play.google.com/store/apps/details?id=com.vishalsinghmcedtu");
            intent.setType("text/plain");
            startActivity(Intent.createChooser(intent,"share via"));
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else if(id == R.id.nav_linkedIn){
            String url = "https://www.linkedin.com/in/bharatiscript/?originalSubdomain=in";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else if(id == R.id.nav_twitter){
            String url = "https://twitter.com/bharatiscript";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else if (id == R.id.nav_facebook){
            String url = "https://www.facebook.com/pages/category/Education/Bharati-733667996658301/";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else if (id == R.id.nav_gmail){
            Intent intent = new Intent (Intent.ACTION_VIEW , Uri.parse("mailto:" + "vikram2036.iitm@gmail.com"));
            startActivity(intent);
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else if (id == R.id.nav_youtube){
            String url = "https://www.youtube.com/channel/UCx6-lQ-QTNAJC6RMHc-mIaA";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
            drawerLayout.closeDrawer(GravityCompat.START);
        }

        return true;
    }


    //Exit Dialog Box


    @Override
    public void onBackPressed() {

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,ImportantLink.class);
                startActivity(intent);
                finish();
            }
        },0);

//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setMessage("Are you sure you want to Exit?")
//                .setCancelable(false)
//                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        MainActivity.super.onBackPressed();
//                    }
//                })
//
//                .setNegativeButton("No", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.cancel();
//                    }
//                });
//        AlertDialog alertDialog = builder.create();
//        alertDialog.show();
    }
}
