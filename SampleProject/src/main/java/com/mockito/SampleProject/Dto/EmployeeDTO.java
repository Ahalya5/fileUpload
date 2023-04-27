package com.mockito.SampleProject.Dto;

import java.util.UUID;



import lombok.Data;

@Data
public class EmployeeDTO {

	private UUID id;

	private String name;

	private String phoneNo;

	private String address;

	private double salary;

	private String location;

}
