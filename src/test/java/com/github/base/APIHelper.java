package com.github.base;



import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.RequestPOJO.CreateRepoRequest;
import com.github.RequestPOJO.UpdateRepoRequest;
import com.github.utils.EnvironmentDetails;

import java.util.HashMap;
import java.util.List;


public class APIHelper {
    RequestSpecification reqSpec;
   // String token = "";
    protected Logger apiHelperLog = LoggerFactory.getLogger(APIHelper.class);


    public APIHelper() {
        RestAssured.baseURI = EnvironmentDetails.getProperty("baseURL");
     reqSpec = RestAssured.given();
       
    }

  /*  public Response login(String username, String password) {
        LoginRequest loginRequest = LoginRequest.builder().username(username).password(password).build(); // payload 
     
        reqSpec.headers(getHeaders(true));
        Response response = null;
        try {
            reqSpec.body(loginRequest); //Serializing  object into a JSON format that can be transmitted over the network. 
             response = reqSpec.post("/login");
            if (response.getStatusCode() == HttpStatus.SC_CREATED) {
                List<LoginResponse> loginResponse = response.getBody().as(new TypeRef<List<LoginResponse>>() {
                });
                this.token = loginResponse.get(0).getToken();
                System.out.println("token====="+token);
            }
        } catch (Exception e) {
            Assert.fail("Login functionality is failing due to :: " + e.getMessage());
        }
        return response;
    }
*/
    public Response getData() {
    	

    	reqSpec = RestAssured.given().pathParam("owner", EnvironmentDetails.getProperty("accountOwner")).pathParam("repo", EnvironmentDetails.getProperty("nameRepo"));
    			reqSpec.headers(getHeaders(false)).  
    			log().params().log().headers();//reqSpec.headers(getHeaders(false));  //  <body>Value for argument "documentPath" is not a valid resource path. Path must be a non-empty string.</body>
    	
    //	apiHelperLoginfo("Repo: {}", repo);
        Response response = null;
        try {
            response = reqSpec.get("repos/{owner}/{repo}");
           response.then().log().all();
        } catch (Exception e) {
            apiHelperLog.info("get data functinality is not working ");

            Assert.fail("Get data is failing due to :: " + e.getMessage());
        }
        return response;
    }
    public Response getData1() {
    	apiHelperLog.info("DDDD");

    	reqSpec = RestAssured.given().pathParam("owner", EnvironmentDetails.getProperty("accountOwner")).pathParam("repo", EnvironmentDetails.getProperty("invalidRepo"));
    			reqSpec.headers(getHeaders(false)).
                log().params().log().headers();//reqSpec.headers(getHeaders(false));  //  <body>Value for argument "documentPath" is not a valid resource path. Path must be a non-empty string.</body>
    	apiHelperLog.info("",reqSpec.log());

        Response response = null;
        try {
            response = reqSpec.get("repos/{owner}/{repo}");
           response.then().log().all();
        } catch (Exception e) {
            apiHelperLog.info("get data functinality is working ");

            Assert.fail("Get data is failing due to :: " + e.getMessage());
        }
        return response;
    }
    
 public Response getAllData() {
    	

    	reqSpec = RestAssured.given()
                .header("Authorization", "Bearer " + EnvironmentDetails.getProperty("token")).
                log().params().log().headers();//reqSpec.headers(getHeaders(false));  //  <body>Value for argument "documentPath" is not a valid resource path. Path must be a non-empty string.</body>
    	
    //	apiHelperLoginfo("Repo: {}", repo);
        Response response = null;
        try {
            response = reqSpec.get("/user/repos");
           response.then().log().headers();
        } catch (Exception e) {
            apiHelperLog.info("get all data functinality is not working ");

            Assert.fail("Get all data is failing due to :: " + e.getMessage());
        }
        return response;
    }

    public Response addData(CreateRepoRequest addDataRequest) {
        reqSpec = RestAssured.given();
        reqSpec.headers(getHeaders(false)).log().headers();

        Response response = null;
        try {
        	 apiHelperLog.info("Adding below data :: " + new ObjectMapper().writeValueAsString(addDataRequest));
        	 System.out.println(new ObjectMapper().writeValueAsString(addDataRequest));
            reqSpec.body(new ObjectMapper().writeValueAsString(addDataRequest)); //Serializing addData Request POJO classes to byte stream
            response = reqSpec.post("/user/repos");
            response.then().log().all();
        } catch (Exception e) {
            Assert.fail("Add data functionality is failing due to :: " + e.getMessage());
        }
        return response;
    }

    public Response patchData(UpdateRepoRequest updateDataRequest) throws JsonProcessingException {
     //log.info("Adding below data :: " + new ObjectMapper().writeValueAsString(updateDataRequest));

   reqSpec = RestAssured.given().pathParam("owner", EnvironmentDetails.getProperty("accountOwner")).pathParam("repo", EnvironmentDetails.getProperty("repoUpdate"));
        reqSpec.headers(getHeaders(false));
        Response response = null;
        try {
         System.out.println("Adding below data :: " + new ObjectMapper().writeValueAsString(updateDataRequest));

        //    log.info("Adding below data :: " + new ObjectMapper().writeValueAsString(updateDataRequest));

            reqSpec.body(new ObjectMapper().writeValueAsString(updateDataRequest)); //Serializing addData Request POJO classes to byte stream
            response = reqSpec.patch("/repos/{owner}/{repo}");
            response.then().log().all();
        } catch (Exception e) {
            Assert.fail("Update data functionality is failing due to :: " + e.getMessage());
        }
        return response;
    }

    public Response deleteRepo() {
    	   reqSpec = RestAssured.given().pathParam("owner", EnvironmentDetails.getProperty("accountOwner")).pathParam("repo", EnvironmentDetails.getProperty("deleteRepo"));
        reqSpec.headers(getHeaders(false));
        Response response = null;
        try {
            response = reqSpec.delete("/repos/{owner}/{repo}");
            response.then().log().all();
        } catch (Exception e) {
            Assert.fail("Delete data functionality is failing due to :: " + e.getMessage());
        }
        return response;
    }
    public Response deleteNonExistRepo() {
 	   reqSpec = RestAssured.given().pathParam("owner", EnvironmentDetails.getProperty("accountOwner")).pathParam("repo", EnvironmentDetails.getProperty("invalidRepo"));
     reqSpec.headers(getHeaders(false));
     Response response = null;
     try {
         response = reqSpec.delete("/repos/{owner}/{repo}");
         response.then().log().all();
     } catch (Exception e) {
         Assert.fail("Delete data functionality is failing due to :: " + e.getMessage());
     }
     return response;
 }
   
    public HashMap<String, String> getHeaders(boolean forLogin) {
        HashMap<String, String> headers = new HashMap();
        headers.put("Content-Type", "application/json");
        if (!forLogin) {
            headers.put("Authorization", "Bearer " + EnvironmentDetails.getProperty("token"));
        }
        return headers;
    }

}
