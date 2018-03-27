package com.coloros.mcssdk.e;
/* loaded from: classes2.dex */
public abstract class c {
    String appPackage;
    int hOT;
    String hOU;

    public String bJV() {
        return this.hOU;
    }

    public String getAppPackage() {
        return this.appPackage;
    }

    public int getMessageID() {
        return this.hOT;
    }

    public abstract int getType();

    public void setAppPackage(String str) {
        this.appPackage = str;
    }

    public void uX(String str) {
        this.hOU = str;
    }

    public void xX(int i) {
        this.hOT = i;
    }
}
