package com.coloros.mcssdk.e;
/* loaded from: classes3.dex */
public abstract class c {
    String appPackage;
    int hDv;
    String hDw;

    public String bKY() {
        return this.hDw;
    }

    public String bKZ() {
        return this.appPackage;
    }

    public int getMessageID() {
        return this.hDv;
    }

    public abstract int getType();

    public void vX(int i) {
        this.hDv = i;
    }

    public void wt(String str) {
        this.hDw = str;
    }

    public void wu(String str) {
        this.appPackage = str;
    }
}
