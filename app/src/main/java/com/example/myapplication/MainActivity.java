package com.example.myapplication;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
    public final String password="1367";
    public final String login="school";
    @Override
     public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dz);
    }
    public void check(View view){
        String p =(((EditText) findViewById(R.id.password)).getText().toString());
        String l =(((EditText) findViewById(R.id.login)).getText().toString());
        if (p.equals(password) &&  l.equals(login)){
            TextView result = (TextView) findViewById(R.id.result);
            result.setText("Пароль верный");
            result.setTextColor(Color.GREEN);
        }else{
            TextView result = (TextView) findViewById(R.id.result);
            result.setText("Пароль не верный");
            result.setTextColor(Color.RED);
        }
    }
}
