package com.coloros.mcssdk.e;
/* loaded from: classes3.dex */
public abstract class c {
    String appPackage;
    int hmr;
    String hms;

    public String bFv() {
        return this.hms;
    }

    public String getAppPackage() {
        return this.appPackage;
    }

    public int getMessageID() {
        return this.hmr;
    }

    public abstract int getType();

    public void setAppPackage(String str) {
        this.appPackage = str;
    }

    public void vA(String str) {
        this.hms = str;
    }

    public void vx(int i) {
        this.hmr = i;
    }
}
