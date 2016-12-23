package com.edge.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
	
	private String status;
	private String message;
	private String rootCause;
	private Object stackTrace;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getRootCause() {
		return rootCause;
	}
	public void setRootCause(String rootCause) {
		this.rootCause = rootCause;
	}
	public Object getStackTrace() {
		return stackTrace;
	}
	public void setStackTrace(Object stackTrace) {
		this.stackTrace = stackTrace;
	}

}
