package stepDefinations;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.Utils;
import resources.ValidationReusable;

public class StepDefination2 extends Utils {
	RequestSpecification res;
	Response response;
	String symbols;
	String Base;
	String date;
	ValidationReusable val = new ValidationReusable();
	
	@Given("User create ratesAPI past Payload with {string}")
	public void user_create_ratesAPI_past_Payload_with(String date) throws IOException {
		this.date = date;
		
		res = given().spec(requestSpecification());
		res = updatePastURL(res, date);
	}
	
	@When("User calls Past {string} with {string} http request")
	public void user_calls_Past_with_http_request(String string, String string2) {
		response = performGetOperation(res);
	}

	@Then("User validates if the Response_past is Success")
	public void user_validates_if_the_Response_past_is_Success() throws IOException {
		if(date.equalsIgnoreCase("validDateFormat")) {
			val.validateValidResponseCode(response);
			val.validateValidResponseMessage(response);
			val.validateValidResponseBodyPastDate(response);
		}
		else if(date.equalsIgnoreCase("inValidDateFormat")) {
			val.validateInValidResponseCode(response);
			val.validateInValidResponseMessage(response);
			val.validateInValidResponseBodyPastDate(response);
		}
		else {
			val.validateInValidResponseCode(response);
			val.validateInValidResponseMessage(response);
			val.validateBlankResponseBodyPastDate(response);
		}
	}
	
	@Given("User create ratesAPI past Payload with queryParams : Symbols {string} {string}")
	public void user_create_ratesAPI_past_Payload_with_queryParams_Symbols(String date, String symbols) throws IOException {
		this.date = date;
		this.symbols = symbols;
		
		res = given().spec(requestSpecification());
		res = updatePastURL(res, date);
		res = setQueryParametersPast(res, symbols);
	}

	@Then("User validates if the Response_past_Symbols is Success")
	public void user_validates_if_the_Response_past_Symbols_is_Success() throws IOException {
		if(date.equalsIgnoreCase("validDateFormat")) {
			if(symbols.equalsIgnoreCase("invalidSymbols")) {
				val.validateInValidResponseCode(response);
				val.validateInValidResponseMessage(response);
				val.validateValidResponseBodyPastDateSymbols(response, symbols);
			} else {
			val.validateValidResponseCode(response);
			val.validateValidResponseMessage(response);
			val.validateValidResponseBodyPastDateSymbols(response, symbols);
			}
		}
		else if(date.equalsIgnoreCase("inValidDateFormat")) {
			val.validateInValidResponseCode(response);
			val.validateInValidResponseMessage(response);
			val.validateInValidResponseBodyPastDateSymbolsandBase(response);
		}
	}
	
	@Given("User create ratesAPI past Payload with queryParams : Base {string} {string}")
	public void user_create_ratesAPI_past_Payload_with_queryParams_Base(String date, String base) throws IOException {
		this.date = date;
		this.Base = base;
		
		res = given().spec(requestSpecification());
		res = updatePastURL(res, date);
		res = setQueryParametersPast(res, base);
	}

	@Then("User validates if the Response_past_Base is Success")
	public void user_validates_if_the_Response_past_Base_is_Success() throws IOException {
		if(date.equalsIgnoreCase("validDateFormat")) {
			if(Base.equalsIgnoreCase("invalidBase")) {
				val.validateInValidResponseCode(response);
				val.validateInValidResponseMessage(response);
				val.validateValidResponseBodyPastDateBase(response, Base);
			} else {
			val.validateValidResponseCode(response);
			val.validateValidResponseMessage(response);
			val.validateValidResponseBodyPastDateBase(response, Base);
			}
		}
		else if(date.equalsIgnoreCase("inValidDateFormat")) {
			val.validateInValidResponseCode(response);
			val.validateInValidResponseMessage(response);
			val.validateInValidResponseBodyPastDateSymbolsandBase(response);
		}
	}
	
	@Given("User create ratesAPI past Payload with queryParams : Symbols and Base {string} {string} {string}")
	public void user_create_ratesAPI_past_Payload_with_queryParams_Symbols_and_Base(String date, String base, String symbols) throws IOException {
		this.Base = base;
		this.symbols = symbols;
		
		res = given().spec(requestSpecification());
		res = updatePastURL(res, date);
		res = setQueryParametersPastSymbolsandBase(res, symbols, base);
	}

	@Then("User validates if the Response_past_Symbols_and_Base is Success")
	public void user_validates_if_the_Response_past_Symbols_and_Base_is_Success() {
		if(Base.equalsIgnoreCase("base")) {
			if(symbols.equalsIgnoreCase("invalidSymbols")) {
				val.validateInValidResponseCode(response);
				val.validateInValidResponseMessage(response);
				
			} else {
			val.validateValidResponseCode(response);
			val.validateValidResponseMessage(response);
			
			}
		}
		else if(Base.equalsIgnoreCase("invalidBase")) {
			val.validateInValidResponseCode(response);
			val.validateInValidResponseMessage(response);
			
		}
	}

}
