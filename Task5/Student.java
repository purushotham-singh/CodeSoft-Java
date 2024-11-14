package Task5;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int rollNumber;
    private String grade;
    private String department;

    public Student(String name, int rollNumber, String grade, String department) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        this.department = department;
    }

    // Getters and Setters
    public String getName() { return name; }
    public int getRollNumber() { return rollNumber; }
    public String getGrade() { return grade; }
    public String getDepartment() { return department; }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll No: " + rollNumber + ", Grade: " + grade + ", Department: " + department;
    }
}
