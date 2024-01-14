## SWAN - Swing Animation library

### Usage


**Creating Swan Components**

```java
//Create a JFrame
JFrame frame = new JFrame("Swan Demo");

//Create a JButton component
JButton b = new JButton("Animate me!");

//Set bounds for the button
b.setBounds(100, 100, 140, 40);

//Create a new SwanComponent with the button
SwanComponent component = new SwanComponent(b);

//Add the component to the frame
frame.add(component);

//Generic frame settings
frame.setSize(400, 500); // setting frame size
frame.setLayout(null);// using no layout managers
frame.setVisible(true);// making the frame visible
frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Exit app on close
```
Its as simple as that, and it can be used with any JComponent. For each following example, we will use the same frame and button.

**Animating SwanComponents**

To animate a swan component, call the animate method with the desired animation.

```java
//Simple position animation
swanComponent.animate(new Position(100, 100));
```

**Easing Functions**

Swan has a number of built in easing functions that can be used to animate components.

``` java
//Simple position animation with easing
swanComponent.animate(new Position(100, 100), new EaseInOut());
```
To create your own easing function, either extend the EasingFunction class or pass in a lambda function.

```java
//Custom easing function
swanComponent.animate(new Position(100, 100), t -> t*t);
```
