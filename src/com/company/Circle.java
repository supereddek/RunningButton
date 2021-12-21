package com.company;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Circle {

    double x, y;
    private final int radius = 20;

    public Circle(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.fillOval((int)x - radius, (int)y - 2 *radius,
                radius, radius);
    }

}