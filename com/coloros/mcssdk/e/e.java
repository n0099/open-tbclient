package com.coloros.mcssdk.e;
/* loaded from: classes3.dex */
public class e {
    private String content;
    private String hMA;

    public void setContent(String str) {
        this.content = str;
    }

    public String toString() {
        return "subscribeId:" + this.hMA + ",content:" + this.content;
    }

    public void xo(String str) {
        this.hMA = str;
    }
}
