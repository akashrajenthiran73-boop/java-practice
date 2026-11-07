import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Student> students = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");

            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    deleteStudent();
                    break;

                case 5:
                    System.out.println("Thank You!");
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    // Add Student
    static void addStudent() {

        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        Student s = new Student(id, name, age, department);

        students.add(s);

        System.out.println("Student Added Successfully!");
    }

    // View Students
    static void viewStudents() {

        if (students.isEmpty()) {

            System.out.println("No Students Found!");

        } else {

            for (Student s : students) {

                s.display();
            }
        }
    }

    // Search Student
    static void searchStudent() {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        boolean found = false;

        for (Student s : students) {

            if (s.id == id) {

                s.display();
                found = true;
                break;
            }
        }

        if (!found) {

            System.out.println("Student Not Found!");
        }
    }

    // Delete Student
    static void deleteStudent() {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        boolean found = false;

        for (Student s : students) {

            if (s.id == id) {

                students.remove(s);

                System.out.println("Student Deleted Successfully!");

                found = true;
                break;
            }
        }

        if (!found) {

            System.out.println("Student Not Found!");
        }
    }
}