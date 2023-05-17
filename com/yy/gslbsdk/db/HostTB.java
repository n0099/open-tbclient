package com.yy.gslbsdk.db;

import java.io.Serializable;
/* loaded from: classes10.dex */
public class HostTB implements Serializable {
    public static final String HOST = "host";
    public static final String ID = "_id";
    public static final String INSERTTIME = "insert_time";
    public static final String ISPRE = "is_pre";
    public static final long serialVersionUID = -2142662150610590774L;
    public int id = -1;
    public String host = null;
    public int isPre = -1;
    public long insertTime = -1;

    public String getHost() {
        return this.host;
    }

    public int getId() {
        return this.id;
    }

    public long getInsertTime() {
        return this.insertTime;
    }

    public int getIsPre() {
        return this.isPre;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setInsertTime(long j) {
        this.insertTime = j;
    }

    public void setIsPre(int i) {
        this.isPre = i;
    }
}
