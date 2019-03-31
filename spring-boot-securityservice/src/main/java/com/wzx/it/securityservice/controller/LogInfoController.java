package com.wzx.it.securityservice.controller;

import com.wzx.it.securityservice.service.impl.LogInfoServiceImpl;
import com.wzx.it.securityservice.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logInfo")
@ResponseBody
public class LogInfoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogInfoController.class);

    @Autowired private LogInfoServiceImpl logInfoService;

    @RequestMapping(value = "/delLog",method = RequestMethod.DELETE)
    public String delLogInfoByids(@RequestParam(value = "ids",required = true) List<Integer> ids){
        try {
            if(ids.isEmpty()){
                return JsonUtils.fail("下发参数为空");
            } else {
                LOGGER.info("删除日志信息begin");
                logInfoService.delLogInfoByIds(ids);
                LOGGER.info("删除日志信息end");
                return JsonUtils.success();
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(),e);
            return JsonUtils.fail(e.getMessage());
        }
    }
}
