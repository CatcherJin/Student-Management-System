package studentManage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * 管理员
 * 操作界面接口类，可以直接扩展、调用。
 */

public class MInterface extends JFrame implements ActionListener {
	static JMenuBar jMenuBar = new JMenuBar();// 菜单条
	static JMenu jMenuFile = new JMenu("文件");// 菜单项
	static JMenu jMenuExit = new JMenu("退出");	
	static JMenuItem jMenuItem2= new JMenuItem("信息查询");
	static JMenuItem jMenuItem3 = new JMenuItem("学生注册");	
	static JLabel label3 = new JLabel("请选择您的操作");
	static JLabel label4 = new JLabel("欢迎访问学籍管理系统");	
	static JButton button2 = new JButton("学生信息查询");
	static JButton button3 = new JButton("学生注册");
	static JButton button4 = new JButton("其他信息查询");
	
	public MInterface() {
		this.setTitle("学籍管理系统");
		this.setLayout(null);
		this.setSize(400, 350);
		label3.setBounds(140, 92, 130, 33);
		label3.setFont(new Font("Dialog", Font.PLAIN, 15));
		label4.setFont(new Font("Dialog", Font.BOLD, 20));		
		label4.setBounds(90, 37, 280, 40);
		button2.setBounds(60, 150, 130, 33);
		button4.setBounds(200, 150, 130, 33);
		button3.setBounds(130, 200, 130, 33);		
		this.add(button2);
		this.add(button3);	
		this.add(button4);		
		this.add(label3);
		this.add(label4);
		setJMenuBar(jMenuBar);
		// ”文件“菜单项中加入子菜单
		jMenuFile.add(jMenuItem2);
		jMenuFile.add(jMenuItem3);		
		jMenuBar.add(jMenuFile);// 将菜单项加入菜单条
		jMenuBar.add(jMenuExit);
		button2.addActionListener(this);// 本窗口向按钮事件源注册
		button3.addActionListener(this);
		button4.addActionListener(this);
		// 本窗口菜单子项注册
		jMenuItem2.addActionListener(this);
		jMenuItem3.addActionListener(this);		
		jMenuExit.addActionListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		MInterface a = new MInterface();
	}

	
	public void actionPerformed(ActionEvent e) // 按钮事件的处理
	{
		if (e.getSource() == jMenuExit) {
			System.exit(0);
		} else if (e.getSource() == jMenuItem2 || e.getSource() == button2) {
			//对学生的信息进行查询
			try {
				MCx a = new MCx();
			} catch (Exception ee) {
			}
		} else if (e.getSource() == button4) {
			//对学生的信息进行查询
			try {
				Qitainfor a = new Qitainfor();
			} catch (Exception ee) {
			}
		} else if (e.getSource() == jMenuItem3 || e.getSource() == button3) {
			//注册学生
			try {
				Zhuce a = new Zhuce();
			} catch (Exception ed) {
			}
		} 
	}
	
	

}

