package hw6;

import org.junit.jupiter.api.*;

class MainTest {

    @Test
    void afterTheLastFour() {
        int[] test1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] test2 = {4, 4, 4, 4, 3};
        int[] test3 = {3, 3, 3, 3, 4};
        int[] test4 = {4, 4, 4, 4};
        int[] test5 = {4};
        int[] test6 = {0, 0, 0, 0};
        int[] test7 = {3};
        int[] test8 = {};
        int[] res1 = {5, 6, 7, 8, 9};
        int[] res2 = {3};
        int[] resNull = {};

        Assertions.assertArrayEquals(res1, Main.afterTheLastFour(test1));
        Assertions.assertArrayEquals(res2, Main.afterTheLastFour(test2));
        Assertions.assertArrayEquals(resNull, Main.afterTheLastFour(test3));
        Assertions.assertArrayEquals(resNull, Main.afterTheLastFour(test4));
        Assertions.assertArrayEquals(resNull, Main.afterTheLastFour(test5));
        Assertions.assertThrows(RuntimeException.class, () -> Main.afterTheLastFour(test6));
        Assertions.assertThrows(RuntimeException.class, () -> Main.afterTheLastFour(test7));
        Assertions.assertThrows(RuntimeException.class, () -> Main.afterTheLastFour(test8));
        Assertions.assertThrows(RuntimeException.class, () -> Main.afterTheLastFour(null));
    }

    @Test
    void onlyOnesAndFours (){
        Assertions.assertTrue(Main.onlyOnesAndFours(new int[] {1, 1, 4, 4}));
        Assertions.assertFalse(Main.onlyOnesAndFours(new int[] {1, 14, 4, 41}));
        Assertions.assertFalse(Main.onlyOnesAndFours(new int[] {1, 1, 4, 3}));
        Assertions.assertFalse(Main.onlyOnesAndFours(new int[] {1, 1, 3, 4}));
        Assertions.assertFalse(Main.onlyOnesAndFours(new int[] {1, 1, 1, 1}));
        Assertions.assertFalse(Main.onlyOnesAndFours(new int[] {4, 4, 4, 4}));
        Assertions.assertFalse(Main.onlyOnesAndFours(new int[] {}));
        Assertions.assertThrows(RuntimeException.class, () -> Main.onlyOnesAndFours(null));
    }
}