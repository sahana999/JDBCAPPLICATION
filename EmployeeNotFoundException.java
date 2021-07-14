package com.fis.app.exce;

public class EmployeeNotFoundException  extends Exception{
	
private int id;
		
		public EmployeeNotFoundException(int id)
		{
			this.id = id;
		}
		
		public String toString()
		{
			return "Invalid Employee ID "+id;
		}

	}


