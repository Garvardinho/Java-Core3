package hw1;

import java.util.ArrayList;
import java.util.Collections;

public class Box<T extends Fruit> {
    ArrayList<T> fruits;
    float fruitWeight;

    Box(T fruit, int number, float fruitWeight) {
        fruits = new ArrayList<>(Collections.nCopies(number, fruit));
        this.fruitWeight = fruitWeight;
    }

    public ArrayList<T> getFruits() {
        return fruits;
    }

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public float getWeight() {
        return fruits.size() * fruitWeight;
    }

    public boolean compare(Box<? extends Fruit> box) {
        return Math.abs(getWeight() - box.getWeight()) < 0.0001f;
    }

    private void free() {
        fruits.clear();
    }

    public void pourFrom(Box<T> box) {
        fruits.addAll(box.getFruits());
        box.free();
    }
}