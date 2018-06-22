import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.*;

import java.awt.*;

public class CheckAllInformationOfRemainEmployees extends JFrame {
	
	private static DbProcess dbProcess;
	
	Vector personVector;
	Vector titleVector;
	
	JTable personJTabel;
	
	public  CheckAllInformationOfRemainEmployees() {
		
		dbProcess = new DbProcess();
		
		JPanel queryallofemployeesinformation = new JPanel();
		/*
		 * It isn't set Leyout to null of creating table title;
		 */
		//queryallofemployeesinformation.setLayout(null);
		
		JTabbedPane jtp = new JTabbedPane();
		jtp.add(queryallofemployeesinformation);
		jtp .setTitleAt(0,"    全体员工信息    ");
		this.setContentPane(jtp);
		
		personVector = new Vector();
		titleVector = new Vector();
		
		//define table title
		titleVector.add("员工号");
		titleVector.add("密码");
		titleVector.add("用户权限");
		titleVector.add("姓名");
		titleVector.add("性别");
		titleVector.add("生日");
		titleVector.add("所在部门");
		titleVector.add("职务");
		titleVector.add("教育程度");
		titleVector.add("专业技能");
		titleVector.add("家庭住址");
		titleVector.add("联系电话");
		titleVector.add("电子邮箱");
		titleVector.add("当前状态");
		titleVector.add("备注");
		
		personJTabel = new JTable(personVector,titleVector);
		personJTabel.setPreferredScrollableViewportSize(new Dimension(1250,850));
		
		JScrollPane personJScrollPane = new JScrollPane(personJTabel);
		personJScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		personJScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		queryallofemployeesinformation.add(personJScrollPane);
		queryAllProcess();
		
		JButton JB1 = new JButton("确定");
		
		queryallofemployeesinformation.add(JB1);

		//JB1 ActionListener 
		JB1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckAllInformationOfRemainEmployees.this.dispose();
				new EncryptionModule();
			}
		});
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1275,975);
		this.setLocation(0,0);
		this.setVisible(true);
		this.setTitle("人事管理系统");
		this.setResizable(false);
	}
	public void queryAllProcess(){
		try{
			String sql = "select * from person;";
			dbProcess.connect();
			ResultSet rs = dbProcess.executeQuery(sql);
			
			personVector.clear();
			while(rs.next()){
				Vector v = new Vector();
				v.add(rs.getString("Id"));
				v.add(rs.getString("Password"));
				v.add(rs.getString("Authority"));
				v.add(rs.getString("Name"));
				v.add(rs.getString("Sex"));
				v.add(rs.getString("Birthday"));
				v.add(rs.getString("Department"));
				v.add(rs.getString("Job"));
				v.add(rs.getString("EduLevel"));
				v.add(rs.getString("Spcialty"));
				v.add(rs.getString("Address"));
				v.add(rs.getString("Tel"));
				v.add(rs.getString("Email"));
				v.add(rs.getString("State"));
				v.add(rs.getString("Remark"));
				personVector.add(v);
			}
			personJTabel.updateUI();
			
			dbProcess.disconnect();
		}catch(SQLException sqle){
			JOptionPane.showMessageDialog(null,"数据操作失误","错误",JOptionPane.ERROR_MESSAGE);
		}
	}
	
}

