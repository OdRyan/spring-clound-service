package com.wzx.it.resourceservice.service;

import com.wzx.it.resourceservice.domain.CapitalInfo;

import java.util.List;

public interface ICapitalInfoService {
    public List<CapitalInfo> getCapitalInfos();

    public List<CapitalInfo> getCapitalByEmpId(Integer empId);
}
