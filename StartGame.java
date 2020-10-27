package com.weijiez.gameSnake;

import javax.swing.*;

public class StartGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.add(new GamePanel());

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setBounds(20, 20, 900, 720);
        frame.setResizable(false);
    }
}
