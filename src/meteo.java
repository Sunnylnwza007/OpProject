

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class meteo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					meteo frame = new meteo();
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
	public meteo() {
		setTitle("Meteor");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\dell\\Desktop\\pic\\1200x630bb.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int jw= this.getSize().width;
		int jh= this.getSize().height;
		int lox = ((dim.width)/6)*2;
		int loy = (dim.height)/6;
		setBounds(lox, loy, 640, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Meteor Activate");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblNewLabel_1.setBounds(0, 0, 340, 78);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton.setBounds(440, 562, 172, 65);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\giphy (3).gif"));
		lblNewLabel.setBounds(0, 0, 640, 640);
		contentPane.add(lblNewLabel);
	}
	public void close(){
		this.dispose();
	}
	

}
