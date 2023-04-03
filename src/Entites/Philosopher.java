package Entites;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Philosopher {
    @Setter(AccessLevel.NONE)
    private final int id;
    @Setter(AccessLevel.NONE)
    private final Fork rightFork;
    @Setter(AccessLevel.NONE)
    private final Fork leftFork;
    private boolean hasEaten = false;

    public Philosopher(int id, Fork rightFork, Fork leftFork) {
        this.id = id;
        this.rightFork = rightFork;
        this.leftFork = leftFork;
    }
}
