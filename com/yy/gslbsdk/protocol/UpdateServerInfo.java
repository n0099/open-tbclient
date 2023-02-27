package com.yy.gslbsdk.protocol;

import java.util.LinkedList;
/* loaded from: classes8.dex */
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

    public void setIsp(int i) {
        this.isp = i;
    }

    public void setVer(int i) {
        this.ver = i;
    }
}
