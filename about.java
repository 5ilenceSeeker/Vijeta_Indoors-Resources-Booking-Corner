package carparking;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class about extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					about frame = new about();
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
	public about() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setBounds(520, 200, 1000, 700);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		JLabel lblTeamMembers = new JLabel(" Developers");
		lblTeamMembers.setFont(new Font("Serif", Font.BOLD, 30));
		lblTeamMembers.setBounds(417, 87, 264, 48);
		lblTeamMembers.setForeground(Color.black);
		contentPane.add(lblTeamMembers);
		
		JLabel lblLit = new JLabel("Lit2018004");
		lblLit.setFont(new Font("Serif", Font.BOLD, 30));
		lblLit.setBounds(163, 478, 204, 48);
		lblLit.setForeground(Color.black);
		contentPane.add(lblLit);
		
		JLabel lblLit_1 = new JLabel("Lit2018030");
		lblLit_1.setFont(new Font("Serif", Font.BOLD, 30));
		lblLit_1.setBounds(629, 478, 204, 48);
		lblLit_1.setForeground(Color.black);
		contentPane.add(lblLit_1);
		
		JLabel lblNewLabel = new JLabel("PIYUSH KUMAR");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 30));
		lblNewLabel.setBounds(163, 294, 292, 48);
		lblNewLabel.setForeground(Color.black);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SHEETAL RANI");
		lblNewLabel_1.setFont(new Font("Serif", Font.BOLD, 30));
		lblNewLabel_1.setBounds(629, 297, 279, 48);
		lblNewLabel_1.setForeground(Color.black);
		contentPane.add(lblNewLabel_1);
		
		JButton backBtn = new JButton("");
		backBtn.setBorder(BorderFactory.createEmptyBorder());
		backBtn.setContentAreaFilled(false);
		Icon icon5 = new ImageIcon(getClass().getResource("/backIcon.png"));
		backBtn.setIcon(icon5);
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				First fss= new First();
				fss.setVisible(true);
			}
		});
		backBtn.setBounds(12, 24, 66, 48);
		contentPane.add(backBtn);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 0, 1000, 700);
		Icon icon22 = new ImageIcon(getClass().getResource("/p27.jpeg"));
		lblNewLabel_2.setIcon(icon22);
		contentPane.add(lblNewLabel_2);
	}
}
