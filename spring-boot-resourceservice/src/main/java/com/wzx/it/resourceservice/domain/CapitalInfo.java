package com.wzx.it.resourceservice.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_capital")
@GenericGenerator(name = "system-uuid",strategy = "uuid")
public class CapitalInfo {
    @Id
    @GeneratedValue(generator = "system-uuid")
    private String id;
    @Column(name = "emp_id")
    private Integer empId;
    @Column(name = "account_num")
    private String accountNum;
    @Column(name = "credit_rate")
    private String creditRate;
    @Column(name = "is_use")
    private Integer isUser;
}
