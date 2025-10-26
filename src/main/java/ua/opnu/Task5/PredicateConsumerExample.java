package ua.opnu.Task5;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateConsumerExample {

    public static void processIf(Predicate<Integer> condition, Consumer<Integer> action, Integer[] numbers) {
        for (Integer number : numbers) {
            if (condition.test(number)) {
                action.accept(number);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Predicate<Integer> isEven = number -> number % 2 == 0;

        Predicate<Integer> isGreaterThanFive = number -> number > 5;

        Consumer<Integer> printAction = number -> System.out.println("Число: " + number);

        System.out.println("Парні числа:");
        processIf(isEven, printAction, numbers);

        System.out.println("\nЧисла, що більші за 5:");
        processIf(isGreaterThanFive, printAction, numbers);
    }
}