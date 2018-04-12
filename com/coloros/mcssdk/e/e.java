package com.coloros.mcssdk.e;
/* loaded from: classes3.dex */
public class e {
    private String content;
    private String hmv;

    public void setContent(String str) {
        this.content = str;
    }

    public String toString() {
        return "subscribeId:" + this.hmv + ",content:" + this.content;
    }

    public void vD(String str) {
        this.hmv = str;
    }
}
