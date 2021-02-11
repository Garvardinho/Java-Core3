package hw4;

public class Main {

    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadLetter('A'));
        Thread t2 = new Thread(new ThreadLetter('B'));
        Thread t3 = new Thread(new ThreadLetter('C'));

        t1.start();
        t2.start();
        t3.start();
    }
}
