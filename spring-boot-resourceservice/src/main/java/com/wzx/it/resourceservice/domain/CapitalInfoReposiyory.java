package com.wzx.it.resourceservice.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CapitalInfoReposiyory extends JpaRepository<CapitalInfo,String> {

    @Transactional
    public void deleteCapitalInfoByIdIn(List<Integer> ids);

    public List<CapitalInfo> getCapitalInfosByEmpId(Integer empId);
}
