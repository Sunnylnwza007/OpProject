

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class gameover extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gameover frame = new gameover();
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
	public gameover() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\dell\\Desktop\\pic\\1200x630bb.jpg"));
		setTitle("GameOver");
		opengame op = new opengame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int jw= this.getSize().width;
		int jh= this.getSize().height;
		int lox = (dim.width-jw)/5;
		int loy = (dim.height-jh)/8;
		setBounds(lox, loy, 1200, 780);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Close Game");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 50));
		btnNewButton.setBounds(416, 565, 359, 104);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\maxresdefault (2).jpg"));
		lblNewLabel.setBounds(-45, 0, 1239, 780);
		contentPane.add(lblNewLabel);
	}
	public void close(){
		System.exit(0);
		
	}

}
