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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class carrom extends JFrame {

	private JPanel contentPane;
//	private JPanel contentPane;
	private JTextField from;
	private JTextField to;
	private JTextField name;
	private JTextField roll;
	private JTextField mobile;
	private JTextField tablee;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					carrom frame = new carrom();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection = null;
	public carrom() {
		connection = conn.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setBounds(520, 200, 1000, 700);
		contentPane.setBackground(Color.gray);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		JButton backBtn = new JButton();
		contentPane.add(backBtn);
		backBtn = new JButton();
		backBtn.setHorizontalAlignment(SwingConstants.RIGHT);
		backBtn.setBorder(BorderFactory.createEmptyBorder());
		backBtn.setContentAreaFilled(false);
		Icon icon4 = new ImageIcon(getClass().getResource("/backIcon.png"));
		backBtn.setIcon(icon4);
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				carromsearch fs= new carromsearch();
				fs.setVisible(true);
			}
		});
		backBtn.setBounds(-28, 0, 93, 48);
		contentPane.add(backBtn);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(82, 147, 105, 48);
		lblName.setFont(new Font("Serif", Font.BOLD, 30));
		lblName.setForeground(Color.black);
		contentPane.add(lblName);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setBounds(83, 265, 93, 40);
		lblFrom.setFont(new Font("Serif", Font.BOLD, 30));
		lblFrom.setForeground(Color.black);
		contentPane.add(lblFrom);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setBounds(547, 259, 68, 46);
		lblTo.setFont(new Font("Serif", Font.BOLD, 30));
		lblTo.setForeground(Color.black);
		contentPane.add(lblTo);
		
		JLabel lblBadminton = new JLabel("Table Tenis");
		lblBadminton.setBounds(410, 37, 267, 48);
		lblBadminton.setFont(new Font("Serif", Font.BOLD, 40));
		lblBadminton.setForeground(Color.black);
		contentPane.add(lblBadminton);
		
		JLabel lblRollNo = new JLabel("Roll No.");
		lblRollNo.setBounds(82, 364, 134, 30);
		lblRollNo.setFont(new Font("Serif", Font.BOLD, 30));
		lblRollNo.setForeground(Color.black);
		contentPane.add(lblRollNo);
		
		JLabel lblMobileNo = new JLabel("Mobile No.");
		lblMobileNo.setBounds(547, 364, 194, 46);
		lblMobileNo.setFont(new Font("Serif", Font.BOLD, 30));
		lblMobileNo.setForeground(Color.black);
		contentPane.add(lblMobileNo);
		
		JLabel lblTable = new JLabel("Table");
		lblTable.setBounds(547, 147, 105, 46);
		lblTable.setFont(new Font("Serif", Font.BOLD, 30));
		lblTable.setForeground(Color.black);
		contentPane.add(lblTable);
		
		tablee = new JTextField();
		tablee.setBounds(759, 145, 184, 48);
		contentPane.add(tablee);
		tablee.setColumns(10);
		
		to = new JTextField();
		to.setBounds(759, 257, 184, 48);
		contentPane.add(to);
		to.setColumns(10);
		
		mobile = new JTextField();
		mobile.setBounds(759, 362,184, 48);
		contentPane.add(mobile);
		mobile.setColumns(10);
		
		from = new JTextField();
		from.setBounds(261, 257, 184, 48);
		contentPane.add(from);
		from.setColumns(10);
		
		name = new JTextField();
		name.setBounds(261, 145, 184, 48);
		contentPane.add(name);
		name.setColumns(10);
		
		roll = new JTextField();
		roll.setBounds(261, 362, 184, 48);
		contentPane.add(roll);
		roll.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
					LocalDateTime now = LocalDateTime.now(); 
					String date =  dtf.format(now);
					if(validEntries()) {
						
						String query1="select Name ,mobile ,fromm , tooo , roll , tablee from carrom Where fromm= '"+ from.getText() +"' and Date = '"+ date +"' and tablee= '"+ tablee.getText() +"'";
						PreparedStatement pat1= connection.prepareStatement(query1);
						ResultSet rs1=pat1.executeQuery();
						int count=0;
						while(rs1.next()) {
							count++;
						}
						
						if(count==0) {
							String query="insert into carrom(Name,fromm,tooo,mobile,Date,roll,tablee) values(?,?,?,?,?,?,?)";
							PreparedStatement pat= connection.prepareStatement(query);
							pat.setString(1,name.getText());
							pat.setString(2,from.getText());
							pat.setString(3,to.getText());
							pat.setString(4,mobile.getText());
							pat.setString(5,date);
							pat.setString(6,roll.getText());
							pat.setString(7,tablee.getText());
							
							
							String query2="insert into history(Name,Sport,Fromm,Too,MobileNO,RollNo,Date,tablee) values(?,?,?,?,?,?,?,?)";
							PreparedStatement pat2= connection.prepareStatement(query2);
							pat2.setString(1,name.getText());
							pat2.setString(2,"Table Tenis");
							pat2.setString(3,from.getText());
							pat2.setString(4,to.getText());
							pat2.setString(5,mobile.getText());
							pat2.setString(6,roll.getText());
							pat2.setString(7,date);
							pat2.setString(8,tablee.getText());
							
							JOptionPane.showMessageDialog(null, "Thank you for booking table no. "+tablee.getText() + " from " + from.getText() + " to " + to.getText());
							
							int rs=pat.executeUpdate();
							int rs2=pat2.executeUpdate();
							pat.close();
							pat1.close();
							pat2.close();
							connection.close();
							setVisible(false);
							booking cp = new booking();
							cp.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "This table is already booked");
							return;
						}
					}
					
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
				
			}
		});
		btnSubmit.setFont(new Font("Serif", Font.BOLD, 30));
		btnSubmit. setBackground(Color.gray);
		btnSubmit. setOpaque(true);
		btnSubmit.setBounds(473, 531, 182, 59);
		contentPane.add(btnSubmit);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 1000, 700);
		Icon icon22 = new ImageIcon(getClass().getResource("/p27.jpeg"));
		lblNewLabel_1.setIcon(icon22);
		contentPane.add(lblNewLabel_1);
		
	}
