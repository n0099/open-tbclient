package com.coloros.mcssdk.e;
/* loaded from: classes2.dex */
public class d extends c {
    private String content;
    private String description;
    private String hNm;
    private String hNn;

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
        return "messageID:" + this.hNk + ",taskID:" + this.hNl + ",globalID:" + this.hNm + ",appPackage:" + this.appPackage + ",content:" + this.content + ",description:" + this.description + ",appID:" + this.hNn;
    }

    public void uS(String str) {
        this.hNm = str;
    }

    public void uT(String str) {
        this.hNn = str;
    }
}
