package com.coloros.mcssdk.e;
/* loaded from: classes3.dex */
public abstract class c {
    String appPackage;
    int jyk;
    String jyl;

    public void BR(int i) {
        this.jyk = i;
    }

    public void Fn(String str) {
        this.jyl = str;
    }

    public void Fo(String str) {
        this.appPackage = str;
    }

    public String csK() {
        return this.jyl;
    }

    public String csL() {
        return this.appPackage;
    }

    public int getMessageID() {
        return this.jyk;
    }

    public abstract int getType();
}
