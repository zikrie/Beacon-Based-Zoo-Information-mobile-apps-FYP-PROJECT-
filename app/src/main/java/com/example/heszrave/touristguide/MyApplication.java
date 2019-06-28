package com.example.heszrave.touristguide;

import android.app.Application;

import com.estimote.sdk.EstimoteSDK;

/**
 * Created by HesZrave on 9/9/2017.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        EstimoteSDK.initialize(getApplicationContext(), "touristguide-cg2", "6e50e7b7e73824e7ff32f688e95b953a");
    }
}
