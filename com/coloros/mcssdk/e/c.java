package com.coloros.mcssdk.e;
/* loaded from: classes3.dex */
public abstract class c {
    String appPackage;
    int jyv;
    String jyw;

    public void BS(int i) {
        this.jyv = i;
    }

    public void Fo(String str) {
        this.jyw = str;
    }

    public void Fp(String str) {
        this.appPackage = str;
    }

    public String csX() {
        return this.jyw;
    }

    public String csY() {
        return this.appPackage;
    }

    public int getMessageID() {
        return this.jyv;
    }

    public abstract int getType();
}
