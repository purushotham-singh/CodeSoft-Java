package Task5;
import java.util.Scanner;
public class StudentManagementSystemApp {
    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Management System:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Save Data");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter grade: ");
                    String grade = scanner.nextLine();
                    System.out.print("Enter department: ");
                    String department = scanner.nextLine();

                    if (!name.isEmpty() && rollNumber > 0 && !grade.isEmpty() && !department.isEmpty()) {
                        Student student = new Student(name, rollNumber, grade, department);
                        system.addStudent(student);
                    } else {
                        System.out.println("Invalid input. All fields are required.");
                    }
                    break;
                case 2:
                    System.out.print("Enter roll number to remove: ");
                    int rollNoToRemove = scanner.nextInt();
                    system.removeStudent(rollNoToRemove);
                    break;
                case 3:
                    System.out.print("Enter roll number to search: ");
                    int rollNoToSearch = scanner.nextInt();
                    Student student = system.searchStudent(rollNoToSearch);
                    if (student != null) {
                        System.out.println(student);
                    }
                    break;
                case 4:
                    system.displayAllStudents();
                    break;
                case 5:
                    system.saveToFile();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    system.saveToFile(); // Save before exit
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
