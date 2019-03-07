package com.coloros.mcssdk.e;
/* loaded from: classes3.dex */
public class d extends c {
    private String aui;
    private String content;
    private String description;
    private String jym;

    public void Fp(String str) {
        this.jym = str;
    }

    public void ei(String str) {
        this.aui = str;
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
        return "messageID:" + this.jyk + ",taskID:" + this.jyl + ",globalID:" + this.jym + ",appPackage:" + this.appPackage + ",content:" + this.content + ",description:" + this.description + ",appID:" + this.aui;
    }
}
