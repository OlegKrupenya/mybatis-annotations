package com.testdev.main;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.testdev.dao.IEmployeeDao;
import com.testdev.domain.Employee;

public class App {
    public static void main(String[] args) throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(inputStream);
        sqlSessionFactory.getConfiguration().addMapper(IEmployeeDao.class);
        sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
        
        try (SqlSession session = sqlSessionFactory.openSession();) {
            IEmployeeDao dao = session.getMapper(IEmployeeDao.class);
            Employee employee = dao.getEmployeeById(1L);
            System.out.println(employee.getEmployeeId());
            
            Employee employeeToDelete = dao.getEmployeeById(5L);
            dao.deleteEmployee(employeeToDelete);
            session.commit();
            
            List<Employee> employees = dao.getEmployees();
            for (Employee emp : employees) {
				System.out.println(emp.getFirstName() + " " + emp.getLastName());
			}
        }
    }
}
