package com.wzx.it.securityservice.service.impl;

import com.wzx.it.securityservice.domain.LogInfo;
import com.wzx.it.securityservice.domain.LogInfoRepository;
import com.wzx.it.securityservice.service.ILogInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogInfoServiceImpl implements ILogInfoService {
    @Autowired private LogInfoRepository logInfoRepository;

    @Override
    public void delLogInfoByIds(List<Integer> ids) {
        logInfoRepository.deleteLogInfoByIdIn(ids);
    }

    @Override
    public List<LogInfo> getLogInfos() {
        return logInfoRepository.findAll(new Sort(Sort.Direction.DESC,"id"));
    }
}
