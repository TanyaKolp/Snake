package ru.ncedu.kolpakova.snake;

/**
 * Created by tania on 10/21/16.
 */
public class Game {
    public int[][] array;
    public int dir; // head movement direction takes values {0,1,2,3}.
    // 0 - to the left, 1 - up, 2 - to the right, 3 -down
    private int hX;
    private int hY;
    public int points;


    public Game() {
        array = new int[30][30];
    }

    private void makeNew() {
        while (true) {
            int x = (int) (Math.random() * 30);
            int y = (int) (Math.random() * 30);

            if (array[y][x] == 0) {
                array[y][x] = -1;
                break;
            }
        }
    }

    public void start() {
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                array[i][j] = 0;
            }
        }
        array[15][15] = 1;
        dir = 0;
        points = 0;
        hX = 15;
        hY = 15;
        makeNew();
    }

    public void moveHead() {
        array[hY][hX] = 0;
        if (dir == 0) {
            if ((hX - 1) >= 0) {
                hX--;
            } else {
                hX = 29;
            }
        } else if (dir == 1) {
            if ((hY - 1) >= 0) {
                hY--;
            } else {
                hY = 29;
            }
        } else if (dir == 2) {
            if ((hX + 1) < 30) {
                hX++;
            } else {
                hX = 0;
            }
        } else {
            if ((hY + 1) < 30) {
                hY++;
            } else {
                hY = 0;
            }
        }
        if (array[hY][hX] == -1) {
            points += 10;
            makeNew();
        }
        array[hY][hX] = 1;
    }
}
