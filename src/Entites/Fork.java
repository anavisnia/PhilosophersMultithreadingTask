package Entites;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Fork {
    private final int number;
    private AtomicBoolean isTaken = new AtomicBoolean(false);
    private AtomicInteger philosopherId = new AtomicInteger(0);

    public Fork(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public AtomicBoolean isTaken() {
        return isTaken;
    }

    public void setIsTaken(AtomicBoolean taken) {
        this.isTaken = taken;
    }

    public AtomicInteger getPhilosopherId() {
        return philosopherId;
    }

    public void setPhilosopherId(AtomicInteger philosopherId) {
        this.philosopherId = philosopherId;
    }
}
