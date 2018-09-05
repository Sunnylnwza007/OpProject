import java.awt.EventQueue;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class maingame {

	JFrame frmStickWar;
	JLabel label_1;
	JLabel label_2;
	JLabel label_3;
	JLabel label_4;
	Timer tm;
	JLabel tap11;
	JLabel Attack1;
	JLabel Heal1;
	JLabel Skill1;
	JLabel btnMeteor11;
	JLabel btnThunder11;
	JLabel btnEart11;
	JLabel btnFrozen11;
	int minustm1=0;
	int minustm2=0;
	int counttap;
	int h_hp=300,h_mp=200,m_hp=100,m_mp=500;
	int h_hp1=h_hp,h_mp1,m_hp1,m_mp1;
	int m_muti;
	int h_lv=1;
	int m_lv=1;
	int h_atk=40;
	int h_heal = 15;
	int m_atk=25;
	int heal;
	int num1,num2,sum,ranx,rany;
	int time;
	int score;
	private JLabel leftnum;
	private JLabel operator;
	private JLabel rightnum;
	private JLabel equal;
	private JTextField textField;
	private JTextField textField2;
	private JLabel labeltime;
	private JLabel tap22;
	private JLabel tap33;
	private JLabel tap44;
	private JLabel btnMeteor1;
	private JLabel btnThunder1;
	private JLabel btnFrozen1;
	private JLabel btnEart1;
	private JLabel btnBack1;
	
	/**
	 * Launch the application.
	 */
	public static void mainscreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					maingame window = new maingame();
					window.frmStickWar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public maingame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStickWar = new JFrame();
		frmStickWar.setResizable(false);
		frmStickWar.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\dell\\Desktop\\pic\\1200x630bb.jpg"));
		frmStickWar.setTitle("Stick War");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int jw= frmStickWar.getSize().width;
		int jh= frmStickWar.getSize().height;
		int lox = (dim.width-jw)/5;
		int loy = (dim.height-jh)/8;
		
		frmStickWar.setBounds(lox, loy, 1200, 780);
		frmStickWar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStickWar.getContentPane().setLayout(null);
		
		levelup lu = new levelup();
		newmon nm = new newmon();
		gameover go = new gameover();
		meteo me = new meteo();
		thunder th = new thunder();
		frozen fr = new frozen();
		earth er = new earth();
		attack at = new attack();
		heal he = new heal();
		takedmg td = new takedmg();
		
		
		
		tm = new Timer(1000,new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				labeltime.setText(Integer.toString(time));
				time--;
				if (time==-1){
					tm.stop();
					m_muti = (int) ((Math.random()*3)+1);
					h_hp1 = h_hp1-(m_atk*m_muti);
					label_1.setText(Integer.toString(h_hp1));
					Attack1.setVisible(true);
					Heal1.setVisible(true);
					Skill1.setVisible(true);
					leftnum.setVisible(false);
					rightnum.setVisible(false);
					operator.setVisible(false);
					equal.setVisible(false);
					textField2.setText("");
					textField2.setVisible(false);
					textField.setText("");
					textField.setVisible(false);
					labeltime.setVisible(false);
					tap11.setVisible(false);
					tap22.setVisible(false);
					tap33.setVisible(false);
					tap44.setVisible(false);
					td.setVisible(true);
					if(h_hp1<=0){
						frmStickWar.dispose();
						go.setVisible(true);
						adddatabase add = new adddatabase(m_lv,h_lv,score);
					}
					if(m_hp1<=0){
						if(minustm1<=5){
							minustm1++;
						}
						if(minustm2<=4){
							minustm2++;
						}
						h_lv++;
						m_lv++;
						nm.setVisible(true);
						lu.setVisible(true);
						h_atk+=10;
						h_heal+=10;
						m_atk+=15;
						m_hp+=100;
						m_hp1=m_hp;
						label_3.setText(Integer.toString(m_hp1));
						m_mp1=m_mp;
						label_4.setText(Integer.toString(m_mp1));
					}
				}
			}
			
		});
		
		
		tap11 = new JLabel("New label");
		tap11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ranx = (int) (Math.random()*1100);
				rany = (int) (Math.random()*700);
				counttap++;
				tap11.setBounds(ranx, rany, 100, 100);
				if (counttap==5 && time!=0){
					h_mp1-=50;
					label_2.setText(Integer.toString(h_mp1));
					m_hp1-=h_atk*2;
					score+=h_atk*2;
					label_3.setText(Integer.toString(m_hp1));
					tm.stop();
					me.setVisible(true);
					tap11.setVisible(false);
					Attack1.setVisible(true);
					labeltime.setVisible(false);
					Heal1.setVisible(true);
					Skill1.setVisible(true);
				}else if (counttap!=5 && time==0){
					m_mp1-=50;
					label_4.setText(Integer.toString(m_mp1));
					m_muti = (int) ((Math.random()*3)+1);
					h_hp1-=m_atk*m_muti;
					label_1.setText(Integer.toString(h_hp1));
					tm.stop();
					tap11.setVisible(false);
					Attack1.setVisible(true);
					labeltime.setVisible(false);
					Heal1.setVisible(true);
					Skill1.setVisible(true);
					td.setVisible(true);
				}
				if(h_hp1<=0){
					frmStickWar.dispose();
					go.setVisible(true);
					adddatabase add = new adddatabase(m_lv,h_lv,score);
					}
				if(m_hp1<=0){
					if(minustm1<=5){
						minustm1++;
					}
					if(minustm2<=4){
						minustm2++;
					}
					nm.setVisible(true);
					lu.setVisible(true);
					h_lv++;
					m_lv++;
					h_atk+=10;
					h_heal+=10;
					m_atk+=15;
					m_hp+=100;
					m_hp1=m_hp;
					label_3.setText(Integer.toString(m_hp1));
					m_mp1=m_mp;
					label_4.setText(Integer.toString(m_mp1));
				}
			}
		});
		tap11.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\logo-tap.png"));
		tap11.setBounds(815, 327, 100, 100);
		frmStickWar.getContentPane().add(tap11);
		tap11.setVisible(false);
		
		tap22 = new JLabel("New label");
		tap22.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ranx = (int) (Math.random()*1100);
				rany = (int) (Math.random()*700);
				counttap++;
				tap22.setBounds(ranx, rany, 100, 100);
				if (counttap==5 && time!=0){
					h_mp1-=100;
					label_2.setText(Integer.toString(h_mp1));
					m_hp1-=h_atk*3;
					score+=h_atk*3;
					label_3.setText(Integer.toString(m_hp1));
					tm.stop();
					th.setVisible(true);
					tap22.setVisible(false);
					Attack1.setVisible(true);
					labeltime.setVisible(false);
					Heal1.setVisible(true);
					Skill1.setVisible(true);
				}else if (counttap!=5 && time==0){
					m_mp1-=50;
					label_4.setText(Integer.toString(m_mp1));
					m_muti = (int) ((Math.random()*3)+1);
					h_hp1-=m_atk*m_muti;
					label_1.setText(Integer.toString(h_hp1));
					tm.stop();
					tap22.setVisible(false);
					Attack1.setVisible(true);
					labeltime.setVisible(false);
					Heal1.setVisible(true);
					Skill1.setVisible(true);
					td.setVisible(true);
				}
				if(h_hp1<=0){
					frmStickWar.dispose();
					go.setVisible(true);
					adddatabase add = new adddatabase(m_lv,h_lv,score);
					}
				if(m_hp1<=0){
					if(minustm1<=5){
						minustm1++;
					}
					if(minustm2<=4){
						minustm2++;
					}
					nm.setVisible(true);
					lu.setVisible(true);
					h_lv++;
					m_lv++;
					h_atk+=10;
					h_heal+=10;
					m_atk+=15;
					m_hp+=100;
					m_hp1=m_hp;
					label_3.setText(Integer.toString(m_hp1));
					m_mp1=m_mp;
					label_4.setText(Integer.toString(m_mp1));
				}
			}
		});
		tap22.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\logo-tap.png"));
		tap22.setBounds(752, 440, 100, 100);
		frmStickWar.getContentPane().add(tap22);
		tap22.setVisible(false);
		
		tap33 = new JLabel("New label");
		tap33.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ranx = (int) (Math.random()*1100);
				rany = (int) (Math.random()*700);
				counttap++;
				tap33.setBounds(ranx, rany, 100, 100);
				if (counttap==5 && time!=0){
					h_mp1-=150;
					label_2.setText(Integer.toString(h_mp1));
					m_hp1-=h_atk*4;
					score+=h_atk*4;
					label_3.setText(Integer.toString(m_hp1));
					tm.stop();
					fr.setVisible(true);
					tap33.setVisible(false);
					Attack1.setVisible(true);
					labeltime.setVisible(false);
					Heal1.setVisible(true);
					Skill1.setVisible(true);
				}else if (counttap!=5 && time==0){
					m_mp1-=50;
					label_4.setText(Integer.toString(m_mp1));
					m_muti = (int) ((Math.random()*3)+1);
					h_hp1-=m_atk*m_muti;
					label_1.setText(Integer.toString(h_hp1));
					tm.stop();
					tap33.setVisible(false);
					Attack1.setVisible(true);
					labeltime.setVisible(false);
					Heal1.setVisible(true);
					Skill1.setVisible(true);
					td.setVisible(true);
				}
				if(h_hp1<=0){
					frmStickWar.dispose();
					go.setVisible(true);
					adddatabase add = new adddatabase(m_lv,h_lv,score);
					}
				if(m_hp1<=0){
					if(minustm1<=5){
						minustm1++;
					}
					if(minustm2<=4){
						minustm2++;
					}
					nm.setVisible(true);
					lu.setVisible(true);
					h_lv++;
					m_lv++;
					h_atk+=10;
					h_heal+=10;
					m_atk+=15;
					m_hp+=100;
					m_hp1=m_hp;
					label_3.setText(Integer.toString(m_hp1));
					m_mp1=m_mp;
					label_4.setText(Integer.toString(m_mp1));
				}
			}
		});
		tap33.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\logo-tap.png"));
		tap33.setBounds(897, 500, 100, 100);
		frmStickWar.getContentPane().add(tap33);
		tap33.setVisible(false);
		
		tap44 = new JLabel("New label");
		tap44.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ranx = (int) (Math.random()*1100);
				rany = (int) (Math.random()*700);
				counttap++;
				tap44.setBounds(ranx, rany, 100, 100);
				if (counttap==5 && time!=0){
					h_mp1-=200;
					label_2.setText(Integer.toString(h_mp1));
					m_hp1-=h_atk*5;
					score+=h_atk*5;
					label_3.setText(Integer.toString(m_hp1));
					tm.stop();
					er.setVisible(true);
					tap44.setVisible(false);
					Attack1.setVisible(true);
					labeltime.setVisible(false);
					Heal1.setVisible(true);
					Skill1.setVisible(true);
				}else if (counttap!=5 && time==0){
					m_mp1-=50;
					label_4.setText(Integer.toString(m_mp1));
					m_muti = (int) ((Math.random()*3)+1);
					h_hp1-=m_atk*m_muti;
					label_1.setText(Integer.toString(h_hp1));
					tm.stop();
					tap44.setVisible(false);
					Attack1.setVisible(true);
					labeltime.setVisible(false);
					Heal1.setVisible(true);
					Skill1.setVisible(true);
					td.setVisible(true);
				}
				if(h_hp1<=0){
					frmStickWar.dispose();
					go.setVisible(true);
					adddatabase add = new adddatabase(m_lv,h_lv,score);
					}
				if(m_hp1<=0){
					if(minustm1<=5){
						minustm1++;
					}
					if(minustm2<=4){
						minustm2++;
					}
					nm.setVisible(true);
					lu.setVisible(true);
					h_lv++;
					m_lv++;
					h_atk+=10;
					h_heal+=10;
					m_atk+=15;
					m_hp+=100;
					m_hp1=m_hp;
					label_3.setText(Integer.toString(m_hp1));
					m_mp1=m_mp;
					label_4.setText(Integer.toString(m_mp1));
				}
			}
		});
		tap44.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\logo-tap.png"));
		tap44.setBounds(752, 578, 100, 100);
		frmStickWar.getContentPane().add(tap44);
		tap44.setVisible(false);
		
		Attack1 = new JLabel("New label");
		Attack1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Attack1.setVisible(false);
				Heal1.setVisible(false);
				Skill1.setVisible(false);
				num1=(int) (Math.random()*100);
				leftnum.setText(Integer.toString(num1));
				leftnum.setVisible(true);
				num2=(int) (Math.random()*100);
				rightnum.setText(Integer.toString(num2));
				rightnum.setVisible(true);
				operator.setText("+");
				operator.setVisible(true);
				equal.setVisible(true);
				textField.setVisible(true);
				time = 10-minustm1;
				tm.start();
				labeltime.setVisible(true);
				sum=num1+num2;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Attack1.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\buttons\\button_attack (1).png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Attack1.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\buttons\\button_attack.png"));
			}
		});
		Attack1.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\buttons\\button_attack.png"));
		Attack1.setBounds(440, 61, 243, 93);
		frmStickWar.getContentPane().add(Attack1);
		
		Heal1 = new JLabel("New label");
		Heal1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Attack1.setVisible(false);
				Heal1.setVisible(false);
				Skill1.setVisible(false);
				num1=(int) (Math.random()*100);
				leftnum.setText(Integer.toString(num1));
				leftnum.setVisible(true);
				num2=(int) (Math.random()*num1);
				rightnum.setText(Integer.toString(num2));
				rightnum.setVisible(true);
				operator.setText("-");
				operator.setVisible(true);
				equal.setVisible(true);
				textField2.setVisible(true);
				time = 10-minustm1;
				tm.start();
				labeltime.setVisible(true);
				sum=num1-num2;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Heal1.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\buttons\\button_heal (1).png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Heal1.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\buttons\\button_heal.png"));
			}
		});
		Heal1.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\buttons\\button_heal.png"));
		Heal1.setBounds(440, 191, 243, 93);
		frmStickWar.getContentPane().add(Heal1);
		
		Skill1 = new JLabel("New label");
		Skill1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Attack1.setVisible(false);
				Heal1.setVisible(false);
				Skill1.setVisible(false);
				btnMeteor11.setVisible(true);
				btnThunder11.setVisible(true);
				btnEart11.setVisible(true);
				btnFrozen11.setVisible(true);
				btnBack1.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Skill1.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\buttons\\button_skill (1).png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Skill1.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\buttons\\button_skill.png"));
			}
		});
		Skill1.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\buttons\\button_skill.png"));
		Skill1.setBounds(440, 331, 243, 93);
		frmStickWar.getContentPane().add(Skill1);
		
		JLabel human = new JLabel("Earthquake");
		human.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\Untitled-1.png"));
		human.setBounds(-60, 240, 373, 493);
		frmStickWar.getContentPane().add(human);
		
		JLabel textleftHp = new JLabel("HP");
		textleftHp.setFont(new Font("Tahoma", Font.PLAIN, 30));
		textleftHp.setBackground(Color.WHITE);
		textleftHp.setForeground(Color.RED);
		textleftHp.setBounds(10, 67, 85, 39);
		frmStickWar.getContentPane().add(textleftHp);
		
		JLabel textleftMp = new JLabel("MP");
		textleftMp.setForeground(Color.CYAN);
		textleftMp.setFont(new Font("Tahoma", Font.PLAIN, 30));
		textleftMp.setBackground(Color.WHITE);
		textleftMp.setBounds(9, 118, 85, 39);
		frmStickWar.getContentPane().add(textleftMp);
		
		JLabel textrightMp = new JLabel("MP");
		textrightMp.setForeground(Color.CYAN);
		textrightMp.setFont(new Font("Tahoma", Font.PLAIN, 30));
		textrightMp.setBackground(Color.WHITE);
		textrightMp.setBounds(1018, 112, 85, 39);
		frmStickWar.getContentPane().add(textrightMp);
		
		JLabel textrightHp = new JLabel("HP");
		textrightHp.setForeground(Color.RED);
		textrightHp.setFont(new Font("Tahoma", Font.PLAIN, 30));
		textrightHp.setBackground(Color.WHITE);
		textrightHp.setBounds(1019, 61, 85, 39);
		frmStickWar.getContentPane().add(textrightHp);
		
		label_1 = new JLabel("");
		h_hp1 = h_hp;
		label_1.setText(Integer.toString(h_hp1));
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(81, 67, 85, 39);
		frmStickWar.getContentPane().add(label_1);
		
		label_2 = new JLabel("200");
		h_mp1 = h_mp;
		label_2.setText(Integer.toString(h_mp1));
		label_2.setForeground(Color.CYAN);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_2.setBackground(Color.WHITE);
		label_2.setBounds(81, 115, 85, 39);
		frmStickWar.getContentPane().add(label_2);
		
		label_3 = new JLabel("500");
		m_hp1 = m_hp;
		label_3.setText(Integer.toString(m_hp1));
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_3.setBackground(Color.WHITE);
		label_3.setBounds(1097, 61, 85, 39);
		frmStickWar.getContentPane().add(label_3);
		
		label_4 = new JLabel("500");
		m_mp1 = m_mp;
		label_4.setText(Integer.toString(m_mp1));
		label_4.setForeground(Color.CYAN);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_4.setBackground(Color.WHITE);
		label_4.setBounds(1097, 112, 85, 39);
		frmStickWar.getContentPane().add(label_4);
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\Untitled-2.png"));
		label.setBounds(797, 196, 373, 493);
		frmStickWar.getContentPane().add(label);
		
		leftnum = new JLabel("?");
		leftnum.setVisible(false);
		leftnum.setHorizontalAlignment(SwingConstants.CENTER);
		leftnum.setForeground(Color.WHITE);
		leftnum.setFont(new Font("Tahoma", Font.BOLD, 42));
		leftnum.setBounds(301, 115, 121, 93);
		frmStickWar.getContentPane().add(leftnum);
		
		operator = new JLabel("?");
		operator.setVisible(false);
		operator.setHorizontalAlignment(SwingConstants.CENTER);
		operator.setForeground(Color.WHITE);
		operator.setFont(new Font("Tahoma", Font.BOLD, 42));
		operator.setBounds(468, 111, 121, 93);
		frmStickWar.getContentPane().add(operator);
		
		rightnum = new JLabel("?");
		rightnum.setVisible(false);
		rightnum.setHorizontalAlignment(SwingConstants.CENTER);
		rightnum.setForeground(Color.WHITE);
		rightnum.setFont(new Font("Tahoma", Font.BOLD, 42));
		rightnum.setBounds(658, 115, 121, 93);
		frmStickWar.getContentPane().add(rightnum);
		
		equal = new JLabel("=");
		equal.setVisible(false);
		equal.setHorizontalAlignment(SwingConstants.CENTER);
		equal.setForeground(Color.WHITE);
		equal.setFont(new Font("Tahoma", Font.BOLD, 42));
		equal.setBounds(468, 242, 121, 93);
		frmStickWar.getContentPane().add(equal);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals(Integer.toString(sum))&& time !=0){
					m_hp1 = m_hp1-h_atk;
					label_3.setText(Integer.toString(m_hp1));
					h_hp1 = h_hp1-m_atk;
					score+=h_atk;
					label_1.setText(Integer.toString(h_hp1));
					Attack1.setVisible(true);
					Heal1.setVisible(true);
					Skill1.setVisible(true);
					leftnum.setVisible(false);
					rightnum.setVisible(false);
					operator.setVisible(false);
					equal.setVisible(false);
					textField.setText("");
					textField.setVisible(false);
					labeltime.setVisible(false);
					tm.stop();
					at.setVisible(true);
				}else{
					tm.stop();
					h_hp1 = h_hp1-m_atk;
					label_1.setText(Integer.toString(h_hp1));
					Attack1.setVisible(true);
					Heal1.setVisible(true);
					Skill1.setVisible(true);
					leftnum.setVisible(false);
					rightnum.setVisible(false);
					operator.setVisible(false);
					equal.setVisible(false);
					textField.setText("");
					textField.setVisible(false);
					labeltime.setVisible(false);
					td.setVisible(true);
				}
				if(h_hp1<=0){
					frmStickWar.dispose();
					go.setVisible(true);
					adddatabase add = new adddatabase(m_lv,h_lv,score);
				}
				if(m_hp1<=0){
					if(minustm1<=5){
						minustm1++;
					}
					if(minustm2<=4){
						minustm2++;
					}
					h_lv++;
					m_lv++;
					nm.setVisible(true);
					lu.setVisible(true);
					h_atk+=10;
					h_heal+=10;
					m_atk+=15;
					m_hp+=100;
					m_hp1=m_hp;
					label_3.setText(Integer.toString(m_hp1));
					m_mp1=m_mp;
					label_4.setText(Integer.toString(m_mp1));
				}
			}
		});
		textField.setVisible(false);
		
		labeltime = new JLabel("?");
		labeltime.setVisible(false);
		labeltime.setForeground(Color.RED);
		labeltime.setHorizontalAlignment(SwingConstants.CENTER);
		labeltime.setFont(new Font("Tahoma", Font.BOLD, 80));
		labeltime.setBounds(439, 449, 203, 92);
		frmStickWar.getContentPane().add(labeltime);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textField.setBounds(455, 354, 158, 64);
		frmStickWar.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textField2.setVisible(false);
		textField2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField2.getText().equals(Integer.toString(sum)) && time !=0){
					tm.stop();
					h_mp1+= 50;
					label_2.setText(Integer.toString(h_mp1));
					h_hp1 = h_hp1+h_heal;
					score+=h_heal;
					label_1.setText(Integer.toString(h_hp1));
					Attack1.setVisible(true);
					Heal1.setVisible(true);
					Skill1.setVisible(true);
					leftnum.setVisible(false);
					rightnum.setVisible(false);
					operator.setVisible(false);
					equal.setVisible(false);
					textField2.setText("");
					textField2.setVisible(false);
					labeltime.setVisible(false);
					he.setVisible(true);
				}else{
					tm.stop();
					h_hp1 = h_hp1-m_atk;
					label_1.setText(Integer.toString(h_hp1));
					Attack1.setVisible(true);
					Heal1.setVisible(true);
					Skill1.setVisible(true);
					leftnum.setVisible(false);
					rightnum.setVisible(false);
					operator.setVisible(false);
					equal.setVisible(false);
					textField2.setText("");
					textField2.setVisible(false);
					labeltime.setVisible(false);
					td.setVisible(true);
				}
				if(h_hp1<=0){
					frmStickWar.dispose();
					go.setVisible(true);
					adddatabase add = new adddatabase(m_lv,h_lv,score);
				}
				if(m_hp1<=0){
					if(minustm1<=5){
						minustm1++;
					}
					if(minustm2<=4){
						minustm2++;
					}
					h_lv++;
					m_lv++;
					nm.setVisible(true);
					lu.setVisible(true);
					h_atk+=10;
					h_heal+=10;
					m_atk+=15;
					m_hp+=100;
					m_hp1=m_hp;
					label_3.setText(Integer.toString(m_hp1));
					m_mp1=m_mp;
					label_4.setText(Integer.toString(m_mp1));
				}
			}
		});
		textField2.setBounds(455, 354, 158, 64);
		frmStickWar.getContentPane().add(textField2);
		textField2.setColumns(10);
		
		btnMeteor11 = new JLabel("New label");
		btnMeteor11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (h_mp1>=50){
					btnMeteor11.setVisible(false);
					btnThunder11.setVisible(false);
					btnEart11.setVisible(false);
					btnFrozen11.setVisible(false);
					btnBack1.setVisible(false);
					ranx = (int) (Math.random()*1100);
					rany = (int) (Math.random()*700);
					counttap = 0;
					time = 7-minustm2;
					tm.start();
					labeltime.setVisible(true);
					tap11.setBounds(ranx, rany, 100, 100);
					tap11.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(frmStickWar, "No mana for this skill");
				}
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMeteor11.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\buttons\\button_meteor (1).png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnMeteor11.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\buttons\\button_meteor.png"));
			}
		});
		btnMeteor11.setVisible(false);
		btnMeteor11.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\buttons\\button_meteor.png"));
		btnMeteor11.setBounds(249, 98, 263, 93);
		frmStickWar.getContentPane().add(btnMeteor11);
		
		btnThunder11 = new JLabel("New label");
		btnThunder11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (h_mp1>=100){
					btnMeteor11.setVisible(false);
					btnThunder11.setVisible(false);
					btnEart11.setVisible(false);
					btnFrozen11.setVisible(false);
					btnBack1.setVisible(false);
					ranx = (int) (Math.random()*1100);
					rany = (int) (Math.random()*700);
					counttap = 0;
					time = 7-minustm2;
					tm.start();
					labeltime.setVisible(true);
					tap22.setBounds(ranx, rany, 100, 100);
					tap22.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(frmStickWar, "No mana for this skill");
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnThunder11.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\buttons\\button_thunder (1).png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnThunder11.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\buttons\\button_thunder.png"));
			}
		});
		btnThunder11.setVisible(false);
		btnThunder11.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\buttons\\button_thunder.png"));
		btnThunder11.setBounds(549, 98, 273, 93);
		frmStickWar.getContentPane().add(btnThunder11);
		
		btnFrozen11 = new JLabel("New label");
		btnFrozen11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (h_mp1>=150){
					btnMeteor11.setVisible(false);
					btnThunder11.setVisible(false);
					btnEart11.setVisible(false);
					btnFrozen11.setVisible(false);
					btnBack1.setVisible(false);
					ranx = (int) (Math.random()*1100);
					rany = (int) (Math.random()*700);
					counttap = 0;
					time = 7-minustm2;
					tm.start();
					labeltime.setVisible(true);
					tap33.setBounds(ranx, rany, 100, 100);
					tap33.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(frmStickWar, "No mana for this skill");
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnFrozen11.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\buttons\\button_frozen (1).png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnFrozen11.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\buttons\\button_frozen.png"));
			}
		});
		btnFrozen11.setVisible(false);
		btnFrozen11.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\buttons\\button_frozen.png"));
		btnFrozen11.setBounds(249, 240, 273, 93);
		frmStickWar.getContentPane().add(btnFrozen11);
		
		btnEart11 = new JLabel("New label");
		btnEart11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (h_mp1>=200){
					btnMeteor11.setVisible(false);
					btnThunder11.setVisible(false);
					btnEart11.setVisible(false);
					btnFrozen11.setVisible(false);
					btnBack1.setVisible(false);
					ranx = (int) (Math.random()*1100);
					rany = (int) (Math.random()*700);
					counttap = 0;
					time = 7-minustm2;
					tm.start();
					labeltime.setVisible(true);
					tap44.setBounds(ranx, rany, 100, 100);
					tap44.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(frmStickWar, "No mana for this skill");
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEart11.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\buttons\\button_earthquake (1).png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnEart11.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\buttons\\button_earthquake.png"));
			}
		});
		btnEart11.setVisible(false);
		btnEart11.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\buttons\\button_earthquake.png"));
		btnEart11.setBounds(549, 240, 273, 93);
		frmStickWar.getContentPane().add(btnEart11);
		
		btnBack1 = new JLabel("New label");
		btnBack1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Attack1.setVisible(true);
				Heal1.setVisible(true);
				Skill1.setVisible(true);
				btnMeteor11.setVisible(false);
				btnThunder11.setVisible(false);
				btnEart11.setVisible(false);
				btnFrozen11.setVisible(false);
				btnBack1.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBack1.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\buttons\\button_back (1).png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBack1.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\buttons\\button_back.png"));
			}
		});
		btnBack1.setVisible(false);
		btnBack1.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\buttons\\button_back.png"));
		btnBack1.setBounds(421, 444, 243, 93);
		frmStickWar.getContentPane().add(btnBack1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\pic\\342032-gorgerous-game-background-1920x1080-720p.jpg"));
		lblNewLabel.setBounds(0, 0, 1200, 780);
		frmStickWar.getContentPane().add(lblNewLabel);
	}
	public void close(){
		maingame window = new maingame();
		window.frmStickWar.setVisible(false);
	}
}
