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

**Setting bounds**

Setting the bounds of a SwanComponent also sets the bounds of the underlying JComponent.

```java
//Set the bounds of the component
swanComponent.setBounds(100, 100, 140, 40);
```

The SwanComponent and the underlying JComponent will now have the same size, but only the SwanComponent has the given position. The JComponent always has a position of (0, 0) relative to the SwanComponent. 

</br>

**Animating SwanComponents**

To animate a swan component, call the animate method with the desired animation.

```java
//Simple position animation
swanComponent.animate(new Position(200, 200));
```
All animations are done relative to the component it is attatched to. The above example will move the button to (200, 200) relative to its current position.


```java
//Simple size animation
swanComponent.animate(new Size(200, 200));
```

</br>

**Triggering mutliple animations**

Multiple animations can be triggered at once.
    
```java
//Multiple animations
swanComponent.animate(new Position(200, 200));
swanComponent.animate(new Size(200, 200));
```
Only one type of animation can be triggered at once. In the example under, the first animation will be cancelled when the second animation triggers.

```java
//The second animation will cancel the first
swanComponent.animate(new Position(200, 200));
swanComponent.animate(new Position(400, 400));
```
To control if an animation cancels another, use the setOverride method.
```java
//The second animation will not cancel the first
swanComponent.animate(new Position(200, 200));
swanComponent.animate(new Position(400, 400).setOverride(false));
```

</br>

**Chaining animations**



</br>

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
