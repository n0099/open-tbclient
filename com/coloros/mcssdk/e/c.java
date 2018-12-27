package com.coloros.mcssdk.e;
/* loaded from: classes3.dex */
public abstract class c {
    String appPackage;
    int ihy;
    String ihz;

    public String bTe() {
        return this.ihz;
    }

    public String bTf() {
        return this.appPackage;
    }

    public int getMessageID() {
        return this.ihy;
    }

    public abstract int getType();

    public void yV(String str) {
        this.ihz = str;
    }

    public void yW(String str) {
        this.appPackage = str;
    }

    public void yd(int i) {
        this.ihy = i;
    }
}
