package com.coloros.mcssdk.e;
/* loaded from: classes2.dex */
public abstract class c {
    String appPackage;
    int hNk;
    String hNl;

    public String bJe() {
        return this.hNl;
    }

    public int bJf() {
        return this.hNk;
    }

    public String getAppPackage() {
        return this.appPackage;
    }

    public abstract int getType();

    public void setAppPackage(String str) {
        this.appPackage = str;
    }

    public void uR(String str) {
        this.hNl = str;
    }

    public void xX(int i) {
        this.hNk = i;
    }
}
