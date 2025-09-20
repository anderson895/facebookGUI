import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class FacebookUI extends JFrame {
    private JPanel FacebookPanel;
    private JLabel lblFacebook;
    private JLabel lblTagline;
    private JTextField txtEmail;
    private JPasswordField pswPassword;
    private JButton btnLogin;
    private JLabel lblForgot;
    private JButton btnCreate;
    private JLabel lblCreatePage;

    public FacebookUI() {
        setContentPane(FacebookPanel);
        setTitle("Facebook - Log in or Sign up");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);

        // === Global Background ===
        FacebookPanel.setBackground(new Color(240, 242, 245));

        // === Input Fields ===
        Border textFieldBorder = BorderFactory.createCompoundBorder(
                new LineBorder(new Color(200, 200, 200), 1, true),
                new EmptyBorder(10, 10, 10, 10)
        );
        txtEmail.setBorder(textFieldBorder);
        pswPassword.setBorder(textFieldBorder);

        // === Login Button (Blue) ===
        btnLogin.setFocusPainted(false);
        btnLogin.setBorder(new EmptyBorder(10, 0, 10, 0));



        // === Create Account Button (Green) ===
        btnCreate.setFocusPainted(false);
        btnCreate.setBorder(new EmptyBorder(10, 20, 10, 20));

        // === Create Page Label ===
        lblCreatePage.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblCreatePage.setForeground(Color.DARK_GRAY);

        // === White Card Effect for Right Panel ===
        JPanel rightPanel = (JPanel) txtEmail.getParent();
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBorder(new CompoundBorder(
                new LineBorder(new Color(220, 220, 220), 1, true),
                new EmptyBorder(20, 20, 20, 20)
        ));

        // === Example Actions ===
        btnLogin.addActionListener(e -> doLogin());

        btnCreate.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Redirecting to Create Account...")
        );

        lblForgot.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // === Keyboard Events ===
        // 1. Press ENTER in txtEmail -> move focus to password field
        txtEmail.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pswPassword.requestFocus();
                }
            }
        });

        // 2. Press ENTER in pswPassword -> trigger login button
        pswPassword.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnLogin.doClick(); // simulate click
                }
            }
        });

        setVisible(true);
    }

    private void doLogin() {
        String email = txtEmail.getText();
        String password = new String(pswPassword.getPassword());

        if (email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please enter both email and password.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Logging in as: " + email,
                    "Login", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FacebookUI::new);
    }
}
