package tsdbms;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
class Readme extends JFrame implements ActionListener
{
	JLabel  l_ver,l_lib;
  Readme()
  {
	  super("ʹ�ð���");
	  final Font myfont=new Font("����_GB2312",Font.BOLD,20);
	  l_ver=new JLabel("                       ������ͼ�����ϵͳ1.0��ʽ��");
	  l_lib=new JLabel("������ͼ�����ϵͳ");
	  l_lib.setFont(myfont);
	  add(l_lib);
	  add(l_ver);
	  setBounds(350,150,300,300);
  }
  public void actionPerformed(final ActionEvent e)
  {
	  
  }
}
