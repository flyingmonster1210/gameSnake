package com.weijiez.gameSnake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener {

    // define a snake
    int length;
    boolean isStart = false;
    int[] snakeX = new int[600]; // body on x-axis
    int[] snakeY = new int[600]; // body on y-axis
    String dir;

    public void init() {
        length = 3;
        snakeX[0] = 100; snakeY[0] = 100;
        snakeX[1] = 75; snakeY[1] = 100;
        snakeX[2] = 50; snakeY[2] = 100;
        dir = "Right"; // initial direction is right
    }

    public GamePanel() {
        init();
        setFocusable(true); // focus on the game
        addKeyListener(this);
    }

    // this is a pen, and we use this pen to paint
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);

        g.fillRect(25, 75, 850, 600);


        switch (dir) {
            case "Right":
                Data.right.paintIcon(this, g, snakeX[0], snakeY[0]);
                break;
            case "Left":
                Data.left.paintIcon(this, g, snakeX[0], snakeY[0]);
                break;
            case "Up":
                Data.up.paintIcon(this, g, snakeX[0], snakeY[0]);
                break;
            case "Down":
                Data.down.paintIcon(this, g, snakeX[0], snakeY[0]);
                break;
        }
        for(int i = 1; i < length; i++) {
            Data.body.paintIcon(this, g, snakeX[i], snakeY[i]);
        }

        // game status
        if(!isStart) {
            g.setColor(Color.white);
            g.setFont(new Font("Times New Roman", Font.BOLD, 40));
            g.drawString("press space key to start the game", 150, 300);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_SPACE) {
            isStart = !isStart;
            repaint();
        }
    }








    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
