package com.yy.gslbsdk.protocol;

import java.util.LinkedList;
/* loaded from: classes10.dex */
public class StatsInfo {
    public LinkedList<long[]> its;
    public String sip;

    public StatsInfo() {
        LinkedList<long[]> linkedList = new LinkedList<>();
        this.its = linkedList;
        linkedList.add(new long[]{0, 0, 0});
        this.its.add(new long[]{0, 0, 0});
        this.its.add(new long[]{0, 0, 0});
        this.its.add(new long[]{0, 0, 0});
        this.its.add(new long[]{0, 0, 0});
    }

    public LinkedList<long[]> getIts() {
        return this.its;
    }

    public String getSip() {
        return this.sip;
    }

    public void setIts(LinkedList<long[]> linkedList) {
        this.its = linkedList;
    }

    public void setSip(String str) {
        this.sip = str;
    }
}
