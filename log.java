package carparking;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import carparking.conn;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JMenuBar;

public class log extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					log frame = new log();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection c =null;
	private JButton backBtn;
	private JPasswordField textField_1;
	private JTable table;
	
	public log() {
	    c=conn.dbConnector();		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(520, 200, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
//		contentPane.setBackground(Color.gray);
//		Icon icon22 = new ImageIcon(getClass().getResource("/im.jpeg"));
//		contentPane.setIcon(icon22);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Serif", Font.BOLD, 30));
		lblUsername.setForeground(Color.black);
		lblUsername.setBounds(343, 197, 177, 36);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Serif", Font.BOLD, 30));
		lblPassword.setForeground(Color.black);
		lblPassword.setBounds(343, 319, 169, 60);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(662, 197, 207, 50);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {				
					if(textField.getText().trim().equals("")) JOptionPane.showMessageDialog(null , "UserName is Required !!!!");
					else if( textField_1.getText().trim().equals(""))JOptionPane.showMessageDialog(null , "Password is Required !!!!");
					else {
						String query="select * from EMP where USERNAME=? and PASSWORD=? ";
						PreparedStatement pat= c.prepareStatement(query);
						pat.setString(1,textField.getText());
						pat.setString(2,textField_1.getText());
						ResultSet rs=pat.executeQuery();
						int count=0;
						while(rs.next()) {
						   count++;
						}
						if(count==1) {
							rs.close();
							pat.close();
							setVisible(false);
							booking ob = new booking();
							ob.setVisible(true);
						}
						else if(count>1) {
							JOptionPane.showMessageDialog(null," duplicate usrname and password are correct");
						}
					    else {
							JOptionPane.showMessageDialog(null,"usrname and password are Incorrect");
						}
					}
					
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null,e);
				}
			}
		});
		btnLogin.setFont(new Font("Serif", Font.BOLD, 30));
		btnLogin. setBackground(Color.gray);
		btnLogin. setOpaque(true);
		btnLogin.setBounds(440, 458, 183, 51);
		contentPane.add(btnLogin);
		
		lblNewLabel = new JLabel("");
		Icon iconn = new ImageIcon(getClass().getResource("/adm-1.png"));
		lblNewLabel.setIcon(iconn);
		lblNewLabel.setBounds(150, 171, 145, 208);
		contentPane.add(lblNewLabel);
		
		backBtn = new JButton();
		backBtn.setHorizontalAlignment(SwingConstants.RIGHT);
		backBtn.setBorder(BorderFactory.createEmptyBorder());
		backBtn.setContentAreaFilled(false);
		Icon icon4 = new ImageIcon(getClass().getResource("/backIcon.png"));
		backBtn.setIcon(icon4);
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				First fs= new First();
				fs.setVisible(true);
			}
		});
		backBtn.setBounds(-54, 12, 108, 51);
		contentPane.add(backBtn);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(662, 338, 207, 50);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 1000, 700);
		Icon icon22 = new ImageIcon(getClass().getResource("/p27.jpeg"));
		lblNewLabel_1.setIcon(icon22);
		contentPane.add(lblNewLabel_1);
		
		
	}
}
