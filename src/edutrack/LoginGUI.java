import edutrack.EduTrackGUI;
import javax.swing.*;
import java.awt.*;

public class LoginGUI extends JFrame {

    private JTextField userField;
    private JPasswordField passField;

    public LoginGUI() {

        setTitle("EduTrack Login");
        setSize(450, 320);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Gradient Panel
        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(
                        0, 0, new Color(58, 123, 213),
                        0, getHeight(), new Color(0, 210, 255)
                );
                g2.setPaint(gp);
                g2.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        panel.setLayout(null);

// 🔲 WHITE CARD (premium look)
        JPanel card = new JPanel();
        card.setLayout(null);
        card.setBounds(60, 40, 320, 230);
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createLineBorder(new Color(220,220,220), 1));

        panel.add(card);

// TITLE
        JLabel title = new JLabel("Login");
        title.setBounds(130, 10, 100, 30);
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        card.add(title);

// USERNAME
        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(20, 50, 100, 20);
        card.add(userLabel);

        userField = new JTextField();
        userField.setBounds(20, 70, 280, 35);
        userField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        userField.setBorder(BorderFactory.createLineBorder(new Color(200,200,200)));
        card.add(userField);

// PASSWORD
        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(20, 110, 100, 20);
        card.add(passLabel);

        passField = new JPasswordField();
        passField.setBounds(20, 130, 280, 35);
        passField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        passField.setBorder(BorderFactory.createLineBorder(new Color(200,200,200)));
        card.add(passField);

// SHOW PASSWORD
        JCheckBox showPass = new JCheckBox("Show");
        showPass.setBounds(20, 170, 100, 20);
        showPass.setBackground(Color.WHITE);

        showPass.addActionListener(e -> {
            if (showPass.isSelected()) {
                passField.setEchoChar((char) 0);
            } else {
                passField.setEchoChar('•');
            }
        });

        card.add(showPass);

// LOGIN BUTTON
        JButton loginBtn = new JButton("LOGIN");
        loginBtn.setBounds(170, 170, 130, 35);

        loginBtn.setBackground(new Color(0, 102, 204));
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        loginBtn.setFocusPainted(false);
        loginBtn.setBorderPainted(false);
        loginBtn.setOpaque(true);

        card.add(loginBtn);
        loginBtn.addActionListener(e -> {
            String user = userField.getText();
            String pass = new String(passField.getPassword());

            if (user.equals("admin") && pass.equals("1234")) {
                JOptionPane.showMessageDialog(this, "Login Successful!");
                new EduTrackGUI().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Wrong Username or Password!");
            }
        });
        add(panel);
    }

    public static void main(String[] args) {
        new LoginGUI().setVisible(true);
    }
}