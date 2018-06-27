package com.coloros.mcssdk.e;
/* loaded from: classes3.dex */
public class d extends c {
    private String content;
    private String description;
    private String hDx;
    private String hDy;

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
        return "messageID:" + this.hDv + ",taskID:" + this.hDw + ",globalID:" + this.hDx + ",appPackage:" + this.appPackage + ",content:" + this.content + ",description:" + this.description + ",appID:" + this.hDy;
    }

    public void wv(String str) {
        this.hDx = str;
    }

    public void ww(String str) {
        this.hDy = str;
    }
}
