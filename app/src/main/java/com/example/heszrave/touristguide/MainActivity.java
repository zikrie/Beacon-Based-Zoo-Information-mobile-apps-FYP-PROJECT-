package com.example.heszrave.touristguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.estimote.sdk.SystemRequirementsChecker;
import com.example.heszrave.touristguide.alarmLunchTime.LunchTimeAlert;
import com.example.heszrave.touristguide.zooMap.GoogleMapsActivity;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    android.support.v7.widget.CardView start;
    android.support.v7.widget.CardView language;
    android.support.v7.widget.CardView zooMap;
  //  android.support.v7.widget.CardView event;
    android.support.v7.widget.CardView lunchTime;
    android.support.v7.widget.CardView info;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SystemRequirementsChecker.checkWithDefaultDialogs(this);

//        Button button = (Button) findViewById(R.id.triggerBtn);
//        Button settingBtn = (Button) findViewById(R.id.settingBtn);
//        Button lunchTimeBtn = (Button) findViewById(R.id.lunchTimeBtn);
//        Button mapBtn = (Button) findViewById(R.id.mapBtn);



        Log.d(TAG, "Main activity");

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d(TAG, "Clicked buton");
//                Intent intent = new Intent(getApplicationContext(), ArtActivity.class);
//                startActivity(intent);
//            }
//        });
//
//
//        settingBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), SettingPreferences.class);
//                startActivity(intent);
//            }
//        });
//
//        lunchTimeBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d(TAG, "Clicked buton");
//                Intent intent = new Intent(getApplicationContext(), LunchTimeAlert.class);
//                startActivity(intent);
//            }
//        });
//
//
//        mapBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d(TAG, "Clicked buton");
//                Intent intent = new Intent(getApplicationContext(), GoogleMapsActivity.class);
//                startActivity(intent);
//            }
//        });

        start = (android.support.v7.widget.CardView) findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ArtActivity.class);
                startActivity(intent);
            }
        });

        language = (android.support.v7.widget.CardView) findViewById(R.id.language);
        language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingPreferences.class);
                startActivity(intent);
            }
        });


        zooMap = (android.support.v7.widget.CardView) findViewById(R.id.zooMap);
        zooMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GoogleMapsActivity.class);
                startActivity(intent);
            }
        });

//        event = (android.support.v7.widget.CardView) findViewById(R.id.event);
//        event.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, info.class);
//                startActivity(intent);
//            }
//        });

        lunchTime = (android.support.v7.widget.CardView) findViewById(R.id.lunchTime);
        lunchTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LunchTimeAlert.class);
                startActivity(intent);
            }
        });

        info = (android.support.v7.widget.CardView) findViewById(R.id.info);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, info.class);
                startActivity(intent);
            }
        });

    }


}
