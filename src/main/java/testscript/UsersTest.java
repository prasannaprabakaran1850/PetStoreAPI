package testscript;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.relevantcodes.extentreports.LogStatus;

import assertion.Verify;
import endpoints.UserEndpoint;
import io.restassured.response.Response;
import payload.User;
import utils.Report;

public class UsersTest extends Report {

	Faker faker;
	User userPayload;

	/**
	 * This method contains the test data for the user
	 */
	@BeforeClass
	public void stupData() {

		faker = new Faker();
		userPayload = new User();

		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(6, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
	}

	/**
	 * This method is used to create new user
	 */
	@Test(priority = 1)
	public void testCreateUser() {

		test.log(LogStatus.INFO,"Create user test");
		Response response = UserEndpoint.createUser(userPayload);
		test.log(LogStatus.INFO, response.getStatusLine());
		Verify.verifyStatusCode200(response);
	}

	/**
	 * This method is used to  get the user details by username
	 */
	@Test(priority = 2)
	public void testGetUserByName() {
		test.log(LogStatus.INFO,"Get user test");
		Response response = UserEndpoint.readUser(userPayload.getUsername());
		Verify.verifyStatusCode200(response);

	}

	/**
	 * This method is used to update the user details by username
	 */
	@Test(priority = 3)
	public void testUpdateUser() {
		test.log(LogStatus.INFO,"Update user test");

		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		Response response = UserEndpoint.updateUser(userPayload.getUsername(), userPayload);
		Verify.verifyStatusCode200(response);
		
		Response responseAfterUpdate = UserEndpoint.readUser(userPayload.getUsername());
		Verify.verifyStatusCode200(responseAfterUpdate);
		
	}
	
	/**
	 * This method is used test login using username and password
	 */
	@Test(priority = 4)
	public void loginUser() {
		test.log(LogStatus.INFO,"Login user test");

		Response response = UserEndpoint.loginUser(userPayload.getUsername(), userPayload.getPassword());
		Verify.verifyStatusCode200(response);
	}
	
	/**
	 * This method is used test logout
	 */
	@Test(priority = 5)
	public void logoutUser() {
		test.log(LogStatus.INFO,"Logout user test");

		Response response = UserEndpoint.logoutUser();
		Verify.verifyStatusCode200(response);
	}
	
	/**
	 * This method is used to delete user details by username
	 */
	@Test(priority = 6)
	public void testDeleteUser() {
		test.log(LogStatus.INFO,"Delete user test");	
		Response response = UserEndpoint.deleteUser(userPayload.getUsername());
		Verify.verifyStatusCode200(response);
	}

}
