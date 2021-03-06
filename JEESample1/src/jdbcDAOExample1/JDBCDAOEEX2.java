package jdbcDAOExample1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

class Employee1
{
	int id = 1001, dept = 10, desig = 10;
	String name = "Martin Luther King";
}

class EmployeeDAO1
{
	
	public int addEmployee(Employee1 e)
	{
		try
		{
//			Employee1 e1 = new Employee1();
			int id = e.id;
			int dept = e.dept;
			int desig = e.desig;
			String query = "insert into personal_info values (?,?,?,?)";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee","test","test123");
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setInt(1, e.id);
			pst.setString(2, e.name);
			pst.setInt(3, e.dept);
			pst.setInt(4, e.desig);
			int rows_inserted = pst.executeUpdate();
			pst.close();
			conn.close();
			return rows_inserted;
		}
		catch (Exception ex)
		{
			System.out.println(ex);
//			return null;
		}
		return 0;
	}
}

public class JDBCDAOEEX2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeDAO1 dao = new EmployeeDAO1();
		Employee1 e = new Employee1();
		int count = dao.addEmployee(e); 
		System.out.println(count);

	}

}
