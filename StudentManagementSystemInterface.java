import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    String name;
    int rollNumber;
    String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }
}

class StudentManagementSystem {
    List<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int rollNumber) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).rollNumber == rollNumber) {
                students.remove(i);
                break;
            }
        }
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.rollNumber == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void displayStudents() {
        for (Student student : students) {
            System.out.println("Name: " + student.name);
            System.out.println("Roll Number: " + student.rollNumber);
            System.out.println("Grade: " + student.grade);
            System.out.println();
        }
    }
}

public class StudentManagementSystemInterface{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();
        while (true) {
            System.out.println("Enter 1 to add a student, 2 to remove a student, 3 to search for a student, 4 to display all students, or 5 to exit: ");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                System.out.println("Enter student name: ");
                String name = sc.nextLine();
                System.out.println("Enter student roll number: ");
                int rollNumber = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter student grade: ");
                String grade = sc.nextLine();
                Student student = new Student(name, rollNumber, grade);
                sms.addStudent(student);
            } else if (choice == 2) {
                System.out.println("Enter student roll number: ");
                int rollNumber = sc.nextInt();
                sms.removeStudent(rollNumber);
            } else if (choice == 3) {
                System.out.println("Enter student roll number: ");
                int rollNumber = sc.nextInt();
                Student student = sms.searchStudent(rollNumber);
                if (student != null) {
                    System.out.println("Name: " + student.name);
                    System.out.println("Roll Number: " + student.rollNumber);
                    System.out.println("Grade: " + student.grade);
                    System.out.println();
                } else {
                    System.out.println("Student not found.");
                }
            } else if (choice == 4) {
                sms.displayStudents();
            } else if (choice == 5) {
                break;
            }
        }
    }
}
