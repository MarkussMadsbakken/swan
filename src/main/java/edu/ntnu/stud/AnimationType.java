package edu.ntnu.stud;

import javax.swing.JComponent;

import edu.ntnu.stud.easing.EasingFunction;
import edu.ntnu.stud.easing.Linear;

public class AnimationType {
  private int elapsed;
  private float duration;
  private final EasingFunction easingFunction;
  private boolean override = true;

  public AnimationType(float duration) {
    this.elapsed = 0;
    this.duration = duration;

    this.easingFunction = new Linear();
  }

  public AnimationType(float duration, EasingFunction easingFunction) {
    this.elapsed = 0;
    this.duration = duration;

    this.easingFunction = easingFunction;
  }

  public boolean getOverride() {
    return override;
  }

  public AnimationType setOverride(boolean override) {
    this.override = override;
    return this;
  }

  public Double getEased() {
    return easingFunction.getValue(getProgress());
  }

  public double getProgress() {
    return getElapsed() / (getDuration() * 1000);
  }

  public boolean isFinished() {
    return getElapsed() >= getDuration() * 1000;
  }

  public float getDuration() {
    return duration;
  }

  public int getElapsed() {
    return elapsed;
  }

  public void addFrames(int arg1) {
    elapsed += arg1;
  }

  public void setCurrentFrame(int arg1) {
    elapsed = arg1;
  }

  @Override
  public boolean equals(Object obj) {
    return obj.getClass().equals(this.getClass());
  }

  void init(SwanComponent sComponent) {

  }

  void generate(JComponent component) {
  }
}
