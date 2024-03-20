package com.github.RequestPOJO;

import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ResponsePOJO.Owner;
import com.github.ResponsePOJO.Permission;
import com.github.ResponsePOJO.Root;
import com.github.ResponsePOJO.SecurityAndAnalysis;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateRepoRequest {
    @JsonProperty(value="name") 

	public String name;
    @JsonProperty(value="description") 

    public String description;
    @JsonProperty(value="homepage") 

    public String homepage;
    @JsonProperty(value="private") 
    public boolean myprivate;

}
