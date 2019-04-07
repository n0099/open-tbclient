package com.coloros.mcssdk.mode;
/* loaded from: classes3.dex */
public class SptDataMessage extends Message {
    private String appID;
    private String content;
    private String description;
    private String globalID;

    public String getAppID() {
        return this.appID;
    }

    public String getContent() {
        return this.content;
    }

    public String getDescription() {
        return this.description;
    }

    public String getGlobalID() {
        return this.globalID;
    }

    @Override // com.coloros.mcssdk.mode.Message
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

    public void setGlobalID(String str) {
        this.globalID = str;
    }

    public String toString() {
        return "messageID:" + this.messageID + ",taskID:" + this.taskID + ",globalID:" + this.globalID + ",appPackage:" + this.appPackage + ",content:" + this.content + ",description:" + this.description + ",appID:" + this.appID;
    }
}
