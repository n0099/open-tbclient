package com.coloros.mcssdk.e;
/* loaded from: classes2.dex */
public class d extends c {
    private String content;
    private String description;
    private String hOK;
    private String hOL;

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
        return "messageID:" + this.hOI + ",taskID:" + this.hOJ + ",globalID:" + this.hOK + ",appPackage:" + this.appPackage + ",content:" + this.content + ",description:" + this.description + ",appID:" + this.hOL;
    }

    public void uY(String str) {
        this.hOK = str;
    }

    public void uZ(String str) {
        this.hOL = str;
    }
}
