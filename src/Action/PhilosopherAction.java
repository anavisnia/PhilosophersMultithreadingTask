package Action;

import Entites.Fork;
import Entites.Philosopher;
import lombok.AllArgsConstructor;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
public class PhilosopherAction {
    private final Philosopher philosopher;

    public void takeRightFork() {
        Fork rightFork = philosopher.getRightFork();
        if (!rightFork.getIsTaken().get() && rightFork.getPhilosopherId().get() == 0) {
            rightFork.setPhilosopherId(new AtomicInteger(philosopher.getId()));
            rightFork.setIsTaken(new AtomicBoolean(true));
        }
    }
    public void takeLeftFork() {
        Fork leftFork = philosopher.getLeftFork();
        if (!leftFork.getIsTaken().get() && leftFork.getPhilosopherId().get() == 0) {
            leftFork.setPhilosopherId(new AtomicInteger(philosopher.getId()));
            leftFork.setIsTaken(new AtomicBoolean(true));
        }
    }

    public void eat() {
        while(!philosopher.isHasEaten()) {
            synchronized (this) {
                int philosopherId = philosopher.getId();
                Fork rightFork = philosopher.getRightFork();
                Fork leftFork = philosopher.getLeftFork();

                if (rightFork.getIsTaken().get() && rightFork.getPhilosopherId().get() == philosopherId &&
                        leftFork.getIsTaken().get() && leftFork.getPhilosopherId().get() == philosopherId
                ) {
                    System.out.println("Philosopher " + philosopherId + " starts eating...");
                    try {
                        Random randomEatDuration = new Random();
                        Thread.sleep(randomEatDuration.nextInt(5000 - 1000) + 1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Philosopher " + philosopherId + " finished eating");

                    rightFork.setPhilosopherId(new AtomicInteger(0));
                    rightFork.setIsTaken(new AtomicBoolean(false));
                    leftFork.setPhilosopherId(new AtomicInteger(0));
                    leftFork.setIsTaken(new AtomicBoolean(false));
                    philosopher.setHasEaten(true);
                } else {
                    synchronized (rightFork) {
                        while (!rightFork.getIsTaken().get() && leftFork.getPhilosopherId().get() != philosopherId + 1) {
                            takeRightFork();
                        }
                    }
                    synchronized (leftFork) {
                        while (!leftFork.getIsTaken().get()) {
                            takeLeftFork();
                        }
                    }
                }
            }
        }
    }
}
