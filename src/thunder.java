

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

public class thunder extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					thunder frame = new thunder();
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
	public thunder() {
		setTitle("Thunder");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\dell\\Desktop\\pic\\1200x630bb.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int jw= this.getSize().width;
		int jh= this.getSize().height;
		int lox = ((dim.width)/5)*2;
		int loy = (dim.height)/3;
		setBounds(lox, loy, 500, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clsoe();
			}
		});
		btnNewButton.setBounds(373, 225, 109, 38);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Thunder Activate");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 44));
		lblNewLabel_1.setBounds(0, 0, 411, 48);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\72f2878ed71944a316c00530a5b74b8daeac4e4c_hq_by_lordmonferno-dbi1ibn.gif"));
		lblNewLabel.setBounds(0, 0, 500, 263);
		contentPane.add(lblNewLabel);
	}
	public void clsoe(){
		this.dispose();
	}

}
