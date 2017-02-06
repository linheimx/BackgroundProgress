package com.soeasytest.app.backgroundprogress;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.soeasytest.app.lib.BackgroundProgress;
import com.soeasytest.app.lib.BackgroundProgressView;

public class BpNoTxt_Activity extends AppCompatActivity {

    BackgroundProgress backgroundProgress;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_progress);

        backgroundProgress = (BackgroundProgress) findViewById(R.id.back);

        go();
    }

    int i = 0;

    void go() {
        i++;
        backgroundProgress.setProgress(i);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (i == 100) {
                    return;
                }
                go();
            }
        }, 100);
    }

}
