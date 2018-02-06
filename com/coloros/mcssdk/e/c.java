package com.coloros.mcssdk.e;
/* loaded from: classes2.dex */
public abstract class c {
    String appPackage;
    int hOI;
    String hOJ;

    public String bJR() {
        return this.hOJ;
    }

    public String getAppPackage() {
        return this.appPackage;
    }

    public int getMessageID() {
        return this.hOI;
    }

    public abstract int getType();

    public void setAppPackage(String str) {
        this.appPackage = str;
    }

    public void uX(String str) {
        this.hOJ = str;
    }

    public void xW(int i) {
        this.hOI = i;
    }
}
