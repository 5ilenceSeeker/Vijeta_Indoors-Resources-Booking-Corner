package carparking;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

public class History extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					History frame = new History();
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
	public History() {
		setUndecorated(true);
		connection = conn.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 638, 410);
		contentPane = new JPanel();
		contentPane.setBackground(Color.red);
		setBounds(520, 200, 1000, 700);
		contentPane.setBackground(Color.gray);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
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
		backBtn.setBounds(0, 0, 69, 55);
		contentPane.add(backBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 84, 936, 542);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Serif", Font.BOLD, 15));
		table.setBackground(Color.pink);
		scrollPane.setViewportView(table);
		
		JButton btnShow = new JButton("Show All");
		btnShow.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				String query="select * from history";
				PreparedStatement pat= connection.prepareStatement(query);
				ResultSet rs=pat.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
		});
		btnShow.setFont(new Font("Serif", Font.BOLD, 30));
		btnShow. setBackground(Color.gray);
		btnShow. setOpaque(true);
		btnShow.setBounds(699, 25, 189, 47);
		contentPane.add(btnShow);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setFont(new Font("Dialog", Font.BOLD, 13));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Date", "Sport", "Name"}));
		comboBox_2.setBounds(192, 25, 145, 47);
		contentPane.add(comboBox_2);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					String s = comboBox_2.getSelectedItem().toString();
					String query1="select *  from history Where " + s +" Like \"" + textField.getText() + "%\"";
					PreparedStatement pat1= connection.prepareStatement(query1);
					ResultSet rs1=pat1.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs1));
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		textField.setBounds(430, 25, 162, 47);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 1000, 700);
		Icon icon22 = new ImageIcon(getClass().getResource("/p27.jpeg"));
		lblNewLabel_1.setIcon(icon22);
		contentPane.add(lblNewLabel_1);
	}
}
