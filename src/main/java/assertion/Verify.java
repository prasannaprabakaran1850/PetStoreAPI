package assertion;

import org.testng.Assert;

import io.restassured.response.Response;

public class Verify {
	
	public static void verifyStatusCode200(Response response) {
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	public static void verifyStatusCode201(Response response) {
		Assert.assertEquals(response.getStatusCode(), 201);
	}

	public static boolean verifyString(String actual, String expected) {
		try {
			Assert.assertEquals(actual, expected);
			System.out.println(("PASS Actual Result:: " + actual + " Expected Result:: " + expected));
			return true;

		} catch (AssertionError assertionError) {
			System.out.println("FAIL Actual Result:: " + actual + " Expected Result:: " + expected);
			return false;
		}
	}

	public static boolean verifyBoolean(boolean actual, boolean expected) {
		try {
			Assert.assertEquals(actual, expected);
			System.out.println("PASS Actual Result:: " + actual + " Expected Result:: " + expected);
			return true;

		} catch (AssertionError assertionError) {
			System.out.println("FAIL Actual Result:: " + actual + " Expected Result:: " + expected);
			return false;
		}
	}
}
