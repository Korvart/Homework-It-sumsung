package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyView extends View {
    Paint paint = new Paint();
    MyView(Context context) {
        super(context);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(0, 0, 50, getHeight(), paint);
        canvas.drawRect(0, 0, getWidth(), 50, paint);
        canvas.drawRect(getWidth(), getHeight(), getWidth()-50, 0, paint);
        canvas.drawRect(getWidth(), getHeight(), 0, getHeight()-50, paint);
    }
}