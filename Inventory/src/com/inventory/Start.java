package com.inventory;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.ImageIcon;
import java.awt.Button;

public class Start extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start frame = new Start();
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
	public Start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 499);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2,
				(Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 201, 460);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserLogin uslogin = new UserLogin();
				uslogin.show();
				setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2,
						(Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
				dispose();

			}
		});
		btnNewButton.setBounds(42, 149, 121, 33);
		panel.add(btnNewButton);

		JButton btnRegistration = new JButton("Registration");
		btnRegistration.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserRegistration reg = new UserRegistration();
				reg.show();
				setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2,
						(Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);

				dispose();

			}
		});
		btnRegistration.setForeground(Color.BLACK);
		btnRegistration.setBackground(Color.WHITE);
		btnRegistration.setBounds(42, 230, 121, 33);
		panel.add(btnRegistration);

		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnNewButton, "Exiting From Application");
				setLocationRelativeTo(null); // this method display the JFrame to center position of a screen

				System.exit(0);
			}
		});
		btnExit.setForeground(Color.BLACK);
		btnExit.setBackground(Color.WHITE);
		btnExit.setBounds(42, 309, 121, 33);
		panel.add(btnExit);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(
				"C:\\Users\\Thilak_Reddi\\Desktop\\pics\\1000_F_317465765_3dqiYi0VM852ISXLOworY69JF0ybkald-removebg-preview.png"));
		lblNewLabel.setBounds(184, 102, 422, 196);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(" ");
		lblNewLabel_1.setIcon(new ImageIcon(
				"C:\\Users\\Thilak_Reddi\\Desktop\\pics\\Screenshot_2024-05-20_203555-removebg-preview.png"));
		lblNewLabel_1.setBounds(392, 270, 140, 51);
		contentPane.add(lblNewLabel_1);
	}
}
