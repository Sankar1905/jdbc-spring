package org.trainings.charan.springjdbch2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.trainings.charan.springjdbch2.entiy.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer > {
	public void findByNameAndEmail(String name,String email);
	public List<EmployeeEntity> findTopByNameAndEmail(String name,String email);
}
