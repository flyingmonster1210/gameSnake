package com.weijiez.gameSnake;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    // define a snake
    int length;
    int status = 0; // 0 - stop, 1 - begin
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
        if(status == 0) {
            g.setColor(Color.white);
            g.setFont(new Font("Times New Roman", Font.BOLD, 40));
            g.drawString("press space key to start the game", 150, 300);
        }
    }
}
