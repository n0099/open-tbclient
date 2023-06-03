package com.yy.gslbsdk.db;

import java.io.Serializable;
/* loaded from: classes10.dex */
public class ResultTB implements Serializable, Cloneable {
    public static final String CMD = "cmd";
    public static final String ENDTIME = "end_time";
    public static final String HOST = "host";
    public static final String ID = "_id";
    public static final String IP = "ip";
    public static final String NETWORK = "network";
    public static final String SOURCE = "src";
    public static final String TTL = "ttl";
    public static final String UIP = "uip";
    public static final String UPDATETIME = "update_time";
    public static final String VIEW = "_view";
    public static final long serialVersionUID = -3157206435418951459L;
    public int id = -1;
    public String network = null;
    public String host = null;
    public String ip = null;
    public int ttl = -1;
    public long endTime = -1;
    public String cmd = null;
    public long updateTime = -1;

    /* renamed from: view  reason: collision with root package name */
    public String f1231view = null;
    public String uip = null;
    public int source = 0;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getCmd() {
        return this.cmd;
    }

    public long getEndTime() {
        return this.endTime;
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

    public String getNetwork() {
        return this.network;
    }

    public int getSource() {
        return this.source;
    }

    public int getTtl() {
        return this.ttl;
    }

    public String getUip() {
        return this.uip;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public String getView() {
        return this.f1231view;
    }

    public void setCmd(String str) {
        this.cmd = str;
    }

    public void setEndTime(long j) {
        this.endTime = j;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setIp(String str) {
        this.ip = str;
    }

    public void setNetwork(String str) {
        this.network = str;
    }

    public void setSource(int i) {
        this.source = i;
    }

    public void setTtl(int i) {
        this.ttl = i;
    }

    public void setUip(String str) {
        this.uip = str;
    }

    public void setUpdateTime(long j) {
        this.updateTime = j;
    }

    public void setView(String str) {
        this.f1231view = str;
    }
}
