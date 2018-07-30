package com.coloros.mcssdk.e;
/* loaded from: classes3.dex */
public abstract class c {
    String appPackage;
    int hEa;
    String hEb;

    public String bJC() {
        return this.hEb;
    }

    public String bJD() {
        return this.appPackage;
    }

    public int getMessageID() {
        return this.hEa;
    }

    public abstract int getType();

    public void vU(int i) {
        this.hEa = i;
    }

    public void wv(String str) {
        this.hEb = str;
    }

    public void ww(String str) {
        this.appPackage = str;
    }
}
