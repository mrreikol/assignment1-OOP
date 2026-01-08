package aitu;

import java.util.Random;
import java.util.Scanner;

public class StudentTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();

        Student.setNextId(250001);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Firstname of student " + (i + 1) + ": ");
            String fn = sc.nextLine();
            System.out.print("Lastname of student " + (i + 1) + ": ");
            String ln = sc.nextLine();

            students[i] = new Student(fn, ln);

            for (int k = 0; k < 5; k++) {
                double grade = 50 + rnd.nextInt(51);
                students[i].addGrade(grade);
            }
        }

        System.out.println("\nID Firstname Lastname Email GPA");
        for (Student s : students) {
            System.out.println(s.toString());
        }

        sc.close();
    }
}