import java.awt.event.*;

import javax.swing.*;

import java.awt.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Random;
import java.util.Vector;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.ResultSetMetaData;

public class ModificationOfEmployeesInformation extends JFrame{
	
	JTextArea Employees;
	JTextField passWord;
	JTextField authority;
	JTextField name;
	JTextArea sex;
	JTextField birthday;
	JTextArea subordinateDepartment;
	JTextArea job;
	JTextArea educationalLevel;
	JTextField personnelSkills;
	JTextField postalAddress;
	JTextField contactNumber;
	JTextField email;
	JTextField currentState;
	JTextField remarks;
	
	//modify JTextField
	JTextField modify;
	JLabel jl;
	
	String SelectQueryFieldSex = "男";
	String SelectQueryFieldDepartment = null;
	String SelectQueryFieldJob = null;
	String SelectQueryFieldEducation = null;
	String SelectQueryFieldEmployee = "员工";
	
	private static DbProcess dbProcess;
	
	public ModificationOfEmployeesInformation() {
		
		dbProcess = new DbProcess();
	    //JPanel
		final JPanel jPanel = new JPanel();
	    jPanel.setLayout(null);
		
	    //JTabbedPane 
		JTabbedPane jtp = new JTabbedPane();
		jtp.add(jPanel);
		jtp.setTitleAt(0, "    员工信息修改");
		this.setContentPane(jtp);
		
		JLabel label = new JLabel("修改员工各类信息：(*不能为空)");
		JLabel label1 = new JLabel("员工号");
		JLabel label2 = new JLabel("密码");
		JLabel label3 = new JLabel("权限");
		JLabel label4 = new JLabel("姓名");
		JLabel label5 = new JLabel("性别");
		JLabel label6 = new JLabel("生日");
		JLabel label7 = new JLabel("所在部门");
		JLabel label8 = new JLabel("职务");
		JLabel label9 = new JLabel("受教育程度");
		JLabel label10 = new JLabel("专业技能");
		JLabel label11 = new JLabel("家庭地址");
		JLabel label12 = new JLabel("联系电话");
		JLabel label13 = new JLabel("电子邮箱");
		JLabel label14 = new JLabel("当前状态");
		JLabel label15 = new JLabel("备注");
		//JLabel label16 = new JLabel("*");
		JLabel label17 = new JLabel("*");
		//JLabel label18 = new JLabel("*");
		JLabel label19 = new JLabel("*");
		JLabel label20 = new JLabel("*");
		JLabel label21 = new JLabel("*");
		JLabel label22 = new JLabel("*");
		JLabel label23 = new JLabel("*");
		JLabel label24 = new JLabel("*");
		JLabel label25 = new JLabel("*");
		JLabel label26 = new JLabel("*");
		JLabel label27 = new JLabel("*");
		JLabel label28 = new JLabel("*");
		JLabel label29 = new JLabel("*");
		//JLabel label30 = new JLabel("*");
		
		
		jPanel.add(label);
		jPanel.add(label1);
		jPanel.add(label2);
		jPanel.add(label3);
		jPanel.add(label4);
		jPanel.add(label5);
		jPanel.add(label6);
		jPanel.add(label7);
		jPanel.add(label8);
		jPanel.add(label9);
		jPanel.add(label10);
		jPanel.add(label11);
		jPanel.add(label12);
		jPanel.add(label13);
		jPanel.add(label14);
		jPanel.add(label15);
		//jPanel.add(label16);
		jPanel.add(label17);
		//jPanel.add(label18);
		jPanel.add(label19);
		jPanel.add(label20);
		jPanel.add(label21);
		jPanel.add(label22);
		jPanel.add(label23);
		jPanel.add(label24);
		jPanel.add(label25);
		jPanel.add(label26);
		jPanel.add(label27);
		jPanel.add(label28);
		jPanel.add(label29);
		//jPanel.add(label30);
		
		//set labels location in  JPanel;
		label.setBounds(20,20,200,20);
		label1.setBounds(20,70,50,20);
		label2.setBounds(20,120,50,20);
		label3.setBounds(20,170,50,20);
		label4.setBounds(20,220,50,20);
		label5.setBounds(20,270,50,20);
		label6.setBounds(20,320,50,20);
		label7.setBounds(20,370,70,20);
		label8.setBounds(425,20,70,20);
		label9.setBounds(425,70,70,20);
		label10.setBounds(425,120,70,20);
		label11.setBounds(425,170,70,20);
		label12.setBounds(425,220,70,20);
		label13.setBounds(425,270,70,20);
		label14.setBounds(425,320,70,20);
		label15.setBounds(425,370,70,20);
				
		//set * is red;
		label17.setForeground(Color.RED);
		//label18.setForeground(Color.RED);
		label19.setForeground(Color.RED);
		label20.setForeground(Color.RED);
		label21.setForeground(Color.RED);
		label22.setForeground(Color.RED);
		label23.setForeground(Color.RED);
		label24.setForeground(Color.RED);
		label25.setForeground(Color.RED);
		label26.setForeground(Color.RED);
		label27.setForeground(Color.RED);
		label28.setForeground(Color.RED);
		label29.setForeground(Color.RED);
		//label30.setForeground(Color.RED);
				
		Employees = new JTextArea();
		passWord = new JTextField();
		authority = new JTextField();
		name = new JTextField();
		sex = new JTextArea();
		sex.setEditable(false);
		birthday = new JTextField();
		subordinateDepartment = new JTextArea();
		subordinateDepartment.setEditable(false);
		job = new JTextArea();
		job.setEditable(false);
		educationalLevel = new JTextArea();
		educationalLevel.setEditable(false);
		personnelSkills = new JTextField();
		postalAddress = new JTextField();
		contactNumber = new JTextField();
		email = new JTextField();
		currentState = new JTextField();
		remarks = new JTextField();
				
		jPanel.add(Employees);
		jPanel.add(passWord);
		jPanel.add(authority);
		jPanel.add(name);
		jPanel.add(sex);
		jPanel.add(birthday);
		jPanel.add(subordinateDepartment);
		jPanel.add(job);
		jPanel.add(educationalLevel);
		jPanel.add(personnelSkills);
		jPanel.add(postalAddress);
		jPanel.add(contactNumber);
		jPanel.add(email);
		jPanel.add(currentState);
		jPanel.add(remarks);
		
		JComboBox<String> jComboBoxsex = new JComboBox<>();
		jComboBoxsex.addItem("男");
		jComboBoxsex.addItem("女");
		sex.setText(SelectQueryFieldSex);
		jComboBoxsex.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				// TODO Auto-generated method stub
				switch(event.getStateChange()) {
					case ItemEvent.SELECTED:
						SelectQueryFieldSex = (String) event.getItem();
						sex.setText(SelectQueryFieldSex);
						break;
					case ItemEvent.DESELECTED:
						break;
				}
			}
		});
		jPanel.add(jComboBoxsex);
		
		JComboBox<String> jComboBoxdepartment = new JComboBox<>();
		jComboBoxdepartment.addItem("政府部门");
		jComboBoxdepartment.addItem("公司部门");
		jComboBoxdepartment.addItem("城市部门");
		jComboBoxdepartment.addItem("乡村部门");
		jComboBoxdepartment.addItem("外企部门");
		subordinateDepartment.setText("001");
		jComboBoxdepartment.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				// TODO Auto-generated method stub
				switch(event.getStateChange()) {
					case ItemEvent.SELECTED:
						SelectQueryFieldDepartment = (String) event.getItem();
						if(SelectQueryFieldDepartment.equals("政府公司"))
							subordinateDepartment.setText("001");
						else if(SelectQueryFieldDepartment.equals("公司部门"))
							subordinateDepartment.setText("002");
						else if(SelectQueryFieldDepartment.equals("城市部门"))
							subordinateDepartment.setText("003");
						else if(SelectQueryFieldDepartment.equals("乡村部门"))
							subordinateDepartment.setText("004");
						else if(SelectQueryFieldDepartment.equals("外企部门"))
							subordinateDepartment.setText("005");
						break;
					case ItemEvent.DESELECTED:
						break;
				}
			}
		});
		jPanel.add(jComboBoxdepartment);
		
		JComboBox<String> jComboBoxjob = new JComboBox<>();
		jComboBoxjob.addItem("员工");
		jComboBoxjob.addItem("经理");
		jComboBoxjob.addItem("老板");
		jComboBoxjob.addItem("董事长");
		job.setText("0");
		jComboBoxjob.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				// TODO Auto-generated method stub
				switch(event.getStateChange()) {
					case ItemEvent.SELECTED:
						SelectQueryFieldJob = (String) event.getItem();
						if(SelectQueryFieldJob.equals("员工"))
							job.setText("0");
						else if(SelectQueryFieldJob.equals("经理"))
							job.setText("1");
						else if(SelectQueryFieldJob.equals("老板"))
							job.setText("2");
						else if(SelectQueryFieldJob.equals("董事长"))
							job.setText("3");
						break;
					case ItemEvent.DESELECTED:
						break;
				}
			}
		});
		jPanel.add(jComboBoxjob);
		
		JComboBox<String> jComboBoxeducation = new JComboBox<>();
		jComboBoxeducation.addItem("小学");
		jComboBoxeducation.addItem("初中");
		jComboBoxeducation.addItem("高中");
		jComboBoxeducation.addItem("职高");
		jComboBoxeducation.addItem("大本");
		jComboBoxeducation.addItem("大专");
		jComboBoxeducation.addItem("硕士");
		jComboBoxeducation.addItem("博士");
		jComboBoxeducation.addItem("博士后");
		educationalLevel.setText("0");
		jComboBoxeducation.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				// TODO Auto-generated method stub
				switch(event.getStateChange()) {
					case ItemEvent.SELECTED:
						SelectQueryFieldEducation = (String) event.getItem();
						if(SelectQueryFieldEducation.equals("小学"))
							educationalLevel.setText("0");
						else if(SelectQueryFieldEducation.equals("初中"))
							educationalLevel.setText("1");
						else if(SelectQueryFieldEducation.equals("高中"))
							educationalLevel.setText("2");
						else if(SelectQueryFieldEducation.equals("职高"))
							educationalLevel.setText("3");
						else if(SelectQueryFieldEducation.equals("大本"))
							educationalLevel.setText("4");
						else if(SelectQueryFieldEducation.equals("大专"))
							educationalLevel.setText("5");
						else if(SelectQueryFieldEducation.equals("硕士"))
							educationalLevel.setText("6");
						else if(SelectQueryFieldEducation.equals("博士"))
							educationalLevel.setText("7");
						else if(SelectQueryFieldEducation.equals("博士后"))
							educationalLevel.setText("8");
						break;
					case ItemEvent.DESELECTED:
						break;
				}
			}
		});
		jPanel.add(jComboBoxeducation);
		
		JComboBox<String> jComboBoxEmployees = new JComboBox<>();
		jComboBoxEmployees.addItem("员工");
		jComboBoxEmployees.addItem("非员工");
		currentState.setText(SelectQueryFieldEmployee);
		jComboBoxEmployees.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				// TODO Auto-generated method stub
				switch(event.getStateChange()) {
					case ItemEvent.SELECTED:
						SelectQueryFieldEmployee = (String) event.getItem();
						currentState.setText(SelectQueryFieldEmployee);
						break;
					case ItemEvent.DESELECTED:
						break;
				}
			}
		});
		jPanel.add(jComboBoxEmployees);

		Employees.setBounds(100,70,200,20);		
		//label16.setBounds(310,75,10,10);
		passWord.setBounds(100,120,200,20);
		label17.setBounds(310,125,10,10);
		authority.setBounds(100,170,200,20);
		//label18.setBounds(310,175,10,10);
		name.setBounds(100,220,200,20);
		label19.setBounds(310,225,10,10);
		sex.setBounds(100,270,150,20);
		jComboBoxsex.setBounds(250,270,60,20);
		label20.setBounds(310,275,10,10);
		birthday.setBounds(100,320,200,20);
		label21.setBounds(310,325,10,10);
		subordinateDepartment.setBounds(100,370,100,20);
		jComboBoxdepartment.setBounds(200,370,100,20);
		label22.setBounds(310,375,10,10);
		job.setBounds(525,20,100,20);
		jComboBoxjob.setBounds(625,20,100,20);
		label23.setBounds(735,25,10,10);
		educationalLevel.setBounds(525,70,100,20);
		jComboBoxeducation.setBounds(625,70,100,20);
		label24.setBounds(735,75,10,10);
		personnelSkills.setBounds(525,120,200,20);
		label25.setBounds(735,125,10,10);
		postalAddress.setBounds(525,170,200,20);
		label26.setBounds(735,175,10,10);
		contactNumber.setBounds(525,220,200,20);
		label27.setBounds(735,225,10,10);
		email.setBounds(525,270,200,20);
		label28.setBounds(735,275,10,10);
		currentState.setBounds(525,320,110,20);
		jComboBoxEmployees.setBounds(635,320,90,20);
		label29.setBounds(735,325,10,10);
		remarks.setBounds(525,370,200,20);
		//label30.setBounds(735,375,10,10);
		
		JLabel JL = new JLabel("选择修改字段");
		JComboBox<String> jComboBox = new JComboBox<>();
		jComboBox.addItem("员工号");
		 
		JLabel JL1 = new JLabel("=");
		modify = new JTextField();
		JButton JB = new JButton("选择");
		JButton JB1 = new JButton("修改");
		JButton JB2 = new JButton("返回");
		
		//add module of up to jPanel
		jPanel.add(JL);
		jPanel.add(jComboBox);
		jPanel.add(JL1);
		jPanel.add(modify);
		jPanel.add(JB);
		jPanel.add(JB1);
		jPanel.add(JB2);
		
		//set location for these module
		JL.setBounds(70,430,100,20);
		jComboBox.setBounds(160,430,80,20);
		JL1.setBounds(250,430,30,20);
		modify.setBounds(270,430,100,20);
		JB.setBounds(380,430,70,20);
		JB1.setBounds(460, 430, 70, 20);
		JB2.setBounds(540,430 ,70 ,20 );
	
		//select ActionListener
		JB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if(modify.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null,"员工号不能为空","错误",JOptionPane.ERROR_MESSAGE);
				}
				else{
//					String string = modify.getText().trim();
//					JLabel employeeNumber = new JLabel(string);
//					jPanel.add(employeeNumber);
//					employeeNumber.setBounds(100,70,200,20);
					String string = modify.getText().trim();
					Employees.setText(string);

					String str_sql="SELECT * FROM PERSON WHERE ID = '";
					str_sql = str_sql + string + "';";
					String[][] table_content=getTableContent(str_sql, 1, "PERSON");		
				    passWord.setText(table_content[0][1]);
					authority.setText(table_content[0][2]);
					name.setText(table_content[0][3]);
					sex.setText(table_content[0][4]);
					birthday.setText(table_content[0][5]);
					subordinateDepartment.setText(table_content[0][6]);
					job.setText(table_content[0][7]);
					educationalLevel.setText(table_content[0][8]);
					personnelSkills.setText(table_content[0][9]);
					postalAddress.setText(table_content[0][10]);
					contactNumber.setText(table_content[0][11]);
					email.setText(table_content[0][12]);
					currentState.setText(table_content[0][13]);
					remarks.setText(table_content[0][14]);
					jl = new JLabel(job.getText());
				
				}
			}
		});
		//modify ActionListener
		JB1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!passWord.getText().trim().equals("") 
					&& !name.getText().trim().equals("") 
					&& !sex.getText().trim().equals("")
					&& !birthday.getText().trim().equals("") 
					&& !subordinateDepartment.getText().trim().equals("")
					&& !job.getText().trim().equals("") 
					&& !educationalLevel.getText().trim().equals("")
					&& !personnelSkills.getText().trim().equals("") 
					&& !postalAddress.getText().trim().equals("")
					&& !contactNumber.getText().equals("") 
					&& !email.getText().equals("")
					&& !currentState.getText().trim().equals("")){
					
					if(!jl.getText().equals(job.getText())){
						modificationchange();
					}
					modification();
						
					modify.setText("");
					passWord.setText("");
					authority.setText("");
					name.setText("");
					sex.setText("");
					birthday.setText("");
					subordinateDepartment.setText("");
					job.setText("");
					educationalLevel.setText("");
					personnelSkills.setText("");
					postalAddress.setText("");
					contactNumber.setText("");
					email.setText("");
					currentState.setText("");
					remarks.setText("");
					JOptionPane.showMessageDialog(null,"修改成功","成功",JOptionPane.PLAIN_MESSAGE);
				}
				else{
						JOptionPane.showMessageDialog(null,"必填不能为空","错误",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		//return ActionListener
		JB2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ModificationOfEmployeesInformation.this.dispose();
				new Menu();
			}
		});
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,550);
		this.setLocation(250,200);
		this.setVisible(true);
		this.setTitle("人事管理系统");
		this.setResizable(false);
	}
	public void modification(){
		
		String Id = modify.getText().trim();
		String Password = passWord.getText().trim();
		String Authority = authority.getText().trim();
		String Name = name.getText().trim();
		String Sex = sex.getText().trim();
		String Birthday = birthday.getText().trim();
		String Department = subordinateDepartment.getText().trim();
		String Job = job.getText().trim();
		String EduLevel = educationalLevel.getText().trim();
		String Spcialty = personnelSkills.getText().trim();
		String Address = postalAddress.getText().trim();
		String Tel = contactNumber.getText().trim();
		String Email = email.getText().trim();
		String State = currentState.getText().trim();
		String Remark = remarks.getText().trim();
	
		String sql = "update person set Password = '";
		sql = sql + Password + "',Authority = '";
		sql = sql + Authority + "',Name = '";
		sql = sql + Name + "',Sex = '";
		sql = sql + Sex + "',Birthday = '";
		sql = sql + Birthday + "',Department = '";
		sql = sql + Department + "',Job = '";
		sql = sql + Job + "',EduLevel = '";
		sql = sql + EduLevel + "',Spcialty = '";
		sql = sql + Spcialty + "',Address = '";
		sql = sql + Address + "',Tel = '";
		sql = sql + Tel + "',Email = '";
		sql = sql + Email + "',State = '";
		sql = sql + State + "',Remark = '";
		sql = sql + Remark + "'";
		sql = sql + "where Id = '" + Id + "';";
		try{
			if(dbProcess.executeUpdate(sql) < 1){
				JOptionPane.showMessageDialog(null, "数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
		}
	}
	public void modificationchange(){
		String Id = modify.getText().trim();
		String str = String.valueOf(new Random().nextInt(100000));
		String sql = "insert into record values('";
		sql = sql + str + "','";
		sql = sql + Id + "','职务变动','change');"; 
		try{
			if(dbProcess.executeUpdate(sql) < 1){
				JOptionPane.showMessageDialog(null,"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	// 数据库访问函数
	private static String[][] getTableContent(String select_sql,int instruction_code,String table_name){
		// Connect to MySQL
				try {
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("mysql driver loaded!");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("mysql driver loaded failed!");
				}
				  
				String userMySql="root";
				String passwordMySql="";
				String urlMySql="jdbc:mysql://localhost:3306/personnelmanagementsystem?user="+userMySql+"&password="+passwordMySql+"&useUnicode=true&characterEncoding=utf8";

				try{
					Connection conn = (Connection) DriverManager.getConnection(urlMySql);
					/*
					 * 要执行SQL语句，必须获得java.sql.Statement实例，Statement实例分为以下3种类型：   
					 * 1）执行静态SQL语句。通常通过Statement实例实现。   
					 * 2）执行动态SQL语句。通常通过PreparedStatement实例实现。   
					 * 3）执行数据库存储过程。通常通过CallableStatement实例实现   
					 */
					Statement stmt=(Statement) conn.createStatement();
					System.out.println("Connect to MySQL success !!");
					/*
					 *  Statement接口提供了三种执行SQL语句的方法：executeQuery 、executeUpdate  和execute  。
					 *  1）ResultSet executeQuery(String sqlString)：执行查询数据库的SQL语句   ，返回一个结果集（ResultSet）对象。   
					 *  2）int executeUpdate(String sqlString)：用于执行INSERT、UPDATE或  DELETE语句以及SQL DDL语句，如：CREATE TABLE和DROP TABLE等   
					 *  3）execute(sqlString):用于执行返回多个结果集、多个更新计数或二者组合的语句。
					 *
					 * 1）执行更新返回的是本次操作影响到的记录数。   
					 * 2）执行查询返回的结果是一个ResultSet对象。   
					 * ResultSet包含符合SQL语句中条件的所有行，并且它通过一套get方法提供了对这些行中数据的访问。
					 */
					// 创建数据对象
					// 1-SELECT 2-INSERT|DELETE
					ResultSet rs;
					switch(instruction_code)
					{
					// 执行 select 操作
					case 1:
						rs=stmt.executeQuery(select_sql);
						
						// 将取得的数据保存到 table_content[][]
						// 统计取得的数据条数和列数
						int rows_count=0;
						ResultSetMetaData rsma=(ResultSetMetaData) rs.getMetaData();
						int lines_count=rsma.getColumnCount();
						while(rs.next()){
							//统计数据总行数
							rows_count++;
						}
						rs.first();

						// 根据不同的表 table_name 进行不同的取数据操作
						// 数组 用以保存表中的数据
						String[][] table_content=new String[rows_count][lines_count];
						switch(table_name)
						{
						
						case "PERSON":
							System.out.println("从 PERSON 表中取数据");
							int i=0;
							if(rows_count>0)
							{
								// 不知为何在下面while中读不到第一行数据，只能在开头先访问
								table_content[i][0]=String.valueOf(rs.getInt(1));
								table_content[i][1]=String.valueOf(rs.getString(2));
								table_content[i][2]=String.valueOf(rs.getString(3));
								table_content[i][3]=String.valueOf(rs.getString(4));
								table_content[i][4]=String.valueOf(rs.getString(5));
								table_content[i][5]=String.valueOf(rs.getString(6));
								table_content[i][6]=String.valueOf(rs.getString(7));
								table_content[i][7]=String.valueOf(rs.getString(8));
								table_content[i][8]=String.valueOf(rs.getString(9));
								table_content[i][9]=String.valueOf(rs.getString(10));
								table_content[i][10]=String.valueOf(rs.getString(11));
								table_content[i][11]=String.valueOf(rs.getString(12));
								table_content[i][12]=String.valueOf(rs.getString(13));
								table_content[i][13]=String.valueOf(rs.getString(14));
								table_content[i][14]=String.valueOf(rs.getString(15));
								i++;
							}
							while(rs.next()){
								table_content[i][0]=String.valueOf(rs.getInt(1));
								table_content[i][1]=String.valueOf(rs.getString(2));
								table_content[i][2]=String.valueOf(rs.getString(3));
								table_content[i][3]=String.valueOf(rs.getString(4));
								table_content[i][4]=String.valueOf(rs.getString(5));
								table_content[i][5]=String.valueOf(rs.getString(6));
								table_content[i][6]=String.valueOf(rs.getString(7));
								table_content[i][7]=String.valueOf(rs.getString(8));
								table_content[i][8]=String.valueOf(rs.getString(9));
								table_content[i][9]=String.valueOf(rs.getString(10));
								table_content[i][10]=String.valueOf(rs.getString(11));
								table_content[i][11]=String.valueOf(rs.getString(12));
								table_content[i][12]=String.valueOf(rs.getString(13));
								table_content[i][13]=String.valueOf(rs.getString(14));
								table_content[i][14]=String.valueOf(rs.getString(15));
								i++;
							}
							break;
							
						default:
							System.out.println("从 【未知】 表中取数据!");
						}
						// 关闭数据库连接
						rs.close();
						stmt.close();
						conn.close();
						// 返回数据
						return table_content;

					// 执行 insert
					// 返回的数组中 table_content2[0][0]="1" 的话代表成功 否则失败
					case 2:
						stmt.executeUpdate(select_sql);
						stmt.close();
						conn.close();
						String[][] table_content2={{"1"}};
						return table_content2;
					// 执行 delete 操作
					case 3:
						int effected_rows=stmt.executeUpdate(select_sql);
						System.out.println("Delete 改变的行数为："+effected_rows);
						String[][] table_content3={{String.valueOf(effected_rows)}};
						stmt.close();
						conn.close();
						return table_content3;

					default:
						break;
					}

				}catch (Exception e){
					System.out.println("Connect to MySQL failed !!");
					e.printStackTrace();
				}
		
				// 如果数据库取数据时发生错误或者执行的是 insert 或 delete 而不是 select，返回空数组
				String[][] empty_String={};
		return empty_String;
	}
}
