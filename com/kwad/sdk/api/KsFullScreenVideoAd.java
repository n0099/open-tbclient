package com.kwad.sdk.api;

import android.app.Activity;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.model.AdExposureFailedReason;
@KsAdSdkApi
/* loaded from: classes7.dex */
public interface KsFullScreenVideoAd {

    @KsAdSdkApi
    /* loaded from: classes7.dex */
    public interface FullScreenVideoAdInteractionListener {
        @KsAdSdkApi
        void onAdClicked();

        @KsAdSdkApi
        void onPageDismiss();

        @KsAdSdkApi
        void onSkippedVideo();

        @KsAdSdkApi
        void onVideoPlayEnd();

        @KsAdSdkApi
        void onVideoPlayError(int i, int i2);

        @KsAdSdkApi
        void onVideoPlayStart();
    }

    @KsAdSdkApi
    int getECPM();

    @KsAdSdkApi
    int getInteractionType();

    @KsAdSdkApi
    int getMaterialType();

    @KsAdSdkApi
    boolean isAdEnable();

    @KsAdSdkApi
    void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason);

    @KsAdSdkApi
    void setBidEcpm(int i);

    @KsAdSdkApi
    void setFullScreenVideoAdInteractionListener(FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener);

    @KsAdSdkApi
    void showFullScreenVideoAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig);
}
