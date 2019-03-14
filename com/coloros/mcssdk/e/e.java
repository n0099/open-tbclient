package com.coloros.mcssdk.e;
/* loaded from: classes3.dex */
public class e {
    private String content;
    private String jyy;

    public void Fr(String str) {
        this.jyy = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String toString() {
        return "subscribeId:" + this.jyy + ",content:" + this.content;
    }
}
