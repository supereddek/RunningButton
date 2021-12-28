package com.company;

import java.awt.*;

public abstract class Shape {
    double x, y;
    public Shape(double x, double y) {
        super();
        this.x = x;
        this.y = y;
    }

    public abstract void draw(Graphics g);
}
