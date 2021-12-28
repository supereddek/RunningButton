package com.company;

public abstract class Shape {
    double x, y;
    private double r;

    public Shape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public abstract void draw();
}
