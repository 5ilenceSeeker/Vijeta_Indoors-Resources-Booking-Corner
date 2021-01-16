package carparking;
import java.awt.*;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import carparking.conn;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class first extends JFrame{

//	private JFrame frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					first window = new first();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public first() {
		initialize();
	}
	private void initialize() {
//		frame = new JFrame();
		getContentPane().setBackground(new Color(255, 255, 240));
		setBounds(600, 300, 1000, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		//setUndecorated(true);
		
		JLabel lblWelcomeToOnline = new JLabel("Vijeta-Indore Slot Booking System");
		lblWelcomeToOnline.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToOnline.setForeground(new Color(0, 128, 128));
		lblWelcomeToOnline.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 25));
		lblWelcomeToOnline.setBounds(12, 28, 604, 82);
		getContentPane().add(lblWelcomeToOnline);
		
		JLabel lblNewLabel = new JLabel("");
		Icon iconn = new ImageIcon(getClass().getResource("/vw-beetle-icon3.png"));
		lblNewLabel.setIcon(iconn);
		lblNewLabel.setBounds(173, 104, 292, 188);
		getContentPane().add(lblNewLabel);
		
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
		btnAdmin.setBounds(232, 322, 156, 42);
		getContentPane().add(btnAdmin);
		
//		JButton btnExit = new JButton();
//		btnExit.setBorder(BorderFactory.createEmptyBorder());
//		btnExit.setContentAreaFilled(false);
//		Icon icon = new ImageIcon(getClass().getResource("/exit.png"));
//		btnExit.setIcon(icon);
//		btnExit.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				boolean flag = false;
//				for(int i=0;i<25;i++) {
//					if(ParkingSlotMatrix.slotMatrix[i].equals("") ){
//						flag = false;
//					}else {
//						flag = true;
//						break;
//					}
//				}
//				if(  !flag) {
//					System.exit(0);
//				}
//				else {
//					JOptionPane.showMessageDialog(null, "Warning!!! Cars are still Parked ");
//				}
//			}
//		});
//		btnExit.setBounds(562, 12, 54, 48);
//		getContentPane().add(btnExit);
		
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
		btnAbout.setBounds(562, 367, 54, 70);
		getContentPane().add(btnAbout);
	}

}
