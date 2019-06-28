package com.example.heszrave.touristguide;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.support.v4.app.FragmentActivity;

/**
 * Created by HesZrave on 15/10/2017.
 */

public class SettingPreferences extends FragmentActivity {


    @Override
    protected void onCreate(Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.preference_holder);

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container_Holder, new PreferenceFrag());
        transaction.commit();
    }

    public static class PreferenceFrag extends PreferenceFragment {
        @Override

        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.app_preference);
        }
    }


}
