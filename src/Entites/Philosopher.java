package Entites;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Philosopher {
    private int id;
    private Fork rightFork;
    private Fork leftFork;
    private boolean hasEaten = false;

    public Philosopher(int id, Fork rightFork, Fork leftFork) {
        this.id = id;
        this.rightFork = rightFork;
        this.leftFork = leftFork;
    }

    public void setHasEaten(boolean hasEaten) {
        this.hasEaten = hasEaten;
    }

    public void takeRightFork() {
        if (!rightFork.isTaken().get() && rightFork.getPhilosopherId().get() == 0) {
            rightFork.setPhilosopherId(new AtomicInteger(id));
            rightFork.setIsTaken(new AtomicBoolean(true));
        }
    }
    public void takeLeftFork() {
        if (!leftFork.isTaken().get() && leftFork.getPhilosopherId().get() == 0) {
            leftFork.setPhilosopherId(new AtomicInteger(id));
            leftFork.setIsTaken(new AtomicBoolean(true));
        }
    }

    public void eat() {
        while(!hasEaten) {
            synchronized (this) {
                if (rightFork.isTaken().get() && rightFork.getPhilosopherId().get() == id &&
                        leftFork.isTaken().get() && leftFork.getPhilosopherId().get() == id
                ) {
                    System.out.println("Philosopher " + id + " starts eating...");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Philosopher " + id + " finished eating");
                    rightFork.setPhilosopherId(new AtomicInteger(0));
                    rightFork.setIsTaken(new AtomicBoolean(false));
                    leftFork.setPhilosopherId(new AtomicInteger(0));
                    leftFork.setIsTaken(new AtomicBoolean(false));
                    setHasEaten(true);
                } else {
                    synchronized (rightFork) {
                        while (!rightFork.isTaken().get()) {
                            takeRightFork();
                        }
                    }
                    synchronized (leftFork) {
                        while (!leftFork.isTaken().get()) {
                            takeLeftFork();
                        }
                    }
                }
            }
        }
    }
}
