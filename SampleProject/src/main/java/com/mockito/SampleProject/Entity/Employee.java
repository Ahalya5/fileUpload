package com.mockito.SampleProject.Entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(generator = "UUId")
	@GenericGenerator(name = "UUId",strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id")
	private UUID id;
	
	@Column(name ="name")
	private String name;
	
	@Column(name ="phone_no")
	private String phoneNo;
	
	@Column(name ="address")
	private String address;
	
	@Column(name = "salary")
	private double salary;
	
	@Column(name = "location")
	private String location;

	
	

}
