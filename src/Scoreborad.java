import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;

import net.proteanit.sql.DbUtils;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class Scoreborad extends JFrame {

	private JPanel contentPane;
	private JTable table;
	JLabel ph ;
	JLabel ps;
	JLabel ms;
	JLabel rank;
	JLabel close;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Scoreborad frame = new Scoreborad();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	private Statement st;
	private JButton btnPlayerStatus;
	private JButton btnMonsterStatus;
	private JButton btnRanking;
	private JButton btnClose;

	/**
	 * Create the frame.
	 */
	public Scoreborad() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\dell\\Desktop\\pic\\1200x630bb.jpg"));
		setTitle("Scoreborad");
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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int jw= this.getSize().width;
		int jh= this.getSize().height;
		int lox = (dim.width-jw)/3;
		int loy = (dim.height-jh)/4;
		setBounds(lox, loy, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(255, 23, 470, 421);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		ph = new JLabel("New label");
		ph.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
					String query = "select *from rank";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					}catch (Exception e){
						e.printStackTrace();
					}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				ph.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\buttons\\New folder\\button_player-history (1).png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ph.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\buttons\\New folder\\button_player-history.png"));
			}
		});
		ph.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\buttons\\New folder\\button_player-history.png"));
		ph.setBounds(26, 13, 210, 50);
		contentPane.add(ph);
		
		ps = new JLabel("New label");
		ps.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
					String query1 = "select *from hstatus";
					PreparedStatement pst = connection.prepareStatement(query1);
					ResultSet rs1 = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs1));
					}catch (Exception e1){
						e1.printStackTrace();
					}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				ps.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\buttons\\New folder\\button_player-status (1).png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ps.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\buttons\\New folder\\button_player-status.png"));
			}
		});
		ps.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\buttons\\New folder\\button_player-status.png"));
		ps.setBounds(26, 76, 210, 50);
		contentPane.add(ps);
		
		ms = new JLabel("New label");
		ms.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					String query2 = "select *from mstatus";
					PreparedStatement pst = connection.prepareStatement(query2);
					ResultSet rs2 = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs2));
					}catch (Exception e2){
						e2.printStackTrace();
					}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				ms.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\buttons\\New folder\\button_monster-status (1).png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ms.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\buttons\\New folder\\button_monster-status.png"));
			}
		});
		ms.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\buttons\\New folder\\button_monster-status.png"));
		ms.setBounds(26, 148, 210, 50);
		contentPane.add(ms);
		
		rank = new JLabel("New label");
		rank.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					String query3 = "select *from scoreborad order by score desc";
					PreparedStatement pst = connection.prepareStatement(query3);
					ResultSet rs3 = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs3));
					}catch (Exception e3){
						e3.printStackTrace();
					}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				rank.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\buttons\\New folder\\button_ranking (1).png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				rank.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\buttons\\New folder\\button_ranking.png"));
			}
		});
		rank.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\buttons\\New folder\\button_ranking.png"));
		rank.setBounds(26, 217, 210, 50);
		contentPane.add(rank);
		
		close = new JLabel("New label");
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				close();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				close.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\buttons\\New folder\\button_close (2).png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				close.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\buttons\\New folder\\button_close.png"));
			}
		});
		close.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\buttons\\New folder\\button_close.png"));
		close.setBounds(26, 384, 210, 50);
		contentPane.add(close);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\03eaac7b9b1f7f47ef24b875c0eb2da5.jpg"));
		lblNewLabel.setBounds(0, -1, 744, 466);
		contentPane.add(lblNewLabel);
	}
	public void close(){
		this.setVisible(false);
	}
}
