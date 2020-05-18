package resources;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	PropertiesReader propreader = new PropertiesReader();
	public static RequestSpecification req;
	public Response resp;

	public RequestSpecification requestSpecification() throws IOException {
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		req = new RequestSpecBuilder().setBaseUri(propreader.getGlobalValue("baseUrl"))
				.addFilter(RequestLoggingFilter.logRequestTo(log)).addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
		return req;
	}
	
	public String getReportConfigPath() throws IOException{
		String reportConfigPath = propreader.getGlobalValue("reportConfigPath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}
	
	public RequestSpecification setQueryParametersLatest(RequestSpecification res, String requestParams) throws IOException {
		
		Map<String, Object> parametersMap = new HashMap<String, Object>();
		
		if(requestParams.equalsIgnoreCase("Symbols")) {
			parametersMap.clear();
			parametersMap.put("symbols", propreader.getGlobalValue("symbols"));
			res.queryParams(parametersMap);
			return res;
			
		}
		else if(requestParams.equalsIgnoreCase("invalidSymbols")) {
			parametersMap.clear();
			parametersMap.put("symbols", propreader.getGlobalValue("invalidValue"));
			res.queryParams(parametersMap);
			return res;
			
		}
		else if(requestParams.equalsIgnoreCase("blankSymbols")) {
			parametersMap.clear();
			parametersMap.put("symbols","");
			res.queryParams(parametersMap);
			return res;
			
		}
		else if(requestParams.equalsIgnoreCase("SymbolsandBase")) {
			parametersMap.clear();
			parametersMap.put("symbols", propreader.getGlobalValue("symbolsandBase"));
			res.queryParams(parametersMap);
			return res;
			
		} else if(requestParams.equalsIgnoreCase("base")) {
			parametersMap.clear();
			parametersMap.put("base", propreader.getGlobalValue("base"));
			res.queryParams(parametersMap);
			return res;
		}
		else if(requestParams.equalsIgnoreCase("invalidBase")) {
			parametersMap.clear();
			parametersMap.put("base", propreader.getGlobalValue("invalidValue"));
			res.queryParams(parametersMap);
			return res;
			
		}
		else if(requestParams.equalsIgnoreCase("blankBase")) {
			parametersMap.clear();
			parametersMap.put("base","");
			res.queryParams(parametersMap);
			return res;
			
		}
		else return res;
	}
	
	public RequestSpecification updateLatestURL(RequestSpecification res) throws IOException {
		res.baseUri(propreader.getGlobalValue("baseUrl") + "latest");
		
		return res;
	}
	
	public Response performGetOperation(RequestSpecification res) {
		resp = res.get();
		return resp;
	}
	
public RequestSpecification setQueryParametersPast(RequestSpecification res, String requestParams) throws IOException {
		
		Map<String, Object> parametersMap = new HashMap<String, Object>();
		
		if(requestParams.equalsIgnoreCase("symbols")) {
			parametersMap.clear();
			parametersMap.put("symbols", propreader.getGlobalValue("symbols"));
			res.queryParams(parametersMap);
			return res;
			
		}
		else if(requestParams.equalsIgnoreCase("invalidSymbols")) {
			parametersMap.clear();
			parametersMap.put("symbols", propreader.getGlobalValue("invalidValue"));
			res.queryParams(parametersMap);
			return res;
			
		}
		else if(requestParams.equalsIgnoreCase("blankSymbols")) {
			parametersMap.clear();
			parametersMap.put("symbols","");
			res.queryParams(parametersMap);
			return res;
			
		}
		else if(requestParams.equalsIgnoreCase("SymbolsandBase")) {
			parametersMap.clear();
			parametersMap.put("symbols", propreader.getGlobalValue("symbolsandBase"));
			res.queryParams(parametersMap);
			return res;
			
		} else if(requestParams.equalsIgnoreCase("base")) {
			parametersMap.clear();
			parametersMap.put("base", propreader.getGlobalValue("base"));
			res.queryParams(parametersMap);
			return res;
		}
		else if(requestParams.equalsIgnoreCase("invalidBase")) {
			parametersMap.clear();
			parametersMap.put("base", propreader.getGlobalValue("invalidValue"));
			res.queryParams(parametersMap);
			return res;
			
		}
		else if(requestParams.equalsIgnoreCase("blankBase")) {
			parametersMap.clear();
			parametersMap.put("base","");
			res.queryParams(parametersMap);
			return res;
			
		}
		else return res;
	}

public RequestSpecification updatePastURL(RequestSpecification res, String date) throws IOException {
	
	if(date.equalsIgnoreCase("validDateFormat"))
		res.baseUri(propreader.getGlobalValue("baseUrl") + propreader.getGlobalValue("validDate"));
	else if(date.equalsIgnoreCase("inValidDateFormat"))
		res.baseUri(propreader.getGlobalValue("baseUrl") + propreader.getGlobalValue("inValidDate"));
	else if(date.equalsIgnoreCase("blankDate"))
		res.baseUri(propreader.getGlobalValue("baseUrl"));
		
	return res;
}

public RequestSpecification setQueryParametersLatestSymbolsandBase(RequestSpecification res, String symbols, String Base) throws IOException {
	
	Map<String, Object> parametersMap = new HashMap<String, Object>();
	
	if(symbols.equalsIgnoreCase("Symbols")) {
		
		if(Base.equalsIgnoreCase("base")) {
			parametersMap.clear();
			parametersMap.put("symbols", propreader.getGlobalValue("symbols"));
			parametersMap.put("base", propreader.getGlobalValue("base"));
			res.queryParams(parametersMap);
			return res;
		}
		else if(Base.equalsIgnoreCase("invalidBase")) {
			parametersMap.clear();
			parametersMap.put("symbols", propreader.getGlobalValue("symbols"));
			parametersMap.put("base", propreader.getGlobalValue("invalidValue"));
			res.queryParams(parametersMap);
			return res;
		}
		else if(Base.equalsIgnoreCase("blankBase")) {
			parametersMap.clear();
			parametersMap.put("symbols", propreader.getGlobalValue("symbols"));
			parametersMap.put("base","");
			res.queryParams(parametersMap);
			return res;
		}
		return res;
	}
	else if(symbols.equalsIgnoreCase("invalidSymbols")) {
		if(Base.equalsIgnoreCase("base")) {
			parametersMap.clear();
			parametersMap.put("symbols", propreader.getGlobalValue("invalidValue"));
			parametersMap.put("base", propreader.getGlobalValue("base"));
			res.queryParams(parametersMap);
			return res;
		}
		else if(Base.equalsIgnoreCase("invalidBase")) {
			parametersMap.clear();
			parametersMap.put("symbols", propreader.getGlobalValue("invalidValue"));
			parametersMap.put("base", propreader.getGlobalValue("invalidValue"));
			res.queryParams(parametersMap);
			return res;
		}
		else if(Base.equalsIgnoreCase("blankBase")) {
			parametersMap.clear();
			parametersMap.put("symbols", propreader.getGlobalValue("invalidValue"));
			parametersMap.put("base","");
			res.queryParams(parametersMap);
			return res;
		}
		return res;
		
	}
	else return res;
}

public RequestSpecification setQueryParametersPastSymbolsandBase(RequestSpecification res, String symbols, String Base) throws IOException {
	
	Map<String, Object> parametersMap = new HashMap<String, Object>();
	
	if(Base.equalsIgnoreCase("base")) {
		
		if(symbols.equalsIgnoreCase("symbols")) {
			parametersMap.clear();
			parametersMap.put("base", propreader.getGlobalValue("base"));
			parametersMap.put("symbols", propreader.getGlobalValue("symbols"));
			res.queryParams(parametersMap);
			return res;
		}
		else if(symbols.equalsIgnoreCase("invalidSymbols")) {
			parametersMap.clear();
			parametersMap.put("base", propreader.getGlobalValue("base"));
			parametersMap.put("symbols", propreader.getGlobalValue("invalidValue"));
			res.queryParams(parametersMap);
			return res;
		}
		else if(symbols.equalsIgnoreCase("blankSymbols")) {
			
			parametersMap.clear();
			parametersMap.put("base", propreader.getGlobalValue("base"));
			parametersMap.put("symbols","");
			res.queryParams(parametersMap);
			return res;
		}
		return res;
	}
	else if(Base.equalsIgnoreCase("invalidBase")) {
		if(symbols.equalsIgnoreCase("symbols")) {
			parametersMap.clear();
			parametersMap.put("base", propreader.getGlobalValue("invalidValue"));
			parametersMap.put("symbols", propreader.getGlobalValue("symbols"));
			res.queryParams(parametersMap);
			return res;
		}
		else if(symbols.equalsIgnoreCase("invalidSymbols")) {
			parametersMap.clear();
			parametersMap.put("base", propreader.getGlobalValue("invalidValue"));
			parametersMap.put("symbols", propreader.getGlobalValue("invalidValue"));
			res.queryParams(parametersMap);
			return res;
		}
		else if(symbols.equalsIgnoreCase("blankSymbols")) {
			parametersMap.clear();
			parametersMap.put("base", propreader.getGlobalValue("invalidValue"));
			parametersMap.put("symbols","");
			res.queryParams(parametersMap);
			return res;
		}
		return res;
		
	}
	else return res;
}
}
