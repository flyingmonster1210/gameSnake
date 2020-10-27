package com.weijiez.gameSnake;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    // this is a pen, and we use this pen to paint
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.black);
    }
}
