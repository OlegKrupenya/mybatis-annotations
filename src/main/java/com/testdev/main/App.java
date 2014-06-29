package com.testdev.main;

import java.io.InputStream;

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
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IEmployeeDao dao = session.getMapper(IEmployeeDao.class);
            Employee employee = dao.getEmployeeById(1L);
            System.out.println(employee.getEmployeeId());
        } finally {
            session.close();
        }
    }
}
