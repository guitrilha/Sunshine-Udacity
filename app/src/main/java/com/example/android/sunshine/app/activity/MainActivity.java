package com.example.android.sunshine.app.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.android.sunshine.app.R;
import com.example.android.sunshine.app.activity.fragment.ForecastFragment;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new ForecastFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                this.onSettingsClicked();
                break;
            case R.id.action_map:
                this.onPreferredLocationInMap();
        }
        return super.onOptionsItemSelected(item);
    }

    private void onPreferredLocationInMap() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String postalCode = preferences.getString(getString(R.string.settings_local_key), getString(R.string.settings_local_defaultValue));
        Uri parse = Uri.parse("geo:0,0?").buildUpon().appendQueryParameter("q", postalCode + ",BR").build();
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(parse);
        if((intent.resolveActivity(getPackageManager()) != null)){
            startActivity(intent);
        }else{
            Log.d("MainActivity","Não foi possível encontrar um aplicativo de mapas no seu dispositivo.");
        }

    }

    private void onSettingsClicked() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

}
