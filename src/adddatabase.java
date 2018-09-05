import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class adddatabase extends JFrame {

	private JPanel contentPane;
	private JTextField here;
	Connection connection = null;
	Statement st;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public adddatabase(int m_lv,int h_lv,int score) {
		setResizable(false);
		setVisible(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\dell\\Desktop\\pic\\1200x630bb.jpg"));
		setTitle("Name");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int jw= this.getSize().width;
		int jh= this.getSize().height;
		int lox = (dim.width-jw)/2;
		int loy = (dim.height-jh)/3;
		setBounds(lox, loy, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel text = new JLabel("Name");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Tahoma", Font.BOLD, 30));
		text.setBounds(167, 13, 96, 72);
		contentPane.add(text);
		
		here = new JTextField();
		here.setHorizontalAlignment(SwingConstants.CENTER);
		here.setFont(new Font("Tahoma", Font.BOLD, 24));
		here.setBounds(111, 76, 202, 53);
		contentPane.add(here);
		here.setColumns(10);
		
		JButton btnNewButton = new JButton("Accept");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				settodb(m_lv,h_lv,score,here.getText());
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(158, 157, 116, 46);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\purple-background-of-colorful-triangles_23-2147616335 (2).jpg"));
		lblNewLabel.setBounds(0, 0, 444, 280);
		contentPane.add(lblNewLabel);
	}
	public void settodb(int m_lv,int h_lv,int score,String name){
		int count1 =0;
		int count2 =0;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();;	
			connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
			st = connection.createStatement();
			if(connection != null){
				System.out.println("Database Connected.");
			} else {
				System.out.println("Database Connect Failed.");
			}
		} catch (Exception e) {
				e.printStackTrace(); 
			}
		
		try {
			String query = "select * from rank";
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()){
				count1++;
			}
			System.out.println(count1++);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String query1 = "select * from scoreborad";
		try {
			st = connection.createStatement();
			ResultSet rs2 = st.executeQuery(query1);
			while (rs2.next()){
				count2++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(count2++);
		
		try {
			PreparedStatement pst;
			pst = connection.prepareStatement("insert into rank (Number,name,LV,MonsterLV) values ("+count1+", '"+here.getText()+"' ,"+h_lv+", "+m_lv+")");
			pst.executeUpdate();
			System.out.println("Save history");
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			PreparedStatement pst1;
			pst1 = connection.prepareStatement("insert into scoreborad (PlayerNo,name,score) values ("+count2+", '"+here.getText()+"' ,"+score+")");
			pst1.executeUpdate();
			System.out.println("Save ranking");
			pst1.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
