package hw1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Task 1
        System.out.println("Task 1");
        Integer[] intArr = new Integer[]{1, 2, 3, 4, 5};
        String[] strArr = new String[]{"6", "7", "8", "9", "0"};

        System.out.println("Array 1 before swap: " + Arrays.toString(intArr));
        System.out.println("Array 2 before swap: " + Arrays.toString(strArr));

        swap(intArr);
        swap(strArr);

        System.out.println("Array 1 after swap: " + Arrays.toString(intArr));
        System.out.println("Array 2 after swap: " + Arrays.toString(strArr));

        System.out.println("\nTask 2");
        ArrayList<Integer> intArrList = toArrayList(intArr);
        ArrayList<String> strArrList = toArrayList(strArr);
        System.out.println(intArrList.toString() + " type: " + intArrList.getClass().getCanonicalName());
        System.out.println(strArrList.toString() + " type: " + intArrList.getClass().getCanonicalName());

        System.out.println("\nTask 3");
        Apple apple = new Apple(1.5f);
        Orange orange = new Orange(2f);

        Box<Apple> box1 = new Box<>(apple, 15, apple.getWeight());
        Box<Apple> box2 = new Box<>(apple, 20, apple.getWeight());
        Box<Apple> box3 = new Box<>(apple, 25, apple.getWeight());
        Box<Orange> box4 = new Box<>(orange, 10, apple.getWeight());
        Box<Orange> box5 = new Box<>(orange, 15, apple.getWeight());
        Box<Orange> box6 = new Box<>(orange, 20, apple.getWeight());

        System.out.println("Box1 weights " + box1.getWeight());
        System.out.println("Box2 weights " + box2.getWeight());
        System.out.println("Box3 weights " + box3.getWeight());
        System.out.println("Box4 weights " + box4.getWeight());
        System.out.println("Box5 weights " + box5.getWeight());
        System.out.println("Box6 weights " + box6.getWeight());
        System.out.println();

        if (box1.compare(box2))
            System.out.println("Box1 weights exactly as Box2");
        else
            System.out.println("Weights of Box1 and Box2 aren't equal");

        if (box1.compare(box5))
            System.out.println("Box1 weights exactly as Box5");
        else
            System.out.println("Weights of Box1 and Box5 aren't equal");

        System.out.println();
        box2.pourFrom(box1);
        System.out.println("After pouring from Box1 to Box2:\nBox1 weights  " + box1.getWeight());
        System.out.println("Box2 weights " + box2.getWeight());
    }

    public static <T> void swap(T[] arr) {
        T val = arr[0];

        arr[0] = arr[arr.length - 1];
        arr[arr.length - 1] = val;
    }

    public static <T> ArrayList<T> toArrayList(T[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }
}