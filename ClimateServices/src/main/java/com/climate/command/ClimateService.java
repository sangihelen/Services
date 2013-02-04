package com.climate.command;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class ClimateService {
	
	@NotEmpty
	@Size(min = 1, max = 5)
	public String zipcode;

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}
