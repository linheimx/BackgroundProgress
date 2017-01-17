package com.soeasytest.app.backgroundprogress;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by LJIAN on 2017/1/17.
 */

public class SnackProgressView extends View {


    int _w, _h;//整个view的宽高
    int _pw;//进度条的宽
    float max = 100, progress;

    RectF rectF_pb;
    Paint paint_pb, paint_txt;
    float txtHeight, txtWidth;

    final int[] SECTION_COLORS = {Color.GREEN, Color.YELLOW, Color.RED};


    public SnackProgressView(Context context) {
        super(context);
        init(context);
    }

    public SnackProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SnackProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {

        rectF_pb = new RectF();

        // paint
        paint_pb = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint_pb.setColor(Color.YELLOW);

        paint_txt = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint_txt.setTextSize(dipToPx(15));
        paint_txt.setColor(Color.BLACK);

        Paint.FontMetrics fm = paint_txt.getFontMetrics();
        txtHeight = Math.abs(fm.ascent) + Math.abs(fm.descent);
        txtWidth = paint_txt.measureText("100%");
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int w = resolveSize(100, widthMeasureSpec);
        int h = resolveSize(100, heightMeasureSpec);

        setMeasuredDimension(w, h);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float percent = progress / max;
        float w = _pw * percent;
        rectF_pb.set(0, 0, 0 + w, 0 + _h);
        canvas.drawRect(rectF_pb, paint_pb);


        String txt = (int) (percent * 100) + "%";

        canvas.drawText(txt, _w - txtWidth, _h / 2 + txtHeight / 2, paint_txt);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        _w = w;
        _h = h;

        notifyChanged();
    }

    private void notifyChanged() {
        LinearGradient linearGradient = new LinearGradient(0, _h, _w, _h, Color.GREEN, Color.RED, Shader.TileMode.CLAMP);
        paint_pb.setShader(linearGradient);
        paint_pb.setAlpha(100);

        _pw = _w - (int) (txtWidth * 1.2);
    }


    public void setMax(float max) {
        this.max = max;
        invalidate();
    }

    public void setProgress(float progress) {
        this.progress = progress;
        if (progress / max >= 1) {
            return;
        }
        invalidate();
    }

    private int dipToPx(int dip) {
        float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dip * scale + 0.5f * (dip >= 0 ? 1 : -1));
    }
}
