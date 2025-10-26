package ua.opnu.Task1;

import java.util.Arrays;
import java.util.function.Predicate;

public class PrimeFilter {

    public static Predicate<Integer> isPrime = number -> {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    };

    public static int[] filter(int[] input, Predicate<Integer> p) {
        int[] result = new int[input.length];
        int counter = 0;

        for (int i : input) {
            if (p.test(i)) {
                result[counter] = i;
                counter++;
            }
        }

        return Arrays.copyOfRange(result, 0, counter);
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int[] primeNumbers = filter(test, isPrime);
        System.out.println(Arrays.toString(primeNumbers)); // Виведе: [2, 3, 5, 7]
    }
}