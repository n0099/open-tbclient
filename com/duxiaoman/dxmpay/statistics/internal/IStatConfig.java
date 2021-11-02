package com.duxiaoman.dxmpay.statistics.internal;

import android.content.Context;
/* loaded from: classes11.dex */
public interface IStatConfig {
    String getAppVersionCode();

    String getAppVersionName();

    String getChannelId();

    String getCommonEvent();

    String getDistinctId();

    String getDistinctIdKey();

    String getHeader();

    String getProductName();

    String getSDKVersion();

    String getUploadUrl();

    boolean isLogin();

    String loadDefaultStrategy();

    String loadStrategy();

    void setContext(Context context);
}