public boolean validEntries() {
		
		

		if(name.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please enter Your Name");
			return false;
		}
		
		String ss= name.getText();
		for(int i=0;i<ss.length();i++) {
			char a = ss.charAt(i);
			if((a>='a' && a<='z') || (a>='A' && a<='Z')) {
				continue;
			}
			else {
				JOptionPane.showMessageDialog(null, "Number and Special char not allowed in Name");
				return false;
			}
		}
		if(ss.length()<3) {
			JOptionPane.showMessageDialog(null, "Atleast 3 char in Name");
			return false;
		}
		
		if(tablee.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please enter court number");
			return false;
		}
		
		String ss1= tablee.getText();
		char a=ss1.charAt(0);
		if((a<'1' || a>'9')) {
			JOptionPane.showMessageDialog(null, "Only Number allowed in court");
			return false;
		}
		int p3 = Integer.parseInt(tablee.getText());
		if(p3>2){
			JOptionPane.showMessageDialog(null, "only 2 court present");
			return false;
		}
		
		if(from.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please enter time in FROM ");
			return false;
		}
		
		String ss2= from.getText();
		for(int i=0;i<ss2.length();i++) {
			char aa=ss2.charAt(0);
			if((aa<'1' || aa>'9')) {
				JOptionPane.showMessageDialog(null, "Only Number allowed in From");
				return false;
			}
		}
		
		if(to.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please enter time in TO");
			return false;
		}
		
		String ss3= to.getText();
		for(int i=0;i<ss3.length();i++) {
			char aa=ss3.charAt(0);
			if((aa<'1' || aa>'9')) {
				JOptionPane.showMessageDialog(null, "Only Number allowed in To");
				return false;
			}
		}
		
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("hh:mm:ss");    
            LocalDateTime now = LocalDateTime.now();
            int hour = now.getHour();
		
		int p2 = Integer.parseInt(to.getText());
		int p1 = Integer.parseInt(from.getText());
		
		
		if(p1>=p2 || (p2-p1) >1) {
			JOptionPane.showMessageDialog(null, "We can book slot only for 1 hour");
			return false;
		}
		if( (p1<9 || p2>23) ){
			JOptionPane.showMessageDialog(null, "Please Enter Valid time between 9 to 23 without timeout");
			return false;
		}
            if( p1< hour+1 || p2>23) {
			JOptionPane.showMessageDialog(null, "It's time-out");
			return false;
		}   
		if(roll.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please enter Roll number");
			return false;
		}
		
		if(mobile.getText().trim().length() != 10) {
			JOptionPane.showMessageDialog(null, "Please enter Valid Phone Number");
			return false;
		}else {
			for(int i=0;i<10;i++) {
				if(mobile.getText().trim().charAt(i) <'0' || mobile.getText().trim().charAt(i)>'9' ) {
					JOptionPane.showMessageDialog(null, "Please enter Valid Phone Number");
					return false;
				}
			}
		}
		return true;
	}
}
