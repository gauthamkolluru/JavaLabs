// Inserting Values to Database

package jdbcsample2;
import java.sql.*;

public class jdbcsample2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String jdbc_driver = "com.mysql.cj.jdbc.Driver";
		String db_url = "jdbc:mysql://localhost:3306/Employee";
		String db_user = "test";
		String db_pass = "test123";
		int id = 200;
		String name = "Indira";
		int desig = 2;
		int dept = 2;
		String db_query = "insert into personal_info values ("+id+","+"'"+name+"'"+","+desig+","+dept+")";
		Class.forName(jdbc_driver);
		Connection con = DriverManager.getConnection(db_url,db_user,db_pass);
		Statement st = con.createStatement();
		int count = st.executeUpdate(db_query);
		
		st.close();
		con.close();
		
		System.out.println(count);

	}

}
