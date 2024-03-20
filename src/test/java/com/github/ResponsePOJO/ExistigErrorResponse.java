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
public class ExistigErrorResponse {
	 @JsonProperty(value="resource") 

 String resource;
	 @JsonProperty(value="code") 

	   String code;
	 @JsonProperty(value="field") 

String field;
	 @JsonProperty(value="message") 

String message;

}
