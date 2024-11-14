package Task5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagementSystem {
    private List<Student> students = new ArrayList<>();
    private static final String FILE_NAME = "students.dat";

    // Load students from file
    public StudentManagementSystem() {
        loadFromFile();
    }

    // Method to add a student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    // Method to remove a student by roll number
    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
        System.out.println("Student removed successfully.");
    }

    // Method to search for a student by roll number
    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        System.out.println("Student not found.");
        return null;
    }

    // Method to display all students
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    // Method to save students to file
    public void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // Method to load students from file
    private void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            students = (List<Student>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No saved data found.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}
