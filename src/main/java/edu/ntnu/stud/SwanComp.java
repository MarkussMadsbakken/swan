package edu.ntnu.stud;

import java.util.Timer;
import java.util.TimerTask;

class SwanComponent extends javax.swing.JComponent {
  private final javax.swing.JComponent component;
  private static final int ANIMATIONDELAY = 10;
  private boolean isAnimating = false;
  private Timer timer;

  public SwanComponent(javax.swing.JComponent component) {
    super();
    this.component = component;
    setBounds(component.getBounds());
    component.setBounds(0, 0, component.getBounds().width, component.getBounds().height);
    add(component);
  }

  @Override
  public void setBounds(int x, int y, int width, int height) {
    super.setBounds(x, y, width, height);
    component.setBounds(0, 0, width, height);
  }

  private SwanComponent getThis() {
    return this;
  }

  public void animate(AnimationType type) {
    if (isAnimating) {
      timer.cancel();
      isAnimating = false;
    }

    timer = new Timer();

    type.init(getThis());

    isAnimating = true;

    timer.scheduleAtFixedRate(new TimerTask() {
      public void run() {

        // System.out.println("Animating");

        if (type.isFinished()) {
          System.out.println("Finished");
          timer.cancel();
          timer.purge();
          type.generate(getThis());
          isAnimating = false;
          return;
        }

        type.generate(getThis());
        type.addFrames(ANIMATIONDELAY);

      }
    }, 0, ANIMATIONDELAY);

    type.getDuration();
    type.generate(component);
  }
}