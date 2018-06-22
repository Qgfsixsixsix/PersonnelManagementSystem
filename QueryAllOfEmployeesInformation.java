import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.*;

import java.awt.*;

public class QueryAllOfEmployeesInformation extends JFrame {
	
	private static DbProcess dbProcess;
	
	Vector personVector;
	Vector titleVector;
	
	JTable personJTabel;
	
	public QueryAllOfEmployeesInformation(){
		
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
		JButton JB2 = new JButton("退出系统");
		
		queryallofemployeesinformation.add(JB1);
		queryallofemployeesinformation.add(JB2);
		
		//JB1 ActionListener 
		JB1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QueryAllOfEmployeesInformation.this.dispose();
				new Menu();
			}
		});
		
		//JB2 ActionListener
		JB2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
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
			String sql = "select person.Id,person.Password,person.Authority,"
					+ "person.Name,person.Sex,person.Birthday,department.Name,"
					+ "job.Description,edu_level.Description,person.Spcialty,person.Address,"
					+ "person.Tel,person.Email,person.State,person.Remark "
					+ "from person,department,job,edu_level where department.Id=person.Department "
					+ "and person.Job=job.Code and person.EduLevel = edu_level.Code;";
			dbProcess.connect();
			ResultSet rs = dbProcess.executeQuery(sql);
			
			personVector.clear();

			while(rs.next()){

				Vector v = new Vector();
				v.add(rs.getString("person.Id"));
				v.add(rs.getString("person.Password"));
				v.add(rs.getString("person.Authority"));
				v.add(rs.getString("person.Name"));
				v.add(rs.getString("person.Sex"));
				v.add(rs.getString("person.Birthday"));
				v.add(rs.getString("department.Name"));
				v.add(rs.getString("job.Description"));
				v.add(rs.getString("edu_level.Description"));
				v.add(rs.getString("person.Spcialty"));
				v.add(rs.getString("person.Address"));
				v.add(rs.getString("person.Tel"));
				v.add(rs.getString("person.Email"));
				v.add(rs.getString("person.State"));
				v.add(rs.getString("person.Remark"));
				personVector.add(v);
			}
			personJTabel.updateUI();
			
			dbProcess.disconnect();
		}catch(SQLException sqle){
			JOptionPane.showMessageDialog(null,"数据操作失误","错误",JOptionPane.ERROR_MESSAGE);
		}

	}
	
	
}
