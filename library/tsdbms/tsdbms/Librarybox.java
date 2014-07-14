package tsdbms;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Librarybox extends JFrame implements ActionListener
{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//JLabel mlabel;
	JMenuBar mainmenu;
	JPanel contentPane;
    BorderLayout borderLayout1 = new BorderLayout();
    JDesktopPane desktop = new javax.swing.JDesktopPane();
	
	static JMenu system,bookse,bookth,bookfo,bookfi,booksex,mi_system_manger;
	JMenuItem mi_system_login,mifi_system_adduser,mifi_system_moduser,mifi_system_deluser,mi_system_exit;
	JMenuItem se_book_addbook,se_book_modifybook,se_book_delbook;
	JMenuItem th_book_borrowmsg,th_book_borrowmsgmodif;
	JMenuItem fo_book_returnmsg,fo_book_returnmsgmodif;
	JMenuItem fi_msglabel_book,fi_msglabel_borrow,fi_msglabel_user,fi_msglabel_reader;
	JMenuItem sex_edition;
	
	Loginfrm frml=new Loginfrm(this,"��¼����");
	Adduser frma=new Adduser(this,"����û�");
	Mdiuser frmm=new Mdiuser(this,"�޸��û�");
	Deluser frmd=new Deluser(this,"ɾ���û�");
	
	Addbookfrm frmab;Mdibookfrm frmmb;Delbookfrm frmdb;Borbookfrm frmbb;BorMsgbookfrm frmbmb;
	Booklistfrm  frmbl;Borlistbookfrm frmblb;Userlistfrm frmul;ReturnMsgbookfrm frmrmb;Returnbookfrm frmrb;
	Readme frmread;ReaderInfoList frmreaderinfo;
	
	Librarybox()
	{
		super("ͼ�����ϵͳ");
		//Font myFont=new Font("����_GB2312",Font.BOLD,60);
		//mlabel=new JLabel("    ϣ��ͼ�����ϵͳ");
		//mlabel.setFont(myFont);
		//add(mlabel);
		
		contentPane = (JPanel) getContentPane();
        contentPane.setLayout(borderLayout1);
        contentPane.add(desktop, java.awt.BorderLayout.CENTER);
        
		mainmenu=new JMenuBar();
		system=new JMenu("ϵͳ����");
		mi_system_login=new JMenuItem("�û���¼");
		mi_system_manger=new JMenu("�û�����");
		mifi_system_adduser=new JMenuItem("����û�");
		mifi_system_moduser=new JMenuItem("�޸��û�");
		mifi_system_deluser=new JMenuItem("ɾ���û�");
		mi_system_manger.add(mifi_system_adduser);
		mi_system_manger.add(mifi_system_moduser);
		mi_system_manger.add(mifi_system_deluser);
		mi_system_exit=new JMenuItem("�˳�");
		mi_system_login.addActionListener(this);
		mi_system_exit.addActionListener(this);
		mifi_system_adduser.addActionListener(this);
		mifi_system_moduser.addActionListener(this);
		mifi_system_deluser.addActionListener(this);
		system.add(mi_system_login);
		system.add(mi_system_manger);
		system.addSeparator();
		system.add(mi_system_exit);
		mainmenu.add(system);
		
		
		bookse=new JMenu("�鼮����" );
		se_book_addbook=new JMenuItem("����鼮");
		se_book_modifybook=new JMenuItem("�޸��鼮");
		se_book_delbook=new JMenuItem("ɾ���鼮");
		se_book_addbook.addActionListener(this);
		se_book_modifybook.addActionListener(this);
		se_book_delbook.addActionListener(this);
		bookse.add(se_book_addbook);
		bookse.add(se_book_modifybook);
		bookse.add(se_book_delbook);
		mainmenu.add(bookse);
		
		
		bookth=new JMenu("���Ĺ���" );
		th_book_borrowmsg=new JMenuItem("����ͼ��");
		th_book_borrowmsgmodif=new JMenuItem("����ͼ��");
		th_book_borrowmsg.addActionListener(this);
		th_book_borrowmsgmodif.addActionListener(this);
		bookth.add(th_book_borrowmsg);
		bookth.addSeparator();
		bookth.add(th_book_borrowmsgmodif);
		mainmenu.add(bookth);
		
		
		bookfo=new JMenu("�������");
		fo_book_returnmsg=new JMenuItem("��ǰ����");
		fo_book_returnmsgmodif=new JMenuItem("�������ɽ����");
		fo_book_returnmsg.addActionListener(this);
		fo_book_returnmsgmodif.addActionListener(this);
		bookfo.add(fo_book_returnmsg);
		bookfo.addSeparator();
		bookfo.add(fo_book_returnmsgmodif);
		mainmenu.add(bookfo);
		
		
		bookfi=new JMenu("��Ϣ��ѯ");
		fi_msglabel_book=new JMenuItem("ͼ���б�");
		fi_msglabel_borrow=new JMenuItem("��������б�");
		fi_msglabel_user=new JMenuItem("�û��б�");
		fi_msglabel_reader=new JMenuItem("������Ϣ��ѯ");
		fi_msglabel_book.addActionListener(this);
		fi_msglabel_borrow.addActionListener(this);
		fi_msglabel_user.addActionListener(this);
		fi_msglabel_reader.addActionListener(this);
		bookfi.add(fi_msglabel_book);
		bookfi.add(fi_msglabel_borrow);
		bookfi.add(fi_msglabel_user);
		bookfi.addSeparator();
		bookfi.add(fi_msglabel_reader);
		mainmenu.add(bookfi);
		
		
		booksex=new JMenu("����");
		sex_edition=new JMenuItem("��ʹ�ð�����");
		sex_edition.addActionListener(this);
		booksex.add(sex_edition);
		mainmenu.add(booksex);
		
		
		
		this.setJMenuBar(mainmenu);
		
		setBounds(200,90,800,600);
		this.setVisible(true);
		this.setResizable(false);
        loadBackgroundImage();
		
	}
	protected void loadBackgroundImage(){
        ImageIcon icon = new ImageIcon("desktop.jpg");
        //ImageIcon icon = new ImageIcon(JF_main.class.getResource("main_bg.jpg"));
        JLabel jl = new JLabel(icon);
        jl.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
       desktop.add(jl,new Integer(Integer.MIN_VALUE));
    //  desktop.add(jl,BorderLayout.CENTER);
     
      
}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand()=="�˳�")
		{
			dispose();
			System.exit(0);
		}
		else if(e.getActionCommand()=="����û�")
		{
			frma.setVisible(true);
			frma.setResizable(false);
		}
		else if(e.getActionCommand()=="�û���¼")
		{
			this.setVisible(false);
			this.dispose();
			frml.setVisible(true);
			frml.setResizable(false);
			
		}
		else if(e.getActionCommand()=="�޸��û�")
		{
			frmm.setVisible(true);
			frmm.setResizable(false);
		}
		else if(e.getActionCommand()=="ɾ���û�")
		{
			frmd.setVisible(true);
			frmd.setResizable(false);
		}
		else if(e.getActionCommand()=="����鼮")
		{
		    frmab=new Addbookfrm();
		    frmab.setVisible(true);
		    frmab.setResizable(false);
		}
		else if(e.getActionCommand()=="�޸��鼮")
		{
			frmmb=new Mdibookfrm();
			frmmb.setVisible(true);
			frmmb.setResizable(false);
		}
		else if(e.getActionCommand()=="ɾ���鼮")
		{
			frmdb=new Delbookfrm();
			frmdb.setVisible(true);
			frmdb.setResizable(false);
		}
		else if(e.getActionCommand()=="����ͼ��")
		{
			frmbb=new Borbookfrm();
			frmbb.setVisible(true);
			frmbb.setResizable(false);
		}
		else if(e.getActionCommand()=="����ͼ��")
		{
			frmbmb=new BorMsgbookfrm();
			frmbmb.setVisible(true);
			frmbmb.setResizable(false);
		}
		else if(e.getActionCommand()=="��ǰ����")
		{
			frmrb=new Returnbookfrm();
			frmrb.setVisible(true);
			frmrb.setResizable(false);
		}
		else if(e.getActionCommand()=="�������ɽ����")
		{
			frmrmb=new ReturnMsgbookfrm();
			frmrmb.setVisible(true);
			frmrmb.setResizable(false);
		}
		else if(e.getActionCommand()=="ͼ���б�")
		{
			frmbl=new Booklistfrm();
			frmbl.setVisible(true);
		}
		else if(e.getActionCommand()=="��������б�")
		{
			frmblb=new Borlistbookfrm();
			frmblb.setVisible(true);
		}
		else if(e.getActionCommand()=="�û��б�")
		{
			frmul=new Userlistfrm();
			frmul.setVisible(true);
		}
		else if(e.getActionCommand()=="������Ϣ��ѯ")
		{
			frmreaderinfo=new ReaderInfoList();
			frmreaderinfo.setVisible(true);
			frmreaderinfo.setResizable(false);
		}
		else if(e.getActionCommand()=="��ʹ�ð�����")
		{
			frmread=new Readme();
			frmread.setVisible(true);
			frmread.setResizable(false);
		}
	}
}
 


