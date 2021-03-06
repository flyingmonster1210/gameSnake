package com.weijiez.gameSnake;

import javax.swing.*;
import java.net.URL;

public class Data {
    public static URL upURL = Data.class.getResource("./static/up.png");
    public static ImageIcon up = new ImageIcon(upURL);
    public static URL leftURL = Data.class.getResource("./static/left.png");
    public static ImageIcon left = new ImageIcon(leftURL);
    public static URL rightURL = Data.class.getResource("./static/right.png");
    public static ImageIcon right = new ImageIcon(rightURL);
    public static URL downURL = Data.class.getResource("./static/down.png");
    public static ImageIcon down = new ImageIcon(downURL);

    public static URL bodyURL = Data.class.getResource("./static/body.png");
    public static ImageIcon body = new ImageIcon(bodyURL);

    public static URL foodURL = Data.class.getResource("./static/food.png");
    public static ImageIcon food = new ImageIcon(foodURL);

    public static void main(String[] args) {

        System.out.println(foodURL);
        System.out.println(bodyURL);
    }
}
