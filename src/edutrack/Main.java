package edutrack;

public class Main {
    public static void main(String[] args) {

        DataManager manager = new DataManager();

                    Student s1 = new Student("S001", "Dihan", "1234");
        Student s2 = new Student("S002", "Mahi", "5678");

        Admin a1 = new Admin("A001", "Teacher", "admin123");

        Course c1 = new Course("C001", "Java Programming", "Mr. John");
        Course c2 = new Course("C002", "Database Systems", "Ms. Lina");

        manager.addStudent(s1);
        manager.addStudent(s2);

        manager.addCourse(c1);
        manager.addCourse(c2);

        manager.addEnrollment(new Enrollment("S001", "C001"));
        manager.addEnrollment(new Enrollment("S002", "C002"));

        System.out.println("Admin: " + a1.getName() + " Role: " + a1.getRole());

        System.out.println("\nStudents:");
        for (Student student : manager.getStudents()) {
            System.out.println(student.getId() + " - " + student.getName());
        }

        System.out.println("\nCourses:");
        for (Course course : manager.getCourses()) {
            System.out.println(course);
        }

        System.out.println("\nEnrollments:");
        for (Enrollment enrollment : manager.getEnrollments()) {
            System.out.println("Student ID: " + enrollment.getStudentId() +
                    " enrolled in Course ID: " + enrollment.getCourseId());

        }
        FileManager.saveStudents(manager);
    }
}
