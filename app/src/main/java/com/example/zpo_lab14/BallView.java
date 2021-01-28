package com.example.zpo_lab14;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.SensorEvent;
import android.view.View;

public class BallView extends View {

    private Paint ballPaint;
    private int x;
    private int y;
    private int viewWidth;
    private int viewHeight;

    private static final int CIRCLE_RADIUS = 40;


    public BallView(Context context) {
        super(context);
//        this.x = x + viewWidth/2;
//        this.y = y + viewHeight/2;
        ballPaint = new Paint();
        ballPaint.setColor(Color.BLACK);


    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        viewHeight = h;
        viewWidth = w;

    }

    public void onSensorEvent (SensorEvent event) {
        x = x - (int) event.values[0]*5;
        y = y + (int) event.values[1]*5;

        if (x <= 0 + CIRCLE_RADIUS) {
            x = 0 + CIRCLE_RADIUS;
        }
        if (x >= viewWidth - CIRCLE_RADIUS) {
            x = viewWidth - CIRCLE_RADIUS;
        }
        if (y <= 0 + CIRCLE_RADIUS) {
            y = 0 + CIRCLE_RADIUS;
        }
        if (y >= viewHeight - CIRCLE_RADIUS) {
            y = viewHeight - CIRCLE_RADIUS;
        }


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(x,y,CIRCLE_RADIUS, ballPaint);
//        ballPaint.setTextSize(30);
//        canvas.drawText("width= "+viewWidth+"  height= "+ viewHeight, viewWidth/2, viewHeight/2, ballPaint);

        invalidate();

    }
}
