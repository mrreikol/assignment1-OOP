package aitu;

public class Group {
    private String title;
    private Student[] students;
    private int capacity;
    private int numberOfStudents;

    public Group() {
        this("MyGroup");
    }

    public Group(String title) {
        this.title = title;
        this.capacity = 4;
        this.students = new Student[capacity];
        this.numberOfStudents = 0;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getNumberOfStudents() { return numberOfStudents; }

    public void addStudent(Student student) {
        if (student == null) return;

        if (numberOfStudents == capacity) {
            capacity *= 2;
            Student[] newArr = new Student[capacity];
            for (int i = 0; i < students.length; i++) newArr[i] = students[i];
            students = newArr;
        }
        students[numberOfStudents++] = student;
    }

    public double getAverageGpa() {
        if (numberOfStudents == 0) return 0.0;
        double sum = 0;
        for (int i = 0; i < numberOfStudents; i++) sum += students[i].getGpa();
        return sum / numberOfStudents;
    }

    public void printHallOfFame() {
        System.out.println("Hall of Fame (Honors GPA >= 3.5):");
        boolean found = false;
        for (int i = 0; i < numberOfStudents; i++) {
            if (students[i].isHonors()) {
                System.out.println(students[i]);
                found = true;
            }
        }
        if (!found) System.out.println("(no honors students)");
    }

    public boolean removeStudent(int id) {
        for (int i = 0; i < numberOfStudents; i++) {
            if (students[i].getId() == id) {
                for (int j = i; j < numberOfStudents - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[numberOfStudents - 1] = null;
                numberOfStudents--;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Group: " + title +
                ", numberOfStudents=" + numberOfStudents +
                ", averageGpa=" + String.format("%.2f", getAverageGpa());
    }
}