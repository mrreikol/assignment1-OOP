package aitu;

import java.util.Random;

public class GroupTest {
    public static void main(String[] args) {
        Random rnd = new Random();

        Student.setNextId(250001);

        Group g = new Group("SE-2529");
        System.out.println(g);

        for (int i = 0; i < 8; i++) {
            Student s = new Student("Name" + (i + 1), "Surname" + (i + 1));
            for (int k = 0; k < 5; k++) {
                double grade = 50 + rnd.nextInt(51); //
                s.addGrade(grade);
            }
            g.addStudent(s);
        }

        System.out.println("\n" + g);
        g.printHallOfFame();

        int removeId = 250003;
        System.out.println("\nRemoving student with id=" + removeId + " -> " + g.removeStudent(removeId));

        System.out.println("\n" + g);
        g.printHallOfFame();
    }
}