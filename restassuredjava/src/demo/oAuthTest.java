package demo;

import static io.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.path.json.JsonPath;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import pojo.Api;
import pojo.GetCourse;
import pojo.WebAutomation;
import org.testng.Assert;

public class oAuthTest {
    public static void main(String[] args) {
		// TODO Auto-generated method stub
	String[] courseTitles = {"Selenium Webdriver Java","Cypress","Protractor"};
		
	String response = given()
		.formParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
		.formParams("grant_type","client_credentials")
		.formParams("scope","trust")
		.when().log().all()
		.post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();
	
	System.out.println(response);
	JsonPath jsonPath = new JsonPath(response);
	String accessToken = jsonPath.getString("access_token");
	
	
	GetCourse gc=	given()
		.queryParams("access_token", accessToken)
		.when().log().all()
		.get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(GetCourse.class);
	
	System.out.println(gc.getLinkedIn());
	System.out.println(gc.getInstructor());
	System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());
	
	
	List<Api> apiCourses=gc.getCourses().getApi();
	for(int i=0;i<apiCourses.size();i++)
	{
		if(apiCourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
				{
			System.out.println(apiCourses.get(i).getPrice());
				}
	}
	
	//Get the course names of WebAutomation
			ArrayList<String> a= new ArrayList<String>();
			
			
			List<pojo.WebAutomation> w=gc.getCourses().getWebAutomation();
			
			for(int j=0;j<w.size();j++)
			{
				a.add(w.get(j).getCourseTitle());
			}
			
			List<String> expectedList=	Arrays.asList(courseTitles);
			
			Assert.assertTrue(a.equals(expectedList));	
	}
}
