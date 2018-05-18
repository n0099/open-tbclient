package com.coloros.mcssdk.e;
/* loaded from: classes3.dex */
public class d extends c {
    private String content;
    private String description;
    private String hnu;
    private String hnv;

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
        return "messageID:" + this.hns + ",taskID:" + this.hnt + ",globalID:" + this.hnu + ",appPackage:" + this.appPackage + ",content:" + this.content + ",description:" + this.description + ",appID:" + this.hnv;
    }

    public void vE(String str) {
        this.hnu = str;
    }

    public void vF(String str) {
        this.hnv = str;
    }
}
