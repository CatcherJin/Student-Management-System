package studentManage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * ����Ա
 * ��������ӿ��࣬����ֱ����չ�����á�
 */

public class MInterface extends JFrame implements ActionListener {
	static JMenuBar jMenuBar = new JMenuBar();// �˵���
	static JMenu jMenuFile = new JMenu("�ļ�");// �˵���
	static JMenu jMenuExit = new JMenu("�˳�");	
	static JMenuItem jMenuItem2= new JMenuItem("��Ϣ��ѯ");
	static JMenuItem jMenuItem3 = new JMenuItem("ѧ��ע��");	
	static JLabel label3 = new JLabel("��ѡ�������");
	static JLabel label4 = new JLabel("ѧ������ϵͳ");	
	static JButton button2 = new JButton("��Ϣ��ѯ");
	static JButton button3 = new JButton("ѧ��ע��");
	
	public MInterface() {
		this.setTitle("ѧ������ϵͳ");
		this.setLayout(null);
		this.setSize(400, 400);
		label3.setBounds(158, 92, 98, 33);
		label3.setFont(new Font("Dialog", Font.PLAIN, 15));
		label4.setFont(new Font("Dialog", Font.BOLD, 20));		
		label4.setBounds(157, 37, 280, 40);
		button2.setBounds(74, 136, 97, 33);
		button3.setBounds(226, 136, 97, 33);		
		this.add(button2);
		this.add(button3);		
		this.add(label3);
		this.add(label4);
		setJMenuBar(jMenuBar);
		// ���ļ����˵����м����Ӳ˵�
		jMenuFile.add(jMenuItem2);
		jMenuFile.add(jMenuItem3);		
		jMenuBar.add(jMenuFile);// ���˵������˵���
		jMenuBar.add(jMenuExit);
		button2.addActionListener(this);// ��������ť�¼�Դע��
		button3.addActionListener(this);
		// �����ڲ˵�����ע��
		jMenuItem2.addActionListener(this);
		jMenuItem3.addActionListener(this);		
		jMenuExit.addActionListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		MInterface a = new MInterface();
	}

	
	public void actionPerformed(ActionEvent e) // ��ť�¼��Ĵ���
	{
		if (e.getSource() == jMenuExit) {
			System.exit(0);
		} else if (e.getSource() == jMenuItem2 || e.getSource() == button2) {
			//��ѧ������Ϣ���в�ѯ
			try {
				MCx a = new MCx();
			} catch (Exception ee) {
			}
		} else if (e.getSource() == jMenuItem3 || e.getSource() == button3) {
			//ע��ѧ��
			try {
				Zhuce a = new Zhuce();
			} catch (Exception ed) {
			}
		} 
	}
	
	

}