package ua.opnu.TaskBonus;

public class Student {
    private final String name;
    private final String lastName;
    private final double avgMark; // Середній бал

    public Student(String name, String lastName, double avgMark) {
        this.name = name;
        this.lastName = lastName;
        this.avgMark = avgMark;
    }

    public String getName() {
        return name;
    }


    public String getLastName() {
        return lastName;
    }


    public double getAvgMark() {
        return avgMark;
    }


    @Override
    public String toString() {

        return lastName +
                " " +
                name +
                ", середній бал: " + avgMark;
    }
}