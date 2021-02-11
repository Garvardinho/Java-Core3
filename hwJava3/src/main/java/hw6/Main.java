package hw6;

import java.util.Arrays;

public class Main {

    public static int[] afterTheLastFour(int[] array) {
        int theLastFourPos = 0;
        boolean hasFour = false;

        if (array == null)
            throw new RuntimeException("Array is null");

        for (int currentPos = 0; currentPos < array.length; currentPos++) {
            if (array[currentPos] == 4) {
                hasFour = true;
                theLastFourPos = currentPos;
            }
        }

        if (hasFour)
            return Arrays.copyOfRange(array, theLastFourPos + 1, array.length);

        throw new RuntimeException("Array does not contain any fours");
    }

    public static boolean onlyOnesAndFours(int[] array) {
        boolean hasOne = false;
        boolean hasFour = false;

        if (array == null)
            throw new RuntimeException("Array is null");

        for (int i = 0; i < array.length; i++) {
            if (array[i] != 1 && array[i] != 4)
                return false;

            if (!hasOne && array[i] == 1)
                hasOne = true;

            if (!hasFour && array[i] == 4)
                hasFour = true;
        }

        return hasOne & hasFour;
    }

    public static void main(String[] args) {

    }
}
