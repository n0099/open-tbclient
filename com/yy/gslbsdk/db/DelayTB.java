package com.yy.gslbsdk.db;

import java.io.Serializable;
/* loaded from: classes7.dex */
public class DelayTB implements Serializable {
    public static final String DELAY = "delay";
    public static final String HOST = "host";
    public static final String ID = "_id";
    public static final String IP = "ip";
    public static final long serialVersionUID = 1349183969932437646L;
    public int id = -1;
    public String host = null;
    public String ip = null;
    public long delay = -1;

    public long getDelay() {
        return this.delay;
    }

    public String getHost() {
        return this.host;
    }

    public int getId() {
        return this.id;
    }

    public String getIp() {
        return this.ip;
    }

    public void setDelay(long j) {
        this.delay = j;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public void setIp(String str) {
        this.ip = str;
    }
}
