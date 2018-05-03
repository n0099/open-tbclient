package com.coloros.mcssdk.e;
/* loaded from: classes3.dex */
public abstract class c {
    String appPackage;
    int hmo;
    String hmp;

    public String bFv() {
        return this.hmp;
    }

    public String getAppPackage() {
        return this.appPackage;
    }

    public int getMessageID() {
        return this.hmo;
    }

    public abstract int getType();

    public void setAppPackage(String str) {
        this.appPackage = str;
    }

    public void vA(String str) {
        this.hmp = str;
    }

    public void vx(int i) {
        this.hmo = i;
    }
}
