package ua.opnu.Task3;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class DualPredicateFilter {

    // Метод фільтрації за двома умовами
    public static <T> void filterAndConsume(T[] input, Predicate<T> condition1, Predicate<T> condition2, Consumer<T> action) {
        for (T element : input) {
            if (condition1.test(element) && condition2.test(element)) {
                action.accept(element);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Перша умова: число парне
        Predicate<Integer> isEven = number -> number % 2 == 0;

        // Друга умова: число більше 5
        Predicate<Integer> isGreaterThanFive = number -> number > 5;

        // Дія: виводимо елемент на консоль
        Consumer<Integer> printAction = number -> System.out.println("Число, що задовольняє умові: " + number);

        // Виклик методу фільтрації
        System.out.println("Фільтрування чисел за двома умовами:");
        filterAndConsume(numbers, isEven, isGreaterThanFive, printAction);
    }
}