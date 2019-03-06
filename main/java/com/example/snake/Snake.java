package com.example.snake;

import android.graphics.Color;
import android.widget.Button;

import java.util.ArrayList;

public class Snake {
    private ArrayList<Integer[]> snake = new ArrayList<>();
    private int dX, dY;
    private int fieldSize;
    private Button[][] btn;
    private Fruits fruits;

    public Snake(int fieldSize, Button[][] btn, Fruits fruits) {
        this.fieldSize = fieldSize;
        this.btn = btn;
        this.fruits = fruits;
        snake.add(new Integer[]{2, 2});
        snake.add(new Integer[]{2, 3});
        snake.add(new Integer[]{2, 4});
        dX = 1;
        dY = 0;
    }

    public boolean isCellInSnake(int x, int y, int offset) {
        for (int i = offset; i < snake.size(); i++) {
            Integer[] currentCell = snake.get(i);
            if (currentCell[0] == x && currentCell[1] == y) return true;
        }
        return false;
    }

    public boolean isCellHeadOfSnake(int x, int y) {
        return (snake.get(0)[0] == x && snake.get(0)[1] == y);
    }

    public boolean moveSnake(Fruits fruits) {
        int currentX = snake.get(0)[0];
        int currentY = snake.get(0)[1];
        int nextX = currentX + dX;
        int nextY = currentY + dY;

        if (nextX < 0) nextX = fieldSize - 1;
        if (nextX >= fieldSize) nextX = 0;
        if (nextY < 0) nextY = fieldSize - 1;
        if (nextY >= fieldSize) nextY = 0;

        if (isCellInSnake(nextX, nextY, 1)) return false;

        btn[snake.get(0)[0]][snake.get(0)[1]].setBackgroundColor(Color.LTGRAY);
        snake.add(0, new Integer[]{nextX, nextY});
        btn[snake.get(0)[0]][snake.get(0)[1]].setBackgroundColor(Color.RED);

        if (!fruits.isCellInFruits(nextX, nextY)) {
            Integer[] forRemove = snake.get(snake.size() - 1);
            btn[forRemove[0]][forRemove[1]].setBackgroundColor(Color.LTGRAY);
            snake.remove(snake.size() - 1);
            fruits.eatFruit(nextX, nextY);
        }

        return true;
    }

    void changeDirection(int dX, int dY) {
        if (this.dX != dX * (-1)) this.dX = dX;
        if (this.dY != dY * (-1)) this.dY = dY;
    }

}
