package com.kwad.sdk.api;

import android.app.Activity;
import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;
@KsAdSdkApi
@Keep
/* loaded from: classes6.dex */
public interface KsRewardVideoAd {

    @KsAdSdkApi
    @Keep
    /* loaded from: classes6.dex */
    public interface RewardAdInteractionListener {
        @KsAdSdkApi
        @Keep
        void onAdClicked();

        @KsAdSdkApi
        @Keep
        void onPageDismiss();

        @KsAdSdkApi
        @Keep
        void onRewardVerify();

        @KsAdSdkApi
        @Keep
        void onVideoPlayEnd();

        @KsAdSdkApi
        @Keep
        void onVideoPlayError(int i, int i2);

        @KsAdSdkApi
        @Keep
        void onVideoPlayStart();
    }

    @KsAdSdkApi
    @Keep
    int getECPM();

    @KsAdSdkApi
    @Keep
    boolean isAdEnable();

    @KsAdSdkApi
    @Keep
    void setBidEcpm(int i);

    @KsAdSdkApi
    @Keep
    void setRewardAdInteractionListener(RewardAdInteractionListener rewardAdInteractionListener);

    @KsAdSdkApi
    @Keep
    void showRewardVideoAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig);
}
