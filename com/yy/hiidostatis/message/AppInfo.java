package com.yy.hiidostatis.message;

import com.yy.hiidostatis.provider.MessageConfig;
/* loaded from: classes8.dex */
public interface AppInfo {
    String getAppAppkey();

    String getAppVer();

    void updateAppInfo(MessageConfig messageConfig);
}
