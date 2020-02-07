package studentManage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * 学生登录
 * 操作界面接口类，可以直接扩展、调用。
 */

public class SInterface extends JFrame implements ActionListener {
	static JMenuBar jMenuBar = new JMenuBar();// 菜单条
	static JMenu jMenuFile = new JMenu("文件");// 菜单项
	static JMenu jMenuExit = new JMenu("退出");
	//static JMenuItem jMenuItem1 = new JMenuItem("添加信息");// 菜单子项
	static JMenuItem jMenuItem2 = new JMenuItem("修改信息");
	static JMenuItem jMenuItem3 = new JMenuItem("信息查询");
	//static JMenuItem jMenuItem4 = new JMenuItem("删除信息");
	static JLabel label3 = new JLabel("请选择操作项");
	static JLabel label4 = new JLabel("学籍管理系统");
	//static JButton button2 = new JButton("添加信息");
	static JButton button3 = new JButton("修改信息");
	static JButton button4 = new JButton("信息查询");
	//static JButton button5 = new JButton("删除信息");

	public SInterface() {
		this.setTitle("学籍管理系统");
		this.setLayout(null);
		this.setSize(400, 400);
		label3.setBounds(158, 92, 98, 33);
		label3.setFont(new Font("Dialog", Font.PLAIN, 15));
		label4.setFont(new Font("Dialog", Font.BOLD, 20));
		label4.setBounds(157, 37, 280, 40);
		//button2.setBounds(74, 136, 97, 33);
		button3.setBounds(226, 136, 97, 33);//修改信息
		button4.setBounds(74, 136, 97, 33);//信息查询
		//button5.setBounds(226, 185, 97, 33);
		//this.add(button2);
		this.add(button3);
		this.add(button4);
		//this.add(button5);
		this.add(label3);
		this.add(label4);
		setJMenuBar(jMenuBar);
		//jMenuFile.add(jMenuItem1);// ”文件“菜单项中加入子菜单
		jMenuFile.add(jMenuItem2);
		jMenuFile.add(jMenuItem3);
		//jMenuFile.add(jMenuItem4);
		jMenuBar.add(jMenuFile);// 将菜单项加入菜单条
		jMenuBar.add(jMenuExit);
		//button2.addActionListener(this);// 本窗口向按钮事件源注册
		button3.addActionListener(this);
		button4.addActionListener(this);
		//button5.addActionListener(this);
		//jMenuItem1.addActionListener(this);// 本窗口菜单子项注册
		jMenuItem2.addActionListener(this);
		jMenuItem3.addActionListener(this);
		//jMenuItem4.addActionListener(this);
		jMenuExit.addActionListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		SInterface a = new SInterface();
	}

	public void actionPerformed(ActionEvent e) // 按钮事件的处理
	{
		if (e.getSource() == jMenuExit) {
			System.exit(0);
		}   if (e.getSource() == jMenuItem3 || e.getSource() == button4) {
			try {
				SCx a = new SCx();
			} catch (Exception ec) {
			}
		} 
	}
}
