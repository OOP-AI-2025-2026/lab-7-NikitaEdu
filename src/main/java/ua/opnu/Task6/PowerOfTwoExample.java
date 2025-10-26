package ua.opnu.Task6;

import java.util.function.Function;

public class PowerOfTwoExample {

    public static void main(String[] args) {
        Integer[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        Function<Integer, Integer> powerOfTwo = n -> (int) Math.pow(2, n);
        System.out.println("2^n для n з масиву:");
        for (Integer number : numbers) {
            Integer result = powerOfTwo.apply(number);
            System.out.println("2^" + number + " = " + result);
        }
    }
}