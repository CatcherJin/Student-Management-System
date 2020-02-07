package studentManage;

/*
 * 初始化界面，使主界面位于屏幕中间，且用户不能改变大小
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
			frame.pack();//调整此窗口的大小，以适合其子组件的首选大小和布局。
		} else {
			frame.validate();//验证此容器及其所有子组件。
		}
		//设置屏幕大小
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
