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

/**
 * Adds timestamp and match success information to a given {@link PatternRequest}
 * 
 * @author Josh Ghiloni
 *
 */
public class PatternResponse extends PatternRequest {
	private long timestamp;

	private boolean matched;

	public PatternResponse(PatternRequest request) {
		setPattern(request.getPattern());
		setTestUri(request.getTestUri());
		setType(request.getType());
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public boolean isMatched() {
		return matched;
	}

	public void setMatched(boolean matched) {
		this.matched = matched;
	}
}
