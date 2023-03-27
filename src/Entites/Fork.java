package Entites;

public class Fork {
    private final int number;
    private boolean isTaken;
    private int philosopherId;

    public Fork(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setIsTaken(boolean taken) {
        this.isTaken = taken;
    }

    public int getPhilosopherId() {
        return philosopherId;
    }

    public void setPhilosopherId(int philosopherId) {
        this.philosopherId = philosopherId;
    }
}
