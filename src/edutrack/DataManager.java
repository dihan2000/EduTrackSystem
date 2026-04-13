package edutrack;

import java.util.ArrayList;

public class DataManager {
    private ArrayList<Student> students;
    private ArrayList<Course> courses;
    private ArrayList<Enrollment> enrollments;

    public DataManager() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
        enrollments = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addEnrollment(Enrollment enrollment) {
        enrollments.add(enrollment);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Enrollment> getEnrollments() {
        return enrollments;
    }
    public void removeStudentById(String studentId) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(studentId)) {
                students.remove(i);
                break;
            }
        }
    }
    public void removeCourseById(String courseId) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseId().equals(courseId)) {
                courses.remove(i);
                break;
            }
        }
    }
}