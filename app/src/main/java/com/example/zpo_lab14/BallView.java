package com.example.zpo_lab14;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class BallView extends View {

    private Paint ballPaint;
    private int x;
    private int y;
    private int viewWidth;
    private int viewHeight;

    private static final int CIRCLE_RADIUS = 40;



    public int getX1() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY1() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getViewWidth() {
        return viewWidth;
    }



    public int getViewHeight() {
        return viewHeight;
    }


    public BallView(Context context, int x, int y) {
        super(context);
        this.x = x + 360;
        this.y = y + 540;
        ballPaint = new Paint();
        ballPaint.setColor(Color.BLACK);


    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        viewHeight = h;
        viewWidth = w;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(x,y,CIRCLE_RADIUS, ballPaint);
        ballPaint.setTextSize(30);
        canvas.drawText("x= "+x+"  y= "+ y, viewWidth/2, viewHeight/2, ballPaint);

        invalidate();

    }
}
