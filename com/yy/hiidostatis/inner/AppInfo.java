package com.yy.hiidostatis.inner;

import android.content.Context;
/* loaded from: classes9.dex */
public enum AppInfo {
    INSTANCE;
    
    public int targetSdkVersion;

    public void init(Context context) {
        this.targetSdkVersion = context.getApplicationInfo().targetSdkVersion;
    }
}
