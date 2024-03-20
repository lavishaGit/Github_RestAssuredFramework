package com.github.ResponsePOJO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SecretScanningPushProtection {
	 @JsonProperty("status") 
	    public String getStatus() { 
			 return this.status; } 
	    public void setStatus(String status) { 
			 this.status = status; } 
	    String status;
}
