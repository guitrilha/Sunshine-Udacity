package com.example.android.sunshine.app.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.example.android.sunshine.app.R;
import com.example.android.sunshine.app.activity.fragment.SettingsFragment;

public class SettingsActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getFragmentManager().beginTransaction()
                .replace(R.id.container, new SettingsFragment()).commit();
    }
}