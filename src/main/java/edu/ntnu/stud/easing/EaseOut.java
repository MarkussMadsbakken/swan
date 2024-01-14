package edu.ntnu.stud.easing;

public class EaseOut extends EasingFunction {
    public EaseOut() {
        super(t -> 1 - Math.pow(1 - t, 3));
    }

}
