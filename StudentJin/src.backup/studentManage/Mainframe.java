package studentManage;

import java.awt.Color;
import java.awt.Event;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;

/*
 * ��������ĵ�½����
 */

public class Mainframe extends JFrame implements ActionListener {

	static Mainframe s;	
	static JPanel pan = new JPanel();//Jpanel����������������������˫����������ֵ��� JPanel��
	//���ڶ��ı��ַ�����ͼ�����ߵ���ʾ��
	static JLabel label1 = new JLabel("��  ��");
	String text=label1.getText();
	
	static JLabel label2 = new JLabel("��  ��");
	
	//static JLabel label3 = new JLabel("��֤��");	
	static JTextField textField3 = new JTextField();
	
	//���������������������֤��
	static int m=(int)(Math.random()*9000+1000);
	static String s1=String.valueOf(m);
	static JLabel label3 = new JLabel(s1);	
	String num=s1;
	
	//JTextField ��һ�������������������༭�����ı���
	static JTextField textField1 = new JTextField();
	//JPasswordField ��һ�����������������༭�����ı�������ͼָʾ�������ݣ�������ʾԭʼ�ַ���
	static JPasswordField password = new JPasswordField();
	
	
	static JButton button1 = new JButton("����ϵͳ");
	//static JButton button2 = new JButton("�û�ע��");

	static JRadioButton radioButton1 = new JRadioButton("����Ա");// ������Ա����ʼ״̬��ѡ��
	static JRadioButton radioButton2 = new JRadioButton("ѧ��");
	
	ButtonGroup buttonGroup = new ButtonGroup();
	
	
	public String getA(){
		return this.text;		
	}
	

	public Mainframe() {
		
		JLabel label = new JLabel();
		label.setSize(400, 400);//����label��С
		pan.add(label);//���label���
		pan.setLayout(null);
		pan.setSize(400, 400);
		
		
		this.setTitle("ѧ������ϵͳ");
		this.setSize(400, 400);
		this.setLayout(null);
		//�������������λ��
		label1.setBounds(100, 25, 50, 20);//�û�
		textField1.setBounds(155, 24, 120, 20);
		
		label2.setBounds(100, 62, 50, 20);//����
		password.setBounds(155, 61, 120, 20);
		
		textField3.setBounds(155, 100, 120, 20);//��д��֤����ı���
		label3.setBounds(100, 100, 50, 20);//��֤��
		//label4.setBounds(200, 85, 20, 20);//������֤��
		
		label3.setForeground(Color.RED);//����label�����������ɫ
		label3.setFont(new java.awt.Font("ITALIC",0,14));
		
		//ImageIcon ima=new ImageIcon("1.png");
		//label3.setIcon(ima);
		
		//��jlabel���ñ߿�ɫ
		label3.setBorder(BorderFactory.createLineBorder(Color.lightGray,1));
		
		//�����������¼���������֤��
		label3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent  e){
				int m=(int)(Math.random()*9000+1000);
				String s1=String.valueOf(m);
				label3.setText(s1);	
				System.out.println("���");	
				num=s1;
			}			
		});
		
		
		
		button1.setBounds(150, 200, 101, 22);//����ϵͳ
		//button2.setBounds(150, 240, 101, 22);//�û�ע��
		radioButton1.setBounds(105, 140, 80, 20);
		radioButton2.setBounds(180, 140, 60, 20);
		//radioButton3.setBounds(240, 140, 60, 20);
		button1.addActionListener(this);//��button�������
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
		//����Ĭ�ϵ��뿪����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);//������ʾ�ɼ�
	}

	public static void main(String[] args) {
		new Mainframe();//�½�һ����½���壬��������
	}

	public void actionPerformed(ActionEvent e) {
				

		if (radioButton1.isSelected())// ѡ�й���Ա
		{
			//��֤�û����������ǲ���syc��123
			if (textField1.getText().equals("syc")
					&& password.getText().equals("123") && textField3.getText().equals(num)) {
				MInterface b = new MInterface();//��֤�ɹ������������ӿ�
				this.dispose();
				// JOptionPane.showMessageDialog(null,"��½�ɹ�");

			} else if ("".equals(textField1.getText())
					|| "".equals(password.getText())) {
				JOptionPane.showMessageDialog(null, "�û��������벻��Ϊ��");
			} else {
				JOptionPane.showMessageDialog(null, "�û����������֤����������");
			}

		}
		
		if (radioButton2.isSelected())// ѡ��ѧ����¼
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
				//�����ݿ�����֤�û���������
				ResultSet rs = stmt.executeQuery("select * from infor where stuId= '"
								+ textField1.getText() + "' and password= '"
								+ password.getText() + "'");

				if (textField1.getText().equals("")
						|| password.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "�û��������벻��Ϊ�գ�");
				} else if (rs.next() && textField3.getText().equals(num))

				{
					try {
						new SCx();
					} catch (Exception e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					}
				}

				else {
					JOptionPane.showMessageDialog(this, "������������");
				}

				// stmt.close();
			}

			catch (SQLException se) {
				JOptionPane.showMessageDialog(s, se.getMessage());
			}
		}
	}
}
