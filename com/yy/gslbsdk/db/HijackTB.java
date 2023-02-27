package com.yy.gslbsdk.db;

import java.io.Serializable;
/* loaded from: classes8.dex */
public class HijackTB implements Serializable {
    public static final String DNSIP = "dnsip";
    public static final String HIP = "hip";
    public static final String HOST = "host";
    public static final String ID = "_id";
    public static final String NT = "nt";
    public static final String UIP = "uip";
    public static final long serialVersionUID = 1349183969932437646L;
    public int id = -1;
    public String host = null;
    public int nt = -1;
    public String uip = null;
    public String dnsip = null;
    public String hip = null;

    public String getDnsip() {
        return this.dnsip;
    }

    public String getHip() {
        return this.hip;
    }

    public String getHost() {
        return this.host;
    }

    public int getId() {
        return this.id;
    }

    public int getNt() {
        return this.nt;
    }

    public String getUip() {
        return this.uip;
    }

    public void setDnsip(String str) {
        this.dnsip = str;
    }

    public void setHip(String str) {
        this.hip = str;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setNt(int i) {
        this.nt = i;
    }

    public void setUip(String str) {
        this.uip = str;
    }
}
