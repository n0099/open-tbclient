package com.coloros.mcssdk.e;
/* loaded from: classes2.dex */
public abstract class c {
    String appPackage;
    int hXg;
    String hXh;

    public int bPA() {
        return this.hXg;
    }

    public String bPz() {
        return this.hXh;
    }

    public String getAppPackage() {
        return this.appPackage;
    }

    public abstract int getType();

    public void setAppPackage(String str) {
        this.appPackage = str;
    }

    public void vp(String str) {
        this.hXh = str;
    }

    public void zu(int i) {
        this.hXg = i;
    }
}
