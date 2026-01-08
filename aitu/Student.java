package aitu;

public class Student {
    private int id;
    private String firstname;
    private String lastname;
    private double[] grades;

    private static int nextId = 1;
    private static String domain = "astanait.edu.kz";

    public Student() {
        this("John", "Wick");
    }

    public Student(String firstname, String lastname) {
        this.id = nextId++;
        this.firstname = firstname;
        this.lastname = lastname;
        this.grades = new double[0];
    }

    public Student(String firstname, String lastname, double[] grades) {
        this.id = nextId++;
        this.firstname = firstname;
        this.lastname = lastname;
        this.grades = (grades == null) ? new double[0] : copyArray(grades);
    }

    private static double[] copyArray(double[] arr) {
        double[] c = new double[arr.length];
        for (int i = 0; i < arr.length; i++) c[i] = arr[i];
        return c;
    }

    // getters
    public int getId() { return id; }
    public String getFirstname() { return firstname; }
    public String getLastname() { return lastname; }
    public double[] getGrades() { return copyArray(grades); }

    public static int getNextId() { return nextId; }
    public static String getDomain() { return domain; }

    // setters (including static fields, as required)
    public void setId(int id) { this.id = id; }
    public void setFirstname(String firstname) { this.firstname = firstname; }
    public void setLastname(String lastname) { this.lastname = lastname; }
    public void setGrades(double[] grades) { this.grades = (grades == null) ? new double[0] : copyArray(grades); }

    public static void setNextId(int nextId) { Student.nextId = nextId; }
    public static void setDomain(String domain) { Student.domain = domain; }

    public String getFullName() {
        return firstname + " " + lastname;
    }

    public double getGpa() {
        if (grades.length == 0) return 0.0;

        double sum = 0;
        for (double g : grades) sum += g;
        double avg = sum / grades.length;

        // If grades look like 0..4 -> use directly. If look like 0..100 -> convert to 0..4
        if (avg <= 4.0) return avg;

        double gpa = avg / 25.0; // 100 -> 4.0
        if (gpa > 4.0) gpa = 4.0;
        return gpa;
    }

    public boolean isHonors() {
        return getGpa() >= 3.5;
    }

    public String getEmail() {
        return id + "@" + domain;
    }

    public void addGrade(double grade) {
        double[] newArr = new double[grades.length + 1];
        for (int i = 0; i < grades.length; i++) newArr[i] = grades[i];
        newArr[newArr.length - 1] = grade;
        grades = newArr;
    }

    @Override
    public String toString() {
        return id + " " + firstname + " " + lastname + " " + getEmail() + " " + String.format("%.2f", getGpa());
    }
}