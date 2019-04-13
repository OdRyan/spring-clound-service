package com.wzx.it.employeeservice;

import com.wzx.it.employeeservice.cache.EmployeeCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class EmployeeRunner implements ApplicationRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeRunner.class);

    @Autowired
    private EmployeeCache employeeCache;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOGGER.info("employeeCache begin*****");
        employeeCache.syncEmployee();
        LOGGER.info("employeeCache end*****");
    }
}
