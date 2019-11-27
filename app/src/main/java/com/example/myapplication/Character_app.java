package com.example.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceView;
import android.view.View;

public class Character_app extends SurfaceView{
    Paint paint = new Paint();
    Character_app(Context context) {
        super(context);
    }
    @Override
    public void onDraw(Canvas canvas) {
        Bitmap imageCertain = BitmapFactory.decodeResource(getResources(),R.drawable.floor1);
        Bitmap imageUnit = BitmapFactory.decodeResource(getResources(),R.drawable.hero1);
        canvas.drawBitmap(imageCertain, 0, 0,null);
        canvas.drawBitmap(imageUnit, Character.x, Character.y,null);
    }
}
