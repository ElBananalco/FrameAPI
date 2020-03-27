package Frame;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.ArrayList;

import org.junit.Test;

public class TestMethods {

	public void classSetup(String URL, String path) {
		try {
			RestAssured.baseURI = URL;
			RestAssured.basePath = path;
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	public static int code;  
	public static int expected;
	public static String path; 
	@Test
	public String executionFile(TestData Obj) {
		String statuscode="";
	
		switch(Obj.getAccion().toLowerCase()) {
			
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
