package Entites;

import java.util.List;

public class Philosopher {
    private int id;
    private List<Fork> forks;
    private boolean hasEaten = false;

    public Philosopher(int id, List<Fork> forkNumbers) {
        this.id = id;
        this.forks = forkNumbers;
    }

    public List<Fork> getForks() {
        return forks;
    }

    public boolean isHasEaten() {
        return hasEaten;
    }

    public void setHasEaten(boolean hasEaten) {
        this.hasEaten = hasEaten;
    }

    public void takeRightFork() {
        Fork rightFork = getForks().get(0);
        if (!rightFork.isTaken() && rightFork.getPhilosopherId() == 0) {
            rightFork.setPhilosopherId(id);
            rightFork.setIsTaken(true);
        }
    }
    public void takeLeftFork() {
        Fork leftFork = getForks().get(1);
        if (!leftFork.isTaken() && leftFork.getPhilosopherId() == 0) {
            leftFork.setPhilosopherId(id);
            leftFork.setIsTaken(true);
        }
    }

    public void eat() {
        synchronized (this) {
            while(!hasEaten) {
                if (getForks().stream().allMatch(f -> f.isTaken() && f.getPhilosopherId() == id)) {
                    System.out.println("Philosopher " + id + " starts eating...");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Philosopher " + id + " finished eating");
                    getForks().stream().forEach(fork -> fork.setIsTaken(false));
                    getForks().stream().forEach(fork -> fork.setPhilosopherId(0));
                    setHasEaten(true);
                } else {
                    while (!getForks().get(0).isTaken()) {
                        takeRightFork();
                    }
                    while (!getForks().get(1).isTaken()) {
                        takeLeftFork();
                    }
                }
            }
        }
    }
}
