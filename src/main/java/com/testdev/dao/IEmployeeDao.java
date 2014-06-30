package com.testdev.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.testdev.domain.Employee;


public interface IEmployeeDao {
	@Select("select * from employees")
	public List<Employee> getEmployees();
	
	@Select("SELECT * FROM employees WHERE employee_id = #{employeeId}")
	public Employee getEmployeeById(Long employeeId);
	
	@Options(useGeneratedKeys = true, keyProperty="employeeId")
	@Insert("insert into employees (first_name, last_name, age) values (#{firstName}, #{lastName}, #{age})")
	public void addEmployee(Employee employeeToAdd);
	
	
	public void updateEmployee(Employee employeeToUpdate);
	public void deleteEmployee(Employee employeeToDelete);
}
