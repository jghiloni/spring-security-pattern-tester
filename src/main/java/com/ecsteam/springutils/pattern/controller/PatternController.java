package com.ecsteam.springutils.pattern.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecsteam.springutils.pattern.model.PatternRequest;
import com.ecsteam.springutils.pattern.model.PatternResponse;
import com.ecsteam.springutils.pattern.model.PatternType;

/**
 * 
 * @author Josh Ghiloni <jghiloni@ecsteam.com>
 */
@RestController
public class PatternController {
	@RequestMapping(value = "/alive", method = RequestMethod.HEAD)
	public void isAlive() {
		return;
	}

	/**
	 * Will determine if a given URI matches a specified pattern, either in ant or regex format
	 * 
	 * @param request The JSON from the client, deserialized
	 * @return The original request, plus an execution timestamp and whether or not the request matched
	 */
	@RequestMapping(value = "/testpattern", method = RequestMethod.POST)
	public PatternResponse testPattern(@RequestBody PatternRequest request) {
		Assert.notNull(request);
		PatternResponse response = new PatternResponse(request);

		RequestMatcher matcher = getRequestMatcher(request);

		HttpServletRequest httpRequest = new PatternServletRequest(request.getTestUri());

		response.setMatched(matcher.matches(httpRequest));
		response.setTimestamp(System.currentTimeMillis());
		return response;
	}

	/**
	 * Build a Spring Security {@link RequestMatcher} from the request
	 * 
	 * @param request
	 * @return
	 */
	private RequestMatcher getRequestMatcher(PatternRequest request) {
		RequestMatcher matcher = null;

		Assert.notNull(request.getPattern());
		Assert.notNull(request.getType());

		PatternType type = PatternType.valueOf(request.getType());

		if (type == PatternType.ANT) {
			matcher = new AntPathRequestMatcher(request.getPattern());
		}
		else if (type == PatternType.REGEX) {
			matcher = new RegexRequestMatcher(request.getPattern(), null);
		}
		else {
			throw new IllegalArgumentException();
		}

		return matcher;
	}
}
