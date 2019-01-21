package jdbcsample1;
import java.sql.*;

public class jdbcsample1 {
	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/Employee";
		String user = "test";
		String pass = "test123";
		String Query = "select * from personal_info -- where id = 100";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, pass);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(Query);
		
		while (rs.next()) {
			String name = rs.getString("name");
			String desig = rs.getString("Designation");
			String dept = rs.getString("Department");
			System.out.println(name);
			System.out.println(desig);
			System.out.println(dept);
		}
		st.close();
		con.close();
	}

}
