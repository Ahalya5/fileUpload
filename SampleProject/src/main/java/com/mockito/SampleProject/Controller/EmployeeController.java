package com.mockito.SampleProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mockito.SampleProject.Dto.EmployeeDTO;
import com.mockito.SampleProject.Dto.FileUploadResponse;
import com.mockito.SampleProject.Entity.Employee;
import com.mockito.SampleProject.Service.EmployeeService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Response;
import lombok.AllArgsConstructor;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@AllArgsConstructor(onConstructor_ = { @Autowired })
@Api(value = "employee Rest API", produces = "application/json", consumes = "application/json")
@RequestMapping("/api/employee")

public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

//	@ApiOperation(value = "Allows to create employee Details.", response = Response.class)
	@PostMapping(value = "/createEmployee", produces = "application/json")
	public Employee saveOrUpdate(@RequestBody EmployeeDTO request) { 
		return employeeService.saveOrUpdate(request);
	}
	
	

}
