package com.example.entity;

import com.example.utils.StringUtil;

import javax.swing.*;

public class ValidReturn {
    /** 规则id*/
    private String id;
    /** 返回代码*/
    private String code;
    /** 返回信息*/
    private String msg;


    public ValidReturn(String id, String msg) {
        this.id = id;
        this.msg = msg;
    }
    public ValidReturn(String id, String code, String msg) {
        this.id = id;
        this.code = code;
        this.msg = msg;
    }

    /**
     *
     * @param id
     * @param code
     * @param msg
     * @return
     */
    public static ValidReturn success(String id, String code, String msg) {
        return new ValidReturn(id, code, msg);
    }

    public static ValidReturn fail(String id, String code, String msg) {
        return new ValidReturn(id, code, msg);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "ValidReturn{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
