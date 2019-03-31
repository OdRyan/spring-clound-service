package com.wzx.it.securityservice.service;

import com.wzx.it.securityservice.domain.LogInfo;

import java.util.List;

public interface ILogInfoService {
    void delLogInfoByIds(List<Integer> ids);

    public List<LogInfo> getLogInfos();

}
