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
public class Owner {
	
	// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
	// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
	/* ObjectMapper om = new ObjectMapper();
	Root root = om.readValue(myJsonString, Root.class); */

	    @JsonProperty(value="login") 
	   
	    String login;
	    @JsonProperty(value="id") 
	    
	
	    int id;
	    @JsonProperty(value="node_id") 
	    
	    String node_id;
	    @JsonProperty(value="avatar_url") 
	     
	    String avatar_url;
	    @JsonProperty(value="gravatar_id") 
	    
	    String gravatar_id;
	    @JsonProperty(value="url") 
	   
	    String url;
	    @JsonProperty(value="html_url") 
	    
	    String html_url;
	    @JsonProperty(value="followers_url") 
	    
	    String followers_url;
	    @JsonProperty(value="following_url") 
	   
	    String following_url;
	    @JsonProperty(value="gists_url") 
	   
	    String gists_url;
	    @JsonProperty(value="starred_url") 
	    
	    String starred_url;
	    @JsonProperty(value="subscriptions_url") 
	    
	    String subscriptions_url;
	    @JsonProperty(value="organizations_url") 
	    
	    String organizations_url;
	    @JsonProperty(value="repos_url") 
	   
	    String repos_url;
	    @JsonProperty(value="events_url") 
	   
	    String events_url;
	    @JsonProperty(value="received_events_url") 
	    
	    String received_events_url;
	    @JsonProperty(value="type") 
	    
	    String type;
	    @JsonProperty(value="site_admin") 
	    
	    boolean site_admin;
	

	
	   
	


	}
	
	

