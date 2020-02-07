package studentManage;

import java.awt.Color;
import java.awt.Event;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;

/*
 * 构建程序的登陆窗体
 */

public class Mainframe extends JFrame implements ActionListener {

	static Mainframe s;	
	static JPanel pan = new JPanel();//Jpanel是轻量级容器，创建具有双缓冲和流布局的新 JPanel。
	//用于短文本字符串或图像或二者的显示区
	static JLabel label1 = new JLabel("用  户");
	String text=label1.getText();
	
	static JLabel label2 = new JLabel("密  码");
	
	//static JLabel label3 = new JLabel("验证码");	
	static JTextField textField3 = new JTextField();
	
	//产生随机数，用于制造验证码
	static int m=(int)(Math.random()*9000+1000);
	static String s1=String.valueOf(m);
	static JLabel label3 = new JLabel(s1);	
	String num=s1;
	
	//JTextField 是一个轻量级组件，它允许编辑单行文本。
	static JTextField textField1 = new JTextField();
	//JPasswordField 是一个轻量级组件，允许编辑单行文本，其视图指示键入内容，但不显示原始字符。
	static JPasswordField password = new JPasswordField();
	
	
	static JButton button1 = new JButton("进入系统");
	//static JButton button2 = new JButton("用户注册");

	static JRadioButton radioButton1 = new JRadioButton("管理员");// “管理员”初始状态被选中
	static JRadioButton radioButton2 = new JRadioButton("学生");
	
	ButtonGroup buttonGroup = new ButtonGroup();
	
	
	public String getA(){
		return this.text;		
	}
	

	public Mainframe() {
		
		JLabel label = new JLabel();
		label.setSize(400, 400);//设置label大小
		pan.add(label);//添加label组件
		pan.setLayout(null);
		pan.setSize(400, 400);
		
		
		this.setTitle("学籍管理系统");
		this.setSize(400, 400);
		this.setLayout(null);
		//设置组件的坐标位置
		label1.setBounds(100, 25, 50, 20);//用户
		textField1.setBounds(155, 24, 120, 20);
		
		label2.setBounds(100, 62, 50, 20);//密码
		password.setBounds(155, 61, 120, 20);
		
		textField3.setBounds(155, 100, 120, 20);//填写验证码的文本框
		label3.setBounds(100, 100, 50, 20);//验证码
		//label4.setBounds(200, 85, 20, 20);//生成验证码
		
		label3.setForeground(Color.RED);//设置label里面的字体颜色
		label3.setFont(new java.awt.Font("ITALIC",0,14));
		
		//ImageIcon ima=new ImageIcon("1.png");
		//label3.setIcon(ima);
		
		//给jlabel设置边框色
		label3.setBorder(BorderFactory.createLineBorder(Color.lightGray,1));
		
		//设置鼠标监听事件，更换验证码
		label3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent  e){
				int m=(int)(Math.random()*9000+1000);
				String s1=String.valueOf(m);
				label3.setText(s1);	
				System.out.println("点击");	
				num=s1;
			}			
		});
		
		
		
		button1.setBounds(150, 200, 101, 22);//进入系统
		//button2.setBounds(150, 240, 101, 22);//用户注册
		radioButton1.setBounds(105, 140, 80, 20);
		radioButton2.setBounds(180, 140, 60, 20);
		//radioButton3.setBounds(240, 140, 60, 20);
		button1.addActionListener(this);//给button加入监听
		//button2.addActionListener(this);
		
		
		buttonGroup.add(radioButton1);
		buttonGroup.add(radioButton2);
		//buttonGroup.add(radioButton3);
		this.add(radioButton1);
		this.add(radioButton2);
		//this.add(radioButton3);
		this.add(label1);
		this.add(label2);
		this.add(textField1);
		this.add(password);
		
		this.add(label3);
		//this.add(label4);
		this.add(textField3);
		
		this.add(button1);
		//this.add(button2);
		this.add(pan);
		//设置默认的离开动作
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);//设置显示可见
	}

	public static void main(String[] args) {
		new Mainframe();//新建一个登陆窗体，程序的入口
	}

	public void actionPerformed(ActionEvent e) {
				

		if (radioButton1.isSelected())// 选中管理员
		{
			//验证用户名和密码是不是syc和123
			if (textField1.getText().equals("syc")
					&& password.getText().equals("123") && textField3.getText().equals(num)) {
				MInterface b = new MInterface();//验证成功进入操作界面接口
				this.dispose();
				// JOptionPane.showMessageDialog(null,"登陆成功");

			} else if ("".equals(textField1.getText())
					|| "".equals(password.getText())) {
				JOptionPane.showMessageDialog(null, "用户名或密码不能为空");
			} else {
				JOptionPane.showMessageDialog(null, "用户名密码或验证码输入有误");
			}

		}
		
		if (radioButton2.isSelected())// 选中学生登录
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			} catch (ClassNotFoundException ce) {
				JOptionPane.showMessageDialog(s, ce.getMessage());
			}
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stu","root","111");
				//Connection con = DriverManager.getConnection("jdbc:odbc:stu","sa","");
				Statement stmt = con.createStatement();
				//在数据库中验证用户名和密码
				ResultSet rs = stmt.executeQuery("select * from infor where stuId= '"
								+ textField1.getText() + "' and password= '"
								+ password.getText() + "'");

				if (textField1.getText().equals("")
						|| password.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "用户名或密码不可为空！");
				} else if (rs.next() && textField3.getText().equals(num))

				{
					try {
						new SCx();
					} catch (Exception e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
				}

				else {
					JOptionPane.showMessageDialog(this, "您的输入有误");
				}

				// stmt.close();
			}

			catch (SQLException se) {
				JOptionPane.showMessageDialog(s, se.getMessage());
			}
		}
	}
}
