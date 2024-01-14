package edu.ntnu.stud.easing;

import java.util.function.UnaryOperator;

public class EasingFunction {
    private UnaryOperator<Double> function;

    public EasingFunction(UnaryOperator<Double> function) {
        this.function = function;
    }

    public Double getValue(Double t) {
        return function.apply(t);
    }

}
