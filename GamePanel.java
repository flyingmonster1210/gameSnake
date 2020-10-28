package com.weijiez.gameSnake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener, ActionListener {

    // define a snake
    int length;
    boolean isStart = false;
    Timer timer = new Timer(120, this); // lister to this activity, and refresh it every 100ms
    int[] snakeX = new int[600]; // body on x-axis
    int[] snakeY = new int[600]; // body on y-axis
    String dir;

    public void init() {
        length = 3;
        snakeX[0] = 100; snakeY[0] = 100;
        snakeX[1] = 75; snakeY[1] = 100;
        snakeX[2] = 50; snakeY[2] = 100;
        dir = "Right"; // initial direction is right
        timer.start();
    }

    public GamePanel() {
        init();
        setFocusable(true); // focus on the game
        addKeyListener(this); // listening to the key board
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

    // listening to the keyboard
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_SPACE:
                isStart = !isStart;
                repaint();
                break;
            case KeyEvent.VK_LEFT:
                dir = "Left";
                break;
            case KeyEvent.VK_UP:
                dir = "Up";
                break;
            case KeyEvent.VK_DOWN:
                dir = "Down";
                break;
            case KeyEvent.VK_RIGHT:
                dir = "Right";
                break;
            default:
                break;
        }
    }

    //
    @Override
    public void actionPerformed(ActionEvent e) {
        if(isStart) {
            // move the body
            for(int i = length - 1; i > 0; i--) {
                snakeX[i] = snakeX[i - 1];
                snakeY[i] = snakeY[i - 1];
            }

            if(dir.equals("Right")) snakeX[0] += 25;
            else if(dir.equals("Left")) snakeX[0] -= 25;
            else if(dir.equals("Up")) snakeY[0] -= 25;
            else if(dir.equals("Down")) snakeY[0] += 25;

            if(snakeX[0] > 850) snakeX[0] = 25;
            else if(snakeX[0] < 25) snakeX[0] = 850;
            if(snakeY[0] < 75) snakeY[0] = 650;
            else if(snakeY[0] > 650) snakeY[0] = 75;


            repaint();
        }
        timer.start();
    }








    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
