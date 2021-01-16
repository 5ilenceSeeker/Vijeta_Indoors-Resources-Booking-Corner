package carparking;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class games extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					games frame = new games();
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
	public games() {
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
				booking fs= new booking();
				fs.setVisible(true);
			}
		});
		backBtn.setBounds(-24, 26, 92, 55);
		contentPane.add(backBtn);
		
		JButton btnChess = new JButton("");
		btnChess.setBounds(226, 154, 101, 154);
		Icon icon1 = new ImageIcon(getClass().getResource("/ch-1.png"));
		 btnChess.setIcon(icon1);
		 btnChess.setContentAreaFilled(false);
		 btnChess.setBorder(null);
		contentPane.add(btnChess);
		btnChess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				chesssearch sw1= new chesssearch();
				sw1.setVisible(true);
			}
		});
		
		JButton btnCarrom = new JButton("");
		btnCarrom.setBounds(212, 412, 160, 128);
		contentPane.add(btnCarrom);
		Icon icon2 = new ImageIcon(getClass().getResource("/tt.png"));
		btnCarrom.setIcon(icon2);
		btnCarrom.setContentAreaFilled(false);
		btnCarrom.setBorder(null);
		btnCarrom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				carromsearch sw2= new carromsearch();
				sw2.setVisible(true);
			}
		});
		
		JButton btnFootball = new JButton("");
		btnFootball.setBounds(607, 154, 133, 154);
		contentPane.add(btnFootball);
		Icon icon3 = new ImageIcon(getClass().getResource("/foot-1.png"));
		btnFootball.setIcon(icon3);
		btnFootball.setContentAreaFilled(false);
		btnFootball.setBorder(null);
		btnFootball.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				footballsearch sw3= new footballsearch();
				sw3.setVisible(true);
			}
		});
		
		JButton btnBadminton = new JButton("");
		btnBadminton.setBounds(626, 400, 135, 154);
		contentPane.add(btnBadminton);
		Icon icon5 = new ImageIcon(getClass().getResource("/badminton-icon.png"));
		btnBadminton.setIcon(icon5);
		btnBadminton.setContentAreaFilled(false);
		btnBadminton.setBorder(null);
		btnBadminton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				badmintonsearch sw4= new badmintonsearch();
				sw4.setVisible(true);
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 1000, 700);
		Icon icon22 = new ImageIcon(getClass().getResource("/p27.jpeg"));
		lblNewLabel_1.setIcon(icon22);
		contentPane.add(lblNewLabel_1);
		
	}
}
