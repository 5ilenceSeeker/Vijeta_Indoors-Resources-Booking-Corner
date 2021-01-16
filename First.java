package carparking;
import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import carparking.conn;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class First extends JFrame{

//	private JFrame frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					First window = new First();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public First() {
		initialize();
	}
	private void initialize() {
		setBounds(520, 200, 1000, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblWelcomeToOnline = new JLabel("VIJETA");
		lblWelcomeToOnline.setFont(new Font("Serif", Font.BOLD, 50));
		lblWelcomeToOnline.setForeground(Color.blue);
		lblWelcomeToOnline.setBounds(430, 95, 215, 82);
		getContentPane().add(lblWelcomeToOnline);
		
		JButton btnAdmin = new JButton("Admin Login");
		btnAdmin.setHorizontalAlignment(SwingConstants.LEFT);
		Icon icon3 = new ImageIcon(getClass().getResource("/admin.png"));
		btnAdmin.setIcon(icon3);
		btnAdmin.setForeground(new Color(255, 255, 255));
		btnAdmin.setBackground(new Color(100, 149, 237));
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				log ob = new log();
				ob.setVisible(true);
			}
		});
		btnAdmin.setBounds(114, 565, 156, 42);
		getContentPane().add(btnAdmin);
		
		JButton btnAbout = new JButton();
		btnAbout.setBorder(BorderFactory.createEmptyBorder());
		btnAbout.setContentAreaFilled(false);
		Icon icon2 = new ImageIcon(getClass().getResource("/info.png"));
		btnAbout.setIcon(icon2);
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				about ab = new about();
				ab.setVisible(true);
			}
		});
		btnAbout.setBounds(921, 600, 54, 70);
		getContentPane().add(btnAbout);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 1000, 700);
		Icon icon22 = new ImageIcon(getClass().getResource("/LOGO.png"));
		lblNewLabel_1.setIcon(icon22);
		getContentPane().add(lblNewLabel_1);
	}

}