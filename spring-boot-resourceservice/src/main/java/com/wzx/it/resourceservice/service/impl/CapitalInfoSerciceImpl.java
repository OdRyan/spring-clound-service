package com.wzx.it.resourceservice.service.impl;

import com.wzx.it.resourceservice.domain.CapitalInfo;
import com.wzx.it.resourceservice.domain.CapitalInfoReposiyory;
import com.wzx.it.resourceservice.service.ICapitalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CapitalInfoSerciceImpl implements ICapitalInfoService {

    @Autowired private CapitalInfoReposiyory capitalInfoReposiyory;

    @Override
    public List<CapitalInfo> getCapitalInfos() {
        return capitalInfoReposiyory.findAll(new Sort(Sort.Direction.DESC, "id"));
    }

    @Override
    public List<CapitalInfo> getCapitalByEmpId(Integer empId) {
        return capitalInfoReposiyory.getCapitalInfosByEmpId(empId);
    }
}
