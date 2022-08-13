package com.tochukwuozurumba.scorekeeper;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;

public class SettingActivity extends AppCompatActivity {

    private int isCheckedValue;
    private Switch settingSw;
    public final static String PREF_NAME = "save_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        SharedPreferencesManger.init(SettingActivity.this);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        settingSw = findViewById(R.id.save_data_switch);

        settingSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    isCheckedValue = 1;
                } else {
                    isCheckedValue = 0;
                }
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    protected void onResume(){
        super.onResume();

        isCheckedValue = SharedPreferencesManger.getInt(PREF_NAME, 0);
        Log.d("onResume isChecked", String.valueOf(isCheckedValue));

//        display
        settingSw.isChecked();
    }

    protected void onPause() {
        saveData();
        super.onPause();
    }

    protected void onStop() {
        saveData();
        super.onStop();
    }

    protected void onDestroy() {
        saveData();
        super.onDestroy();
    }

    private void saveData() {
        Log.d("isCheckedValue", String.valueOf(isCheckedValue));
        SharedPreferencesManger.setInt(PREF_NAME, isCheckedValue);
    }
}