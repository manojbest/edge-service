package com.edge.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Street {
	
	private String summaryline;
	private String street;
	private String dependentlocality;
	private String posttown;
	private String county;
	private String postcode;
	
	@JsonProperty(required = true)
	public String getSummaryline() {
		return summaryline;
	}
	
	public void setSummaryline(String summaryline) {
		this.summaryline = summaryline;
	}
	
	@JsonProperty(required = true)
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	@JsonProperty(required = true)
	public String getDependentlocality() {
		return dependentlocality;
	}
	
	public void setDependentlocality(String dependentlocality) {
		this.dependentlocality = dependentlocality;
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
}
