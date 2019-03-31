package com.wzx.it.securityservice.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "t_log_info")
public class LogInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "operator")
    private String operator;
    @Column(name = "ip_addr")
    private String ipAddr;
    @Column(name = "operator_method")
    private String operatorMethod;
    @Column(name = "content")
    private String content;
    @Column(name = "operator_time")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date operatorTime;
}
