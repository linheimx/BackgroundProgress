package com.soeasytest.app.backgroundprogress;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    SnackProgressView snackProgressView;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        snackProgressView = (SnackProgressView) findViewById(R.id.snack);

        go();
    }

    int i = 0;

    void go() {
        i++;
        snackProgressView.setProgress(i);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                go();
            }
        }, 100);
    }

}
