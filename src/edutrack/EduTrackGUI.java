package edutrack;

import javax.swing.*;
import java.awt.*;

public class EduTrackGUI extends JFrame {

    private JTextArea textArea;
    private DataManager manager;

    public EduTrackGUI() {
        manager = new DataManager();

        manager.addStudent(new Student("S001", "Dihan", "1234"));
        manager.addStudent(new Student("S002", "Mahi", "5678"));

        manager.addCourse(new Course("C001", "Java Programming", "Mr. John"));
        manager.addCourse(new Course("C002", "Database Systems", "Ms. Lina"));

        manager.addEnrollment(new Enrollment("S001", "C001"));
        manager.addEnrollment(new Enrollment("S002", "C002"));

        setTitle("EduTrack: Student Learning Management System");
        setSize(950, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 12));
        topPanel.setBackground(new Color(33, 150, 243));

        JButton btnStudents = new JButton("Show Students");
        JButton btnCourses = new JButton("Show Courses");
        JButton btnEnrollments = new JButton("Show Enrollments");
        JButton btnSave = new JButton("Save Students");
        JButton btnAddStudent = new JButton("Add Student");
        JButton btnDeleteStudent = new JButton("Delete Student");
        JButton btnAddCourse = new JButton("Add Course");

        styleButton(btnStudents);
        styleButton(btnCourses);
        styleButton(btnEnrollments);
        styleButton(btnSave);
        styleButton(btnAddStudent);
        styleButton(btnDeleteStudent);
        styleButton(btnAddCourse);

        btnStudents.addActionListener(e -> showStudents());
        btnCourses.addActionListener(e -> showCourses());
        btnEnrollments.addActionListener(e -> showEnrollments());
        btnSave.addActionListener(e -> saveStudents());
        btnAddStudent.addActionListener(e -> addStudent());
        btnDeleteStudent.addActionListener(e -> deleteStudent());
        btnAddCourse.addActionListener(e -> addCourse());

        topPanel.add(btnStudents);
        topPanel.add(btnCourses);
        topPanel.add(btnEnrollments);
        topPanel.add(btnSave);
        topPanel.add(btnAddStudent);
        topPanel.add(btnDeleteStudent);
        topPanel.add(btnAddCourse);

        add(topPanel, BorderLayout.NORTH);

        ImageIcon bgIcon = new ImageIcon(getClass().getResource("/edutrack/bg.jpg"));
        Image img = bgIcon.getImage().getScaledInstance(950, 600, Image.SCALE_SMOOTH);
        bgIcon = new ImageIcon(img);

        JLabel background = new JLabel(bgIcon);
        background.setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setOpaque(false);
        textArea.setForeground(Color.WHITE);
        textArea.setFont(new Font("Arial", Font.BOLD, 20));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setMargin(new Insets(20, 20, 20, 20));

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);

        background.add(scrollPane, BorderLayout.CENTER);

        add(background, BorderLayout.CENTER);
    }

    private void styleButton(JButton button) {
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);
        button.setFont(new Font("Arial", Font.BOLD, 13));
        button.setFocusPainted(false);
    }

    private void showStudents() {
        textArea.setText("Students:\n\n");
        for (Student s : manager.getStudents()) {
            textArea.append(s.getId() + " - " + s.getName() + "\n");
        }
    }

    private void showCourses() {
        textArea.setText("Courses:\n\n");
        for (Course c : manager.getCourses()) {
            textArea.append(c.toString() + "\n");
        }
    }

    private void showEnrollments() {
        textArea.setText("Enrollments:\n\n");
        for (Enrollment e : manager.getEnrollments()) {
            textArea.append("Student ID: " + e.getStudentId()
                    + " enrolled in Course ID: " + e.getCourseId() + "\n");
        }
    }

    private void saveStudents() {
        FileManager.saveStudents(manager);
        JOptionPane.showMessageDialog(this, "Students saved to file successfully!");
    }

    private void addStudent() {
        String id = JOptionPane.showInputDialog(this, "Enter Student ID:");
        String name = JOptionPane.showInputDialog(this, "Enter Student Name:");
        String password = JOptionPane.showInputDialog(this, "Enter Password:");

        if (id != null && name != null && password != null
                && !id.trim().isEmpty() && !name.trim().isEmpty() && !password.trim().isEmpty()) {
            Student newStudent = new Student(id, name, password);
            manager.addStudent(newStudent);
            JOptionPane.showMessageDialog(this, "Student added successfully!");
            showStudents();
        }
    }

    private void deleteStudent() {
        String id = JOptionPane.showInputDialog(this, "Enter Student ID to delete:");

        if (id != null && !id.trim().isEmpty()) {
            manager.removeStudentById(id);
            JOptionPane.showMessageDialog(this, "Student deleted successfully!");
            showStudents();
        }
    }

    private void addCourse() {
        String id = JOptionPane.showInputDialog(this, "Enter Course ID:");
        String name = JOptionPane.showInputDialog(this, "Enter Course Name:");
        String instructor = JOptionPane.showInputDialog(this, "Enter Instructor Name:");

        if (id != null && name != null && instructor != null
                && !id.trim().isEmpty() && !name.trim().isEmpty() && !instructor.trim().isEmpty()) {
            Course newCourse = new Course(id, name, instructor);
            manager.addCourse(newCourse);
            JOptionPane.showMessageDialog(this, "Course added successfully!");
            showCourses();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EduTrackGUI().setVisible(true));
    }
}