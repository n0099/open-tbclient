package com.kwad.sdk.api;

import com.kwad.sdk.api.core.KsAdSdkApi;
@KsAdSdkApi
/* loaded from: classes7.dex */
public interface KsAppDownloadListener {
    @KsAdSdkApi
    void onDownloadFailed();

    @KsAdSdkApi
    void onDownloadFinished();

    @KsAdSdkApi
    void onDownloadStarted();

    @KsAdSdkApi
    void onIdle();

    @KsAdSdkApi
    void onInstalled();

    @KsAdSdkApi
    void onProgressUpdate(int i);
}
