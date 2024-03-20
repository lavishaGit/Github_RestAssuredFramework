package com.github.ResponsePOJO;

import com.fasterxml.jackson.annotation.JsonProperty;

import groovy.transform.builder.Builder;
@Builder
public class Permission {
	@JsonProperty("admin") 
    public boolean getAdmin() { 
		 return this.admin; } 
    public void setAdmin(boolean admin) { 
		 this.admin = admin; } 
    boolean admin;
    @JsonProperty("maintain") 
    public boolean getMaintain() { 
		 return this.maintain; } 
    public void setMaintain(boolean maintain) { 
		 this.maintain = maintain; } 
    boolean maintain;
    @JsonProperty("push") 
    public boolean getPush() { 
		 return this.push; } 
    public void setPush(boolean push) { 
		 this.push = push; } 
    boolean push;
    @JsonProperty("triage") 
    public boolean getTriage() { 
		 return this.triage; } 
    public void setTriage(boolean triage) { 
		 this.triage = triage; } 
    boolean triage;
    @JsonProperty("pull") 
    public boolean getPull() { 
		 return this.pull; } 
    public void setPull(boolean pull) { 
		 this.pull = pull; } 
    boolean pull;

}
