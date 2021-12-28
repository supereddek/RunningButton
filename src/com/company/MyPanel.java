package com.company;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class MyPanel extends JPanel implements KeyListener {
    private final JLabel lblCircle, lblSquare;
    private List<Object> shapes = new ArrayList<>();
    private int x, y;

    public MyPanel() {
        setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
        setBackground(Color.ORANGE);
        setLayout(null);
        addKeyListener(this);
        setFocusable(true);


        lblCircle = new JLabel("q - circle");
        lblSquare = new JLabel("w - square");
        lblCircle.setBounds(10, 10, 60, 15);
        lblSquare.setBounds(10, 40, 60, 15);
        add(lblSquare);
        add(lblCircle);
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                x = e.getX();
                y = e.getY();
            }
        });

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Object s : shapes) {
            if (s instanceof Circle) {
                ((Circle) s).draw(g);
            } else if (s instanceof Square) {
                ((Square) s).draw(g);
            }
        }
    }

    public void addCircle() {
        shapes.add(new Circle(this.x, this.y));
        System.out.println(this.shapes.size());
        repaint();
    }

    public void addSquare() {
        shapes.add(new Square(this.x, this.y));
        System.out.println(this.shapes.size());
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
        switch (e.getKeyCode()) {
            case KeyEvent.VK_Q:
                addCircle();
                break;
            case KeyEvent.VK_W:
                addSquare();
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
