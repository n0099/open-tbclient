package com.coloros.mcssdk.e;
/* loaded from: classes3.dex */
public abstract class c {
    String appPackage;
    int hEc;
    String hEd;

    public String bJG() {
        return this.hEd;
    }

    public String bJH() {
        return this.appPackage;
    }

    public int getMessageID() {
        return this.hEc;
    }

    public abstract int getType();

    public void vU(int i) {
        this.hEc = i;
    }

    public void wA(String str) {
        this.appPackage = str;
    }

    public void wz(String str) {
        this.hEd = str;
    }
}
