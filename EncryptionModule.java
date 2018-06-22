import javax.swing.*;

import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.*;
import java.util.Random;

public class EncryptionModule extends JFrame{
	
	JTextField jTextField;
	
	private static DbProcess dbProcess;
	
	String SelectQueryFieldStr = "员工号";
	
	public EncryptionModule() {
		 
		dbProcess = new DbProcess();	
		//JPanel
		JPanel jPanel = new JPanel();
	    jPanel.setLayout(null);
	    
	    //JTabbedPane 
		JTabbedPane jtp = new JTabbedPane();
		jtp.add(jPanel);
		jtp.setTitleAt(0, "    加密模块");
		this.setContentPane(jtp);
	    
	    JLabel JL1 = new JLabel("选择删除字段");
	    JLabel JL2 = new JLabel("=");
	    JLabel JL3 =new JLabel("注意：删除内容涉及到员工全部信息，请慎重考虑!");
	    
	    JButton JB1 = new JButton("删除");
	    JButton JB2 = new JButton("返回");
	    JButton JB3 = new JButton("查看剩余员工全部信息");
	   
	    JL3.setForeground(Color.RED);
	    
	    jTextField = new JTextField(10);
	    
	    JComboBox<String> jComboBox = new JComboBox<>();
	    jComboBox.addItem("员工号");
	    jComboBox.addItem("姓名");
	    jComboBox.addItemListener(new ItemListener() {
			
			public void itemStateChanged(ItemEvent event) {
				
				switch(event.getStateChange()) {
				case ItemEvent.SELECTED:
					SelectQueryFieldStr = (String) event.getItem();
					break;
				case ItemEvent.DESELECTED:
					break;
				}
			}
		});
		
	    jPanel.add(JL1);
	    jPanel.add(JL2);
	    jPanel.add(JL3);
	    jPanel.add(JB1);
	    jPanel.add(JB2);
	    jPanel.add(JB3);
	    jPanel.add(jComboBox);
	    jPanel.add(jTextField);
	    
	    JL3.setBounds(50,30,300,40);
	    JL1.setBounds(50,70,100,40);
	    jComboBox.setBounds(140,80,70,20);
	    JL2.setBounds(220,80,20,20);
	    jTextField.setBounds(240,80,130,20);
	    JB1.setBounds(50,120,60,20);
	    JB2.setBounds(130,120,60,20);
	    JB3.setBounds(210,120,200,20);
	    
	    //delete ActionListener
	    JB1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		deleteCurrentRecordProcess(jTextField.getText().trim());
	    		jTextField.setText("");
	    	}
	    });
	    
	    //return ActionListener
	    JB2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		EncryptionModule.this.dispose();
	    		new Menu();
	    	}
	    });
	    
	    //Check all the information of the remaining employees ActionListener
	    JB3.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		EncryptionModule.this.dispose();
	    		new CheckAllInformationOfRemainEmployees();
	    	}
	    });
		
     	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(500,300);
	    this.setLocation(400,350);
	    this.setVisible(true);
	    this.setTitle("人事管理系统");
	    this.setResizable(false);
    }
	public void deleteCurrentRecordProcess(String deleteProcess) {
		String sql = "delete from person where ";
		String deleteFieldStr = deleteTransfer(SelectQueryFieldStr);
		sql = sql + deleteFieldStr;
		sql = sql + "= '";
		sql = sql + deleteProcess + "';";
		try {
			if(dbProcess.executeUpdate(sql) < 1) {
				JOptionPane.showMessageDialog(null,"数据操作错误" ,"错误" ,JOptionPane.ERROR_MESSAGE );
			}
			else 
				deleteprocess(jTextField.getText().trim());
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "数据操作错误", "错误",JOptionPane.ERROR_MESSAGE );
		}
	}
	public String deleteTransfer(String input) {
		String outputStr = "";
		if(input.equals("员工号")) {
			outputStr = "Id";
		}
		else if(input.equals("姓名")) {
			outputStr = "Name";
		}
		return outputStr;
	}
	public void deleteprocess(String r){
		String st = r;
		String string = String.valueOf(new Random().nextInt(100000));
		String sql = "insert into record values('";
		sql = sql + string + "','";
		sql = sql + st + "','辞退','delete');";
		try{
			if(dbProcess.executeUpdate(sql) < 1){
				JOptionPane.showMessageDialog(null,"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
		}
	}
}
