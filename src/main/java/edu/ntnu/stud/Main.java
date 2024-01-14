package edu.ntnu.stud;

import javax.swing.*;

import edu.ntnu.stud.easing.EaseIn;
import edu.ntnu.stud.easing.EaseInOut;
import edu.ntnu.stud.easing.EaseOut;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Test");
        JButton b = new JButton("Animate me!");
        b.setBounds(100, 100, 140, 40);

        SwanComponent swanComponent = new SwanComponent(b);

        frame.add(swanComponent);

        frame.setSize(400, 500);
        frame.setLayout(null);// using no layout managers
        frame.setVisible(true);// making the frame visible
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        b.addActionListener(e -> {
            swanComponent.animate(new Position(100, 100, new EaseInOut()));
        });
    }
}