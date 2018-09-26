package com.coloros.mcssdk.e;
/* loaded from: classes3.dex */
public abstract class c {
    String appPackage;
    int hMw;
    String hMx;

    public String bMx() {
        return this.hMx;
    }

    public String bMy() {
        return this.appPackage;
    }

    public int getMessageID() {
        return this.hMw;
    }

    public abstract int getType();

    public void wt(int i) {
        this.hMw = i;
    }

    public void xk(String str) {
        this.hMx = str;
    }

    public void xl(String str) {
        this.appPackage = str;
    }
}
