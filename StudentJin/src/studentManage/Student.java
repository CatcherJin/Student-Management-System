package studentManage;

/*
 * ��ʼ�����棬ʹ������λ����Ļ�м䣬���û����ܸı��С
 */

import javax.swing.UIManager; 
import java.awt.*;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import javax.swing.*;

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
	
	public static String[] DEFAULT_FONT = new String[]{
            "Table.font"
            , "TableHeader.font"
            , "CheckBox.font"
            , "Tree.font"
            , "Viewport.font"
            , "ProgressBar.font"
            , "RadioButtonMenuItem.font"
            , "ToolBar.font"
            , "ColorChooser.font"
            , "ToggleButton.font"
            , "Panel.font"
            , "TextArea.font"
            , "Menu.font"
            , "TableHeader.font"
             ,"TextField.font"
            , "OptionPane.font"
            , "MenuBar.font"
            , "Button.font"
            , "Label.font"
            , "PasswordField.font"
            , "ScrollPane.font"
            , "MenuItem.font"
            , "ToolTip.font"
            , "List.font"
            , "EditorPane.font"
            , "Table.font"
            , "TabbedPane.font"
            , "RadioButton.font"
            , "CheckBoxMenuItem.font"
            , "TextPane.font"
            , "PopupMenu.font"
            , "TitledBorder.font"
            , "ComboBox.font"
    };
	public static void main(String[] args) {
//		try {
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
            UIManager.put("RootPane.setupButtonVisible", false);
            for (int i = 0; i < DEFAULT_FONT.length; i++)
                UIManager.put(DEFAULT_FONT[i], new Font("΢���ź�", Font.PLAIN, 14));
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();

        } catch (Exception e) {
            //TODO exception
        }
		new Student();
	}
}