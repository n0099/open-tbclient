package com.yy.gslbsdk.protocol;

import java.util.LinkedList;
/* loaded from: classes7.dex */
public class UpdateServerInfo {
    public LinkedList<String> ips = new LinkedList<>();
    public int isp;
    public int ver;

    public LinkedList<String> getIps() {
        return this.ips;
    }

    public int getIsp() {
        return this.isp;
    }

    public int getVer() {
        return this.ver;
    }

    public void setIps(LinkedList<String> linkedList) {
        this.ips = linkedList;
    }

    public void setIsp(int i2) {
        this.isp = i2;
    }

    public void setVer(int i2) {
        this.ver = i2;
    }
}
