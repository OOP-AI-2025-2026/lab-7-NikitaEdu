package ua.opnu.Task2;

import java.util.Arrays;

public class Student {
    private String name;
    private String lastName;
    private String group;
    private int[] marks;

    // Конструктор
    public Student(String name, String group, int[] marks) {
        this.name = name;
        this.group = group;
        this.marks = marks;
    }
    public Student(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
    // Гетери
    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int[] getMarks() {
        return marks;
    }

    // Метод для перевірки, чи є студент з заборгованостями
    public boolean hasDebts() {
        return Arrays.stream(marks).anyMatch(mark -> mark < 60);
    }

    public String getLastName() {
        return lastName;
    }
}