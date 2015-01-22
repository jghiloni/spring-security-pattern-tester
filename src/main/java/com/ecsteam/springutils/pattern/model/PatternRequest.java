/**************************************************************************
 * Copyright 2015 ECS Team, Inc.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **************************************************************************/
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
