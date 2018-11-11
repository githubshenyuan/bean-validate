package com.example.test;

import com.example.annotation.StringValidate;

/**
 * @author sh_home on 2018/11/11 22:27
 * @version ideaIU-2018.2.3.win
 */
public class Grade {
    private String uuid;
    @StringValidate
    private String name;
    private int mun;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMun() {
        return mun;
    }

    public void setMun(int mun) {
        this.mun = mun;
    }
}
