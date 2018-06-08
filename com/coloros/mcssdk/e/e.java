package com.coloros.mcssdk.e;
/* loaded from: classes3.dex */
public class e {
    private String content;
    private String hzs;

    public void setContent(String str) {
        this.content = str;
    }

    public String toString() {
        return "subscribeId:" + this.hzs + ",content:" + this.content;
    }

    public void wA(String str) {
        this.hzs = str;
    }
}
