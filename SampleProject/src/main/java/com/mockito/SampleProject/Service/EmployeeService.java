package com.mockito.SampleProject.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mockito.SampleProject.Dto.EmployeeDTO;
import com.mockito.SampleProject.Dto.FileUploadResponse;
import com.mockito.SampleProject.Entity.Employee;

import com.mockito.SampleProject.Repository.EmployeeRepository;


import springfox.documentation.spring.web.json.Json;

@Service
public class EmployeeService {

//	private final Path dirLocation;
	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee saveOrUpdate(EmployeeDTO employeeDTO) {
		Employee employee =null;
		if(employeeDTO.getId()!=null) {
			Optional<Employee> op=employeeRepository.findById(employeeDTO.getId());
			if(op.isPresent()) {
				employee=op.get();
			}else {
				employee=new Employee();
			}
			}else {
			employee=new Employee();
		}
		employee.setName(employeeDTO.getName());
		employee.setLocation(employeeDTO.getLocation());
		employee.setPhoneNo(employeeDTO.getPhoneNo());
		employee.setSalary(employeeDTO.getSalary());
		employee.setAddress(employeeDTO.getAddress());
		return employeeRepository.saveAndFlush(employee);
	}

}
