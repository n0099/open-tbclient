package com.yy.hiidostatis.defs;
/* loaded from: classes10.dex */
public class BaseStatisOption {
    public String appId;
    public String appkey;
    public String from;
    public String ver;

    public BaseStatisOption() {
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppkey() {
        return this.appkey;
    }

    public String getFrom() {
        return this.from;
    }

    public String getVer() {
        return this.ver;
    }

    public BaseStatisOption(String str, String str2, String str3, String str4) {
        this.appId = str2;
        this.appkey = str;
        this.from = str3;
        this.ver = str4;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setAppkey(String str) {
        this.appkey = str;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public void setVer(String str) {
        this.ver = str;
    }
}
