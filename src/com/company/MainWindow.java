package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class MainWindow extends JFrame {
    private Random d = new Random();

    public static void main(String[] args) {
	// write your code here
        MainWindow frame = new MainWindow("okno");
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);
    }

    public MainWindow() throws HeadlessException {
        this("untitled");
    }

    public MainWindow(String title) throws HeadlessException {
        super(title);
        int windowWidth = 648;
        int windowHeight = 478;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(windowWidth, windowHeight);


        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        this.add(contentPane);


        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        MyPanel panel = new MyPanel();
        panel.setBounds(10, 11, 570, 360);
        contentPane.add(panel);
        panel.requestFocus();
        contentPane.requestFocus();
        this.requestFocusInWindow();

        JButton runBtn = new JButton("Click me!");
        runBtn.setBounds(windowWidth - 2 * 90, windowHeight - 4 * 23, 90, 23);
        contentPane.add(runBtn);
        JButton resetBtn = new JButton("Reset");
        resetBtn.setBounds(windowWidth - 6 * 90, windowHeight - 4 * 23, 90, 23);
        contentPane.add(resetBtn);


        runBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if(MouseInfo.getPointerInfo().getLocation().x >= runBtn.getX() &&
                        MouseInfo.getPointerInfo().getLocation().x <= runBtn.getX() + 20) {
                    System.out.println("Weszlo");
                    return;
                }

                int a = d.nextInt(getWidth()- 2 * runBtn.getWidth());
                int b = d.nextInt(getHeight() - 2 *runBtn.getHeight() - panel.getHeight());
                runBtn.setLocation(a, b + panel.getHeight());
            }
        });

        resetBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                runBtn.setLocation(windowWidth - 2 * 90, windowHeight - 4 * 23);
                panel.clear();
                contentPane.setFocusable(true);
                panel.requestFocus();
            }
        });

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                panel.addCircle();
            }
        });



    }


}

