import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    String course;
    String college;
    String email;

    Student(int id, String name, String course,
            String college, String email) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.college = college;
        this.email = email;
    }

    void display() {
        System.out.println("\n========== STUDENT ID CARD ==========");
        System.out.println("Student ID : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Course     : " + course);
        System.out.println("College    : " + college);
        System.out.println("Email      : " + email);
        System.out.println("=====================================");
    }
}

public class StudentIDManagement {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int nextId = 1001;

    // Add Student
    static void addStudent() {
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        System.out.print("Enter College Name: ");
        String college = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        Student s = new Student(
            nextId++, name, course, college, email
        );

        students.add(s);

        System.out.println("\nStudent added successfully!");
        s.display();
    }


    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        for (Student s : students) {
            s.display();
        }
    }

    
    static void searchStudent() {
        System.out.print("Enter Student ID: ");
        int id = Integer.parseInt(sc.nextLine());

        for (Student s : students) {
            if (s.id == id) {
                System.out.println("Student Found!");
                s.display();
                return;
            }
        }

        System.out.println("Student not found!");
    }

    
    static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = Integer.parseInt(sc.nextLine());

        for (Student s : students) {
            if (s.id == id) {
                students.remove(s);
                System.out.println("Student deleted successfully!");
                return;
            }
        }

        System.out.println("Student not found!");
    }


    public static void main(String[] args) {

        while (true) {
            System.out.println("\n==================================");
            System.out.println(" DIGITAL STUDENT ID MANAGEMENT");
            System.out.println("==================================");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    addStudent();
                    break;

                case "2":
                    viewStudents();
                    break;

                case "3":
                    searchStudent();
                    break;

                case "4":
                    deleteStudent();
                    break;

                case "5":
                    System.out.println("Thank you for using the system!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}

