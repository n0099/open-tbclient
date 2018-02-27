package com.coloros.mcssdk.e;
/* loaded from: classes2.dex */
public class d extends c {
    private String content;
    private String description;
    private String hOx;
    private String hOy;

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
        return "messageID:" + this.hOv + ",taskID:" + this.hOw + ",globalID:" + this.hOx + ",appPackage:" + this.appPackage + ",content:" + this.content + ",description:" + this.description + ",appID:" + this.hOy;
    }

    public void uY(String str) {
        this.hOx = str;
    }

    public void uZ(String str) {
        this.hOy = str;
    }
}
