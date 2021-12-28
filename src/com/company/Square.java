package com.company;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Square {
    double x, y;
    private final int d = 15;

    public Square (double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.fillRect((int)x, (int)y, d, d);
    }


}
