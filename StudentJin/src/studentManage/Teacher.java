package studentManage;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public  class Teacher extends JFrame implements ActionListener {
	static Teacher s;
	static JLabel label1 = new JLabel("�γ̺�:");
	static JTextField textField1 = new JTextField("");
	static JLabel label2 = new JLabel("�γ���:");
	static JTextField textField2 = new JTextField("");

	static JLabel label4 = new JLabel("�Ͽεص�:");
	static JTextField textField4 = new JTextField("");
	static JLabel label5 = new JLabel("�ον�ʦ:");
	static JTextField textField5 = new JTextField("");
	
	
	static JLabel label6 = new JLabel("ѧ����:");
	static JTextField textField6 = new JTextField("");
	static JLabel label7 = new JLabel("ѧ����:");
	static JTextField textField7 = new JTextField("");
	static JLabel label8 = new JLabel("�γ̺�:");
	static JTextField textField8 = new JTextField("");
	static JLabel label9 = new JLabel("�γ���:");
	static JTextField textField9 = new JTextField("");
	static JLabel label10 = new JLabel("�ɼ�:");
	static JTextField textField10 = new JTextField("");

	
	static JButton button3 = new JButton("���γ̺Ų�ѯ");
	static JButton button4 = new JButton("���γ�����ѯ");
	
	static JButton button7 = new JButton("��ѯ");
	static JButton button8 = new JButton("�Ǽǳɼ�");

	//��ʼ������	
	public Teacher() throws Exception {
		this.setTitle("��ʦ����");
		this.setLayout(null);
		this.setSize(400, 450);
		
		label1.setBounds(30, 11, 80, 30);	//�γ̺�
		textField1.setBounds(90, 16, 70, 20);
		
		label2.setBounds(190, 11, 80, 30);//�γ���
		textField2.setBounds(250, 16, 70, 20);
		
		
		label4.setBounds(30, 61, 80, 30);//�Ͽεص�
		textField4.setBounds(90, 66, 70, 20);
		
		label5.setBounds(190, 61, 80, 30);//�ον�ʦ
		textField5.setBounds(250, 66, 70, 20);
		
		
		//
		
		label6.setBounds(30, 181, 80, 30);	//ѧ����
		textField6.setBounds(90, 186, 70, 20);
		
		label7.setBounds(190, 181, 80, 30);//ѧ����
		textField7.setBounds(250, 186, 70, 20);
		
		
		label8.setBounds(30, 221, 80, 30);//�γ̺�
		textField8.setBounds(90, 226, 70, 20);
		
		label9.setBounds(190, 221, 80, 30);//�γ���
		textField9.setBounds(250, 226, 70, 20);
		

		
		label10.setBounds(30, 261, 80, 30);//�γ̺�
		textField10.setBounds(90, 266, 70, 20);
	
			
		button3.setBounds(30, 120, 130, 33);
		
		button4.setBounds(200, 120, 130, 33);
	
		button7.setBounds(30, 320, 130, 33);
		button8.setBounds(200,320, 130, 33);
		
		
		button3.addActionListener(this);
		button4.addActionListener(this);

		button7.addActionListener(this);
		button8.addActionListener(this);
		
		
		this.add(label1);
		this.add(label2);
		this.add(label4);
		this.add(label5);
		this.add(label6);
		this.add(label7);
		this.add(label8);
		this.add(label9);
		this.add(label10);
		
		this.add(textField1);
		this.add(textField2);
		this.add(textField4);		
		this.add(textField5);
		this.add(textField6);
		this.add(textField7);
		this.add(textField8);
		this.add(textField9);
		this.add(textField10);
		
		this.add(button3);
		this.add(button4);
		
		this.add(button7);
		this.add(button8);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);

	}

	public static void main(String[] args) throws Exception {
		Teacher a = new Teacher();
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
				
				ResultSet rs = stmt.executeQuery("select * from kecheng where keId='"
								+ textField1.getText() + "'");
				if (textField1.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(this, "�γ̺Ų���Ϊ�գ�");
				}
				else if (rs.next()) {
					textField1.setText(rs.getString("keId"));
					textField2.setText(rs.getString("kename"));
					textField4.setText(rs.getString("keroom"));
					textField5.setText(rs.getString("ketea"));
				
				} else {
					JOptionPane.showMessageDialog(this, "�޴˼�¼������");
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
				
				ResultSet rs = stmt.executeQuery("select * from kecheng where kename='"
								+ textField2.getText() + "'");
				if (textField2.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(this, "�γ�������Ϊ�գ�");
				}
				else if (rs.next()) {
					textField1.setText(rs.getString("keId"));
					textField2.setText(rs.getString("kename"));
					textField4.setText(rs.getString("keroom"));
					textField5.setText(rs.getString("ketea"));
				
				} else {
					JOptionPane.showMessageDialog(this, "�޴˼�¼������");
				}
			}
			catch (SQLException se) {
				JOptionPane.showMessageDialog(s, se.getMessage());
			}
		}
		
		if (e.getSource() == button7) {
			try {

				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException ce) {
				JOptionPane.showMessageDialog(s, ce.getMessage());
			}
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stu?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true&user=root&password=123456&useSSL=true&serverTimezone=UTC&&useSSL=false&allowPublicKeyRetrieval=true\\r\\n");
				Statement stmt = con.createStatement();
				
				ResultSet rs = stmt.executeQuery("select * from ke_stu where ksstuname='"
								+ textField7.getText() + "' and kskename='"+ textField9.getText()+ "' " );
				if (textField7.getText().trim().equals("")||textField9.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(this, "ѧ�����Ϳγ�������Ϊ�գ�");
				}
				else if (rs.next()) {
					textField6.setText(rs.getString("ksstuId"));
					textField7.setText(rs.getString("ksstuname"));
					textField8.setText(rs.getString("kskeId"));
					textField9.setText(rs.getString("kskename"));
					textField10.setText(rs.getString("ksscore"));
				
				} else {
					JOptionPane.showMessageDialog(this, "�޴˼�¼������");
				}
			}
			catch (SQLException se) {
				JOptionPane.showMessageDialog(s, se.getMessage());
			}
		}
