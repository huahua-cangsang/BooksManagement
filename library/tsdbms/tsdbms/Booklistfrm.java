package tsdbms;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
//===========Bug:��Ŀ��ѯ���ȷ������Ҫ�Ƚ�����������һ�²�����ʾ����ѯ������������ӳ١���
class Booklistfrm extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Object a[][]; 
	Object colname[]={"ͼ��������","����","������","����","��������","�۸�","����","��ע","Ŀǰ�ɽ�/(��)"};
	JLabel l_name,l_author,l_company;
	JTextField t_name,t_author,t_company;
	JTable table;
	Container container;
	JButton b_enter,b_back;
	JProgressBar p_bar;
	JPanel pan1;
	String a1,a2,a3;
	
	NetConn sql;
	Statement sqll;
	ResultSet rs;
	
	Booklistfrm()
	{
		super("�鼮�б�");
		l_name=new JLabel("���ƣ�");
		l_author=new JLabel("���ߣ�");
		l_company=new JLabel("�����磺");
		t_name=new JTextField("",10);
		t_author=new JTextField("",10);
		t_company=new JTextField("",10);
		a=new Object[30][9];
		table=new JTable(a,colname);
		setSize(300,300);setVisible(true);
		b_enter=new JButton("ȷ��");
		b_back=new JButton("����");
		b_enter.addActionListener(this);
		b_back.addActionListener(this);
		b_enter.addActionListener(this);
		b_back.addActionListener(this);
		pan1=new JPanel();
		pan1.add(l_name);pan1.add(t_name);pan1.add(l_author);pan1.add(t_author);
		pan1.add(l_company);pan1.add(t_company);pan1.add(b_enter);pan1.add(b_back);
		
		p_bar=new JProgressBar(JProgressBar.VERTICAL,0,50);
		p_bar.setStringPainted(true);
		container=getContentPane();
		container.add(pan1,BorderLayout.SOUTH);
		container.add(new JScrollPane(table),BorderLayout.CENTER);
		container.add(p_bar,BorderLayout.WEST);
		table.isEnabled();
		sql=new NetConn();
		setBounds(150,140,850,400);
	}
	public void  actionPerformed(ActionEvent eb)
	{
		if(eb.getSource()==b_back)
		{
			dispose();
		}
		else if(eb.getSource()==b_enter)
		{
			try
			{
				int i=0;
				sqll=sql.connect();
				//table.removeAll();
				while(i<10)
				{
					a[i][0]=a[i][1]=a[i][2]=a[i][3]=a[i][4]=a[i][5]=a[i][6]=a[i][7]=a[i][8]="";
					i++;					                             
				}
				i=0;
				a1="'"+"%"+t_name.getText().trim()+"%"+"'";
				a2="'"+"%"+t_author.getText().trim()+"%"+"'";
				a3="'"+"%"+t_company.getText().trim()+"%"+"'";
				String temp="select * from books"+" where bookname like "+a1+" and company like "+a3+" and author like "+a2;
				rs=sqll.executeQuery(temp);
				while(rs.next())
				{
					a[i][0]=rs.getString(1);a[i][1]=rs.getString(2);a[i][2]=rs.getString(3);a[i][3]=rs.getString(4);
					a[i][4]=rs.getDate(5);a[i][5]=rs.getString(6);a[i][6]=rs.getString(7);a[i][7]=rs.getString(8);
					a[i][8]=rs.getString(9);
					i++;
					p_bar.setValue(i);p_bar.setString("��ѯ��"+i+"����¼");
				}
			}
			catch(SQLException ed)
			{
				System.out.println("��ʾͼ��ʧ��");
			}
		}
	}
}