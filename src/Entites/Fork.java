package Entites;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class Fork {
    @Setter(AccessLevel.NONE)
    private final int number;
    private AtomicBoolean isTaken = new AtomicBoolean(false);
    private AtomicInteger philosopherId = new AtomicInteger(0);

    public Fork(int number) {
        this.number = number;
    }
}
