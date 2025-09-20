import javax.swing.*;
import java.awt.*;

public class FacebookUI extends JFrame {
    private JPanel LoginPanel;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton createAccountButton;
    private JLabel forgotPasswordLabel;
    private JLabel facebookLabel;
    private JLabel taglineLabel;
    private JLabel createPageLabel;

    public FacebookUI() {
        // Main panel
        LoginPanel = new JPanel(new BorderLayout());
        LoginPanel.setBackground(new Color(240, 242, 245));

        // Left panel (logo + tagline)
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBackground(new Color(240, 242, 245));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(100, 60, 100, 20));

        facebookLabel = new JLabel("facebook");
        facebookLabel.setFont(new Font("Arial", Font.BOLD, 50));
        facebookLabel.setForeground(new Color(24, 119, 242));

        taglineLabel = new JLabel("<html>Facebook helps you connect and share<br>with the people in your life.</html>");
        taglineLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        taglineLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        leftPanel.add(facebookLabel);
        leftPanel.add(taglineLabel);

        // Right panel (login form)
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBackground(new Color(240, 242, 245));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(100, 20, 100, 60));

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220)),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        // Email field with placeholder
        emailField = new JTextField();
        emailField.setMaximumSize(new Dimension(300, 40));
        setPlaceholder(emailField, "Email address or phone number");

        // Password field with placeholder
        passwordField = new JPasswordField();
        passwordField.setMaximumSize(new Dimension(300, 40));
        setPasswordPlaceholder(passwordField, "Password");

        // Buttons and labels
        loginButton = new JButton("Log in");
        loginButton.setBackground(new Color(24, 119, 242));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        loginButton.setMaximumSize(new Dimension(300, 40));
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT); // <-- ito ang dagdag


        forgotPasswordLabel = new JLabel("Forgotten password?");
        forgotPasswordLabel.setForeground(new Color(24, 119, 242));
        forgotPasswordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JSeparator separator = new JSeparator();
        separator.setMaximumSize(new Dimension(300, 1));

        createAccountButton = new JButton("Create new account");
        createAccountButton.setBackground(new Color(66, 183, 42));
        createAccountButton.setForeground(Color.WHITE);
        createAccountButton.setFont(new Font("Arial", Font.BOLD, 14));
        createAccountButton.setMaximumSize(new Dimension(200, 40));
        createAccountButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add components to form
        formPanel.add(emailField);
        formPanel.add(Box.createVerticalStrut(10));
        formPanel.add(passwordField);
        formPanel.add(Box.createVerticalStrut(15));
        formPanel.add(loginButton);   // now centered
        formPanel.add(Box.createVerticalStrut(10));
        formPanel.add(forgotPasswordLabel);
        formPanel.add(Box.createVerticalStrut(10));
        formPanel.add(separator);
        formPanel.add(Box.createVerticalStrut(10));
        formPanel.add(createAccountButton);


        createPageLabel = new JLabel("<html><b>Create a Page</b> for a celebrity, brand or business.</html>");
        createPageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        createPageLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        createPageLabel.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));

        rightPanel.add(formPanel);
        rightPanel.add(createPageLabel);

        // Add left + right to main
        LoginPanel.add(leftPanel, BorderLayout.WEST);
        LoginPanel.add(rightPanel, BorderLayout.EAST);

        // Frame settings
        setContentPane(LoginPanel);
        setTitle("Facebook Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Utility: placeholder for JTextField
    private void setPlaceholder(JTextField field, String placeholder) {
        field.setForeground(Color.GRAY);
        field.setText(placeholder);

        field.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                if (field.getText().equals(placeholder)) {
                    field.setText("");
                    field.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setForeground(Color.GRAY);
                    field.setText(placeholder);
                }
            }
        });
    }

    // Utility: placeholder for JPasswordField
    private void setPasswordPlaceholder(JPasswordField field, String placeholder) {
        field.setForeground(Color.GRAY);
        field.setText(placeholder);
        field.setEchoChar((char) 0); // show text instead of •••

        field.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                String pwd = new String(field.getPassword());
                if (pwd.equals(placeholder)) {
                    field.setText("");
                    field.setForeground(Color.BLACK);
                    field.setEchoChar('•');
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (field.getPassword().length == 0) {
                    field.setForeground(Color.GRAY);
                    field.setText(placeholder);
                    field.setEchoChar((char) 0);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FacebookUI::new);
    }
}
