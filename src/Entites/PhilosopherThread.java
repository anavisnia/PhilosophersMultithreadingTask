package Entites;

public class PhilosopherThread extends Thread{
    private final Philosopher philosopher;

    public PhilosopherThread(Philosopher philosopher) {
        this.philosopher = philosopher;
    }

    @Override
    public void run() {
        philosopher.eat();
    }
}
