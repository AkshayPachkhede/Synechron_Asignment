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

public class StepDefination1 extends Utils {
	RequestSpecification res;
	Response response;
	String symbols;
	String Base;
	ValidationReusable val = new ValidationReusable();
	
	@Given("User create ratesAPI latest Payload")
	public void user_create_ratesAPI_latest_Payload() throws IOException {
		res = given().spec(requestSpecification());
		res = updateLatestURL(res);
	}

	@When("User calls {string} with {string} http request")
	public void user_calls_with_http_request(String string, String string2) {
		response = performGetOperation(res);
	}

	@Then("User validates if the Response is Success")
	public void user_validates_if_the_Response_is_Success() {
		val.validateValidResponseCode(response);
		val.validateValidResponseMessage(response);
		val.validateValidResponseBodyLatest(response);
	}
	
	@Given("User create ratesAPI latest Payload with queryParams {string}")
	public void user_create_ratesAPI_latest_Payload_with_queryParams(String symbols) throws IOException {
		
		this.symbols = symbols;
		
		res = given().spec(requestSpecification());
		res = setQueryParametersLatest(res, symbols);
		res = updateLatestURL(res);
	}

	@Then("User validates if the Response_Symbols is Success")
	public void user_validates_if_the_Response_Symbols_is_Success() {
		
		if(symbols.equals("symbols") || symbols.equals("blankSymbols")) {
		val.validateValidResponseCode(response);
		val.validateValidResponseMessage(response);
		val.validateValidResponseBodyLatestSymbols(response);
		}
		else if(symbols.equals("invalidSymbols")) {
			val.validateInValidResponseCode(response);
			val.validateInValidResponseMessage(response);
			val.validateInValidResponseBodyLatestSymbols(response);
		}
	}
	
	@Given("User create ratesAPI latest Base Payload with queryParams {string}")
	public void user_create_ratesAPI_latest_Base_Payload_with_queryParams(String Base) throws IOException {
		this.Base = Base;
		
		res = given().spec(requestSpecification());
		res = setQueryParametersLatest(res, Base);
		res = updateLatestURL(res);
	}

	@Then("User validates if the Response_Base is Success")
	public void user_validates_if_the_Response_Base_is_Success() {
		if(Base.equals("base")) {
			val.validateValidResponseCode(response);
			val.validateValidResponseMessage(response);
			val.validateValidResponseBodyLatestBase(response);
			}
			else if(Base.equals("invalidBase")) {
				val.validateInValidResponseCode(response);
				val.validateInValidResponseMessage(response);
				val.validateInValidResponseBodyLatestBase(response);
			}
			else if(Base.equals("blankBase")) {
				val.validateValidResponseCode(response);
				val.validateValidResponseMessage(response);
				val.validateBlankResponseBodyLatestBase(response);
			}
	}
	
	@Given("User create ratesAPI latest Payload with queryParams : Symbols and Base {string} {string}")
	public void user_create_ratesAPI_latest_Payload_with_queryParams_Symbols_and_Base(String symbols, String base) throws IOException {
		
		this.symbols = symbols;
		this.Base = base;
		
		res = given().spec(requestSpecification());
		res = setQueryParametersLatestSymbolsandBase(res, symbols, Base);
		res = updateLatestURL(res);
	}

	@When("User calls latest {string} with {string} http request")
	public void user_calls_latest_with_http_request(String string, String string2) {
		response = performGetOperation(res);
	}

	@Then("User validates if the Response_latest_SymbolsandBase is Success")
	public void user_validates_if_the_Response_latest_SymbolsandBase_is_Success() {
		if(symbols.equals("symbols")) {
			
			if(Base.equals("base")) {
				val.validateValidResponseCode(response);
				val.validateValidResponseMessage(response);
				val.validateValidResponseBodyLatestBase(response);
				}
				else if(Base.equals("invalidBase")) {
					val.validateInValidResponseCode(response);
					val.validateInValidResponseMessage(response);
					val.validateInValidResponseBodyLatestBase(response);
				}
				else if(Base.equals("blankBase")) {
					val.validateValidResponseCode(response);
					val.validateValidResponseMessage(response);
					val.validateValidResponseBodyLatestSymbols(response);
					val.validateBlankResponseBodyLatestBase(response);
				}
		}
		else if(symbols.equals("invalidSymbols")) {
			
			if(Base.equals("base")) {
				val.validateInValidResponseCode(response);
				val.validateInValidResponseMessage(response);
				val.validateInValidResponseBodyLatestSymbols(response);
				}
				else if(Base.equals("invalidBase")) {
					val.validateInValidResponseCode(response);
					val.validateInValidResponseMessage(response);
					val.validateInValidResponseBodyLatestBase(response);
				}
				else if(Base.equals("blankBase")) {
					val.validateInValidResponseCode(response);
					val.validateInValidResponseMessage(response);
					val.validateInValidResponseBodyLatestSymbols(response);
				}
		}
	}

}
