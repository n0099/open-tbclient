package com.sina.weibo.sdk.network.base;
/* loaded from: classes6.dex */
public class WbUserInfo {
    public String gsid;
    public String token;
    public String uid;

    public WbUserInfo(String str, String str2, String str3) {
        this.gsid = str;
        this.uid = str2;
        this.token = str3;
    }

    public String getGsid() {
        return this.gsid;
    }

    public String getToken() {
        return this.token;
    }

    public String getUid() {
        return this.uid;
    }
}
