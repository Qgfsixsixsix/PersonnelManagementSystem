import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbProcess {
	Connection connection = null;
	ResultSet rs = null;
	
	String userMySql = "root";
	String passwordMySql = "";
	String urlMySql = "jdbc:mysql://localhost:3306/personnelmanagementsystem?user="
					+ userMySql + "&password=" + passwordMySql + "&useUnicode=true&characterEncoding=gbk" ;
	public DbProcess(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(java.lang.ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public void connect(){
		try{
			connection = DriverManager.getConnection(urlMySql);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void disconnect(){
		try{
			if(connection != null){
				connection.close();
				connection = null;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public ResultSet executeQuery(String sql){
		try{
			PreparedStatement pstm = connection.prepareStatement(sql);
			rs = pstm.executeQuery();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return rs;
	}
	public  int executeUpdate(String sql){
		int count = 0;
		connect();
		try{
			Statement stmt = connection.createStatement();
			count = stmt.executeUpdate(sql);
		}catch(SQLException e){
			System.err.println(e.getMessage());
		}
		disconnect();
		return count;
	}
}
