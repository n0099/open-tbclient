package com.yy.hiidostatis.inner.util.hdid;

import android.app.Application;
/* loaded from: classes7.dex */
public interface IClientIdConfig {
    Application getAppContext();

    boolean logEnable();

    boolean sdReadGranted();

    boolean sdWriteGranted();
}
