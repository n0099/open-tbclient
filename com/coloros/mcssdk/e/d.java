package com.coloros.mcssdk.e;
/* loaded from: classes3.dex */
public class d extends c {
    private String content;
    private String description;
    private String hzq;
    private String hzr;

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
        return "messageID:" + this.hzo + ",taskID:" + this.hzp + ",globalID:" + this.hzq + ",appPackage:" + this.appPackage + ",content:" + this.content + ",description:" + this.description + ",appID:" + this.hzr;
    }

    public void wy(String str) {
        this.hzq = str;
    }

    public void wz(String str) {
        this.hzr = str;
    }
}
