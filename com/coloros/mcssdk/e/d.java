package com.coloros.mcssdk.e;
/* loaded from: classes2.dex */
public class d extends c {
    private String content;
    private String description;
    private String hMS;
    private String hMT;

    @Override // com.coloros.mcssdk.e.c
    public int getType() {
        return 4103;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String toString() {
        return "messageID:" + this.hMQ + ",taskID:" + this.hMR + ",globalID:" + this.hMS + ",appPackage:" + this.appPackage + ",content:" + this.content + ",description:" + this.description + ",appID:" + this.hMT;
    }

    public void uL(String str) {
        this.hMS = str;
    }

    public void uM(String str) {
        this.hMT = str;
    }
}
