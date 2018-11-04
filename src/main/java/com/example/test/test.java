package com.example.test;

import com.example.annotation.DateValidate;
import com.example.annotation.StringValidate;

import java.util.Date;

public class test {
    @StringValidate()
    private String uuid;
    @StringValidate()
    private String userName;
    @StringValidate()
    private String password;
    @DateValidate()
    private Date inputDate;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }
}
