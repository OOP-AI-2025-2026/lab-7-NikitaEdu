package ua.opnu.Task4;

import ua.opnu.Task2.Student;

import java.util.function.Consumer;

public class StudentConsumerExample {

    // Метод forEach, який приймає масив студентів та акцію
    public static void forEach(Student[] students, Consumer<Student> action) {
        for (Student student : students) {
            action.accept(student);
        }
    }

    public static void main(String[] args) {
        // Створюємо масив студентів
        Student[] students = {
                new Student("Ivan", "Petrenko"),
                new Student("Oksana", "Ivanova"),
                new Student("Viktor", "Sidorov")
        };

        // Реалізуємо Consumer для виводу імені та прізвища студента
        Consumer<Student> printStudent = student -> System.out.println(student.getLastName() + " " + student.getName());

        // Викликаємо метод forEach для виводу даних студентів
        System.out.println("Список студентів:");
        forEach(students, printStudent);
    }
}