package com.coloros.mcssdk.e;
/* loaded from: classes2.dex */
public class e {
    private String content;
    private String hMU;

    public void setContent(String str) {
        this.content = str;
    }

    public String toString() {
        return "subscribeId:" + this.hMU + ",content:" + this.content;
    }

    public void uN(String str) {
        this.hMU = str;
    }
}
