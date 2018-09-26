package com.coloros.mcssdk.e;
/* loaded from: classes3.dex */
public class d extends c {
    private String content;
    private String description;
    private String hMy;
    private String hMz;

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
        return "messageID:" + this.hMw + ",taskID:" + this.hMx + ",globalID:" + this.hMy + ",appPackage:" + this.appPackage + ",content:" + this.content + ",description:" + this.description + ",appID:" + this.hMz;
    }

    public void xm(String str) {
        this.hMy = str;
    }

    public void xn(String str) {
        this.hMz = str;
    }
}
