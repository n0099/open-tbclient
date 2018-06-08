package com.coloros.mcssdk.e;
/* loaded from: classes3.dex */
public abstract class c {
    String appPackage;
    int hzo;
    String hzp;

    public String bKx() {
        return this.hzp;
    }

    public String getAppPackage() {
        return this.appPackage;
    }

    public int getMessageID() {
        return this.hzo;
    }

    public abstract int getType();

    public void setAppPackage(String str) {
        this.appPackage = str;
    }

    public void vO(int i) {
        this.hzo = i;
    }

    public void wx(String str) {
        this.hzp = str;
    }
}
