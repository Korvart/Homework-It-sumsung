package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    EditText et;
    Button t;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dz1);
        et= (EditText) findViewById(R.id.et);
        String p =(((EditText) findViewById(R.id.password)).getText().toString());
        final String l =(((EditText) findViewById(R.id.login)).getText().toString());
        t= (Button) findViewById(R.id.t);
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.putExtra("et",et.getText().toString());
                setResult(RESULT_OK, i);
                finish();
            }
        };
        t.setOnClickListener(listener);
    }

}


