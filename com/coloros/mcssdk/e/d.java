package com.coloros.mcssdk.e;
/* loaded from: classes3.dex */
public class d extends c {
    private String content;
    private String description;
    private String hEc;
    private String hEd;

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
        return "messageID:" + this.hEa + ",taskID:" + this.hEb + ",globalID:" + this.hEc + ",appPackage:" + this.appPackage + ",content:" + this.content + ",description:" + this.description + ",appID:" + this.hEd;
    }

    public void wx(String str) {
        this.hEc = str;
    }

    public void wy(String str) {
        this.hEd = str;
    }
}
