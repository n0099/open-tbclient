package com.coloros.mcssdk.e;
/* loaded from: classes2.dex */
public abstract class c {
    String appPackage;
    int hMQ;
    String hMR;

    public String bJc() {
        return this.hMR;
    }

    public int bJd() {
        return this.hMQ;
    }

    public String getAppPackage() {
        return this.appPackage;
    }

    public abstract int getType();

    public void setAppPackage(String str) {
        this.appPackage = str;
    }

    public void uK(String str) {
        this.hMR = str;
    }

    public void xX(int i) {
        this.hMQ = i;
    }
}
