package ru.ncedu.kolpakova.snake;

import javax.swing.*;

/**
 * Created by tania on 10/18/16.
 */
public class Snake {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyFrame snake = new MyFrame();
                snake.setVisible(true);
            }
        });
    }
}
