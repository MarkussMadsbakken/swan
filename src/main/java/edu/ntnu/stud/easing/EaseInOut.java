package edu.ntnu.stud.easing;

public class EaseInOut extends EasingFunction {
    public EaseInOut() {
        super(t -> t < 0.5 ? 4 * t * t * t : 1 - Math.pow(-2 * t + 2, 3) / 2);
    }
}
