package com.coloros.mcssdk.e;
/* loaded from: classes2.dex */
public class d extends c {
    private String content;
    private String description;
    private String hXi;
    private String hXj;

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
        return "messageID:" + this.hXg + ",taskID:" + this.hXh + ",globalID:" + this.hXi + ",appPackage:" + this.appPackage + ",content:" + this.content + ",description:" + this.description + ",appID:" + this.hXj;
    }

    public void vq(String str) {
        this.hXi = str;
    }

    public void vr(String str) {
        this.hXj = str;
    }
}
