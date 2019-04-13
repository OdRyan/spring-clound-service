package com.wzx.it.employeeservice.cache;

import com.wzx.it.employeeservice.domain.EmployeeInfo;
import com.wzx.it.employeeservice.domain.EmployeeInfoRepository;
import lombok.Synchronized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class EmployeeCache {

    private static Map<Integer, EmployeeInfo> employeeInfoMap = new HashMap<>();

    @Autowired
    private EmployeeInfoRepository employeeInfoRepository;

    @Synchronized
    public void syncEmployee() {
        List<EmployeeInfo> employeeInfos = employeeInfoRepository.findAll();
        for (int i = 0; i < employeeInfos.size(); i++) {
            EmployeeInfo employeeInfo = employeeInfos.get(i);
            employeeInfoMap.put(employeeInfo.getId(), employeeInfo);
        }
    }

    public List<EmployeeInfo> getAllEmployeesByCache() {
        List<EmployeeInfo> employeeInfos = new ArrayList<>();
        if (employeeInfoMap.isEmpty()) {
            employeeInfos = employeeInfoRepository.findAll();
        } else {
            for (Integer empId : employeeInfoMap.keySet()) {
                employeeInfos.add(employeeInfoMap.get(empId));
            }
        }
        return employeeInfos;
    }

    public EmployeeInfo getEmployeesByCache(Integer empId) {
        EmployeeInfo employeeInfo = employeeInfoMap.get(empId);
        if (employeeInfo == null) {
            return employeeInfoRepository.findEmployeeInfoById(empId);
        }
        return employeeInfo;
    }
}
