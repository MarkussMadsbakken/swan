package edu.ntnu.stud;

import java.awt.Point;

import javax.swing.JComponent;

import edu.ntnu.stud.easing.EasingFunction;

public class Position extends AnimationType {
    private final float x;
    private final float y;

    public Position(float x, float y, float duration) {
        super(duration);

        this.x = x;
        this.y = y;
    }

    public Position(float x, float y, float duration, EasingFunction easingFunction) {
        super(duration, easingFunction);

        this.x = x;
        this.y = y;
    }

    public Position(float x, float y) {
        this(x, y, 1.0f);
    }

    public Position(float x, float y, EasingFunction easingFunction) {
        this(x, y, 1.0f, easingFunction);
    }

    @Override
    public void generate(JComponent component) {
        int xval = (int) (x * getEased());
        int yval = (int) (y * getEased());
        component.setLocation(xval, yval);
    }
}
