package com.example.entity;

public class RuleEntity {
    private String id;
    private String superId;
    private int maxLength = -1;
    private String maxLengthMsg;
    private int minLength = -1;
    private String minLengthMsg;
    private String dateFormat;
    private String dateFormatMsg;

    private String code;
    private String msg;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSuperId() {
        return superId;
    }

    public void setSuperId(String superId) {
        this.superId = superId;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public int getMinLength() {
        return minLength;
    }

    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getMaxLengthMsg() {
        return maxLengthMsg;
    }

    public void setMaxLengthMsg(String maxLengthMsg) {
        this.maxLengthMsg = maxLengthMsg;
    }

    public String getMinLengthMsg() {
        return minLengthMsg;
    }

    public void setMinLengthMsg(String minLengthMsg) {
        this.minLengthMsg = minLengthMsg;
    }

    public String getDateFormatMsg() {
        return dateFormatMsg;
    }

    public void setDateFormatMsg(String dateFormatMsg) {
        this.dateFormatMsg = dateFormatMsg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
