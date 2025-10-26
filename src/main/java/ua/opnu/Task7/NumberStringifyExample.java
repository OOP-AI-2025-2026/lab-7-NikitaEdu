package ua.opnu.Task7;

import java.util.function.Function;

public class NumberStringifyExample {

    public static String[] stringify(int[] numbers, Function<Integer, String> converter) {
        String[] result = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            result[i] = converter.apply(numbers[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        Function<Integer, String> numberToString = number -> switch (number) {
            case 0 -> "нуль";
            case 1 -> "один";
            case 2 -> "два";
            case 3 -> "три";
            case 4 -> "чотири";
            case 5 -> "п'ять";
            case 6 -> "шість";
            case 7 -> "сім";
            case 8 -> "вісім";
            case 9 -> "дев'ять";
            default -> "";
        };

        String[] stringifiedNumbers = stringify(numbers, numberToString);

        System.out.println("Числа у рядковому представленні:");
        for (String str : stringifiedNumbers) {
            System.out.println(str);
        }
    }
}