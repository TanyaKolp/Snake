package ru.ncedu.kolpakova.snake;

import javax.swing.*;

/**
 * Created by tania on 10/18/16.
 */
public class MyFrame extends JFrame {
    public MyFrame(){
        super("Игра \"Змейка\"");
        MyPanel pan = new MyPanel();
        setSize(5,5);
        setBounds(100,100,800,650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(pan);
        setResizable(false);
    }


}
