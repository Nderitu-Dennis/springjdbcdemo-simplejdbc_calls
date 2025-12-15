package tech.csm.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Citizen implements Serializable {

	private Integer id;
	
	private String name;
	
	private String email;
	
	
}
