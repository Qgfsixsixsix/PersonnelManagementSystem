import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.*;

import javax.swing.*;

public class QueryOneOfEmployeesInformation extends JFrame{
	
	String SelectQueryFieldStr = "员工号";
	
	JTextField JT1;
	
	Vector personVector;
	Vector titleVector;
	
	JTable personJTabel;
	
	private static DbProcess dbProcess;
	
	public QueryOneOfEmployeesInformation() {
		
		dbProcess = new DbProcess();
		
		JPanel queryoneofemployeesinformation = new JPanel();
		/*
		 * It isn't set Leyout to null of creating table title;
	   	 * queryoneofemployeesinformation.setLayout(null);
		 */
		JTabbedPane jtp = new JTabbedPane();
		jtp.add(queryoneofemployeesinformation);
		jtp .setTitleAt(0,"    个体员工信息    ");
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
		
		queryoneofemployeesinformation.add(personJScrollPane);
		
		JLabel JL1 = new JLabel("选择查询字段");
		JLabel JL2 = new JLabel("=");
		 
		JT1 = new JTextField(10);
		
		JButton JB1 = new JButton("查询");
		JButton JB2 = new JButton("返回");
		
		JComboBox<String> jCBSelectQueryField = new JComboBox<>();
		jCBSelectQueryField.addItem("员工号");
		jCBSelectQueryField.addItem("姓名");
		jCBSelectQueryField.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent event) {
				// TODO Auto-generated method stub
				switch(event.getStateChange()) {
				case ItemEvent.SELECTED:
					SelectQueryFieldStr = (String) event.getItem();
					break;
				case ItemEvent.DESELECTED:
					break;
				}
			}
		});
		
		queryoneofemployeesinformation.add(JL1);
		queryoneofemployeesinformation.add(jCBSelectQueryField);
		queryoneofemployeesinformation.add(JL2);
		queryoneofemployeesinformation.add(JT1);
		queryoneofemployeesinformation.add(JB1);
		queryoneofemployeesinformation.add(JB2);
		
		
		
		//JB1 ActionListener 
		JB1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JT1.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "输入不能为空", "错误", JOptionPane.ERROR_MESSAGE);
				}
				queryProcess(JT1.getText().trim());
			}
		});
		
		//JB2 ActionListener
		JB2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QueryOneOfEmployeesInformation.this.dispose();
				new Menu();
			}
		});
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1275,975);
		this.setLocation(0,0);
		this.setVisible(true);
		this.setTitle("人事管理系统");
		this.setResizable(false);
	}
	public void queryProcess(String sQueryField){
		try{
			String sql = "select person.Id,person.Password,person.Authority,"
					+ "person.Name,person.Sex,person.Birthday,department.Name,"
					+ "job.Description,edu_level.Description,person.Spcialty,person.Address,"
					+ "person.Tel,person.Email,person.State,person.Remark "
					+ "from person,department,job,edu_level where department.Id=person.Department "
					+ "and person.Job=job.Code and person.EduLevel = edu_level.Code and ";
			String queryFieldStr = jCBSelectQueryFieldTransfer(SelectQueryFieldStr);
			sql = sql + queryFieldStr;
			sql = sql + "=";
			sql = sql+ "'" + sQueryField + "'";
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
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
		}
	}
	public String jCBSelectQueryFieldTransfer(String input){
		String outputStr = "";
		if (input.equals("员工号")){
			outputStr = "person.Id";
		}
		else if(input.equals("姓名")){
			outputStr = "person.Name";
		}
		return outputStr;
	}
}

