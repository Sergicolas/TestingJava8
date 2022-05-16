package TestingJava8.Model;

public class Course {

    private String courseName;
    private int students;

    public Course(String courseName, int students) {
        this.courseName = courseName;
        this.students = students;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getStudents() {
        return students;
    }

    public void setStudents(int students) {
        this.students = students;
    }
}