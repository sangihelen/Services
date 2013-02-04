package com.climate.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.climate.command.DisplayLocation;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 * This is the Util Class.
 * @author sangi
 *
 */
@Service
public class ControlerUtil {
	
	public static final String urlName = "http://api.wunderground.com/api/ed044d75b91fb500/conditions/q/94117.json";
	
	public  Map<String,DisplayLocation> dispLocationList = new HashMap<String,DisplayLocation>();
	
	/**
	 * Constructor for the ControlerUtil.
	 */
	public ControlerUtil() throws Exception {
		// Generates the Json String.
		String jsonString = generateJsonString(getJsonFileStreamFromURL(null));
		//Generates the Display Location from the Json String.
		setDispLocationList(generateJsonValueObj(generateJsonObject(jsonString)));
	}
	
	/**
	 * This method generates the InputStream from the provided URL.
	 * @param url
	 * @return InputStream
	 * @throws Exception
	 */
	private  InputStream getJsonFileStreamFromURL( String url) throws Exception {
		
		try {
		
		URL urlObj = new URL(urlName);
		InputStream urlInputStream = urlObj.openConnection().getInputStream();
		return urlInputStream;
		}
		catch(MalformedURLException mal) {
			throw new Exception("Url Access Error");
		}
	}
	
	/**
	 * This method generate the Json String from the InputStream.
	 * @param urlInputStream
	 * @return String
	 * @throws Exception
	 */
	private  String generateJsonString(InputStream urlInputStream) throws Exception {
	    StringBuilder responseStrBuilder = new StringBuilder();

		try 
		 {
		 BufferedReader streamReader = new BufferedReader(new InputStreamReader(urlInputStream, "UTF-8")); 
		
		    String inputStr;
		    while ((inputStr = streamReader.readLine()) != null)
		        responseStrBuilder.append(inputStr);
	 }
	 catch(UnsupportedEncodingException unSuppor) {
		 throw new Exception("Json File is not right format");
	 }
	 catch(IOException io) {
		 throw new Exception("Error Reading Json File");
		 
	 }
		    return responseStrBuilder.toString();
		    
	}
	
	/**
	 * This method will returns the JSON Object for the given String.
	 * @param jsonObj
	 * @return json
	 */
	private JSONObject generateJsonObject(String jsonObj) throws Exception {
		
		try 
		{
		JSONObject json = (JSONObject) JSONSerializer.toJSON(jsonObj);
		return json;
		}
		catch(Exception jsonParseExcep) {
			throw new Exception("Json Parsing Exception");
		}
		
	}
	
	/**
	 * This method generates the DisplayLocation List from the Json Value Object.
	 * @param json
	 * @return dispLocationList
	 */
	private  Map<String, DisplayLocation> generateJsonValueObj(JSONObject json) {
		
			
		
		   JSONObject currentObserOBJ = (JSONObject) json.get("current_observation");
		    JSONArray displayLocs = (JSONArray.fromObject(currentObserOBJ.get("display_location"))) ;
		   
		    Iterator<JSONObject> itr = displayLocs.iterator();	
		    
		    while( itr.hasNext()) {
		    	JSONObject dispLoc = itr.next();
		    	
		    	dispLocationList.put((String)dispLoc.get("zip"),
	    				new DisplayLocation((String)dispLoc.get("city"),
				    			(String)dispLoc.get("state"),
				    			(String) dispLoc.get("country"), 
				    			(String)dispLoc.get("zip"), 
				    			(String) ((Double)currentObserOBJ.get("temp_f")).toString(), 
				    			(String) ((Double) currentObserOBJ.get("temp_c")).toString()));
		    	
		    	System.out.println((String)dispLoc.get("zip"));
		    }
		    return dispLocationList;
		
	}

	/**
	 * This method will returns TRUE if zipCode
	 * is present.
	 * @param zipCode
	 * @return
	 */
	public boolean zipCodeCheck(String zipCode) {
		
		return dispLocationList.containsKey(zipCode);
		
	}
	
	/**
	 * This method returns the corresponding DisplayLocation Object
	 * for the given ZipCode.
	 * 
	 * @param zipCode
	 * @return
	 */
	public DisplayLocation getLocationObj(String zipCode) {
		
		if (dispLocationList.containsKey(zipCode)) {
			
			return dispLocationList.get(zipCode);
		}
		else {
			return null;
		}
	}

	
	/**
	 * This method gets the Display Location.
	 * @return dispLocationList
	 */
	public Map<String, DisplayLocation> getDispLocationList() {
		return dispLocationList;
	}

	/**
	 * This method sets the Display Location.
	 * @param dispLocationList
	 */
	public void setDispLocationList(Map<String, DisplayLocation> dispLocationList) {
		this.dispLocationList = dispLocationList;
	}

	
	
}
