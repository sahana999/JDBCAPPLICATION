package com.fis.app.dao;
import java.sql.SQLException;
import java.util.List;

import com.fis.app.exce.EmployeeNotFoundException;
import com.fis.app.model.Employee;


public interface IEmployeeDAO {
	
		
		public boolean addEmployee(Employee e)throws Exception;
		public List<Employee>  getAllEmployees()throws Exception;
		public Employee getEmployeeBasedOnID(int id)throws Exception,SQLException,EmployeeNotFoundException;
		public boolean deleteEmployee(int id)throws SQLException,EmployeeNotFoundException;
	}


	
	

