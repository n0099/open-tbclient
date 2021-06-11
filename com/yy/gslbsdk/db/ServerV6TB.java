package com.yy.gslbsdk.db;

import java.io.Serializable;
/* loaded from: classes7.dex */
public class ServerV6TB implements Serializable {
    public static final String ID = "_id";
    public static final String IP = "ip";
    public static final String ISP = "isp";
    public static final String VER = "ver";
    public static final long serialVersionUID = 5363924125145918963L;
    public int id = -1;
    public int isp = -1;
    public String ip = null;
    public int ver = -1;

    public int getId() {
        return this.id;
    }

    public String getIp() {
        return this.ip;
    }

    public int getIsp() {
        return this.isp;
    }

    public int getVer() {
        return this.ver;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public void setIp(String str) {
        this.ip = str;
    }

    public void setIsp(int i2) {
        this.isp = i2;
    }

    public void setVer(int i2) {
        this.ver = i2;
    }

    public String toString() {
        return this.ip + "-" + this.isp + "-" + this.ver;
    }
}
