

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class opengame extends JFrame {
	private JPanel contentPane;
	Thread th = new Thread();
	private JLabel lblNewLabel_1;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					opengame frame = new opengame();
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
	public opengame() {
		setResizable(false);
		setTitle("Stick War");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\dell\\Desktop\\pic\\1200x630bb.jpg"));
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
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				maingame mg = new maingame();
				close();
				mg.mainscreen();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\button_start (1).png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\button_start.png"));
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\button_start.png"));
		lblNewLabel_1.setBounds(825, 231, 304, 112);
		contentPane.add(lblNewLabel_1);
		
		label = new JLabel("New label");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tutorial tu = new Tutorial();
				tu.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				label.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\button_tutorial (1).png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\button_tutorial.png"));
			}
		});
		label.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\button_tutorial.png"));
		label.setBounds(825, 379, 304, 112);
		contentPane.add(label);
		
		label_1 = new JLabel("New label");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Scoreborad sc = new Scoreborad();
				sc.setVisible(true);
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				label_1.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\button_ranking (1).png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label_1.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\button_ranking.png"));
			}
		});
		label_1.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\button_ranking.png"));
		label_1.setBounds(825, 533, 304, 112);
		contentPane.add(label_1);
		
		label_2 = new JLabel("New label");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				label_2.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\button_close (1).png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label_2.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\button_close.png"));
			}
		});
		label_2.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\button_close.png"));
		label_2.setBounds(12, 620, 304, 112);
		contentPane.add(label_2);

		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\unnamed2.jpg"));
		lblNewLabel.setBounds(-385, -15, 1660, 900);
		contentPane.add(lblNewLabel);
		
	}
	
	public void close(){
		 this.dispose();
	}
}
