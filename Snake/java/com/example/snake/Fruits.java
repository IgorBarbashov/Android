package com.example.snake;

import java.util.ArrayList;

public class Fruits {
    private ArrayList<Integer[]> fruits = new ArrayList<>();
    private int fieldSize;

    public Fruits(int fieldSize) {
        this.fieldSize = fieldSize;
        fruits.add(new Integer[]{10, 10});
    }

    public boolean isCellInFruits(int x, int y) {
        for (int i = 0; i < fruits.size(); i++) {
            Integer[] currentCell = fruits.get(i);
            if (currentCell[0] == x && currentCell[1] == y) return true;
        }
        return false;
    }

    void eatFruit(int x, int y) {
        for (int i = 0; i < fruits.size(); i++) {
            if (fruits.get(i)[0] == x && fruits.get(i)[1] == y) {
                fruits.remove(i);
                return;
            }
        }
    }

}