//		//�޸ĵǼǳɼ�
		if(e.getSource()==button8)
	    {
				try{
		
						Class.forName("com.mysql.jdbc.Driver");
						}
				catch (ClassNotFoundException ce)
					{
						JOptionPane.showMessageDialog(s,ce.getMessage());
					}
				try
				{
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stu?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true&user=root&password=123456&useSSL=true&serverTimezone=UTC&&useSSL=false&allowPublicKeyRetrieval=true\\r\\n");
				
					Statement stmt = con.createStatement();
				
				
	     ResultSet rs = stmt.executeQuery("select * from ke_stu where ksstuname='"
					+ textField7.getText() + "' and kskename='"+ textField9.getText()+ "' " );
	                if(textField7.getText().trim().equals("")||textField9.getText().trim().equals(""))
	                {
	                    JOptionPane.showMessageDialog(this,"ѧ�����Ϳγ�������Ϊ�գ�");
	                }else if(rs.next())
	               {             
	                	 try{
	                		 
	                	stmt.execute("update ke_stu set ksscore='"+
	               	          textField10.getText()+"' where ksstuname='"+ textField7.getText() + "' and kskename='"+ textField9.getText()+ "' ");  
	               	           
	                	JOptionPane.showMessageDialog(null,"�޸ĳɹ�!");                 	 
	               }               	                
	               	    
	               	     catch(SQLException se)
	               	         {
	               	      JOptionPane.showMessageDialog(s,se.getMessage());               	                 		
	               }      	                 
	                	               	
	               	}   	
	                     }
	      	catch(SQLException se)
	        {
	           JOptionPane.showMessageDialog(s,se.getMessage());
	          }
	    }

	}
}
