package studentManage;

/*
 * ��ʼ�����棬ʹ������λ����Ļ�м䣬���û����ܸı��С
 */

import javax.swing.UIManager; 
import java.awt.*;

//import screen
public class Student {
	boolean packFrame = false;

	// JFrame frame=new JFrame();
	public Student() {
		Mainframe frame = new Mainframe();
		if (packFrame) {
			frame.pack();//�����˴��ڵĴ�С�����ʺ������������ѡ��С�Ͳ��֡�
		} else {
			frame.validate();//��֤���������������������
		}
		//������Ļ��С
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = frame.getSize();
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		frame.setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		new Student();
	}
}
