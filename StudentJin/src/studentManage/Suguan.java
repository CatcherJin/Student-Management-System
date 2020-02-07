package studentManage;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public  class Suguan extends JFrame implements ActionListener {
	static Suguan s;
	static JLabel label1 = new JLabel("寝室号:");
	static JTextField textField1 = new JTextField("");
	static JLabel label2 = new JLabel("卫生成绩:");
	static JTextField textField2 = new JTextField("");

	static JLabel label4 = new JLabel("学生名:");
	static JTextField textField4 = new JTextField("");
	static JLabel label5 = new JLabel("学号:");
	static JTextField textField5 = new JTextField("");
	
	static JButton button3 = new JButton("登记卫生成绩");
	static JButton button4 = new JButton("查询寝室人数");


	//初始化界面	
	public Suguan() throws Exception {
		this.setTitle("宿管操作");
		this.setLayout(null);
		this.setSize(400, 260);
		
		label1.setBounds(30, 11, 80, 30);	//寝室号
		textField1.setBounds(90, 16, 70, 20);
		
		label2.setBounds(190, 11, 80, 30);//卫生成绩
		textField2.setBounds(250, 16, 70, 20);
		
		
		label4.setBounds(30, 61, 80, 30);//学生名
		textField4.setBounds(90, 66, 70, 20);
		
		label5.setBounds(190, 61, 80, 30);//学号
		textField5.setBounds(250, 66, 70, 20);
		

	
			
		button3.setBounds(30, 120, 130, 33);
		
		button4.setBounds(200, 120, 130, 33);

		
		button3.addActionListener(this);
		button4.addActionListener(this);

		
		this.add(label1);
		this.add(label2);
		this.add(label4);
		this.add(label5);
		
		this.add(textField1);
		this.add(textField2);
		this.add(textField4);		
		this.add(textField5);
		
		this.add(button3);
		this.add(button4);
		
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);

	}

	public static void main(String[] args) throws Exception {
		Suguan a = new Suguan();
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==button3)
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
				
				
	     ResultSet rs = stmt.executeQuery("select * from qin_stu where qsqinId='"
					+ textField1.getText() + "' and qsstuname='"+ textField4.getText()+ "' " );
	                if(textField1.getText().trim().equals("")||textField4.getText().trim().equals(""))
	                {
	                    JOptionPane.showMessageDialog(this,"寝室号和学生名不可为空！");
	                }else if(rs.next())
	               {             
	                	 try{
	                		 
	                	stmt.execute("update qin_stu set qsscore='"+
	               	          textField2.getText()+"' where qsqinId='"+ textField1.getText() + "' and qsstuname='"+ textField4.getText()+ "' ");  
	               	           
	                	JOptionPane.showMessageDialog(null,"修改成功!");                 	 
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
		
		if (e.getSource() == button4) {
			try {

				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException ce) {
				JOptionPane.showMessageDialog(s, ce.getMessage());
			}
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stu?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true&user=root&password=123456&useSSL=true&serverTimezone=UTC&&useSSL=false&allowPublicKeyRetrieval=true\\r\\n");
				Statement stmt = con.createStatement();
				
				ResultSet rs = stmt.executeQuery("select * from qinshi where qId='"
								+ textField1.getText() + "'");
				if (textField1.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(this, "寝室号不可为空！");
				}
				else if (rs.next()) {
					  System.out.println("寝室号"+"\t\t人数");
					  int qnum =rs.getInt("qnum");
			    	  String qId =rs.getString("qId").trim();
			    	  System.out.println(qId+"\t\t"+qnum);
				} else {
					JOptionPane.showMessageDialog(this, "无此记录！！！");
				}
			}
			catch (SQLException se) {
				JOptionPane.showMessageDialog(s, se.getMessage());
			}
		}
		
		

	}
}
