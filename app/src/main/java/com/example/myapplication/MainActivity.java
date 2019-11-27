package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.GridLayout;


import task.Sub;
import task.Task;

public class MainActivity extends Activity implements OnClickListener,
        OnLongClickListener {

    private int WIDTH = 10;
    private int HEIGHT = 10;

    private Button[][] cells;
    int[][] mines= new int[10][10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cells);
        makeCells();

        generate();

    }

    void generate() {

        //Эту строку нужно удалить


        for (int i=0;i < 10;i++){
            for (int j=0; j<10;j++){
                if (Math.random()>=0.75){
                    mines[i][j]=1;
                }else{
                    mines[i][j]=0;
                }
            }
        }
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                cells[i][j].setBackgroundColor(Color.BLUE);
            }
        }
        mines[0][0]=0;
        mines[0][1]=0;
    }

    @Override
    public boolean onLongClick(View v) {
        //Эту строку нужно удалить
        return false;
    }

    @Override
    public void onClick(View v) {
        //Эту строку нужно удалить

        Button tappedCell = (Button) v;

        //Получаем координтаты нажатой клетки
        int x = getX(tappedCell);
        int y = getY(tappedCell);
        if (mines[y][x]==1){
            cells[y][x].setBackgroundColor(Color.RED);
        }else{
            if (mines[y][x]!=2){
                cells[y][x].setBackgroundColor(Color.WHITE);
                mines[y][x]=2;
                if (y>0){
                    if (mines[y-1][x]!=1){
                        cells[y-1][x].setBackgroundColor(Color.WHITE);
                        int s=0;
                        if (y>1){
                            if (mines[y-2][x]==1){
                                s++;
                            }
                            if (x>0){
                                if (mines[y-2][x-1]==1){
                                    s++;
                                }
                            }
                            if (x<9){
                                if (mines[y-2][x+1]==1){
                                    s++;
                                }
                            }
                        }
                        if (x>0){
                            if (mines[y-1][x-1]==1){
                                s++;
                            }
                            if (mines[y][x-1]==1){
                                s++;
                            }
                        }
                        if (x<9){
                            if (mines[y-1][x+1]==1){
                                s++;
                            }
                            if (mines[y][x+1]==1){
                                s++;
                            }
                        }
                        mines[y-1][x]=2;
                        cells[y-1][x].setText(s + "");
                        s=0;
                    }
                }
                if (y>0 && x>0){
                    if (mines[y-1][x-1]!=1){
                        cells[y-1][x-1].setBackgroundColor(Color.WHITE);
                        int s=0;
                        if (mines[y][x-1]==1){
                            s++;
                        }
                        if (mines[y-1][x]==1){
                            s++;
                        }
                        if (x>1){
                            if (mines[y][x-2]==1){
                                s++;
                            }
                            if (mines[y-1][x-2]==1){
                                s++;
                            }
                            if (y>1){
                                if (mines[y-2][x-2]==1){
                                    s++;
                                }
                            }
                        }
                        if (y>1){
                            if (mines[y-2][x-1]==1){
                                s++;
                            }
                            if (mines[y-2][x]==1){
                                s++;
                            }
                        }
                        mines[y-1][x-1]=2;
                        cells[y-1][x-1].setText(s + "");
                        s=0;
                    }
                }
                if (x>0){
                    if (mines[y][x-1]!=1) {
                        cells[y][x - 1].setBackgroundColor(Color.WHITE);
                        int s = 0;
                        if (x>1){
                            if (mines[y][x-2]==1){
                                s++;
                            }
                            if (y>0){
                                if (mines[y-1][x-2]==1){
                                    s++;
                                }
                            }
                            if (y<9){
                                if (mines[y+1][x-2]==1){
                                    s++;
                                }
                            }
                        }
                        if (y>0){
                            if (mines[y-1][x-1]==1){
                                s++;
                            }
                            if (mines[y-1][x]==1){
                                s++;
                            }
                        }
                        if (y<9){
                            if (mines[y+1][x-1]==1){
                                s++;
                            }
                            if (mines[y+1][x]==1){
                                s++;
                            }
                        }
                        mines[y][x-1]=2;
                        cells[y][x-1].setText(s + "");
                        s=0;
                    }
                }
                if (x>0 && y<9){
                    if (mines[y+1][x-1]!=1){
                        cells[y+1][x-1].setBackgroundColor(Color.WHITE);
                        int s=0;
                        if (mines[y][x-1]==1){
                            s++;
                        }
                        if (mines[y+1][x]==1){
                            s++;
                        }
                        if (x>1){
                            if (mines[y][x-2]==1){
                                s++;
                            }
                            if (mines[y+1][x-2]==1){
                                s++;
                            }
                            if (y<8){
                                if (mines[y+2][x-2]==1){
                                    s++;
                                }
                            }
                        }
                        if (y<8){
                            if (mines[y+2][x-1]==1){
                                s++;
                            }
                            if (mines[y+2][x]==1){
                                s++;
                            }
                        }
                        mines[y+1][x-1]=2;
                        cells[y+1][x-1].setText(s + "");
                        s=0;
                    }
                }
                if (y<9){
                    if (mines[y+1][x]!=1) {
                        cells[y+1][x].setBackgroundColor(Color.WHITE);
                        int s = 0;
                        if (y<8){
                            if (mines[y+2][x]==1){
                                s++;
                            }
                            if (x>0){
                                if (mines[y+2][x-1]==1){
                                    s++;
                                }
                            }
                            if (x<9){
                                if (mines[y+2][x+1]==1){
                                    s++;
                                }
                            }
                        }
                        if (x>0){
                            if (mines[y+1][x-1]==1){
                                s++;
                            }
                            if (mines[y][x-1]==1){
                                s++;
                            }
                        }
                        if (x<9){
                            if (mines[y+1][x+1]==1){
                                s++;
                            }
                            if (mines[y][x+1]==1){
                                s++;
                            }
                        }
                        mines[y+1][x]=2;
                        cells[y+1][x].setText(s + "");
                        s=0;
                    }
                }
                if (x<9 && y<9){
                    if (mines[y+1][x+1]!=1){
                        cells[y+1][x+1].setBackgroundColor(Color.WHITE);
                        int s=0;
                        if (mines[y][x+1]==1){
                            s++;
                        }
                        if (mines[y+1][x]==1){
                            s++;
                        }
                        if (x<8){
                            if (mines[y][x+2]==1){
                                s++;
                            }
                            if (mines[y+1][x+2]==1){
                                s++;
                            }
                            if (y<8){
                                if (mines[y+2][x+2]==1){
                                    s++;
                                }
                            }
                        }
                        if (y<8){
                            if (mines[y+2][x+1]==1){
                                s++;
                            }
                            if (mines[y+2][x]==1){
                                s++;
                            }
                        }
                        mines[y+1][x+1]=2;
                        cells[y+1][x+1].setText(s + "");
                        s=0;
                    }
                }
                if (x<9){
                    if (mines[y][x+1]!=1) {
                        cells[y][x+1].setBackgroundColor(Color.WHITE);
                        int s = 0;
                        if (x<8){
                            if (mines[y][x+2]==1){
                                s++;
                            }
                            if (y>0){
                                if (mines[y-1][x+2]==1){
                                    s++;
                                }
                            }
                            if (y<9){
                                if (mines[y+1][x+2]==1){
                                    s++;
                                }
                            }
                        }
                        if (y>0){
                            if (mines[y-1][x+1]==1){
                                s++;
                            }
                            if (mines[y-1][x]==1){
                                s++;
                            }
                        }
                        if (y<9){
                            if (mines[y+1][x+1]==1){
                                s++;
                            }
                            if (mines[y+1][x]==1){
                                s++;
                            }
                        }
                        mines[y][x+1]=2;
                        cells[y][x+1].setText(s + "");
                        s=0;
                    }
                }
                if (x<9 && y>0){
                    if (mines[y-1][x+1]!=1){
                        cells[y-1][x+1].setBackgroundColor(Color.WHITE);
                        int s=0;
                        if (mines[y][x+1]==1){
                            s++;
                        }
                        if (mines[y-1][x]==1){
                            s++;
                        }
                        if (x<8){
                            if (mines[y][x+2]==1){
                                s++;
                            }
                            if (mines[y-1][x+2]==1){
                                s++;
                            }
                            if (y>1){
                                if (mines[y-2][x+2]==1){
                                    s++;
                                }
                            }
                        }
                        if (y>1){
                            if (mines[y-2][x+1]==1){
                                s++;
                            }
                            if (mines[y-1][x]==1){
                                s++;
                            }
                        }
                        mines[y-1][x+1]=2;
                        cells[y-1][x+1].setText(s + "");
                        s=0;
                    }
                }
            }

        }
    }


    int getX(View v) {
        return Integer.parseInt(((String) v.getTag()).split(",")[1]);
    }

    int getY(View v) {
        return Integer.parseInt(((String) v.getTag()).split(",")[0]);
    }

    void makeCells() {
        cells = new Button[HEIGHT][WIDTH];
        GridLayout cellsLayout = (GridLayout) findViewById(R.id.CellsLayout);
        cellsLayout.removeAllViews();
        cellsLayout.setColumnCount(HEIGHT);
        for (int i = 0; i < HEIGHT; i++)
            for (int j = 0; j < WIDTH; j++) {
                LayoutInflater inflater = (LayoutInflater) getApplicationContext()
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                cells[i][j] = (Button) inflater.inflate(R.layout.cell, cellsLayout, false);
                cells[i][j].setOnClickListener(this);
                cells[i][j].setOnLongClickListener(this);
                cells[i][j].setTag(i + "," + j);
                cellsLayout.addView(cells[i][j]);
            }
    }

}