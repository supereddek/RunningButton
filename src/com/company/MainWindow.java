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

        //JPanel panel = new JPanel();
       // panel.setBounds(10, 11, 569, 353);
        //contentPane.add(panel);

        JButton runBtn = new JButton("Click me!");
        runBtn.setBounds(100, 100, 90, 23);
        contentPane.add(runBtn);

        runBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                //if(MouseInfo.getPointerInfo().getLocation().x)

                int a = d.nextInt(windowWidth- 100);
                int b = d.nextInt(windowHeight- 30);
                runBtn.setLocation(a, b);
            }
        });

    }
}

