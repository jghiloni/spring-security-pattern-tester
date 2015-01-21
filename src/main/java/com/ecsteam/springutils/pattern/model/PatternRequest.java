package com.ecsteam.springutils.pattern.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Represents all the information necessary to test a URI against a given expression
 * 
 * @author Josh Ghiloni
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PatternRequest {
	private String pattern;

	private String type;

	private String testUri;

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getTestUri() {
		return testUri;
	}

	public void setTestUri(String testUri) {
		this.testUri = testUri;
	}

	public String getType() {
		return type.toString();
	}

	public void setType(String type) {
		this.type = type;
	}
}
