package com.coloros.mcssdk.e;
/* loaded from: classes3.dex */
public abstract class c {
    String appPackage;
    int iiF;
    String iiG;

    public String bTM() {
        return this.iiG;
    }

    public String bTN() {
        return this.appPackage;
    }

    public int getMessageID() {
        return this.iiF;
    }

    public abstract int getType();

    public void yf(int i) {
        this.iiF = i;
    }

    public void zl(String str) {
        this.iiG = str;
    }

    public void zm(String str) {
        this.appPackage = str;
    }
}
