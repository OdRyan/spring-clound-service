package com.wzx.it.employeeservice.service.impl;

import com.wzx.it.employeeservice.domain.EmployeeInfo;
import com.wzx.it.employeeservice.domain.EmployeeInfoRepository;
import com.wzx.it.employeeservice.service.IEmployeeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeInfoServiceImpl implements IEmployeeInfoService {

    @Autowired private EmployeeInfoRepository employeeInfoRepository;

    @Override
    public List<EmployeeInfo> getEmpInfos() {
        return  employeeInfoRepository.findAll(new Sort(Sort.Direction.DESC, "id"));
    }
}
