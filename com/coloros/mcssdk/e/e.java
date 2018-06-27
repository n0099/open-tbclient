package com.coloros.mcssdk.e;
/* loaded from: classes3.dex */
public class e {
    private String content;
    private String hDz;

    public void setContent(String str) {
        this.content = str;
    }

    public String toString() {
        return "subscribeId:" + this.hDz + ",content:" + this.content;
    }

    public void wx(String str) {
        this.hDz = str;
    }
}
