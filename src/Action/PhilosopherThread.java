package Action;

import Entites.Philosopher;

public class PhilosopherThread extends Thread {
    private final Philosopher philosopher;
    private final PhilosopherAction action;

    public PhilosopherThread(Philosopher philosopher) {
        this.philosopher = philosopher;
        this.action = new PhilosopherAction(philosopher);
    }

    @Override
    public void run() {
        action.eat();
    }
}
