package com.coloros.mcssdk.e;
/* loaded from: classes2.dex */
public abstract class c {
    String appPackage;
    int hOv;
    String hOw;

    public String bJQ() {
        return this.hOw;
    }

    public String getAppPackage() {
        return this.appPackage;
    }

    public int getMessageID() {
        return this.hOv;
    }

    public abstract int getType();

    public void setAppPackage(String str) {
        this.appPackage = str;
    }

    public void uX(String str) {
        this.hOw = str;
    }

    public void xX(int i) {
        this.hOv = i;
    }
}
