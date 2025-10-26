package ua.opnu.Task2;

import java.util.Arrays;
import java.util.function.Predicate;

public class StudentFilter {

    // Метод для фільтрації масиву студентів
    public static Student[] filterStudents(Student[] students, Predicate<Student> predicate) {
        return Arrays.stream(students)
                .filter(predicate)
                .toArray(Student[]::new);
    }

    public static void main(String[] args) {
        // Приклад масиву студентів
        Student[] students = {
                new Student("John", "Group A", new int[]{75, 80, 90}),
                new Student("Alice", "Group B", new int[]{55, 65, 70}),
                new Student("Bob", "Group A", new int[]{60, 59, 61}),
                new Student("Charlie", "Group B", new int[]{88, 92, 95})
        };

        // Предикат для фільтрації студентів без заборгованостей
        Predicate<Student> noDebts = student -> !student.hasDebts();

        // Використовуємо метод фільтрації
        Student[] passedStudents = filterStudents(students, noDebts);

        // Виводимо результати
        System.out.println("Студенти без заборгованостей:");
        for (Student student : passedStudents) {
            System.out.println(student.getName());
        }
    }
}