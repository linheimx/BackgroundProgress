package com.soeasytest.app.lib;

import android.content.Context;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by LJIAN on 2017/1/17.
 */

public class BackgroundProgress extends LinearLayout {

    TextView tv;
    SnackProgressView snackProgressView;

    public BackgroundProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public BackgroundProgress(Context context) {
        super(context);
        init(context);
    }

    public BackgroundProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    private void init(Context context) {

        View view = LayoutInflater.from(context).inflate(R.layout.bp, null);

        snackProgressView = (SnackProgressView) view.findViewById(R.id.progress);
        tv = (TextView) view.findViewById(R.id.tv);

        ViewGroup.LayoutParams layoutParams = new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        addView(view,layoutParams);
    }




    public void setText(String txt) {
        tv.setText(txt);
    }

    public void setMax(float max) {
        snackProgressView.setMax(max);
    }

    public void setProgress(float progress) {
        snackProgressView.setProgress(progress);
    }

}
