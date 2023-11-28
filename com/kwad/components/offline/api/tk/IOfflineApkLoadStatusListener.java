package com.kwad.components.offline.api.tk;
/* loaded from: classes10.dex */
public interface IOfflineApkLoadStatusListener {
    void onDownloadFailed();

    void onDownloadFinished();

    void onDownloadStarted();

    void onIdle();

    void onInstalled();

    void onPaused(int i);

    void onProgressUpdate(int i);
}
