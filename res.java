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

public class res extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					res frame = new res();
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
	public res() {
		setUndecorated(true);
		connection = conn.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setBounds(520, 200, 1000, 700);
		contentPane.setBackground(Color.gray);
		
		JButton btnShowBooking = new JButton("Show Resources");
		btnShowBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
					LocalDateTime now = LocalDateTime.now(); 
					String date =  dtf.format(now);				
//					System.out.println(date);
					
					String query="select * from res";
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
		btnShowBooking.setBounds(296, 64, 343, 38);
		contentPane.add(btnShowBooking);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(249, 114, 463, 276);
		contentPane.add(scrollPane);
		
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
				booking las= new booking();
				las.setVisible(true);
			}
		});
		backBtn.setBounds(12, 12, 69, 55);
		contentPane.add(backBtn);
		

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(96, 428, 265, 227);
		Icon icon5 = new ImageIcon(getClass().getResource("/football.jpeg"));
		lblNewLabel.setIcon(icon5);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(585, 428, 270, 227);
		Icon icon6 = new ImageIcon(getClass().getResource("/badmintn.jpeg"));
		lblNewLabel_2.setIcon(icon6);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 1000, 700);
		Icon icon22 = new ImageIcon(getClass().getResource("/p27.jpeg"));
		lblNewLabel_1.setIcon(icon22);
		contentPane.add(lblNewLabel_1);
		
		
		
	}
}
