package Entites;

public class Philosopher {
    private final int id;
    private final Fork rightFork;
    private final Fork leftFork;
    private boolean hasEaten = false;

    public Philosopher(int id, Fork rightFork, Fork leftFork) {
        this.id = id;
        this.rightFork = rightFork;
        this.leftFork = leftFork;
    }

    public int getId() {
        return id;
    }

    public Fork getRightFork() {
        return rightFork;
    }

    public Fork getLeftFork() {
        return leftFork;
    }

    public boolean isHasEaten() {
        return hasEaten;
    }

    public void setHasEaten(boolean hasEaten) {
        this.hasEaten = hasEaten;
    }
}
