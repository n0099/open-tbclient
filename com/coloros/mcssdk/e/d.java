package com.coloros.mcssdk.e;
/* loaded from: classes2.dex */
public class d extends c {
    private String content;
    private String description;
    private String hOV;
    private String hOW;

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
        return "messageID:" + this.hOT + ",taskID:" + this.hOU + ",globalID:" + this.hOV + ",appPackage:" + this.appPackage + ",content:" + this.content + ",description:" + this.description + ",appID:" + this.hOW;
    }

    public void uY(String str) {
        this.hOV = str;
    }

    public void uZ(String str) {
        this.hOW = str;
    }
}
