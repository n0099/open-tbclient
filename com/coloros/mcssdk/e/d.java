package com.coloros.mcssdk.e;
/* loaded from: classes3.dex */
public class d extends c {
    private String auj;
    private String content;
    private String description;
    private String jyx;

    public void Fq(String str) {
        this.jyx = str;
    }

    public void ei(String str) {
        this.auj = str;
    }

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
        return "messageID:" + this.jyv + ",taskID:" + this.jyw + ",globalID:" + this.jyx + ",appPackage:" + this.appPackage + ",content:" + this.content + ",description:" + this.description + ",appID:" + this.auj;
    }
}
