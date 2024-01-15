package edu.ntnu.stud;

import javax.swing.*;

import edu.ntnu.stud.easing.EaseIn;
import edu.ntnu.stud.easing.EaseInOut;
import edu.ntnu.stud.easing.EaseOut;

public class Main {
    static boolean big = false;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Test");
        JButton b = new JButton("Animate me!");
        b.setBounds(50, 100, 140, 40);

        SwanComponent swanComponent = new SwanComponent(b);

        frame.add(swanComponent);

        frame.setSize(400, 500);
        frame.setLayout(null);// using no layout managers
        frame.setVisible(true);// making the frame visible
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        b.addActionListener(e -> {

            if (big) {
                swanComponent.animate(new Size(140, 40, new EaseInOut()));
                swanComponent.animate(new Position(0, 100, new EaseInOut()));
            } else {
                swanComponent.animate(new Size(200, 200, new EaseInOut()));
                swanComponent.animate(new Position(50, 50, new EaseInOut()));
            }

            setBig(!big);
        });
    }

    public static void setBig(boolean b) {
        big = b;
    }

}