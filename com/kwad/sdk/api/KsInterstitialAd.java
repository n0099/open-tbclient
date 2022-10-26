package com.kwad.sdk.api;

import android.app.Activity;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.model.AdExposureFailedReason;
@KsAdSdkApi
/* loaded from: classes7.dex */
public interface KsInterstitialAd {

    @KsAdSdkApi
    /* loaded from: classes7.dex */
    public interface AdInteractionListener {
        @KsAdSdkApi
        void onAdClicked();

        @KsAdSdkApi
        void onAdClosed();

        @KsAdSdkApi
        void onAdShow();

        @KsAdSdkApi
        void onPageDismiss();

        @KsAdSdkApi
        void onSkippedAd();

        @KsAdSdkApi
        void onVideoPlayEnd();

        @KsAdSdkApi
        void onVideoPlayError(int i, int i2);

        @KsAdSdkApi
        void onVideoPlayStart();
    }

    @KsAdSdkApi
    int getECPM();

    int getInteractionType();

    int getMaterialType();

    @KsAdSdkApi
    @Deprecated
    boolean isVideo();

    @KsAdSdkApi
    void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason);

    @KsAdSdkApi
    void setAdInteractionListener(AdInteractionListener adInteractionListener);

    @KsAdSdkApi
    void setBidEcpm(int i);

    @KsAdSdkApi
    void showInterstitialAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig);
}
