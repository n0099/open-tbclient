package com.coloros.mcssdk.e;
/* loaded from: classes3.dex */
public abstract class c {
    String appPackage;
    int jyD;
    String jyE;

    public void BS(int i) {
        this.jyD = i;
    }

    public void Fq(String str) {
        this.jyE = str;
    }

    public void Fr(String str) {
        this.appPackage = str;
    }

    public String csU() {
        return this.jyE;
    }

    public String csV() {
        return this.appPackage;
    }

    public int getMessageID() {
        return this.jyD;
    }

    public abstract int getType();
}
