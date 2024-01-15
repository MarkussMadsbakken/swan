package edu.ntnu.stud;

import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
import java.util.Map;

public class AnimationScheduler {
    private final ArrayList<Map<AnimationType, Timer>> animatons = new ArrayList<>();
    private static final int ANIMATIONDELAY = 10;

    public boolean schedule(AnimationType type, SwanComponent component) {
        if (animationExists(type)) {
            if (!type.getOverride()) {
                return false;
            }
            removeAnimation(type);
        }

        return addAnimation(type, component);
    }

    private boolean addAnimation(AnimationType type, SwanComponent component) {
        if (animationExists(type)) {
            return false;
        }

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {

                if (type.isFinished()) {
                    cancel();
                    type.generate(component);
                    return;
                }

                type.generate(component);
                type.addFrames(ANIMATIONDELAY);
            }
        }, 0, ANIMATIONDELAY);
        animatons.add(Map.of(type, timer));

        return true;

    }

    public void removeAnimation(AnimationType type) {
        animatons.stream().filter(map -> map.containsKey(type)).forEach(map -> {
            map.get(type).cancel();
        });
        animatons.removeIf(map -> map.containsKey(type));
    }

    private boolean animationExists(AnimationType type) {
        return animatons.stream().anyMatch(map -> map.containsKey(type));
    }
}
