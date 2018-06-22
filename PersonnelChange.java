import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class PersonnelChange extends JFrame {
	
	private static DbProcess dbProcess;
	
	Vector personVector;
	Vector titleVector;
	
	JTable personJTabel;
	
	public PersonnelChange() {
		
		dbProcess = new DbProcess();
		
		//JPanel
		JPanel jPanel = new JPanel();
		
		//JTabbbedPane
		JTabbedPane pane = new JTabbedPane();
		pane.add(jPanel);
		pane.setTitleAt(0, "    人事变动");
		
		this.setContentPane(pane);
		personVector = new Vector();
		titleVector = new Vector();
		
		//define table title
		titleVector.add("记录编号");
		titleVector.add("员工号");
	   //titleVector.add("姓名");
		titleVector.add("说明");
		titleVector.add("详细记录");
		
		personJTabel = new JTable(personVector,titleVector);
		personJTabel.setPreferredScrollableViewportSize(new Dimension(1250,850));
		
		JScrollPane personJScrollPane = new JScrollPane(personJTabel);
		personJScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		personJScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		jPanel.add(personJScrollPane);
		
		JButton JB1 = new JButton("确定");
		jPanel.add(JB1);
		
		//jPanel ActionListener
		JB1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				PersonnelChange.this.dispose();
				new Menu();	
			}
		});
		
		//windows
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1275,975);
		this.setLocation(0,0);
		this.setVisible(true);
		this.setTitle("人事管理系统");
		this.setResizable(false);
		
		personnelchange();
	}
	public void personnelchange() {
		try {
			String sql = "select * from record;";
			dbProcess.connect();
			ResultSet rs = dbProcess.executeQuery(sql);
			personVector.clear();
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("record"));
				v.add(rs.getString("id"));
				v.add(rs.getString("description"));
				v.add(rs.getString("detial"));
				personVector.add(v);
			}
			personJTabel.updateUI();
			dbProcess.disconnect();
		}catch(SQLException sqle) {
			JOptionPane.showMessageDialog(null, "数据操作错误", "错误", JOptionPane.ERROR_MESSAGE);
		}
	}
}
