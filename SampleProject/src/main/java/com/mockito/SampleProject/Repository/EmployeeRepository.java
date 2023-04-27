package com.mockito.SampleProject.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mockito.SampleProject.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, UUID>{

}
