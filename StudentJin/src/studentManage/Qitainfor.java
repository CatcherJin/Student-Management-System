package studentManage;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Qitainfor extends JFrame implements ActionListener {
	static Qitainfor s;
	
	static JButton button3 = new JButton("רҵ��Ϣ��ѯ");
	static JButton button4 = new JButton("�༶��Ϣ��ѯ");
	static JButton button5 = new JButton("��ʦ��Ϣ��ѯ");
	
	//��ʼ������	
	public Qitainfor() throws Exception {
		this.setTitle("��ѯ������Ϣ");
		this.setLayout(null);
		this.setSize(430, 270);
		
		
		button3.setBounds(60, 60, 130, 33);
		
		button4.setBounds(200, 60, 130, 33);
		button5.setBounds(60, 130, 130, 33);
		
		
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		
		this.add(button3);
		this.add(button4);
		this.add(button5);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);

	}

	public static void main(String[] args) throws Exception {
		Qitainfor a = new Qitainfor();
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == button3) {
			try {

				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException ce) {
				JOptionPane.showMessageDialog(s, ce.getMessage());
			}
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stu?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true&user=root&password=123456&useSSL=true&serverTimezone=UTC&&useSSL=false&allowPublicKeyRetrieval=true\\r\\n");
				Statement stmt = con.createStatement();
				
				ResultSet rs = stmt.executeQuery("select * from profess");
				
				System.out.println("���"+"\t רҵ����"+"\t����ѧԺ");
				
				while(rs.next()) {
					int pId =rs.getInt("pId");
			    	  String pname =rs.getString("pname").trim();
			    	  String pdepart =rs.getString("pdepart").trim();
			    	  System.out.println(pId+"\t"+pname+"\t\t"+pdepart);
				}			
				
			}
			catch (SQLException se) {
				JOptionPane.showMessageDialog(s, se.getMessage());
			}
		}
		
		if (e.getSource() == button4) {
			try {

				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException ce) {
				JOptionPane.showMessageDialog(s, ce.getMessage());
			}
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stu?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true&user=root&password=123456&useSSL=true&serverTimezone=UTC&&useSSL=false&allowPublicKeyRetrieval=true\\r\\n");
				Statement stmt = con.createStatement();
				
				ResultSet rs = stmt.executeQuery("select * from class");
				
				System.out.println("�༶��"+"\t\t רҵ��"+"\t\t������");
				
				while(rs.next()) {
					  int cId =rs.getInt("cId");
			    	  String cname =rs.getString("cname").trim();
			    	  String ctea =rs.getString("ctea").trim();
			    	  System.out.println(cId+"\t"+cname+"\t\t"+ctea);
				}			
				
			}
			catch (SQLException se) {
				JOptionPane.showMessageDialog(s, se.getMessage());
			}
		}
		
		if (e.getSource() == button5) {
			try {

				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException ce) {
				JOptionPane.showMessageDialog(s, ce.getMessage());
			}
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stu?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true&user=root&password=123456&useSSL=true&serverTimezone=UTC&&useSSL=false&allowPublicKeyRetrieval=true\\r\\n");
				Statement stmt = con.createStatement();
				
				ResultSet rs = stmt.executeQuery("select * from teacher");
				
				System.out.println("��ʦ����"+"\t\t��ʦ����"+"\t\t����ѧԺ"+"\t\t����");
				
				while(rs.next()) {
					int tId =rs.getInt("tId");
			    	  String tname =rs.getString("tname").trim();
			    	  String tdepart =rs.getString("tdepart").trim();
			    	  String tpw =rs.getString("tpw").trim();
			    	  System.out.println(tId+"\t"+tname+"\t\t"+tdepart+"\t\t"+tpw);
				}			
				
			}
			catch (SQLException se) {
				JOptionPane.showMessageDialog(s, se.getMessage());
			}
		}
	}
}
