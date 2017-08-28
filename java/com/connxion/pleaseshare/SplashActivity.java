package com.connxion.pleaseshare;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by Sbonelo Sthole on 2017/08/25.
 */

public class SplashActivity extends Activity {
    private static boolean splashLoaded = false;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!splashLoaded) {

            setContentView(R.layout.splash_screen);
            int secondsOfDisplay = 1;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                }
            }, secondsOfDisplay * 1000);
            splashLoaded = true;
        }
        else {
            Intent goToMain = new Intent(SplashActivity.this, MainActivity.class);
            goToMain.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(goToMain);
            finish();
        }
    }
}
