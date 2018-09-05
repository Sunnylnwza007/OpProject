

import java.awt.*;
import javax.swing.*;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tutorial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tutorial frame = new Tutorial();
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
	public Tutorial() {
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
		
		JLabel lblHowToPlay = new JLabel("How To Play This Fucking Awsome Game\r\n");
		lblHowToPlay.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\Untitled55.png"));
		lblHowToPlay.setToolTipText("1.\u0E40\u0E21\u0E37\u0E48\u0E2D\u0E17\u0E33\u0E01\u0E32\u0E23 ATTACK \u0E2B\u0E23\u0E37\u0E2D HEAL \u0E15\u0E49\u0E2D\u0E07\u0E17\u0E33\u0E01\u0E32\u0E23\u0E41\u0E01\u0E49\u0E2A\u0E21\u0E01\u0E32\u0E23\u0E1A\u0E27\u0E01\u0E25\u0E1A\u0E43\u0E2B\u0E49\u0E16\u0E39\u0E01\u0E04\u0E49\u0E2D\u0E07\u0E20\u0E32\u0E22\u0E43\u0E19\u0E40\u0E27\u0E25\u0E2A\u0E17\u0E35\u0E48\u0E01\u0E33\u0E2B\u0E19\u0E14\u0E42\u0E14\u0E22\u0E40\u0E21\u0E37\u0E48\u0E2D\u0E15\u0E2D\u0E1A\u0E41\u0E25\u0E49\u0E27\u0E43\u0E2B\u0E49\u0E01\u0E14 ENTER \u0E2B\u0E32\u0E01\u0E15\u0E2D\u0E1A\u0E1C\u0E34\u0E14\u0E01\u0E47\u0E08\u0E30\u0E42\u0E14\u0E19\u0E14\u0E32\u0E40\u0E21\u0E08\u0E08\u0E32\u0E01\u0E21\u0E2D\u0E19\u0E2A\u0E40\u0E15\u0E2D\u0E23\u0E4C\u0E42\u0E14\u0E22\u0E17\u0E35\u0E48\u0E40\u0E23\u0E32\u0E44\u0E21\u0E48\u0E2A\u0E32\u0E21\u0E32\u0E23\u0E16\u0E17\u0E33\u0E14\u0E32\u0E40\u0E21\u0E08\u0E21\u0E31\u0E19\u0E44\u0E14\u0E49\u0E40\u0E25\u0E22 \u0E41\u0E15\u0E48\u0E16\u0E49\u0E32\u0E2B\u0E32\u0E01\u0E15\u0E2D\u0E1A\u0E16\u0E39\u0E01\u0E40\u0E23\u0E32\u0E01\u0E47\u0E08\u0E30\u0E2A\u0E32\u0E21\u0E32\u0E23\u0E16\u0E42\u0E08\u0E21\u0E15\u0E35\u0E2B\u0E23\u0E37\u0E2D\u0E2E\u0E34\u0E25\u0E21\u0E31\u0E19\u0E44\u0E14\u0E49\u0E2A\u0E33\u0E40\u0E23\u0E47\u0E08");
		lblHowToPlay.setHorizontalAlignment(SwingConstants.CENTER);
		lblHowToPlay.setVerticalAlignment(SwingConstants.TOP);
		lblHowToPlay.setForeground(Color.BLACK);
		lblHowToPlay.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblHowToPlay.setBackground(new Color(10, 20, 220));
		lblHowToPlay.setBounds(135, 171, 943, 453);
		contentPane.add(lblHowToPlay);
		
		JLabel lblNewLabel = new JLabel("Lnw");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\Untitled.png"));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(new Color(10,20,220));
		lblNewLabel.setBounds(135, 171, 943, 453);
		contentPane.add(lblNewLabel);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
				
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnBack.setBounds(878, 638, 282, 80);
		contentPane.add(btnBack);
		
		JLabel label = new JLabel("New label");
		label.setFont(new Font("Tahoma", Font.BOLD, 28));
		label.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\unnamed2.jpg"));
		label.setBounds(-380, -14, 1660, 900);
		contentPane.add(label);
	}
	public void close(){
		 this.dispose();
	}
}
