package com.github.ResponsePOJO;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Status {
	 @JsonProperty(value="message") 
	  
	    String message;
	    @JsonProperty(value="documentation_url") 
	    
	   String documentation_url;

}
