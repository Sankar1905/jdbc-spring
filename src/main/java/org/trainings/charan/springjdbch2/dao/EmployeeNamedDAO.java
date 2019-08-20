package org.trainings.charan.springjdbch2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import org.springframework.stereotype.Repository;
import org.trainings.charan.springjdbch2.constants.EmployeeConstants;
import org.trainings.charan.springjdbch2.model.Employee;

@Repository
public class EmployeeNamedDAO {
	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	public Employee getEmployeeByNameAndEmail(String name,String email) {
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("NAME", name);
	paramMap.addValue("EMAIL", email);
	return namedJdbcTemplate.queryForObject(EmployeeConstants.GET_EMPLOYEE_BY_NAME_AND_EMAIL, paramMap,new BeanPropertyRowMapper<>(Employee.class));
		
	}
	/*private RowMapper<Employee> prepareRowMapper(){
		return new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Employee employee = new Employee();
				employee.setId(rs.getInt("ID"));
				employee.setName(rs.getString("NAME"));
				employee.setEmail(rs.getString("EMAIL"));
				employee.setDob(rs.getDate("DOB"));
				return employee;
			}
		};
	}*/
}
