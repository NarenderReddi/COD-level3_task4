package com.inventory;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

public class UserLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnNewButton;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JLabel label_1;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogin frame = new UserLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 190, 738, 551);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(472, 119, 193, 33);
		contentPane.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField.setBounds(472, 197, 193, 33);
		contentPane.add(passwordField);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBackground(Color.BLACK);
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblUsername.setBounds(330, 107, 92, 52);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setBackground(Color.CYAN);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(341, 193, 82, 38);
		contentPane.add(lblPassword);

		btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(514, 278, 127, 38);
		btnNewButton.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String userName = textField.getText();
				String passWord = passwordField.getText();
				try {
					Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/reg",
							"root", "root");

					PreparedStatement st = (PreparedStatement) connection
							.prepareStatement("Select count(*)from  account where username=? and password=?");

					st.setString(1, userName);
					st.setString(2, passWord);
					ResultSet rs = st.executeQuery();

					if ("".equals(textField.getText())) {

						JOptionPane.showMessageDialog(new JFrame(), "Username is require", "Dialog",
								JOptionPane.ERROR_MESSAGE);

					} else if ("".equals(passwordField.getText())) {

						JOptionPane.showMessageDialog(new JFrame(), "Password  is require", "Dialog",
								JOptionPane.ERROR_MESSAGE);
					}

					while (rs.next()) {
						int res = rs.getInt(1);
						if (res > 0) {
							Store s=new Store();
							s.show();
							dispose();
						} else {
							JOptionPane.showMessageDialog(new JFrame(), "enter correct details", "Dialog",
									JOptionPane.ERROR_MESSAGE);

						}

					}

				} catch (SQLException sqlException) {
					sqlException.printStackTrace();
				}
			}
		});

		contentPane.add(btnNewButton);

		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 274, 512);
		contentPane.add(panel);
		panel.setLayout(null);

		label_1 = new JLabel("");
		label_1.setBounds(114, 5, 46, 14);
		panel.add(label_1);

		JLabel lblNewLabel = new JLabel("Login...");
		lblNewLabel.setBounds(54, 136, 164, 62);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 40));

		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(
				"C:\\Users\\Thilak_Reddi\\Desktop\\pics\\account-login-flat-illustration-vector-removebg-preview (1).png"));
		lblNewLabel_2.setBounds(10, 197, 264, 242);
		panel.add(lblNewLabel_2);

		lblNewLabel_1 = new JLabel("Enter Credentials..");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(426, 28, 215, 38);
		contentPane.add(lblNewLabel_1);
	}
}