package carparking;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class booking extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					booking frame = new booking();
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
	public booking() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setBounds(520, 200, 1000, 700);
		contentPane.setBackground(Color.gray);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		JButton btnLogout_1 = new JButton("");
		btnLogout_1.setBounds(-23, 12, 117, 56);
		contentPane.add(btnLogout_1);
		Icon icon6 = new ImageIcon(getClass().getResource("/logout.png"));
		btnLogout_1.setIcon(icon6);
		btnLogout_1.setContentAreaFilled(false);
		btnLogout_1.setBorder(null);
		btnLogout_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				log fs= new log();
				fs.setVisible(true);
			}
		});
		
		JButton btnBooking = new JButton("");
		btnBooking.setBounds(445, 234, 157, 150);
		contentPane.add(btnBooking);
		Icon icon7 = new ImageIcon(getClass().getResource("/his-1.png"));
		btnBooking.setIcon(icon7);
		btnBooking.setContentAreaFilled(false);
		btnBooking.setBorder(null);
		btnBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				games gs= new games();
				gs.setVisible(true);
			}
		});
		
		JButton btnHistory = new JButton("");
		btnHistory.setBounds(135, 222, 135, 162);
		contentPane.add(btnHistory);
		Icon icon5 = new ImageIcon(getClass().getResource("/db1.png"));
		btnHistory.setIcon(icon5);
		btnHistory.setContentAreaFilled(false);
		btnHistory.setBorder(null);
		btnHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				History gs= new History();
				gs.setVisible(true);
			}
		});
		
		JButton btnResorces = new JButton("");
		btnResorces.setBounds(738, 234, 135, 128);
		contentPane.add(btnResorces);
		Icon icon55 = new ImageIcon(getClass().getResource("/res.png"));
		btnResorces.setIcon(icon55);
		btnResorces.setContentAreaFilled(false);
		btnResorces.setBorder(null);
		btnResorces.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				res fs= new res();
				fs.setVisible(true);
			}
		});
		
		JLabel lblHistory = new JLabel("History");
		lblHistory.setBounds(135, 409, 135, 37);
		lblHistory.setFont(new Font("Serif", Font.BOLD, 30));
		lblHistory.setForeground(Color.black);
		contentPane.add(lblHistory);
		
		JLabel lblBooking = new JLabel("Booking");
		lblBooking.setBounds(463, 409, 147, 37);
		lblBooking.setFont(new Font("Serif", Font.BOLD, 30));
		lblBooking.setForeground(Color.black);
		contentPane.add(lblBooking);
		
		JLabel lblBooking1 = new JLabel("Resources");
		lblBooking1.setBounds(747, 409, 186, 37);
		lblBooking1.setFont(new Font("Serif", Font.BOLD, 30));
		lblBooking1.setForeground(Color.black);
		contentPane.add(lblBooking1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 1000, 700);
		Icon icon22 = new ImageIcon(getClass().getResource("/p27.jpeg"));
		lblNewLabel_1.setIcon(icon22);
		contentPane.add(lblNewLabel_1);
		
		
	}
}
