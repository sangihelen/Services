package com.climate.command;

public class DisplayLocation {

	/**
	 * This is the instance variable for city.
	 */
	private String city;
	/**
	 * This is the instance variable for state.
	 */
	private String state;
	/**
	 * This is the instance variable for country.
	 */
	private String country;
	/**
	 * This is the instance variable for zipCode.
	 */
	private String zipCode;
	/**
	 * This is the instance variable for temp_f.
	 */
	private String temp_f;
	/**
	 * This is the instance variable for temp_c.
	 */
	private String temp_c;
	
	/**
	 * This is the default Constructor.
	 */
	public DisplayLocation() {
		
	}
	
	/**
	 * Construction with all the parameters.
	 * @param city
	 * @param state
	 * @param country
	 * @param zipCode
	 * @param temp_f
	 * @param temp_c
	 */
	public DisplayLocation(String city, String state, String country, String zipCode, String temp_f,
			String temp_c) {
		
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
		this.temp_f = temp_f;
		this.temp_c = temp_c;
			
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getTemp_f() {
		return temp_f;
	}
	public void setTemp_f(String temp_f) {
		this.temp_f = temp_f;
	}
	public String getTemp_c() {
		return temp_c;
	}
	public void setTemp_c(String temp_c) {
		this.temp_c = temp_c;
	}
	
	
	
}
