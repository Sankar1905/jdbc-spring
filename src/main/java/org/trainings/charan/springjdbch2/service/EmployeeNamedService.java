package org.trainings.charan.springjdbch2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.trainings.charan.springjdbch2.dao.EmployeeNamedDAO;
import org.trainings.charan.springjdbch2.dao.EmployeeVODAO;
import org.trainings.charan.springjdbch2.entiy.EmployeeEntity;
import org.trainings.charan.springjdbch2.model.Employee;
import org.trainings.charan.springjdbch2.model.EmployeeVO;
import org.trainings.charan.springjdbch2.repository.EmployeeRepository;

import com.google.common.base.Optional;

@Service
public class EmployeeNamedService {
	@Autowired
	private EmployeeNamedDAO employeeNamedDAO;
	@Autowired
	private EmployeeVODAO employeeVODAO;
	@Autowired
	private EmployeeRepository employeeRepository;
	public Employee getEmployeeByNameAndEmail(String name,String email) {
		return employeeNamedDAO.getEmployeeByNameAndEmail(name, email);
		
	}
	public EmployeeVO getEmployeeWithAddressById(Integer id) {
		return employeeVODAO.getEmployeeVOById(id);
	}
	public void addEmployeeAddressWithId(EmployeeVO employeeVO) {
		employeeVODAO.addEmployeeVO(employeeVO);
	}
	public List<EmployeeEntity> getAllEmployeesWithJPA(){
		return employeeRepository.findAll();
		
	}
	public void addEmployeeWithJPA(EmployeeEntity employeeVO) {
		employeeRepository.save(employeeVO);
	}
	public void findEmployeeById(Integer id) {
		java.util.Optional<EmployeeEntity>employeeEntity=employeeRepository.findById(id);
		if(employeeEntity.isPresent()) {
			employeeEntity.get();
		}
	}
}
