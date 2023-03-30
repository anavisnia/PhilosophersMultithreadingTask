package Action;

import Entites.Fork;
import Entites.Philosopher;

import java.util.ArrayList;
import java.util.List;

public final class CreateEntities {
    public static List<Fork> createForks() {
        List<Fork> forks = new ArrayList<>();
        for(int i = 1; i <= 5; i++) {
            forks.add(new Fork(i));
        }
        return forks;
    }

    public static List<Philosopher> createPhilosophers(List<Fork> forks) {
        List<Philosopher> philosophers = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            if (i == 0) {
                philosophers.add(new Philosopher(i + 1, forks.get(forks.size() - 1), forks.get(i)));
            } else {
                philosophers.add(new Philosopher(i + 1, forks.get(i - 1), forks.get(i)));
            }

        }
        return philosophers;
    }
}
