package com.sina.weibo.sdk.auth;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public class WbAppInfo {
    public int supportVersion;
    public String packageName = "com.sina.weibo";
    public String authActivityName = "com.sina.weibo.SSOActivity";

    public String getAuthActivityName() {
        return this.authActivityName;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int getSupportVersion() {
        return this.supportVersion;
    }

    public boolean isLegal() {
        return !TextUtils.isEmpty(this.packageName) && this.supportVersion > 0;
    }

    public void setAuthActivityName(String str) {
        this.authActivityName = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setSupportVersion(int i) {
        this.supportVersion = i;
    }
}
