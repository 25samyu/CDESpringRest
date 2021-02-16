package com.cognizant.springlearn.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.SpringLearnApplication;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
public class CountryController {
	private static Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	@Autowired
	CountryService countryService;

	@RequestMapping(value="/country",method=RequestMethod.GET)
	public Country getCountryIndia() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country India = context.getBean("in",Country.class);
		return India;
	}
	
	@RequestMapping(value="/countries",method=RequestMethod.GET)
	public List getAllCountries() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList countries = context.getBean("countryList",ArrayList.class);
		return countries;
	}
	
	@RequestMapping(value="/country/{code}",method=RequestMethod.GET)
	public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
		Country country = countryService.getCountry(code);
		return country;
	}
	
	public CountryController() {
		LOGGER.debug("Inside Country Controller Constructor");
	}
}
