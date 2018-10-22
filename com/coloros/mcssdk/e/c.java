package com.coloros.mcssdk.e;
/* loaded from: classes3.dex */
public abstract class c {
    String appPackage;
    int hVr;
    String hVs;

    public String bQN() {
        return this.hVs;
    }

    public String bQO() {
        return this.appPackage;
    }

    public int getMessageID() {
        return this.hVr;
    }

    public abstract int getType();

    public void xa(int i) {
        this.hVr = i;
    }

    public void yk(String str) {
        this.hVs = str;
    }

    public void yl(String str) {
        this.appPackage = str;
    }
}
