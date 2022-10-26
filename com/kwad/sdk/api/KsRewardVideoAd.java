package com.kwad.sdk.api;

import android.app.Activity;
import com.kwad.sdk.api.KsInnerAd;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.model.AdExposureFailedReason;
@KsAdSdkApi
/* loaded from: classes7.dex */
public interface KsRewardVideoAd {

    @KsAdSdkApi
    /* loaded from: classes7.dex */
    public interface RewardAdInteractionListener {
        @KsAdSdkApi
        void onAdClicked();

        @KsAdSdkApi
        void onExtraRewardVerify(int i);

        @KsAdSdkApi
        void onPageDismiss();

        @KsAdSdkApi
        void onRewardStepVerify(int i, int i2);

        @KsAdSdkApi
        void onRewardVerify();

        @KsAdSdkApi
        void onVideoPlayEnd();

        @KsAdSdkApi
        void onVideoPlayError(int i, int i2);

        @KsAdSdkApi
        void onVideoPlayStart();

        @KsAdSdkApi
        void onVideoSkipToEnd(long j);
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
    void setInnerAdInteractionListener(KsInnerAd.KsInnerAdInteractionListener ksInnerAdInteractionListener);

    @KsAdSdkApi
    void setRewardAdInteractionListener(RewardAdInteractionListener rewardAdInteractionListener);

    @KsAdSdkApi
    void setRewardPlayAgainInteractionListener(RewardAdInteractionListener rewardAdInteractionListener);

    @KsAdSdkApi
    void showRewardVideoAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig);
}
