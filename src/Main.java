import Entites.Fork;
import Entites.Philosopher;
import Entites.PhilosopherThread;

public class Main {
    public static void main(String[] args) {
        Fork[] forks = { new Fork(1), new Fork(2), new Fork(3), new Fork(4), new Fork(5) };

        Philosopher p1 = new Philosopher(1, forks[4], forks[0]);
        Philosopher p2 = new Philosopher(2, forks[0], forks[1]);
        Philosopher p3 = new Philosopher(3, forks[1], forks[2]);
        Philosopher p4 = new Philosopher(4, forks[2], forks[3]);
        Philosopher p5 = new Philosopher(5, forks[3], forks[4]);

        Thread p1Thread = new PhilosopherThread(p1);
        Thread p2Thread = new PhilosopherThread(p2);
        Thread p3Thread = new PhilosopherThread(p3);
        Thread p4Thread = new PhilosopherThread(p4);
        Thread p5Thread = new PhilosopherThread(p5);

        p1Thread.start();
        p2Thread.start();
        p3Thread.start();
        p4Thread.start();
        p5Thread.start();
    }
}