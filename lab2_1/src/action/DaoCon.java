package action;

import java.sql.Connection;
import java.sql.DriverManager;
public class DaoCon{
	public static void main(String[] args){
		DaoCon dd = new DaoCon();
	}
	public Connection getCon() throws Exception{
		Connection con = null;
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "945400&&&");
		return con;
	}
}
