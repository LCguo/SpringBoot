package com.mine.springboot;

import com.mine.springboot.module.test.service.ITestService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootApplicationTests {

	@Autowired
	ITestService testService;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Test
	void contextLoads() {
		logger.info("```````````````````````````"+testService.testReturnString());
	}

}
