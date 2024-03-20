package com.github.CRUD;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import static org.testng.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.RequestPOJO.CreateRepoRequest;
import com.github.RequestPOJO.UpdateRepoRequest;
import com.github.ResponsePOJO.ExistigErrorResponse;
import com.github.ResponsePOJO.ExistingDataResponse;
import com.github.ResponsePOJO.Owner;
import com.github.ResponsePOJO.Root;
import com.github.ResponsePOJO.Status;
import com.github.base.APIHelper;
import com.github.base.BaseTest;
import com.github.javafaker.Faker;
import com.github.utils.EnvironmentDetails;
import com.github.utils.ExtentReportsUtility;
import com.github.utils.JsonSchemaValidate;
import com.github.utils.TestDataUtils;

import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;

@Listeners(com.gitbhub.listerners.TestEventListenersUtility.class)
public class Validating_CRUDTests extends BaseTest {
	protected Logger crudLog = LoggerFactory.getLogger(Validating_CRUDTests.class);

	ExtentReportsUtility reports = ExtentReportsUtility.getInstance();
	APIHelper apiHelper;
	String name = "Hello WORLD!!";
//	, departmentNo="7", salary, pincode,Id;
	// String dataId ;

	// String userId;
	@BeforeClass
	public void beforeClass() {
		apiHelper = new APIHelper();

	}

	@Test(priority = 0)
	public void validateGetSingleRepo() {

		Response data = apiHelper.getData();

		Root getDataResponseList = data.getBody().as(Root.class);
		Assert.assertEquals(getDataResponseList.getFull_name(), TestDataUtils.getProperty("fullName"),
				"The value of full name key is not as expected in response ");
		Assert.assertEquals(getDataResponseList.getDefault_branch(), TestDataUtils.getProperty("branch"),
				"The value of Default branch key is not as expected in response ");
		// In your Log4j configuration, ensure that you have correctly specified the
		// placeholder {} in the log pattern to receive the message argument.

		crudLog.info("Received status code {} ", data.getStatusCode());
		reports.logTestpassed("Assertion passed: Received status code 200 successfully ");
		Assert.assertEquals(data.getStatusCode(), HttpStatus.SC_OK,
				"Get data functionality is not working as expected.");

		Assert.assertEquals(data.getContentType(), TestDataUtils.getProperty("contentType"),
				"The value of content-type key is not as expected in response ");
		reports.logTestpassed("Assertion passed:Content type matches  successfully ");

	}

	@Test(priority = 1)
	public void validateInvalidRepo() {

		Response data = apiHelper.getData1();
		Status status = data.getBody().as(Status.class);
		String str = status.getMessage();
		// In your Log4j configuration, ensure that you have correctly specified the
		// placeholder {} in the log pattern to receive the message argument.
		crudLog.info("Received status message: {}", str);
		Assert.assertEquals(status.getMessage(), TestDataUtils.getProperty("message"),
				"The value of Message key is not as expected in response ");
		crudLog.info("Received status code: {}", data.getStatusCode());
		reports.logTestpassed("Assertion passed :Received status code 404 as expected");

		Assert.assertEquals(data.getStatusCode(), HttpStatus.SC_NOT_FOUND,
				"Get data functionality is not working as expected.");
		Assert.assertEquals(data.getContentType(), TestDataUtils.getProperty("contentType"),
				"The value of content-type key is not as expected in response ");
		JsonSchemaValidate.validateSchemaInClassPath(data, "ExpectedJsonSchema/ErrorResponse.json");
		crudLog.info("Schema validation passed successfully");
		reports.logTestpassed("Schema validation for Negative Test is  passed successfully");
	}

	@Test(priority = 2)
	public void validateGetallRepos() {
		Response data = apiHelper.getAllData();
		Root[] getDataResponseList = data.getBody().as(Root[].class);
		List<Root> getalldata = data.getBody().as(new TypeRef<List<Root>>() {
		});
		Assert.assertEquals(data.getStatusCode(), HttpStatus.SC_OK,
				"Get  all Repos data functionality is not working as expected.");
		crudLog.info(" Status code validation   200 is  passed successfully");
		reports.logTestpassed(" Assertion passed :Status code validation   200 is  passed successfully");

		JsonSchemaValidate.validateSchemaInClassPath(data, "ExpectedJsonSchema/getAllReposResponseSchema.json");
		crudLog.info("Schema validation for All Repositories is  passed successfully");
		reports.logTestpassed("Schema validation for All Repositories is  passed successfully");
		int totalReposwithArray = getDataResponseList.length;
		int totalReposwithList = getalldata.size();
		reports.logTestInfo(Integer.toString(totalReposwithList) + "Received  total number of repositories");
		for (Root dataResponse : getalldata) {
			if (dataResponse.getVisibility().equals("public"))
				System.out.println("Repositories names which are public " + dataResponse.getName());
			reports.logTestInfo("Repositories names which are public " + dataResponse.getName());

		}
		Assert.assertEquals(data.getContentType(), TestDataUtils.getProperty("contentType"),
				"The value of content-type key is not as expected in response ");
		reports.logTestpassed("Validation for response header  Content type is matched ");

	}

