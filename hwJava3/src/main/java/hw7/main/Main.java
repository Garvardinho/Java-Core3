package hw7.main;

import hw7.annotations.AfterSuite;
import hw7.annotations.BeforeSuite;
import hw7.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Main {
    private static final int MIN_METHOD_PRIORITY = 1;
    private static final int MAX_METHOD_PRIORITY = 10;

    public static void main(String[] args) {
        start(MyTest.class);
    }

    public static <T> void start(Class<T> tClass) {
        Queue <Method> methodsInPriority = getMethodsInPriority(tClass);

        while (methodsInPriority.size() != 0)
            execute(tClass, methodsInPriority.remove());
    }

    private static <T> Queue<Method> getMethodsInPriority(Class<T> tClass) {
        Queue<Method> methodsQueue = new PriorityQueue<>((method1, method2) -> {
            if (method1.isAnnotationPresent(Test.class) && method2.isAnnotationPresent(Test.class))
                return method1.getAnnotation(Test.class).priority() - method2.getAnnotation(Test.class).priority();
            else {
                if (method1.isAnnotationPresent(BeforeSuite.class) || method2.isAnnotationPresent(AfterSuite.class))
                    return -1;
                if (method2.isAnnotationPresent(BeforeSuite.class) || method1.isAnnotationPresent(AfterSuite.class))
                    return 1;

                return 0;
            }
        });
        Method[] methods = tClass.getMethods();
        boolean beforeSuiteIsPresented = false;
        boolean afterSuiteIsPresented = false;

        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                if (beforeSuiteIsPresented)
                    throw new RuntimeException(BeforeSuite.class.getSimpleName() +
                            " is presented more than once at the method " + method.getName());


                methodsQueue.add(method);
                beforeSuiteIsPresented = true;
            }

            if (method.isAnnotationPresent(AfterSuite.class)) {
                if (afterSuiteIsPresented)
                    throw new RuntimeException(AfterSuite.class.getSimpleName() +
                            " is presented more than once at the method " + method.getName());


                methodsQueue.add(method);
                afterSuiteIsPresented = true;
            }

            if (method.isAnnotationPresent(Test.class)) {
                int priority = method.getAnnotation(Test.class).priority();

                if (priority < MIN_METHOD_PRIORITY || priority > MAX_METHOD_PRIORITY)
                    throw new RuntimeException("Priority of method " +
                            method.getName() + " is out of range (1-10)");

                methodsQueue.add(method);
            }
        }

        return methodsQueue;
    }

    private static <T> T getInstanceOf(Class<T> tClass) {
        try {
            return tClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static <T> void execute(Class<T> tClass, Method method) {
        try {
            method.setAccessible(true);
            method.invoke(getInstanceOf(tClass));
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
