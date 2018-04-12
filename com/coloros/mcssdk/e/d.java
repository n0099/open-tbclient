package com.coloros.mcssdk.e;
/* loaded from: classes3.dex */
public class d extends c {
    private String content;
    private String description;
    private String hmt;
    private String hmu;

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
        return "messageID:" + this.hmr + ",taskID:" + this.hms + ",globalID:" + this.hmt + ",appPackage:" + this.appPackage + ",content:" + this.content + ",description:" + this.description + ",appID:" + this.hmu;
    }

    public void vB(String str) {
        this.hmt = str;
    }

    public void vC(String str) {
        this.hmu = str;
    }
}
