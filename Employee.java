package com.fis.app.model;

public class Employee implements Comparable<Employee> {
	private String employeeName;
		private int employeeId;
		private int employeeSalary;
		
		
		public Employee() {
			super();
			// TODO Auto-generated constructor stub
		}

		
		public String getEmployeeName() {
			return employeeName;
		}


		public void setEmployeeName(String employeeName) {
			this.employeeName = employeeName;
		}


		public int getEmployeeId() {
			return employeeId;
		}


		public void setEmployeeId(int employeeId) {
			this.employeeId = employeeId;
		}


		public int getEmployeeSalary() {
			return employeeSalary;
		}


		public void setEmployeeSalary(int employeeSalary) {
			this.employeeSalary = employeeSalary;
		}


		public Employee(String employeeName, int employeeId, int employeeSalary) {
			super();
			this.employeeName = employeeName;
			this.employeeId = employeeId;
			this.employeeSalary = employeeSalary;
		}

		

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + employeeId;
			result = prime * result + ((employeeName == null) ? 0 : employeeName.hashCode());
			result = prime * result + employeeSalary;
			return result;
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Employee other = (Employee) obj;
			if (employeeId != other.employeeId)
				return false;
			if (employeeName == null) {
				if (other.employeeName != null)
					return false;
			} else if (!employeeName.equals(other.employeeName))
				return false;
			if (employeeSalary != other.employeeSalary)
				return false;
			return true;
		}


		@Override
		public String toString() {
			return "=> "+employeeId+" - "+employeeName+" - "+employeeSalary+"\n";
		}

		@Override
		public int compareTo(Employee o) {
			
			return this.getEmployeeId() - o.getEmployeeId();
		}
		
		
		
		
		
		
	}//end class













	


