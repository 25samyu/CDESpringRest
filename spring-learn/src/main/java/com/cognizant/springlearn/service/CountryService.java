package com.cognizant.springlearn.service;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
@Service
public class CountryService {
	public Country getCountry(String code) throws CountryNotFoundException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> countries = context.getBean("countryList", ArrayList.class);
		Country matchedCountry = null;
		try {
		matchedCountry =  countries.stream()
						.filter(country->country.getCode().equalsIgnoreCase(code))
						.findFirst().get();
		}catch(NoSuchElementException e) {
			throw new CountryNotFoundException();
		}
		return matchedCountry;
		
	}
			

}
