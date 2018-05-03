package com.coloros.mcssdk.e;
/* loaded from: classes3.dex */
public class d extends c {
    private String content;
    private String description;
    private String hmq;
    private String hmr;

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
        return "messageID:" + this.hmo + ",taskID:" + this.hmp + ",globalID:" + this.hmq + ",appPackage:" + this.appPackage + ",content:" + this.content + ",description:" + this.description + ",appID:" + this.hmr;
    }

    public void vB(String str) {
        this.hmq = str;
    }

    public void vC(String str) {
        this.hmr = str;
    }
}
