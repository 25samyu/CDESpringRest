package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cognizant.springlearn.SpringLearnApplication;

public class Country {
	private static Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

private String code;
private String name;
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Country() {
	LOGGER.debug("Inside Country Constructor");
}
@Override
public String toString() {
	return "Country [code=" + code + ", name=" + name + "]";
}
}
