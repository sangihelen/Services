package com.climate.services;

import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.climate.command.ClimateService;
import com.climate.command.DisplayLocation;
import com.climate.util.ControlerUtil;


/**
 * This Class Validates the given ZipCode and generates the
 * Climate details for the given ZipCode.
 * @author sangi
 *
 */

@Controller
public class ClimateServiceController {
	
	
	/**
	 * Instance variable for the Controller Util.
	 */
	@Autowired
	ControlerUtil controlerUtil;

	private static final Logger logger = LoggerFactory.getLogger(ClimateServiceController.class);
	
	@RequestMapping(value = "/zipcode.check", method = RequestMethod.POST)
	  public String getForm(@Valid ClimateService climateService, BindingResult result, ModelMap model) { 
		
		if (result.hasErrors()) {
			
			return "climateform";
		} else {
			if (!(getControlerUtil().zipCodeCheck(climateService.getZipcode())) ) {
				
				result.reject("ZipCodeNotFound", "Given Zip Code Not Found");
				return "climateform";
			}
			else {
				DisplayLocation displayLocation = getControlerUtil().getLocationObj(climateService.getZipcode());
				model.addAttribute("displayLocation", displayLocation);
				return "climatedetails";
			}
		}
	 
	}
	
	
	@RequestMapping(value="/climateform.check" , method = RequestMethod.GET)
	public String displayCustomerForm(ModelMap model) {

		model.addAttribute("climateService", new ClimateService());
		return "climateform";

	}
	

	/**
	 * This method will get the Controler Util Instance.
	 * @return controlerUtil
	 */
	public ControlerUtil getControlerUtil() {
		return controlerUtil;
	}

	/**
	 * This method will set the Co
	 * @param controlerUtil
	 */
	public void setControlerUtil(ControlerUtil controlerUtil) {
		this.controlerUtil = controlerUtil;
	}

	
	
}
