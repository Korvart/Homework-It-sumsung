package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyView extends View {
    Paint paint = new Paint();
    float x;
    long lastTime = System.currentTimeMillis();

    public MyView(Context context) {
        super(context);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(x, 300, 20, paint);
        // готовим x c учетом прошедшего времени
        // c момента последней перерисовки
        long nowTime = System.currentTimeMillis();
        x += 0.01f * (nowTime - lastTime);
        // сохраняем время последней перерисовки
        lastTime = nowTime;
        invalidate();
    }
}