package edu.ntnu.stud.easing;

public class EaseIn extends EasingFunction {
    public EaseIn() {
        super(t -> t * t * t);
    }
}
