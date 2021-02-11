package hw5;

import java.util.concurrent.Phaser;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static final Phaser phaser = new Phaser(CARS_COUNT);


    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), phaser);
            new Thread(cars[i]).start();
        }

        phaser.awaitAdvance(phaser.getPhase());
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

        phaser.awaitAdvance(phaser.getPhase());
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}

