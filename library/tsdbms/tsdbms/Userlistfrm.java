package tsdbms;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

@SuppressWarnings("serial")
class Userlistfrm extends JFrame implements ActionListener
{
	Object a[][]; 
	Object colname[]={"�û���","����","Ȩ��"};
	JTable table;
	Container container;
	JButton b_back;
	JProgressBar p_bar;
	JPanel pan1;
	
	NetConn  sql;
	Statement sqll;
	ResultSet rs;
	
	Userlistfrm()
	{
		super("�û��б�");
		a=new Object[30][3];
		table=new JTable(a,colname);
		setSize(300,300);setVisible(true);
		//b_enter=new JButton("ȷ��");
		b_back=new JButton("ȷ��");
		//b_enter.addActionListener(this);
		b_back.addActionListener(this);
		pan1=new JPanel();
		//pan1.add(b_enter);
		pan1.add(b_back);
		p_bar=new JProgressBar(JProgressBar.VERTICAL,0,50);
		p_bar.setStringPainted(true);
		container=getContentPane();
		container.add(pan1,BorderLayout.SOUTH);
		container.add(new JScrollPane(table),BorderLayout.CENTER);
		container.add(p_bar,BorderLayout.WEST);
		sql=new NetConn();
		setBounds(250,150,600,350);
		this.setResizable(false);
		displayInfo();
	}
	public void  actionPerformed(ActionEvent eb)
	{
		if(eb.getSource()==b_back)
		{
			dispose();
		}
	}
	public void displayInfo()
	{
		try
		{
			int i=0;
			sqll=sql.connect();
			rs=sqll.executeQuery("select * from users");
			while(rs.next())
			{
				a[i][0]=rs.getString(2);a[i][1]=rs.getString(3);
				switch(Integer.parseInt(rs.getString(4)))
				{case 1:a[i][2]="������";break;
				 case 2:a[i][2]="����";break;
				 case 3:a[i][2]="����";break;
				}		
				i++;
				p_bar.setValue(i);p_bar.setString("��ѯ��"+i+"����¼");
			}
		}
		catch(SQLException ed)
		{		}
	}
}