package com.example.snake;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;

public class Field {
    private Context context;
    private LinearLayout mainLinear;
    private int fieldSize;
    private Button[][] btn;
    private Fruits fruits;
    private Snake snake;

    public Field(int fieldSize, LinearLayout mainLinear, Context context) {
        this.context = context;
        this.mainLinear = mainLinear;
        this.fieldSize = fieldSize;
        this.btn = new Button[fieldSize][fieldSize];
        Fruits fruits = new Fruits(fieldSize);
        Snake snake = new Snake(fieldSize, this.btn, this.fruits);
    }

    void renderField () {
        int cellSize = 50;

        for (int j = 0; j < fieldSize; j++) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            linearLayout.setGravity(Gravity.CENTER);
            mainLinear.addView(linearLayout);

            for (int i = 0; i < fieldSize; ++i) {
                btn[j][i] = new Button(context);
                btn[j][i].setId(i);
                btn[j][i].setPadding(0, 0, 0, 0);
                btn[j][i].setLayoutParams(new LinearLayout.LayoutParams(cellSize, cellSize));

                if (snake.isCellInSnake(i, j, 0)) {
                    btn[j][i].setBackgroundColor(Color.RED);
                } else if (snake.isCellHeadOfSnake(i, j)) {
                    btn[j][i].setBackgroundColor(Color.DKGRAY);
                } else if (fruits.isCellInFruits(i, j)) {
                    btn[j][i].setBackgroundColor(Color.GREEN);
                } else {
                    btn[j][i].setBackgroundColor(Color.LTGRAY);
                }

                linearLayout.addView(btn[j][i]);
            }
        }
    }

}
