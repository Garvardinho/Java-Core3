package hw4;

public class ThreadLetter extends Thread {
    char letter;
    static char letterToShow = 'A';
    static final Monitor mon = new Monitor();

    ThreadLetter(char letter) {
        this.letter = letter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (mon) {
                while (letter != letterToShow)
                    holdOn();

                System.out.print(letter);
                if (letterToShow == 'C')
                    letterToShow = 'A';
                else
                    letterToShow++;

                mon.notifyAll();
            }
        }
    }

    private void holdOn() {
        try {
            mon.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
