package hw7.main;

import hw7.annotations.AfterSuite;
import hw7.annotations.BeforeSuite;
import hw7.annotations.Test;

public class MyTest {

    @BeforeSuite
    public void before() {
        System.out.println("Before the tests");
    }

    @AfterSuite
    public void after() {
        System.out.println("After the tests");
    }

    @Test(priority = 1)
    public void testWithPriorityOne() {
        System.out.println("Test with priority 1");
    }

    @Test(priority = 7)
    public void testWithPrioritySeven() {
        System.out.println("Test with priority 7");
    }

    @Test(priority = 10)
    public void testWithPriorityTen() {
        System.out.println("Test with priority 10");
    }

    @Test
    public void testOneWithDefaultPriority() {
        System.out.println("Test #1 with default priority (5)");
    }

    @Test
    public void testTwoWithDefaultPriority() {
        System.out.println("Test #2 with default priority (5)");
    }

}
