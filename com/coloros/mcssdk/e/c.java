package com.coloros.mcssdk.e;
/* loaded from: classes3.dex */
public abstract class c {
    String appPackage;
    int hns;
    String hnt;

    public String bFt() {
        return this.hnt;
    }

    public String getAppPackage() {
        return this.appPackage;
    }

    public int getMessageID() {
        return this.hns;
    }

    public abstract int getType();

    public void setAppPackage(String str) {
        this.appPackage = str;
    }

    public void vD(String str) {
        this.hnt = str;
    }

    public void vw(int i) {
        this.hns = i;
    }
}
