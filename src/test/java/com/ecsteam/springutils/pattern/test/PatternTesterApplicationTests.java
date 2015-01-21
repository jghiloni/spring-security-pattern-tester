package com.ecsteam.springutils.pattern.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ecsteam.springutils.pattern.PatternTesterApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PatternTesterApplication.class)
@WebAppConfiguration
public class PatternTesterApplicationTests {

	@Test
	public void contextLoads() {
	}

}
