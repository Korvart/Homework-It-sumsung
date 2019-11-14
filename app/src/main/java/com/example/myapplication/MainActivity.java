package com.example.myapplication;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends Activity {
    // Вызывается при создании активности
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Инициализирует активность.
        setContentView(R.layout.activity_main);
    }

    /** Вызывается при нажатии пользователем на кнопку Решить */
    public void solveEquation(View view) {
        // ax+b=c
        double a = Double.parseDouble( ((EditText)
                findViewById(R.id.coefficient_a)).getText().toString());
        double b = Double.parseDouble( ((EditText)
                findViewById(R.id.coefficient_b)).getText().toString());
        double c = Double.parseDouble( ((EditText)
                findViewById(R.id.coefficient_c)).getText().toString());
        TextView result = (TextView) findViewById(R.id.result);
        if (a==0){
            if (b==0){
                if (c==0) {
                    result.setText(""+"Уравнение имеет бесконечно много решений");
                }else{
                    result.setText(""+"Уравнение не имеет решений");
                }
            }else{
                if (c==0){
                    result.setText(""+"x="+0);
                }else{
                    result.setText(""+"x="+String.valueOf(-c/b));
                }
            }
        }else{
            double D=b*b-4*a*c;
            if (D>0){
                result.setText(""+"x1="+String.valueOf((-b+Math.sqrt(D))/2*a)+"\nx2="+String.valueOf((-b-Math.sqrt(D))/2*a));
            }else{
                if (D==0){
                    result.setText(""+"x="+String.valueOf((-b)/2*a));
                }else{
                    result.setText(""+"Уравнение не имеет решений");
                }
            }
        }
    }
}