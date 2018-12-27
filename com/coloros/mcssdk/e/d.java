package com.coloros.mcssdk.e;
/* loaded from: classes3.dex */
public class d extends c {
    private String appID;
    private String content;
    private String description;
    private String ihA;

    @Override // com.coloros.mcssdk.e.c
    public int getType() {
        return 4103;
    }

    public void setAppID(String str) {
        this.appID = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String toString() {
        return "messageID:" + this.ihy + ",taskID:" + this.ihz + ",globalID:" + this.ihA + ",appPackage:" + this.appPackage + ",content:" + this.content + ",description:" + this.description + ",appID:" + this.appID;
    }

    public void yX(String str) {
        this.ihA = str;
    }
}
