

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class newmon extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newmon frame = new newmon();
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
	public newmon() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\dell\\Desktop\\pic\\1200x630bb.jpg"));
		setTitle("Monster");
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
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 34));
		btnNewButton.setBounds(1004, 625, 166, 87);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("New Monster");
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 80));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(86, 82, 556, 385);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\wraith.jpg"));
		lblNewLabel.setBounds(0, 0, 1200, 780);
		contentPane.add(lblNewLabel);
	}

	public void close(){
		this.dispose();
	}
	
}
