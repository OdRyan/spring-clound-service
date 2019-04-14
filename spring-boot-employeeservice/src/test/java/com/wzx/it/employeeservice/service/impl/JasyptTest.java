package com.wzx.it.employeeservice.service.impl;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JasyptTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(JasyptTest.class);

    @Autowired
    StringEncryptor stringEncryptor;

    @Test
    public void encryptUser() {
        String encrypt = stringEncryptor.encrypt("root");
        LOGGER.info("加密user："+encrypt);
    }

    @Test
    public void encryptPwd() {
        String encrypt = stringEncryptor.encrypt("Huawei123456@");
        LOGGER.info("加密pwd："+encrypt);
    }

    @Test
    public void decryptUser() {
        String decrypt = stringEncryptor.decrypt("gVDnw9TVsSJcMGU/HggdIA==");
        LOGGER.info("解密user："+decrypt);
    }

    @Test
    public void decryptPwd() {
        String decrypt = stringEncryptor.decrypt("b3JWmCnp+WWZZ9VFMSKE1hU3T5JYZgWm");
        LOGGER.info("解密pwd："+decrypt);
    }
}
