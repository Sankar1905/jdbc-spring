package org.trainings.charan.springjdbch2.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.trainings.charan.springjdbch2.model.Employee;
import org.trainings.charan.springjdbch2.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@GetMapping("/all")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	@GetMapping("/id/{id}")
	public Employee getEmployeeById(@PathVariable("id") Integer id) {
		return employeeService.getEmployeeById(id);
		
	}
	@PostMapping("/add")
		public ResponseEntity<Boolean> addEmployee(Employee employee)
		{
			boolean result = employeeService.insertEmployee(employee);
			return new ResponseEntity<Boolean>(result,HttpStatus.OK);
		}
	@PostMapping("/update/{id}")
	public ResponseEntity<Boolean> updateEmployee(Employee employee) {
		boolean result = employeeService.updateEmployee(employee);
		return new ResponseEntity<Boolean>(result,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteEmployee(Integer id) {
		boolean result = employeeService.deleteEmployee(id);
		return new ResponseEntity<Boolean>(result,HttpStatus.OK);
	}
}
