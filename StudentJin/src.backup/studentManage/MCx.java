package studentManage;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MCx extends JFrame implements ActionListener {
	static MCx s;
	static JLabel label1 = new JLabel("ѧ��:");
	static JTextField textField1 = new JTextField("");
	static JLabel label2 = new JLabel("����:");
	static JTextField textField2 = new JTextField("");
	static JLabel label3 = new JLabel("�༶:");
	static JTextField textField3= new JTextField("");
	static JLabel label4 = new JLabel("רҵ:");
	static JTextField textField4 = new JTextField("");
	static JLabel label5 = new JLabel("Ժϵ:");
	static JTextField textField5 = new JTextField("");
	static JLabel label6 = new JLabel("�Ա�");
	static JTextField textField6 = new JTextField("");
	static JLabel label7 = new JLabel("�꼶:");
	static JTextField textField7 = new JTextField("");
	static JLabel label8 = new JLabel("����");
	static JTextField textField8 = new JTextField("");
	static JLabel label9 = new JLabel("�绰:");
	static JTextField textField9 = new JTextField("");
	static JLabel label10 = new JLabel("QQ:");
	static JTextField textField10 = new JTextField("");
	static JLabel label11 = new JLabel("״̬:");
	static JTextField textField11 = new JTextField("");
	static JLabel label12 = new JLabel("����:");
	static JTextField textField12 = new JTextField("");
	
	static JButton button3 = new JButton("��ѧ�Ų�ѯ");
	static JButton button4 = new JButton("�޸�");
	static JButton button5 = new JButton("ɾ��");
	static JButton button6 = new JButton("��������ѯ");

	//��ʼ������	
	public MCx() throws Exception {
		this.setTitle("��ѯѧ����Ϣ");
		this.setLayout(null);
		this.setSize(600, 600);
		
		label1.setBounds(30, 11, 50, 30);	//ѧ��	
		textField1.setBounds(60, 16, 70, 20);
		
		label2.setBounds(160, 11, 50, 30);//����
		textField2.setBounds(190, 16, 70, 20);
		
		label3.setBounds(290, 11, 50, 30);//�༶
		textField3.setBounds(320, 16, 70, 20);
		//===========
		
		label4.setBounds(30, 61, 50, 30);//רҵ
		textField4.setBounds(60, 66, 70, 20);
		
		label5.setBounds(160, 61, 50, 30);//ϵ��
		textField5.setBounds(190, 66, 70, 20);
		
		label6.setBounds(290, 61,50, 30);//�Ա�		
		textField6.setBounds(320, 66, 70, 20);
		
		//===========
		
		label7.setBounds(30, 111, 50, 30);//�꼶	
		textField7.setBounds(60, 116, 70, 20);	
		
		label8.setBounds(140, 111, 50, 30);//��������		
		textField8.setBounds(190, 116, 70, 20);
		
		label9.setBounds(290, 111, 50, 30);//�绰
		textField9.setBounds(320, 116, 70, 20);
		
		//=========
		
		label10.setBounds(30, 161, 50, 30);//QQ
		textField10.setBounds(60,166,70,20 );
		
		label11.setBounds(160, 161, 50, 30);//״̬
		textField11.setBounds(190,166, 70, 20);
		
		label12.setBounds(290, 161, 51, 33);//����
		textField12.setBounds(320,166, 70, 22);
		
				
		button6.setBounds(60, 241, 100, 33);
		button3.setBounds(180, 241, 100, 33);
		
		button4.setBounds(60, 300, 100, 33);
		button5.setBounds(180, 300, 100, 33);
		
		
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		
		this.add(label1);
		this.add(label2);
		this.add(label3);
		this.add(label4);
		this.add(label5);
		this.add(label6);
		this.add(label7);
		this.add(label8);
		this.add(label9);
		this.add(label10);
		this.add(label11);
		this.add(label12);
		
		this.add(textField1);
		this.add(textField2);
		this.add(textField3);
		this.add(textField4);		
		this.add(textField5);
		this.add(textField6);
		this.add(textField7);
		this.add(textField8);
		this.add(textField9);
		this.add(textField10);
		this.add(textField11);
		this.add(textField12);		
		
		this.add(button3);
		this.add(button4);
		this.add(button5);
		this.add(button6);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);

	}

	public static void main(String[] args) throws Exception {
		MCx a = new MCx();
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == button6) {
			try {

				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException ce) {
				JOptionPane.showMessageDialog(s, ce.getMessage());
			}
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stu","root","111");
				Statement stmt = con.createStatement();
				
				ResultSet rs = stmt.executeQuery("select * from infor where name='"
								+ textField2.getText() + "'");
				if (textField2.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(this, "��������Ϊ�գ�");
				}
				else if (rs.next()) {
					textField1.setText(rs.getString("stuId"));
					textField2.setText(rs.getString("name"));
					textField3.setText(rs.getString("class"));
					textField4.setText(rs.getString("profess"));
					textField5.setText(rs.getString("depart"));
					textField6.setText(rs.getString("sex"));
					textField7.setText(rs.getString("grade"));
					textField8.setText(rs.getString("bir"));
					textField9.setText(rs.getString("phone"));
					textField10.setText(rs.getString("QQ"));
					textField11.setText(rs.getString("state"));
					textField12.setText(rs.getString("password"));
				
				} else {
					JOptionPane.showMessageDialog(this, "�޴˼�¼������");
				}
			}
			catch (SQLException se) {
				JOptionPane.showMessageDialog(s, se.getMessage());
			}
		}
		
		
		
		if (e.getSource() == button3) {
			try {

				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException ce) {
				JOptionPane.showMessageDialog(s, ce.getMessage());
			}
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stu","root","111");
				Statement stmt = con.createStatement();
				
				ResultSet rs = stmt.executeQuery("select * from infor where stuId='"
								+ textField1.getText() + "'");
				if (textField1.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(this, "ѧ�Ų���Ϊ�գ�");
				}
				else if (rs.next()) {
					textField1.setText(rs.getString("stuId"));
					textField2.setText(rs.getString("name"));
					textField3.setText(rs.getString("class"));
					textField4.setText(rs.getString("profess"));
					textField5.setText(rs.getString("depart"));
					textField6.setText(rs.getString("sex"));
					textField7.setText(rs.getString("grade"));
					textField8.setText(rs.getString("bir"));
					textField9.setText(rs.getString("phone"));
					textField10.setText(rs.getString("QQ"));
					textField11.setText(rs.getString("state"));
					textField12.setText(rs.getString("password"));
				
				} else {
					JOptionPane.showMessageDialog(this, "�޴˼�¼������");
				}
			}
			catch (SQLException se) {
				JOptionPane.showMessageDialog(s, se.getMessage());
			}
		}
		
		//�޸ı���Ϣ
		if(e.getSource()==button4)
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
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stu","root","111");
				
					Statement stmt = con.createStatement();
				
				
	     ResultSet rs=stmt.executeQuery("select * from infor where stuId='"+textField1.getText()+"'");
	                if(textField1.getText().trim().equals(""))
	                {
	                    JOptionPane.showMessageDialog(this,"ѧ�Ų���Ϊ�գ�");
	                }else if(rs.next())
	               {             
	                	 try{
	                		 
	                	stmt.execute("update infor set name='"+
	               	          textField2.getText()+"',class='"+textField3.getText()+"',profess='"+
	               	                 textField4.getText()+"',depart='"+textField5.getText()+"',sex='"+
	               	                 textField6.getText()+"',grade='"+textField7.getText()+"',bir='"+
	               	                 textField8.getText()+ "',phone='"+textField9.getText()+"',QQ='"+textField10.getText()+
	               	                 "',state='"+textField11.getText()+"',password='"+textField12.getText()
	               	              +"'where stuId='"+textField1.getText

	               	           ()+"'");  
	               	           
	                	stmt.execute("insert into operate(stuId,operate)values("+textField1.getText()+",'�޸Ĳ���')");
	                				JOptionPane.showMessageDialog(null,"�޸ĳɹ����Ѵ˴β�����¼�������ݿ�");                 	 
	                	 }               	                
	               	                 	//stmt.executeQuery(updateSql);}
	               	             // stmt.executeUpdate(updateSql);}
	               	                 	catch(SQLException se)
	               	                 	{
	               	                 	//JOptionPane.showMessageDialog(null,"��������ȷ����Ϣ");
	               	                 	JOptionPane.showMessageDialog(s,se.getMessage());               	                 		
	               	                 	}      	                 
	                	               	
	               	}   	
	                     }
	      	catch(SQLException se)
	        {
	           JOptionPane.showMessageDialog(s,se.getMessage());
	          }
	    }
		
		if (e.getSource() == button5) {
			try {

				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException ce) {
				JOptionPane.showMessageDialog(s, ce.getMessage());
			}
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stu","root","111");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt
						.executeQuery("select * from infor where stuId='"
								+ textField1.getText() + "'");
				if (textField1.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(this, "ѧ�Ų���Ϊ�գ�");
				}

				else if (rs.next()) {
					JOptionPane.showConfirmDialog(null,
							"ȷ��Ҫɾ������Ϣ�\nɾ������Ϣ�����ָܻ���������", "ɾ�� ȷ��",
							JOptionPane.OK_CANCEL_OPTION);// ,JOption.QUESTION_MESSAGE)==0;
					stmt.execute("delete  from infor where  stuId='"
							+ textField1.getText() + "'");
					stmt.execute("insert into operate(stuId,operate)values("+textField1.getText()+",'ɾ������')");
					JOptionPane.showMessageDialog(null, "ɾ����Ϣ�ɹ����Ѵ˴β�����¼�������ݿ⣡");
					this.dispose();
				} else
					JOptionPane.showMessageDialog(null, "�޴�ѧ�Ŷ�Ӧ��Ϣ", "����",
							JOptionPane.WARNING_MESSAGE);
			} catch (Exception ed) {
				JOptionPane.showMessageDialog(s, ed.getMessage());
			}
		}		
	}
}
