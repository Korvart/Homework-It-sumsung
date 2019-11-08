package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyView extends View {


    public MyView(Context context) {
        super(context);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        int x=0;
        int y=0;
        while (x<canvas.getWidth()){
            canvas.drawLine(x, 0, canvas.getWidth(), canvas.getWidth()-x, paint);
            x+=30;
        }
        while (y<canvas.getHeight()) {
            canvas.drawLine(0, y, canvas.getHeight() - y, canvas.getHeight(), paint);
            y += 30;
        }
    }
}