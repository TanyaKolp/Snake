package ru.ncedu.kolpakova.snake;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by tania on 10/18/16.
 */
public class MyPanel extends JPanel {
    private Image background;
    private Image body;
    private Image head;
    private Image food;
    private Image gameOver;
    private Game myGame;
    private JButton newGame;
    private JButton exit;
    private Timer tmDraw;
    private Timer tmUpdate;
    private JLabel lb;
    private MyPanel panel;

//    private class MyKey implements KeyListener {
//
//        @Override
//        public void keyTyped(KeyEvent e) {
//        }
//
//        @Override
//        public void keyPressed(KeyEvent e) {
//            int key = e.getKeyCode();
//            if (key == KeyEvent.VK_LEFT) {
//                myGame.dir = 0;
//            } else if (key == KeyEvent.VK_UP) {
//                myGame.dir = 1;
//            } else if (key == KeyEvent.VK_RIGHT) {
//                myGame.dir = 2;
//            } else if (key == KeyEvent.VK_DOWN) {
//                myGame.dir = 3;
//            }
//        }
//
//        @Override
//        public void keyReleased(KeyEvent e) {
//        }
//    }

    public MyPanel() {
        panel = this;
        try {
            background = ImageIO.read(new File("bg.jpg"));
            food = ImageIO.read(new File("food.jpg"));
            gameOver = ImageIO.read(new File("end.jpg"));
            head = ImageIO.read(new File("head.jpg"));
            body = ImageIO.read(new File("body.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        myGame = new Game();
        myGame.start();
        tmDraw = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        tmDraw.start();
        tmUpdate = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myGame.moveHead();
                lb.setText("Счет: "+myGame.points);
            }
        });
        tmUpdate.start();
        setLayout(null);
        lb = new JLabel("Счет: 0");
        lb.setFont(new Font(null, Font.BOLD, 20));
        lb.setBounds(630, 200, 150, 50);
        add(lb);
        newGame = new JButton("Новая игра");
        newGame.setBackground(Color.ORANGE);
        newGame.setFont(new Font(null, Font.BOLD, 15));
        newGame.setBounds(630, 30, 150, 50);
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myGame.start();
                newGame.setFocusable(false);
                exit.setFocusable(false);
                panel.setFocusable(true);
            }
        });
        add(newGame);
        exit = new JButton("Выход");
        exit.setBackground(Color.orange);
        exit.setFont(new Font(null, 0, 20));
        exit.setBounds(630, 100, 150, 50);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exit);
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_LEFT) {
                    myGame.dir = 0;
                } else if (key == KeyEvent.VK_UP) {
                    myGame.dir = 1;
                } else if (key == KeyEvent.VK_RIGHT) {
                    myGame.dir = 2;
                } else if (key == KeyEvent.VK_DOWN) {
                    myGame.dir = 3;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        this.setFocusable(true);


    }

    public void paintComponent(Graphics gr) {

        super.paintComponent(gr);
        gr.drawImage(background, 0, 0, 800, 650, null);

        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                if (myGame.array[i][j] != 0) {
                    if (myGame.array[i][j] == 1) {
                        gr.drawImage(head, 10 + 20 * j, 10 + 20 * i, 20, 20, null);
                    } else if (myGame.array[i][j] == -1) {
                        gr.drawImage(food, 10 + 20 * j, 10 + 20 * i, 20, 20, null);
                    }
                }
            }
        }
        gr.setColor(Color.BLUE);
        for (int i = 0; i <= 30; i++) {
            gr.drawLine(10 + i * 20, 10, 10 + i * 20, 610);
            gr.drawLine(10, 10 + i * 20, 610, 10 + i * 20);
        }

    }


}
