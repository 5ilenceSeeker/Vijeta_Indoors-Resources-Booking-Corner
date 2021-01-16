package carparking;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

public class carromsearch extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					carromsearch frame = new carromsearch();
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
	Connection connection = null;
	private JTable table;
	
	public carromsearch() {
		setUndecorated(true);
		connection = conn.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setBounds(520, 200, 1000, 700);
		contentPane.setBackground(Color.gray);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 98, 919, 549);
		contentPane.add(scrollPane);
		
		JButton btnForBooking = new JButton("For Booking");
		btnForBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				carrom ls= new carrom();
				ls.setVisible(true);
			}
		});
		btnForBooking.setFont(new Font("Serif", Font.BOLD, 30));
		btnForBooking. setBackground(Color.gray);
		btnForBooking. setOpaque(true);
		btnForBooking.setBounds(197, 25, 265, 38);
		contentPane.add(btnForBooking);
		
		JButton btnShowBooking = new JButton("Show Booking");
		btnShowBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
					LocalDateTime now = LocalDateTime.now(); 
					String date =  dtf.format(now);				
//					System.out.println(date);
					
					String query="select Name,fromm,tooo,mobile,Date,roll,tablee from carrom where Date = '"+ date +"' ";
					PreparedStatement pat= connection.prepareStatement(query);
					ResultSet rs=pat.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnShowBooking.setFont(new Font("Serif", Font.BOLD, 30));
		btnShowBooking. setBackground(Color.gray);
		btnShowBooking. setOpaque(true);
		btnShowBooking.setBounds(609, 25, 279, 38);
		contentPane.add(btnShowBooking);
		
		table = new JTable();
		table.setFont(new Font("Serif", Font.BOLD, 15));
		table.setBackground(Color.pink);
		scrollPane.setViewportView(table);
		
		JButton backBtn = new JButton();
		backBtn.setBorder(BorderFactory.createEmptyBorder());
		backBtn.setContentAreaFilled(false);
		Icon icon4 = new ImageIcon(getClass().getResource("/backIcon.png"));
		backBtn.setIcon(icon4);
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				games las= new games();
				las.setVisible(true);
			}
		});
		backBtn.setBounds(0, 0, 69, 55);
		contentPane.add(backBtn);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 1000, 700);
		Icon icon22 = new ImageIcon(getClass().getResource("/p27.jpeg"));
		lblNewLabel_1.setIcon(icon22);
		contentPane.add(lblNewLabel_1);
	}

}
