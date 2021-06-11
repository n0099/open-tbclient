package com.yy.gslbsdk.protocol;

import com.yy.gslbsdk.device.NetStatusInfo;
import java.util.HashMap;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class ReportInfo {
    public LinkedList<HijackInfo> hijack;
    public HashMap<String, StatsInfo> stats1;
    public HashMap<String, StatsInfo> stats15;
    public String host = null;
    public String view = null;
    public NetStatusInfo netInfo = null;
    public StatsInfo stats0 = null;
    public int ct = -1;
    public int tt = -1;
    public int fc = -1;
    public int lc = -1;

    public ReportInfo() {
        this.stats1 = null;
        this.stats15 = null;
        this.hijack = null;
        this.stats1 = new HashMap<>();
        this.stats15 = new HashMap<>();
        this.hijack = new LinkedList<>();
    }

    public int getCt() {
        return this.ct;
    }

    public int getFc() {
        return this.fc;
    }

    public LinkedList<HijackInfo> getHijack() {
        return this.hijack;
    }

    public String getHost() {
        return this.host;
    }

    public int getLc() {
        return this.lc;
    }

    public NetStatusInfo getNetInfo() {
        return this.netInfo;
    }

    public StatsInfo getStats0() {
        return this.stats0;
    }

    public HashMap<String, StatsInfo> getStats1() {
        return this.stats1;
    }

    public HashMap<String, StatsInfo> getStats15() {
        return this.stats15;
    }

    public int getTt() {
        return this.tt;
    }

    public String getView() {
        return this.view;
    }

    public void setCt(int i2) {
        this.ct = i2;
    }

    public void setFc(int i2) {
        this.fc = i2;
    }

    public void setHijack(LinkedList<HijackInfo> linkedList) {
        this.hijack = linkedList;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public void setLc(int i2) {
        this.lc = i2;
    }

    public void setNetInfo(NetStatusInfo netStatusInfo) {
        this.netInfo = netStatusInfo;
    }

    public void setStats0(StatsInfo statsInfo) {
        this.stats0 = statsInfo;
    }

    public void setStats1(HashMap<String, StatsInfo> hashMap) {
        this.stats1 = hashMap;
    }

    public void setStats15(HashMap<String, StatsInfo> hashMap) {
        this.stats15 = hashMap;
    }

    public void setTt(int i2) {
        this.tt = i2;
    }

    public void setView(String str) {
        this.view = str;
    }
}
