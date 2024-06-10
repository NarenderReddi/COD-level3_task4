package com.inventory;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.ImageIcon;

/**
 * User Registration using Swing
 * 
 * @author javaguides.net
 *
 */
public class UserRegistration extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField firstname;
	private JTextField lastname;
	private JTextField email;
	private JTextField username;
	private JTextField mob;
	private JPasswordField passwordField;
	private JButton btnNewButton;
	private final JPanel panel = new JPanel();
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */

	public UserRegistration() {
		// setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Desktop\\STDM.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 190, 947, 597);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblName = new JLabel("First name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(474, 91, 99, 43);
		contentPane.add(lblName);

		JLabel lblNewLabel = new JLabel("Last name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(474, 135, 99, 29);
		contentPane.add(lblNewLabel);

		JLabel lblEmailAddress = new JLabel("Email\r\n address");
		lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmailAddress.setBounds(444, 296, 124, 36);
		contentPane.add(lblEmailAddress);

		firstname = new JTextField();
		firstname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		firstname.setBounds(606, 93, 147, 29);
		contentPane.add(firstname);
		firstname.setColumns(10);

		lastname = new JTextField();
		lastname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lastname.setBounds(606, 135, 147, 29);
		contentPane.add(lastname);
		lastname.setColumns(10);

		email = new JTextField();

		email.setFont(new Font("Tahoma", Font.PLAIN, 15));
		email.setBounds(606, 295, 147, 29);
		contentPane.add(email);
		email.setColumns(10);

		username = new JTextField();
		username.setFont(new Font("Tahoma", Font.PLAIN, 15));
		username.setBounds(606, 175, 147, 29);
		contentPane.add(username);
		username.setColumns(10);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsername.setBounds(474, 175, 90, 29);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(474, 223, 99, 24);
		contentPane.add(lblPassword);

		JLabel lblMobileNumber = new JLabel("Mobile number");
		lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMobileNumber.setBounds(434, 258, 139, 26);
		contentPane.add(lblMobileNumber);

		mob = new JTextField();
		mob.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mob.setBounds(606, 258, 147, 26);
		contentPane.add(mob);
		mob.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setBounds(606, 215, 147, 29);
		contentPane.add(passwordField);

		btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName = firstname.getText();
				String lastName = lastname.getText();
				String emailId = email.getText();
				String userName = username.getText();
				String mobileNumber = mob.getText();
				int len = mobileNumber.length();
				String password = passwordField.getText();

				String msg = "" + firstName;
				msg += " \n";
//				if (len != 10) {
//					JOptionPane.showMessageDialog(btnNewButton, "Please Check the details");
//				}
				firstname.setText(" ");
				lastname.setText(" ");
				email.setText(" ");
				username.setText(" ");
				mob.setText(" ");
				passwordField.setText(" ");

				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/reg", "root",
							"root");

					String query = "INSERT INTO account values('" + firstName + "','" + lastName + "','" + userName
							+ "','" + password + "','" + emailId + "','" + mobileNumber + "')";

					Statement sta = connection.createStatement();
					int x = sta.executeUpdate(query);
					if (x == 0) {
						JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
					}
					else {
						JOptionPane.showMessageDialog(btnNewButton, "Submitted");

					}
					Start us=new Start();
					us.show();
					dispose();

					connection.close();
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.setBounds(520, 414, 157, 43);
		contentPane.add(btnNewButton);
		panel.setBackground(Color.BLACK);
		panel.setForeground(Color.WHITE);
		panel.setBounds(0, 0, 348, 574);
		contentPane.add(panel);
				panel.setLayout(null);
		
				JLabel lblNewUserRegister = new JLabel("New User Register");
				lblNewUserRegister.setForeground(Color.WHITE);
				lblNewUserRegister.setBounds(22, 107, 316, 57);
				panel.add(lblNewUserRegister);
				lblNewUserRegister.setFont(new Font("Tempus Sans ITC", Font.BOLD, 32));
				
				lblNewLabel_2 = new JLabel("New label");
				lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Thilak_Reddi\\Desktop\\pics\\images-removebg-preview.png"));
				lblNewLabel_2.setBounds(-17, 157, 355, 290);
				panel.add(lblNewLabel_2);
				
				lblNewLabel_1 = new JLabel("Fill the Details");
				lblNewLabel_1.setForeground(Color.RED);
				lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 22));
				lblNewLabel_1.setBounds(549, 25, 204, 36);
				contentPane.add(lblNewLabel_1);
	}
}
