package studentManage;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SCx extends JFrame implements ActionListener {
	static SCx s;
	static JLabel label1 = new JLabel("学号:");
	static JTextField textField1 = new JTextField("");
	static JLabel label2 = new JLabel("姓名:");
	static JTextField textField2 = new JTextField("");
	static JLabel label3 = new JLabel("班级:");
	static JTextField textField3= new JTextField("");
	static JLabel label4 = new JLabel("专业:");
	static JTextField textField4 = new JTextField("");
	static JLabel label5 = new JLabel("院系:");
	static JTextField textField5 = new JTextField("");
	static JLabel label6 = new JLabel("性别");
	static JTextField textField6 = new JTextField("");
	static JLabel label7 = new JLabel("年级:");
	static JTextField textField7 = new JTextField("");
	static JLabel label8 = new JLabel("生日");
	static JTextField textField8 = new JTextField("");
	static JLabel label9 = new JLabel("电话:");
	static JTextField textField9 = new JTextField("");
	static JLabel label10 = new JLabel("QQ:");
	static JTextField textField10 = new JTextField("");
	static JLabel label11 = new JLabel("状态:");
	static JTextField textField11 = new JTextField("");
	static JLabel label12 = new JLabel("密码:");
	static JTextField textField12 = new JTextField("");
	
	static JButton button3 = new JButton("查询");
	static JButton button4 = new JButton("修改");

	//初始化界面	
	public SCx() throws Exception {
		this.setTitle("查询学生信息");
		this.setLayout(null);
		
		this.setSize(480, 400);
		
		label1.setBounds(30, 11, 50, 30);	//学号	
		textField1.setBounds(60, 16, 70, 20);
		
		label2.setBounds(160, 11, 50, 30);//姓名
		textField2.setBounds(190, 16, 70, 20);
		
		label3.setBounds(290, 11, 50, 30);//班级
		textField3.setBounds(320, 16, 70, 20);
		//===========
		
		label4.setBounds(30, 61, 50, 30);//专业
		textField4.setBounds(60, 66, 70, 20);
		
		label5.setBounds(160, 61, 50, 30);//系别
		textField5.setBounds(190, 66, 70, 20);
		
		label6.setBounds(290, 61,50, 30);//性别		
		textField6.setBounds(320, 66, 70, 20);
		
		//===========
		
		label7.setBounds(30, 111, 50, 30);//年级	
		textField7.setBounds(60, 116, 70, 20);	
		
		label8.setBounds(140, 111, 50, 30);//出生日期		
		textField8.setBounds(190, 116, 70, 20);
		
		label9.setBounds(290, 111, 50, 30);//电话
		textField9.setBounds(320, 116, 70, 20);
		
		//=========
		
		label10.setBounds(30, 161, 50, 30);//QQ
		textField10.setBounds(60,166,70,20 );
		
		label11.setBounds(160, 161, 50, 30);//状态
		textField11.setBounds(190,166, 70, 20);
		
		label12.setBounds(290, 161, 51, 33);//密码
		textField12.setBounds(320,166, 70, 22);
		
		
		button3.setBounds(150, 241, 80, 33);
		button4.setBounds(250, 241, 80, 33);
		
		button3.addActionListener(this);
		button4.addActionListener(this);
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
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);

	}

	
	
	public static void main(String[] args) throws Exception {
		SCx a = new SCx();
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
				
				ResultSet rs = stmt.executeQuery("select * from infor where stuId='"
								+ textField1.getText() + "'");
				if (textField1.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(this, "学号不可为空！");
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
					JOptionPane.showMessageDialog(this, "无此记录！！！");
				}
			}
			catch (SQLException se) {
				JOptionPane.showMessageDialog(s, se.getMessage());
			}
		}
		
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
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stu?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true&user=root&password=123456&useSSL=true&serverTimezone=UTC&&useSSL=false&allowPublicKeyRetrieval=true\\\\r\\\\n");
				
					Statement stmt = con.createStatement();
				
				
	     ResultSet rs=stmt.executeQuery("select * from infor where stuId='"+textField1.getText()+"'");
	                if(textField1.getText().trim().equals(""))
	                {
	                    JOptionPane.showMessageDialog(this,"学号不可为空！");
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

	               	           ()+"'"
);                	
	                				JOptionPane.showMessageDialog(null,"修改成功");                 	 
	                	 }               	                
	               	                 	//stmt.executeQuery(updateSql);}
	               	             // stmt.executeUpdate(updateSql);}
	               	                 	catch(SQLException se)
	               	                 	{
	               	                 	//JOptionPane.showMessageDialog(null,"请输入正确的信息");
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
