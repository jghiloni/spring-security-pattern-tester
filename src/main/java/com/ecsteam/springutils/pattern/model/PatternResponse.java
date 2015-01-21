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
