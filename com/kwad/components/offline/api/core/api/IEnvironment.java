package com.kwad.components.offline.api.core.api;

import android.content.Context;
/* loaded from: classes5.dex */
public interface IEnvironment {
    String getAppId();

    Context getContext();

    String getDeviceId();

    String getProcessName(Context context);

    String getSdkVersion();

    String getUserAgent();

    boolean isArm64(Context context);

    boolean isDebug();

    boolean isDevelopEnable();

    boolean isInMainProcess(Context context);

    String localIpAddress();
}
