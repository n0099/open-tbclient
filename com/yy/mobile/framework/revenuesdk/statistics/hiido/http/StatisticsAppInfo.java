package com.yy.mobile.framework.revenuesdk.statistics.hiido.http;

import android.content.Context;
/* loaded from: classes7.dex */
public enum StatisticsAppInfo {
    INSTANCE;
    
    public int targetSdkVersion;

    public void init(Context context) {
        this.targetSdkVersion = context.getApplicationInfo().targetSdkVersion;
    }
}
