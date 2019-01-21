package jdbcDAOExample1;
import java.sql.*;

import java.sql.DriverManager;


class Employee
{
	int id;
	String name;
}

class EmployeeDAO
{
	
	public Employee getEmployee(int id)
	{
		try
		{
			Employee e = new Employee();
			e.id = id;
			String query = "select name from personal_info where id = "+id;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee","test","test123");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			e.name = rs.getString(1);
			st.close();
			conn.close();
			return e;
		}
		catch (Exception ex)
		{
			System.out.println(ex);
//			return null;
		}
		return null;
	}
}

public class JDBCDAOEX1 {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		EmployeeDAO dao = new EmployeeDAO();
		Employee e = dao.getEmployee(100);
		System.out.println(e.name);

	}

}