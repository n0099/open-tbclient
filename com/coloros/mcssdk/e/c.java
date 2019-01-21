package com.coloros.mcssdk.e;
/* loaded from: classes3.dex */
public abstract class c {
    String appPackage;
    int iiG;
    String iiH;

    public String bTM() {
        return this.iiH;
    }

    public String bTN() {
        return this.appPackage;
    }

    public int getMessageID() {
        return this.iiG;
    }

    public abstract int getType();

    public void yf(int i) {
        this.iiG = i;
    }

    public void zl(String str) {
        this.iiH = str;
    }

    public void zm(String str) {
        this.appPackage = str;
    }
}
