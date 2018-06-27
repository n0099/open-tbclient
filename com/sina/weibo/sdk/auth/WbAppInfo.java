package com.sina.weibo.sdk.auth;

import android.text.TextUtils;
import com.sina.weibo.BuildConfig;
/* loaded from: classes2.dex */
public class WbAppInfo {
    private int supportVersion;
    private String packageName = BuildConfig.APPLICATION_ID;
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
