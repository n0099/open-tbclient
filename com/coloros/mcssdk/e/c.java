package com.coloros.mcssdk.e;
/* loaded from: classes3.dex */
public abstract class c {
    String appPackage;
    int ieo;
    String iep;

    public String bSn() {
        return this.iep;
    }

    public String bSo() {
        return this.appPackage;
    }

    public int getMessageID() {
        return this.ieo;
    }

    public abstract int getType();

    public void xQ(int i) {
        this.ieo = i;
    }

    public void yS(String str) {
        this.iep = str;
    }

    public void yT(String str) {
        this.appPackage = str;
    }
}
