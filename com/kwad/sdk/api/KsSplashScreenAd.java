package com.kwad.sdk.api;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.model.AdExposureFailedReason;
@KsAdSdkApi
/* loaded from: classes7.dex */
public interface KsSplashScreenAd {

    @KsAdSdkApi
    /* loaded from: classes7.dex */
    public interface SplashScreenAdInteractionListener {
        @KsAdSdkApi
        void onAdClicked();

        @KsAdSdkApi
        void onAdShowEnd();

        @KsAdSdkApi
        void onAdShowError(int i, String str);

        @KsAdSdkApi
        void onAdShowStart();

        @KsAdSdkApi
        void onDownloadTipsDialogCancel();

        @KsAdSdkApi
        void onDownloadTipsDialogDismiss();

        @KsAdSdkApi
        void onDownloadTipsDialogShow();

        @KsAdSdkApi
        void onSkippedAd();
    }

    @KsAdSdkApi
    int getECPM();

    @KsAdSdkApi
    int getInteractionType();

    @KsAdSdkApi
    int getMaterialType();

    @KsAdSdkApi
    View getView(Context context, SplashScreenAdInteractionListener splashScreenAdInteractionListener);

    @KsAdSdkApi
    boolean isAdEnable();

    @KsAdSdkApi
    @Deprecated
    boolean isVideo();

    @KsAdSdkApi
    void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason);

    @KsAdSdkApi
    void setBidEcpm(int i);

    boolean showSplashMiniWindowIfNeeded(Context context, SplashScreenAdInteractionListener splashScreenAdInteractionListener, Rect rect);
}
