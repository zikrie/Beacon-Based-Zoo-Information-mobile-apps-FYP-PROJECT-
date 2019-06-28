package com.example.heszrave.touristguide;

import android.app.DialogFragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.estimote.sdk.Beacon;
import com.estimote.sdk.BeaconManager;
import com.estimote.sdk.Region;
import com.estimote.sdk.SystemRequirementsChecker;
import com.estimote.sdk.eddystone.Eddystone;

import java.util.List;

public class ArtActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    public String scanID;
    public TextView displayView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art);

        displayView = (TextView) findViewById(R.id.textView);

        Log.d(TAG, "art activity started");
        scan();
//        String bcn = "e888f90efae9";
//        displayDialog(bcn);

    }

    public ArtActivity scan() {
//        Context context = getApplicationContext();
        Log.d(TAG, "Scan started");
        final BeaconManager beaconManager = new BeaconManager(getApplicationContext());
        beaconManager.setRegionExitExpiration(1000);
        beaconManager.setEddystoneListener(new BeaconManager.EddystoneListener() {
            @Override
            public void onEddystonesFound(List<Eddystone> eddystoneList) {

                Log.d(TAG, "scanning");

                if (!eddystoneList.isEmpty()) {
                    Eddystone beacon = eddystoneList.get(0);
                    int beaconRSSI = beacon.rssi;
                    String beaconID = beacon.instance;
                    Log.d(TAG, "Beacon RSSI is : " + beaconRSSI);
                    Log.d(TAG, "Beacon beaconID is : " + beaconID);

                    // Triggered when beacon is in 4 meter range
                    if (beaconRSSI > -90) {
                        String beaconInstance = beacon.instance;
                        Log.d(TAG, "beacon instance is: " + beaconInstance);
//                        extractBeacon(beaconInstance);
                        displayDialog(beaconInstance);
                        beaconManager.stopEddystoneScanning(scanID);
//                        Toast.makeText(getApplicationContext(), "Beacon in range", Toast.LENGTH_SHORT).show();
//                        displayView.setText("Beacon inside range");
//                        beaconManager.stopEddystoneScanning(scanID);
                    }
//                    Log.d(TAG, "Beacon name is : " + beacon.instance);
//                    Log.d(TAG, "Beacon RSSI is  : " + beacon.rssi);
//                    Log.d(TAG, "Beacon name is : " + eddystoneList.get(0));
//                    Log.d(TAG, "Number of beacond detected : " + eddystoneList.size());
//                    Toast.makeText(getApplicationContext(), "Beacon FOUND", Toast.LENGTH_LONG).show();
                }


            }
        });


        beaconManager.connect(new BeaconManager.ServiceReadyCallback() {
            @Override
            public void onServiceReady() {
                scanID = beaconManager.startEddystoneScanning();
            }
        });
        return null;
    }

// Fr testing purpose only
//    public void extractBeacon(String beaconID) {
//
//        if (beaconID.equals(Config.BeaconInstaceA)) {
//
//            Intent intent = new Intent(this, DisplayArt.class);
//            intent.putExtra("beaconInstance", beaconID);
//            startActivity(intent);
//
//        }
//
//    }

    public void displayDialog(String instance) {

        Log.d(TAG, "Displaying dialog function");
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        DialogFragment dialogFragment = DisplayArtFragment.newInstance(instance, getApplication());
        dialogFragment.show(fragmentTransaction, "dialog");


    }


}
