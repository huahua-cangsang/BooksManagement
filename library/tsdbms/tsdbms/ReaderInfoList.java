package tsdbms;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

class ReaderInfoList extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Object a[][]; 
	Object colname[]={"�û�","���ߺ�","��������","��������","�Ƿ�黹","�黹����","��ע"};
	JLabel l_msg,l_msg2;
	JTextField t_readernum;
	JTable table;
	Container container;
	JButton b_enter,b_back;
	JProgressBar p_bar;
	JPanel pan1,pan2,pan3,pan4,pan5;
	String a1,a2,s1,s3;
	
	NetConn sql;
	Statement sqll;
	ResultSet rs,rs1;
	@SuppressWarnings("unused")
	private LayoutManager GridLayout;

	ReaderInfoList()
	{
		super("������Ϣ��ѯ�б�");
		l_msg=new JLabel("��������ߺ�");
		//l_readernum=new JLabel("���ߺţ�");
		l_msg2=new JLabel("");
		t_readernum=new JTextField("",10);
		a=new Object[30][7];
		table=new JTable(a,colname);
		setSize(300,300);setVisible(true);
		b_enter=new JButton("ȷ��");
		b_back=new JButton("����");
		b_enter.addActionListener(this);
		b_back.addActionListener(this);
		pan1=new JPanel();pan2=new JPanel();pan3=new JPanel();pan4=new JPanel();pan5=new JPanel();
		pan1.setLayout(new GridLayout(2,1));
		pan4.add(l_msg);//pan1.add(l_readernum);
		pan4.add(t_readernum);
		pan4.add(b_enter);pan4.add(b_back);
		pan1.add(pan4);pan1.add(pan5);
		pan5.add(l_msg2);
		
		p_bar=new JProgressBar(JProgressBar.VERTICAL,0,50);
		p_bar.setStringPainted(true);
		container=getContentPane();
		container.add(pan1,BorderLayout.NORTH);
		container.add(new JScrollPane(table),BorderLayout.CENTER);
		container.add(p_bar,BorderLayout.WEST);
		
		sql=new NetConn();
		setBounds(230,150,650,350);
	}
	
	public void  actionPerformed(ActionEvent eR)
	{
		if(eR.getSource()==b_back)
		{
			dispose();
		}
		if(eR.getSource()==b_enter)
		{
			l_msg2.setText("");
			try
			{
				int i=0;
				while(i<10)
				{
					a[i][0]=a[i][1]=a[i][2]=a[i][3]=a[i][4]=a[i][5]=a[i][6]="";
					i++;					                             
				}
				sqll=sql.connect();
				a1="'"+t_readernum.getText().trim()+"'";
				String temp="select * from readerinfo where readernum ="+a1;
				rs=sqll.executeQuery(temp);
				i=0;			
				if(rs.next())
				{					
					s1=rs.getString(1);
					a2=rs.getString(2);
					s3=rs.getString(3);
					
					String temp1="select * from "+a2;
					rs1=sqll.executeQuery(temp1);
					
					while(rs1.next())
					{
						a[i][0]=rs1.getString(1);a[i][1]=rs1.getString(2);a[i][2]=rs1.getString(3);
						a[i][3]=rs1.getDate(4);a[i][4]=rs1.getString(5);a[i][5]=rs1.getDate(6);
						a[i][6]=rs1.getString(7);
						i++;
					}
					if(i==0)
					{
						l_msg2.setText("��������: "+s3+" ; ���ߺ�: "+s1+" ; �ö��߽��ļ�¼Ϊ��.");
						p_bar.setValue(i);p_bar.setString("��ѯ��0����¼");
					}
					else 
					{
						l_msg2.setText("��������: "+s3+" ; ���ߺ�: "+s1+" ; �����Ĺ�"+i+"��ͼ��.");
						p_bar.setValue(i);p_bar.setString("��ѯ��"+i+"����¼");
					}
				}
				else 
				{
					l_msg2.setText("���ߺŴ���,����������.");
				}
			}
			catch(SQLException exR)
			{
				
			}
		}
	}
}
