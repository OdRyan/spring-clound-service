package com.wzx.it.resourceservice.controller;

import com.wzx.it.resourceservice.domain.CapitalInfo;
import com.wzx.it.resourceservice.service.impl.CapitalInfoSerciceImpl;
import com.wzx.it.resourceservice.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/capital")
@ResponseBody
public class CapitalController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CapitalController.class);

    @Autowired private CapitalInfoSerciceImpl capitalInfoSercice;

    @RequestMapping(value = "/getCapitals",method = RequestMethod.GET)
    public String getCapitalInfos(){
        try {
            LOGGER.info("查询所有人员的资产begin");
            List<CapitalInfo> capitalInfos = capitalInfoSercice.getCapitalInfos();
            LOGGER.info("查询所有人员的资产end");
            return JsonUtils.success(capitalInfos);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(),e);
            return JsonUtils.fail(e.getMessage());
        }
    }

    @RequestMapping(value = "/getCapitalByEmpId",method = RequestMethod.GET)
    public String getCapitalByEmpId(@RequestParam(value = "empId",required = true) Integer empId){
        try {
            LOGGER.info("根据人员id查询资产begin");
            List<CapitalInfo> capitalInfos = capitalInfoSercice.getCapitalByEmpId(empId);
            LOGGER.info("根据人员id查询资产end");
            return JsonUtils.success(capitalInfos);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(),e);
            return JsonUtils.fail(e.getMessage());
        }
    }
}
