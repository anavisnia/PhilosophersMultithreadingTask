package Action;

import Entites.Philosopher;

public class PhilosopherThread extends Thread {
    private final PhilosopherAction action;

    public PhilosopherThread(Philosopher philosopher) {
        this.action = new PhilosopherAction(philosopher);
    }

    @Override
    public void run() {
        action.eat();
    }
}
