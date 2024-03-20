package com.github.ResponsePOJO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SecurityAndAnalysis {

	 @JsonProperty("secret_scanning") 
	    public SecretScanning getSecret_scanning() { 
			 return this.secret_scanning; } 
	    public void setSecret_scanning(SecretScanning secret_scanning) { 
			 this.secret_scanning = secret_scanning; } 
	    SecretScanning secret_scanning;
	    @JsonProperty("secret_scanning_push_protection") 
	    public SecretScanningPushProtection getSecret_scanning_push_protection() { 
			 return this.secret_scanning_push_protection; } 
	    public void setSecret_scanning_push_protection(SecretScanningPushProtection secret_scanning_push_protection) { 
			 this.secret_scanning_push_protection = secret_scanning_push_protection; } 
	    SecretScanningPushProtection secret_scanning_push_protection;
	    @JsonProperty("dependabot_security_updates") 
	    public DependabotSecurityUpdates getDependabot_security_updates() { 
			 return this.dependabot_security_updates; } 
	    public void setDependabot_security_updates(DependabotSecurityUpdates dependabot_security_updates) { 
			 this.dependabot_security_updates = dependabot_security_updates; } 
	    DependabotSecurityUpdates dependabot_security_updates;
	    @JsonProperty("secret_scanning_validity_checks") 
	    public SecretScanningValidityChecks getSecret_scanning_validity_checks() { 
			 return this.secret_scanning_validity_checks; } 
	    public void setSecret_scanning_validity_checks(SecretScanningValidityChecks secret_scanning_validity_checks) { 
			 this.secret_scanning_validity_checks = secret_scanning_validity_checks; } 
	    SecretScanningValidityChecks secret_scanning_validity_checks;
}
	    
