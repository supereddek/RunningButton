package com.company;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class MyPanel extends JPanel implements KeyListener {
    private final JLabel lblCoords;
    private List<Object> shapes = new ArrayList<>();

    public MyPanel() {
        setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
        setBackground(Color.ORANGE);
        setLayout(null);
        addKeyListener(this);
        setFocusable(true);


        lblCoords = new JLabel("x, y");
        lblCoords.setBounds(10, 10, 60, 15);
        add(lblCoords);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Object s : shapes) {
            if (s instanceof Circle) {
                ((Circle) s).draw(g);
            }
        }
    }

    public void addCircle() {
        shapes.add(new Circle(MouseInfo.getPointerInfo().getLocation().getX(),
                MouseInfo.getPointerInfo().getLocation().getY()));
        System.out.println(this.shapes.size());
        repaint();
    }

    public void addCircle(double x, double y) {
        shapes.add(new Circle(x, y));
        repaint();
    }

    public void clear() {
        this.shapes.clear();
        System.out.println(shapes.size());
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        addCircle();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
