package com.coloros.mcssdk.e;
/* loaded from: classes3.dex */
public abstract class c {
    String appPackage;
    int hXb;
    String hXc;

    public String bQi() {
        return this.hXc;
    }

    public String bQj() {
        return this.appPackage;
    }

    public int getMessageID() {
        return this.hXb;
    }

    public abstract int getType();

    public void xt(int i) {
        this.hXb = i;
    }

    public void yp(String str) {
        this.hXc = str;
    }

    public void yq(String str) {
        this.appPackage = str;
    }
}
