package com.idatafox.landscapedemo;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
        Log.d("vivi","created again...");

    }



    @Override

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setContentView(R.layout.my_main);
        Log.d("vivi", "configure changes");
       // Toast.makeText(this, "hello", Toast.LENGTH_LONG);
    }

}
