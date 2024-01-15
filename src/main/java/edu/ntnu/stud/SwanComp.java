package edu.ntnu.stud;

class SwanComponent extends javax.swing.JComponent {
  private final javax.swing.JComponent component;
  private final AnimationScheduler animationScheduler = new AnimationScheduler();

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

  public void animate(AnimationType type) {

    type.init(this);

    animationScheduler.schedule(type, this);
  }
}