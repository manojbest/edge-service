package com.edge.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address {
	
	private String addressline1;
	private String addressline2;
	private String summaryline;
	private String organisation;
	private String street;
	private String posttown;
	private String county;
	private String postcode;
	private String number;
	private String premise;
	private String buildingname;
	private String buildinggroupname;
	
	@JsonProperty(required = true)
	public String getAddressline1() {
		return addressline1;
	}
	
	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}
	
	@JsonProperty(required = true)
	public String getAddressline2() {
		return addressline2;
	}
	
	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}
	
	@JsonProperty(required = true)
	public String getSummaryline() {
		return summaryline;
	}
	
	public void setSummaryline(String summaryline) {
		this.summaryline = summaryline;
	}
	
	@JsonProperty(required = true)
	public String getOrganisation() {
		return organisation;
	}
	
	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}
	
	@JsonProperty(required = true)
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	@JsonProperty(required = true)
	public String getPosttown() {
		return posttown;
	}
	
	public void setPosttown(String posttown) {
		this.posttown = posttown;
	}
	
	@JsonProperty(required = true)
	public String getCounty() {
		return county;
	}
	
	public void setCounty(String county) {
		this.county = county;
	}
	
	@JsonProperty(required = true)
	public String getPostcode() {
		return postcode;
	}
	
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	@JsonProperty(required = false)
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@JsonProperty(required = false)
	public String getPremise() {
		return premise;
	}

	public void setPremise(String premise) {
		this.premise = premise;
	}

	@JsonProperty(required = false)
	public String getBuildingname() {
		return buildingname;
	}

	public void setBuildingname(String buildingname) {
		this.buildingname = buildingname;
	}

	@JsonProperty(required = false)
	public String getBuildinggroupname() {
		return buildinggroupname;
	}

	public void setBuildinggroupname(String buildinggroupname) {
		this.buildinggroupname = buildinggroupname;
	}
	
}
