package com.coloros.mcssdk.e;
/* loaded from: classes3.dex */
public class d extends c {
    private String content;
    private String description;
    private String hEe;
    private String hEf;

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
        return "messageID:" + this.hEc + ",taskID:" + this.hEd + ",globalID:" + this.hEe + ",appPackage:" + this.appPackage + ",content:" + this.content + ",description:" + this.description + ",appID:" + this.hEf;
    }

    public void wB(String str) {
        this.hEe = str;
    }

    public void wC(String str) {
        this.hEf = str;
    }
}
