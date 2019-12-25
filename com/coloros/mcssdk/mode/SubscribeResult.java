package com.coloros.mcssdk.mode;
/* loaded from: classes5.dex */
public class SubscribeResult {
    private String content;
    private String subscribeId;

    public String getContent() {
        return this.content;
    }

    public String getSubscribeId() {
        return this.subscribeId;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setSubscribeId(String str) {
        this.subscribeId = str;
    }

    public String toString() {
        return "subscribeId:" + this.subscribeId + ",content:" + this.content;
    }
}
