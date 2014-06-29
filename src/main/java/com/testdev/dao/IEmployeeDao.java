package com.testdev.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.testdev.domain.Employee;


public interface IEmployeeDao {
	public List<Employee> getEmployees();
	@Select("SELECT * FROM employees WHERE employee_id = #{employeeId}")
	public Employee getEmployeeById(Long employeeId);
	public Employee addEmployee(Employee employeeToAdd);
	public boolean updateEmployee(Employee employeeToUpdate);
	public boolean deleteEmployee(Employee employeeToDelete);
}
