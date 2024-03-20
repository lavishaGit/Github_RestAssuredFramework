package com.github.ResponsePOJO;

import java.util.ArrayList;
import java.util.Date;

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
public class ExistingDataResponse {
	 @JsonProperty(value="message") 

	 public String message;
	 @JsonProperty(value="errors") 

ArrayList<ExistigErrorResponse> errors;
	 @JsonProperty(value="documentation_url") 

	    public String documentation_url;

}
