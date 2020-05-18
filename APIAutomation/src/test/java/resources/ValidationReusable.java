package resources;

import java.io.IOException;

import org.junit.Assert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojo.Latest;

public class ValidationReusable {
	public Response resp;
	PropertiesReader reader = new PropertiesReader();
	
	public String getJsonPath(Response response, String key) {
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		return js.get(key).toString();
	}
	
	public void validateValidResponseCode(Response resp) {
		Assert.assertEquals(200, resp.getStatusCode());
	}
	
	public void validateInValidResponseCode(Response resp) {
		Assert.assertEquals(400, resp.getStatusCode());
	}
	
	public void validateValidResponseMessage(Response resp) {
		String statusLine = resp.getStatusLine();
		String expectedMessage = "OK";
		Assert.assertTrue(statusLine.contains(expectedMessage));
	}
	
	public void validateInValidResponseMessage(Response resp) {
		String statusLine = resp.getStatusLine();
		String expectedMessage = "Bad Request";
		Assert.assertTrue(statusLine.contains(expectedMessage));
	}
	
	public void validateValidResponseBodyLatest(Response resp) {
		Latest latest = resp.as(Latest.class);
		String base = "EUR";
		Assert.assertTrue(base.equalsIgnoreCase(latest.getBase()));
	}
	
	public void validateValidResponseBodyLatestSymbols(Response resp) {
		Latest latest = resp.as(Latest.class);
		String base = "EUR";
		Assert.assertTrue(base.equalsIgnoreCase(latest.getBase()));
		
		Assert.assertTrue(latest.getRates().getUSD() != 0);
		Assert.assertTrue(latest.getRates().getGBP() != 0);
		
	}

	public void validateInValidResponseBodyLatestSymbols(Response resp) {
		String errorMessage = "Symbols 'asdsd' are invalid for date";
		Assert.assertTrue(getJsonPath(resp, "error").contains(errorMessage));
	}
	
	public void validateValidResponseBodyLatestBase(Response resp) {
		Latest latest = resp.as(Latest.class);
		String base = "USD";
		Assert.assertTrue(base.equalsIgnoreCase(latest.getBase()));
		
		Assert.assertTrue(latest.getRates().getUSD() != 0);
		Assert.assertTrue(latest.getRates().getGBP() != 0);
		
	}
	
	public void validateInValidResponseBodyLatestBase(Response resp) {
		String errorMessage = "Base 'asdsd' is not supported.";
		Assert.assertTrue(getJsonPath(resp, "error").contains(errorMessage));
	}
	
	public void validateBlankResponseBodyLatestBase(Response resp) {
		Latest latest = resp.as(Latest.class);
		String base = "EUR";
		Assert.assertTrue(base.equalsIgnoreCase(latest.getBase()));
		
		Assert.assertTrue(latest.getRates().getUSD() != 0);
		Assert.assertTrue(latest.getRates().getGBP() != 0);
		
	}
	
	public void validateValidResponseBodyPastDate(Response resp) throws IOException {
		Latest latest = resp.as(Latest.class);
		String base = "EUR";
		Assert.assertTrue(base.equalsIgnoreCase(latest.getBase()));
		
		Assert.assertTrue(latest.getRates().getUSD() != 0);
		Assert.assertTrue(latest.getRates().getGBP() != 0);
		
		Assert.assertEquals(reader.getGlobalValue("validDate"), latest.getDate());
		
	}
	
	public void validateInValidResponseBodyPastDate(Response resp) throws IOException {
		String error = "time data '01-02-2017' does not match format '%Y-%m-%d'";
		Assert.assertTrue(getJsonPath(resp, "error").contains(error));
	}
	
	public void validateBlankResponseBodyPastDate(Response resp) throws IOException {
		String error = "time data 'api' does not match format '%Y-%m-%d'";
		Assert.assertTrue(getJsonPath(resp, "error").contains(error));
	}
	
	public void validateValidResponseBodyPastDateSymbols(Response resp, String symbols) throws IOException {
		
		if(symbols.equals("symbols")) {
		Latest latest = resp.as(Latest.class);
		String base = "EUR";
		Assert.assertTrue(base.equalsIgnoreCase(latest.getBase()));
		
		Assert.assertTrue(latest.getRates().getUSD() != 0);
		Assert.assertTrue(latest.getRates().getGBP() != 0);
		
		Assert.assertEquals(reader.getGlobalValue("validDate"), latest.getDate());
		}
		else if(symbols.equalsIgnoreCase("invalidSymbols")) {
			String error = "Symbols 'asdsd' are invalid for date 2010-01-12.";
			Assert.assertTrue(getJsonPath(resp, "error").contains(error));
		} else if(symbols.equalsIgnoreCase("blankSymbols")) {
			
				Latest latest = resp.as(Latest.class);
				String base = "EUR";
				Assert.assertTrue(base.equalsIgnoreCase(latest.getBase()));
				
				Assert.assertEquals(reader.getGlobalValue("validDate"), latest.getDate());
			
		}
		
	}
	
	public void validateInValidResponseBodyPastDateSymbolsandBase(Response resp) throws IOException {
		String error = "time data '01-02-2017' does not match format '%Y-%m-%d'";
		Assert.assertTrue(getJsonPath(resp, "error").contains(error));
	}
	
	public void validateValidResponseBodyPastDateBase(Response resp, String Base) throws IOException {
		
		if(Base.equals("base")) {
		Latest latest = resp.as(Latest.class);
		String base = "USD";
		Assert.assertTrue(base.equalsIgnoreCase(latest.getBase()));
		
		Assert.assertTrue(latest.getRates().getUSD() != 0);
		Assert.assertTrue(latest.getRates().getGBP() != 0);
		
		Assert.assertEquals(reader.getGlobalValue("validDate"), latest.getDate());
		}
		else if(Base.equalsIgnoreCase("invalidBase")) {
			String error = "Base 'asdsd' is not supported.";
			Assert.assertTrue(getJsonPath(resp, "error").contains(error));
		} else if(Base.equalsIgnoreCase("blankBase")) {
				Latest latest = resp.as(Latest.class);
				String base = "EUR";
				Assert.assertTrue(base.equalsIgnoreCase(latest.getBase()));
				
				Assert.assertEquals(reader.getGlobalValue("validDate"), latest.getDate());
		}
		
	}
}
