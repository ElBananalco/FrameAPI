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

	
	@Test
	public void executionFile(TestData Obj) {
		
		int code,expected;
		switch(Obj.getAccion().toLowerCase()) {
			
		case "post":
			Response resp = RestAssured.given().header("content-type", "application/json").body(Obj.getBody()).post();
			validationCode(Obj.getExpected(),resp.statusCode(),Obj.getNameTC());
			
			break;
		case "get":
			Response resp2 = RestAssured.given().get();
			validationCode(Obj.getExpected(),resp2.statusCode(),Obj.getNameTC());
			
			break;
		
		}

	}
	
	public void validationCode(int expected, int code, String name) {
		if(expected==code) {
			
			System.out.println("Test Case Pass "+name);
			System.out.println("Status code expected is "+expected);
			System.out.println("Status code is "+code);
		}else {
			System.out.println("Test Case Fail "+name);
			System.out.println("Status code expected is "+expected);
			System.out.println("Status code is "+code);
		}
		
	}
 
	public String testCases(TestData Obj){
		String sheet="";
		if( Obj.getNameTC()=="") {
		
		}else {
			sheet = Obj.getNameTC();
		}
		
		return sheet;
	}
	
}
