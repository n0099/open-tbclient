package com.sina.weibo.sdk.auth;

import android.text.TextUtils;
/* loaded from: classes4.dex */
public class WbAppInfo {
    private int supportVersion;
    private String packageName = "com.sina.weibo";
    private String authActivityName = "com.sina.weibo.SSOActivity";

    public String getPackageName() {
        return this.packageName;
    }

    public String getAuthActivityName() {
        return this.authActivityName;
    }

    public int getSupportVersion() {
        return this.supportVersion;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setAuthActivityName(String str) {
        this.authActivityName = str;
    }

    public void setSupportVersion(int i) {
        this.supportVersion = i;
    }

    public boolean isLegal() {
        return !TextUtils.isEmpty(this.packageName) && this.supportVersion > 0;
    }
}
