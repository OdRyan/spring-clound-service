package com.wzx.it.securityservice.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface LogInfoRepository extends JpaRepository<LogInfo,Integer> {
    @Transactional
    void deleteLogInfoByIdIn(List<Integer> ids);

}
