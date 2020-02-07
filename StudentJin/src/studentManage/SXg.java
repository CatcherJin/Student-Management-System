package studentManage;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SXg extends JFrame implements ActionListener {
	static SXg s;
	static JLabel label1 = new JLabel("学号:");
	static JTextField textField1 = new JTextField("");
	static JLabel label2 = new JLabel("姓名:");
	static JTextField textField2 = new JTextField("");
	static JLabel label3 = new JLabel("性别:");
	static JTextField textField7 = new JTextField("");
	static JLabel label4 = new JLabel("出生日期:");
	static JTextField textField3 = new JTextField("");
	static JLabel label5 = new JLabel("政治面貌:");
	static JTextField textField8 = new JTextField("");
	static JLabel label6 = new JLabel("籍贯");
	static JTextField textField4 = new JTextField("");
	static JLabel label7 = new JLabel("系别:");
	static JTextField textField9 = new JTextField("");
	static JLabel label8 = new JLabel("专业:");	
	static JTextField textField5 = new JTextField("");
	static JButton button2 = new JButton("修改");

	public SXg() {
		this.setTitle("修改学生信息");
		this.setLayout(null);
		this.setSize(400, 400);
		label1.setBounds(30, 11, 51, 33);
		textField1.setBounds(86, 16, 74, 22);
		label2.setBounds(162, 11, 51, 33);
		textField2.setBounds(192, 16, 44, 22);
		label3.setBounds(241, 11, 70, 33);
		textField7.setBounds(275, 15, 50, 25);
		label4.setBounds(31, 53, 55, 33);
		textField3.setBounds(86, 58, 74, 22);
		label5.setBounds(241, 53, 70, 33);
		textField8.setBounds(296, 57, 72, 25);
		label6.setBounds(163, 53, 26, 33);
		textField4.setBounds(191, 58, 44, 22);
		label7.setBounds(30, 94, 50, 33);
		textField9.setBounds(86, 94, 74, 22);
		label8.setBounds(163, 94, 51, 33);
		textField5.setBounds(190, 99, 178, 22);
		button2.setBounds(115, 241, 80, 33);
		button2.addActionListener(this);
		this.add(label1);
		this.add(label2);
		this.add(label3);
		this.add(label4);
		this.add(label5);
		this.add(label6);
		this.add(label7);
		this.add(label8);
		this.add(textField1);
		this.add(textField2);
		this.add(textField3);
		this.add(textField4);
		this.add(textField5);
		this.add(textField7);
		this.add(textField8);
		this.add(textField9);
		this.add(button2);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) throws Exception {
		SXg a = new SXg();
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e)//事件处理程序
   {
    if(e.getSource()==button2)
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
			
			
     ResultSet rs=stmt.executeQuery("select * from infor where stuId='"+textField1.getText()+"'");
                if(textField1.getText().trim().equals(""))
                {
                    JOptionPane.showMessageDialog(this,"学号不可为空！");
                }else if(rs.next())
               {             
                	 try{
                	stmt.execute("update infor set stuId='"+textField1.getText()+"',name='"+
               	          textField2.getText()+"',sex='"+textField7.getText()+"',birDate='"+
               	                 textField3.getText()+"',look='"+textField8.getText()+"',jiGuan='"+
               	                 textField4.getText()+"',xiBie='"+textField9.getText()+"',zhuanYe='"+
               	                 textField5.getText()+ "'");                	
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
