package Frame;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.ArrayList;

import org.junit.Test;

public class TestMethods {

	/**This method initialize the URI and Path for execute the Test Cases*/
	public void classSetup(String URL, String path) {
		try {
			RestAssured.baseURI = URL;
			RestAssured.basePath = path;
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	/** Variable used for the method validation code  */
	public static int code;
	/** Variable used for the method validation code  */
	public static int expected;
	/** Variable used for the method executionFila() */
	public static String path; 
	
	/** This method execute the actions */
	@Test
	public String executionFile(TestData Obj) {
		String statuscode="";
	
		switch(Obj.getAction().toLowerCase()) {
			
		case "post":
			Response resp = RestAssured.given().header("Accept", "application/json")
			.header("content-type", "application/json")
			.body(Obj.getBody()).post();
			code = resp.statusCode();
			expected = Obj.getExpected();
			statuscode=resp.getBody().asString();
         	return statuscode;
		case "get":
			RestAssured.basePath = "usersquery";
			Response resp2 = RestAssured.given().get();
			code = resp2.statusCode();
			expected = Obj.getExpected();
			statuscode= validationCode();
			return statuscode;
         	
		case "put":
			path=Obj.getPath();
			Response resp3 = RestAssured.given().header("Accept", "application/json")
			.header("content-type", "application/json")
			.body(Obj.getBody()).put();
			code = resp3.statusCode();
			expected = Obj.getExpected();
			statuscode=resp3.getBody().asString();
         	return statuscode;
         	
         	default: return "error desconocido";
			
			
		
		}

	}
	
	
	/** This method validate if the test cases pass or fail */
	public String validationCode() {
		if(expected==code) {
			String result="";
			result="Pass";
			
			return result;
		}else {
			String result="";
			result="Fail";
			
			return result;
		}
		
	}
	
		
}
