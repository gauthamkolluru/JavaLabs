package jdbcsample3;
import java.sql.*;

public class jdbcsample3 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String jdbc_driver = "com.mysql.cj.jdbc.Driver";
		String db_url = "jdbc:mysql://localhost:3306/Employee";
		String db_user = "test";
		String db_pass = "test123";
		int id = 700;
		String name = "Gopi";
		int desig = 3;
		int dept = 3;
		String db_query = "insert into personal_info values (?,?,?,?)";
		
		Class.forName(jdbc_driver);
		Connection conn = DriverManager.getConnection(db_url, db_user, db_pass);
		PreparedStatement pst = conn.prepareStatement(db_query);
		pst.setInt(1, id);
		pst.setString(2, name);
		pst.setInt(3, dept);
		pst.setInt(4, desig);

		int count = pst.executeUpdate();
		id += 1;
		
		pst.close();
		conn.close();
		System.out.println(count);

	}

}
