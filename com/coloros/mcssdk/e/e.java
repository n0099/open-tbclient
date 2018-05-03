package com.coloros.mcssdk.e;
/* loaded from: classes3.dex */
public class e {
    private String content;
    private String hms;

    public void setContent(String str) {
        this.content = str;
    }

    public String toString() {
        return "subscribeId:" + this.hms + ",content:" + this.content;
    }

    public void vD(String str) {
        this.hms = str;
    }
}
