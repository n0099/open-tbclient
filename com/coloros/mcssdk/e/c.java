package com.coloros.mcssdk.e;
/* loaded from: classes3.dex */
public abstract class c {
    String appPackage;
    int hVq;
    String hVr;

    public String bQN() {
        return this.hVr;
    }

    public String bQO() {
        return this.appPackage;
    }

    public int getMessageID() {
        return this.hVq;
    }

    public abstract int getType();

    public void xa(int i) {
        this.hVq = i;
    }

    public void yk(String str) {
        this.hVr = str;
    }

    public void yl(String str) {
        this.appPackage = str;
    }
}
