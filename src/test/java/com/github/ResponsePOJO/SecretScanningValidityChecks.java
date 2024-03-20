package com.github.ResponsePOJO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SecretScanningValidityChecks {
	@JsonProperty("status") 
    public String getStatus() { 
		 return this.status; } 
    public void setStatus(String status) { 
		 this.status = status; } 
    String status;
}