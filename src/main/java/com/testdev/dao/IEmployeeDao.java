package com.testdev.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.testdev.domain.Employee;

public interface IEmployeeDao {
	@Select("select * from employees")
	public List<Employee> getEmployees();

	@Select("SELECT * FROM employees WHERE employee_id = #{employeeId}")
	public Employee getEmployeeById(Long employeeId);

	@Options(useGeneratedKeys = true, keyProperty = "employeeId")
	@Insert("insert into employees (first_name, last_name, age) values (#{firstName}, #{lastName}, #{age})")
	public void addEmployee(Employee employeeToAdd);

	@Update("update employees set first_name = #{firstName}, last_name = #{lastName}, age = #{age} where employee_id = #{employeeId}")
	public void updateEmployee(Employee employeeToUpdate);

	@Delete("delete from employees where employee_id = #{employeeId}")
	public void deleteEmployee(Employee employeeToDelete);
}