	@Test(priority = 3)
	public void validateAddData() {

		CreateRepoRequest addDataRequest = new CreateRepoRequest().builder().name("Hello-World")
				.description("This is my new created repo!").homepage("https://github.com").myprivate(false).build();
		Response res = apiHelper.addData(addDataRequest);
		// The response.as(AddDataResponse.class) statement deserializes the response
		// body into an object of type AddDataResponse.
		// Owner owner=res.getBody().as(Owner.class);
		Root getDataResponseList = res.getBody().as(Root.class);
		// Root getDataResponseList=getDataResponseList.getOwner();
		Owner owner = getDataResponseList.getOwner();
		reports.logTestInfo("Login  is " + owner.getLogin());
		reports.logTestInfo("Type  is " + owner.getType());
		reports.logTestInfo("Name is " + getDataResponseList.getName());
		Assert.assertEquals(res.getStatusCode(), HttpStatus.SC_CREATED,
				"Creating a new Repository functionality is not working as expected.");
		crudLog.info(" Status code validation   201 is  passed successfully");
		// Assert.assertEquals(res.as(AddDataResponse.class).getStatus(),
		// TestDataUtils.getProperty("successStatusMessage"), "The value of status key
		// is not as expected in response ");
		JsonSchemaValidate.validateSchemaInClassPath(res, "ExpectedJsonSchema/GetSingleRepoResponseSchema.json");

	}

	@Test(priority = 4)
	public void validateCreateRepoWithExisting() {

		CreateRepoRequest addDataRequest = new CreateRepoRequest().builder().name("Hello-World")
				.description("This is my new created repo!").homepage("https://github.com").myprivate(false).build();
		Response res = apiHelper.addData(addDataRequest);

		Assert.assertEquals(res.getStatusCode(), HttpStatus.SC_UNPROCESSABLE_ENTITY,
				" Repository functionality is not working as expected.");
		crudLog.info(" Status code validation  422 is  passed successfully" + res.getStatusCode());
		reports.logTestpassed(" Status code validation   422 is  passed successfully" + res.getStatusCode());
		// Assert.assertEquals(res.as(AddDataResponse.class).getStatus(),
		// TestDataUtils.getProperty("successStatusMessage"), "The value of status key
		// is not as expected in response ");
		ExistingDataResponse errormessagErrorResponse = res.getBody().as(ExistingDataResponse.class);
		ArrayList<ExistigErrorResponse> errors = errormessagErrorResponse.getErrors();

		Assert.assertEquals(errors.get(0).getMessage(), TestDataUtils.getProperty("errorMessage"),
				"Assertion failed  Response message not matiching with expected");
		reports.logTestpassed("Assertion passsed : errors/message= \"message\": \"name already exists on this account");
	}
//	Assert.assertEquals(errormessagErrorResponse.getMessage(), "Repository creation failed.");
//	reports.logTestpassed(  errormessagErrorResponse.getMessage()+" Assertion Passed");

	@Test(priority = 5)
	public void validateUpdatedData() throws JsonProcessingException {

		UpdateRepoRequest updateDataRequest = new UpdateRepoRequest().builder().name("Hello-WorldUpdate")
				.description("This is my repo!").homepage("https://github.com").myprivate(false).build();
		Response data = apiHelper.patchData(updateDataRequest);
		Assert.assertEquals(data.getStatusCode(), HttpStatus.SC_OK, "Response code is not matching for get data.");
		Root getDataResponseList = data.getBody().as(Root.class);
		reports.logTestpassed(" Status code validation 200 is  passed successfully" + data.getStatusCode());

		Assert.assertEquals(getDataResponseList.getName(), updateDataRequest.getName(),
				"Validation is not matching with the   Response new repository name is as in the Request repository  Name");
		reports.logTestpassed(
				"Validation is successful:Response new repository name is as in the Request repository  Name "
						+ getDataResponseList.getName() + updateDataRequest.getName());

	}

	@Test(priority = 6)
	public void validateDeletedRepo() {
		Response data = apiHelper.deleteRepo();
		Assert.assertEquals(data.getStatusCode(), HttpStatus.SC_NO_CONTENT,
				"Response code is not matching for get data.");
		reports.logTestpassed(" Status code validation 404 is  passed successfully" + data.getStatusCode());
		Assert.assertNull(null);
		reports.logTestpassed("Assertion passed: Body is null");

	}

	@Test(priority = 7)
	public void validateDeletedNonExistRepo() {
		Response data = apiHelper.deleteNonExistRepo();
		Assert.assertEquals(data.getStatusCode(), HttpStatus.SC_NOT_FOUND,
				"Response code is not matching for get data.");
		reports.logTestpassed(" Status code validation 204 is  passed successfully" + data.getStatusCode());

		Status status = data.getBody().as(Status.class);
		Assert.assertEquals(status.getMessage(), TestDataUtils.getProperty("message"),
				"Message data from response is not matching with expected");
		reports.logTestpassed("Assertion passed: " + status.getMessage());

	}

}