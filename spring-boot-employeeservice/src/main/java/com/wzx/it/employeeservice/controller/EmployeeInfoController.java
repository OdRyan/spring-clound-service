package com.wzx.it.employeeservice.controller;

import com.wzx.it.employeeservice.domain.EmployeeInfo;
import com.wzx.it.employeeservice.service.impl.EmployeeInfoServiceImpl;
import com.wzx.it.employeeservice.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
@ResponseBody
public class EmployeeInfoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeInfoController.class);

    @Autowired private EmployeeInfoServiceImpl employeeInfoService;

    @RequestMapping(value = "/getEmpInfos",method = RequestMethod.GET)
    public String getEmpInfos(){
        LOGGER.info("查询人员信息begin");
        try {
            List<EmployeeInfo> result = employeeInfoService.getEmpInfos();
            LOGGER.info("查询人员信息begin");
            return JsonUtils.success(result);
        } catch (Exception e) {
            LOGGER.info(e.getMessage(),e);
            return JsonUtils.fail(e.getMessage());
        }
    }
}
