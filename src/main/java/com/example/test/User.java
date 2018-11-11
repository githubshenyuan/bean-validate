package com.example.test;

import com.example.annotation.DateValidate;
import com.example.annotation.StringValidate;
import com.example.annotation.Validate;

import java.util.Date;

/**
 * @author sh_home on 2018/11/10 13:44
 * @version ideaIU-2018.2.3.win
 */
@Validate
public class User {
    @StringValidate()
    private String uuid;
    @StringValidate(id = "uaername", minLength = 8,minLengthMsg = "长度不能大于 8"
            ,maxLength = 12,maxLengthMsg = "长度不能大于20",code = "fail",msg = "userName 校验失败")
    private String userName;
    @StringValidate()
    private String password;
    @DateValidate()
    private Date date;
    @StringValidate
    private String inputDate;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }
}
