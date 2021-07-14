package com.fis.app.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.fis.app.exce.EmployeeNotFoundException;
import com.fis.app.model.Employee;


public class EmployeeDAOImpl implements IEmployeeDAO {

Connection con = null;

	String insertEmployeeQuery = "insert into fis.ElectronivDevice values(?,?,?)";
	String selectAllEmployees = "select * from fis.ElectronicDev";
	String selectEmployeeBasedOnID = "select * from fisapp.employee where EmployeeId = ?";

	@Override
	public boolean addEmployee(Employee e) throws Exception {

		con = DatabaseUtil.getConnection();
		boolean isInserted = false;
		if (con != null) {

			// Step1 : extract employee details from e object
			int id = e.getEmployeeId();
			String name = e.getEmployeeName();
			int salary = e.getEmployeeSalary();

			// Step 2 :- write the code to create complete insert Query with data
			PreparedStatement ps = con.prepareStatement(insertEmployeeQuery);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, salary);

			// Step 3 : execute Query
			int i = ps.executeUpdate(); // only works with insert , update & delete

			if (i > 0)
				isInserted = true;

		}

		return isInserted;
	}

	@Override
	public List<Employee> getAllEmployees() throws Exception {

		con = DatabaseUtil.getConnection();
		List<Employee> employeesList = new ArrayList<>();
		if (con != null) {

			PreparedStatement ps = con.prepareStatement(selectAllEmployees);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Employee temp = new Employee(); // default emp,

				temp.setEmployeeId(rs.getInt(1));
				temp.setEmployeeName(rs.getString("EmployeeName"));
				temp.setEmployeeSalary(rs.getInt("EmployeeSalary"));

				employeesList.add(temp);
			}

		}
		return employeesList;
	}

	@Override
	public Employee getEmployeeBasedOnID(int id) throws Exception {

		con = DatabaseUtil.getConnection();
		Employee e = null;
		if (con != null) {

			PreparedStatement ps = con.prepareStatement(selectEmployeeBasedOnID);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			boolean isFound = false;
			while (rs.next()) {
				isFound = true;
				Employee temp = new Employee(); // default emp,

				temp.setEmployeeId(rs.getInt(1));
				temp.setEmployeeName(rs.getString("EmployeeName"));
				temp.setEmployeeSalary(rs.getInt("EmployeeSalary"));

				e = temp;
			}

			if (!isFound)
				throw new EmployeeNotFoundException(id);

		}
		return e;
	}

	@Override
	public boolean deleteEmployee(int id) throws SQLException, EmployeeNotFoundException {

		// TODO Auto-generated method stub
		return false;
	}

}

