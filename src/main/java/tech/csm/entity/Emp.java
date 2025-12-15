package tech.csm.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter @ToString
public class Emp implements Serializable {

	private Integer employeeId;
	
	private String lastName;
	
	private Double salary;
	
	
	private Integer departmentId;
	
}
