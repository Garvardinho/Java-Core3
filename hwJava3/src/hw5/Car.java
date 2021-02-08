package hw5;

import java.util.concurrent.Phaser;
import java.util.concurrent.atomic.AtomicBoolean;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static final AtomicBoolean winner = new AtomicBoolean(false);

    static {
        CARS_COUNT = 0;
    }
    private final Race race;
    private final int speed;
    private final String name;
    private final Phaser phaser;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, Phaser phaser) {
        CARS_COUNT++;
        this.race = race;
        this.speed = speed;
        this.name = "Участник #" + CARS_COUNT;
        this.phaser = phaser;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        phaser.arriveAndAwaitAdvance();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        if (!winner.getAndSet(true))
            System.out.println(name + " won!!!!!!!!!!!!!!!!!!!!!!!!!");

        phaser.arriveAndAwaitAdvance();
    }
}
