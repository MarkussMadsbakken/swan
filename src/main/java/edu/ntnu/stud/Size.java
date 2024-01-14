package edu.ntnu.stud;

import javax.swing.JComponent;

import edu.ntnu.stud.easing.EasingFunction;

public class Size extends AnimationType {
    private final float width;
    private final float height;
    private int fromwidth;
    private int fromheight;

    public Size(float width, float height, float duration) {
        super(duration);

        this.width = width;
        this.height = height;
    }

    public Size(float width, float height, float duration, EasingFunction easingFunction) {
        super(duration, easingFunction);

        this.width = width;
        this.height = height;
    }

    public Size(float width, float height) {
        this(width, height, 1.0f);
    }

    public Size(float width, float height, EasingFunction easingFunction) {
        this(width, height, 1.0f, easingFunction);
    }

    @Override
    public void init(SwanComponent sComponent) {
        fromwidth = sComponent.getBounds().width;
        fromheight = sComponent.getBounds().height;
    }

    @Override
    public void generate(JComponent component) {
        int wval = fromwidth + (int) (((int) width - fromwidth) * getEased());
        int hval = fromheight + (int) (((int) height - fromheight) * getEased());
        component.setBounds(component.getX(), component.getY(), wval, hval);
    }

}
