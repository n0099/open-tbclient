package com.kwad.components.offline.api.obiwan;

import com.kwad.components.offline.api.IOfflineCompoInitConfig;
/* loaded from: classes5.dex */
public interface IObiwanOfflineCompoInitConfig extends IOfflineCompoInitConfig {
    String getLogDirPath();

    String getLogObiwanData();

    long getLogObiwanStorageQuota();

    boolean isLogObiwanEnableNow();

    boolean isLogObiwanRecordAll();
}
