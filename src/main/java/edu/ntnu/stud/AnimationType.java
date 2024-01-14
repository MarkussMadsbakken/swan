package edu.ntnu.stud;

import javax.swing.JComponent;

import edu.ntnu.stud.easing.EasingFunction;
import edu.ntnu.stud.easing.Linear;

public class AnimationType {
  private int elapsed;
  private float duration;
  private final EasingFunction easingFunction;

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

  void generate(JComponent component) {
  }
}
