import Action.CreateEntities;
import Entites.Philosopher;
import Action.PhilosopherThread;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Philosopher> philosophers = CreateEntities.createPhilosophers(CreateEntities.createForks());
        philosophers.forEach(p -> new PhilosopherThread(p).start());
    }
}