package endpoints;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload.User;

/**
 * This class contains repositories methods.
 * 
 * @author Prasanna.Prabakaran
 *
 */
public class UserEndpoint {

	public static Response createUser(User payload) {

	Response response=	given().
			log().all().
			contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload).
			when().post(Routes.create_user_url).
			then().extract().response();
	
	return response;
	}
	
	public static Response readUser(String username) {
		Response response=	given().
				log().all().
				contentType(ContentType.JSON)
				.accept(ContentType.JSON).
				pathParam("username", username).
				when().get(Routes.get_user_url).
				then().extract().response();
		
		return response;
		
	}
	
	public static Response updateUser(String userName,User payload) {
		Response response=	given().
				contentType(ContentType.JSON).
				pathParam("username", userName)
				.accept(ContentType.JSON)
				.body(payload)
				.when().put(Routes.update_user_url).
				then().extract().response();
		
		return response;
		
	}
	
	public static Response deleteUser(String username) {
		Response response=	given().
				contentType(ContentType.JSON)
				.accept(ContentType.JSON).
				pathParam("username", username).
				when().get(Routes.delete_user_url).
				then().extract().response();
		
		return response;
		
	}
	
	public static Response loginUser(String username, String password) {
		Response response=	given().
				queryParam("username", username).
				queryParam("password", password).
				contentType(ContentType.JSON)
				.accept(ContentType.JSON).
				when().get(Routes.login_user_url).
				then().extract().response();
		
		return response;
	}
	
	public static Response logoutUser() {
		Response response=	given().
				contentType(ContentType.JSON)
				.accept(ContentType.JSON).
				when().get(Routes.logout_user_url).
				then().extract().response();
		
		return response;
	}

}
