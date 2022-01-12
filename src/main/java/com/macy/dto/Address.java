package com.macy.dto;

import java.io.Serializable;


public class Address implements Serializable{

	private String line1;
	private String line2;
	private String line3;
	private String city;
	private String state;
	private String zipCode;
	private String countryCode;
	private int seperatorAddress0;
	
	public Address() {}
	
	public Address(String line1, String line2, String line3, String city, String state, String zipCode,
			String countryCode, int seperatorAddress0) {
		super();
		this.line1 = line1;
		this.line2 = line2;
		this.line3 = line3;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.countryCode = countryCode;
		this.seperatorAddress0 = seperatorAddress0;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getLine3() {
		return line3;
	}

	public void setLine3(String line3) {
		this.line3 = line3;
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

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public int getSeperatorAddress0() {
		return seperatorAddress0;
	}

	public void setSeperatorAddress0(int seperatorAddress0) {
		this.seperatorAddress0 = seperatorAddress0;
	}

	@Override
	public String toString() {
		return "Address [line1=" + line1 + ", line2=" + line2 + ", line3=" + line3 + ", city=" + city + ", state="
				+ state + ", zipCode=" + zipCode + ", countryCode=" + countryCode + ", seperatorAddress0="
				+ seperatorAddress0 + "]";
	}
	
}

