package CIE;

public class Student {
    protected String usn;
    protected String name;
    protected int semester;

    public Student(String usn, String name, int semester) {
        this.usn = usn;
        this.name = name;
        this.semester = semester;
    }

    public void displayStudentInfo() {
        System.out.println("Student Details:");
        System.out.println("USN: " + usn);
        System.out.println("Name: " + name);
        System.out.println("Semester: " + semester);
    }
}
