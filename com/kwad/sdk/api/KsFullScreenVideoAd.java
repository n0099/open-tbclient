package com.kwad.sdk.api;

import android.app.Activity;
import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;
@KsAdSdkApi
@Keep
/* loaded from: classes7.dex */
public interface KsFullScreenVideoAd {

    @KsAdSdkApi
    @Keep
    /* loaded from: classes7.dex */
    public interface FullScreenVideoAdInteractionListener {
        @KsAdSdkApi
        @Keep
        void onAdClicked();

        @KsAdSdkApi
        @Keep
        void onPageDismiss();

        @KsAdSdkApi
        @Keep
        void onSkippedVideo();

        @KsAdSdkApi
        @Keep
        void onVideoPlayEnd();

        @KsAdSdkApi
        @Keep
        void onVideoPlayError(int i2, int i3);

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
    void setBidEcpm(int i2);

    @KsAdSdkApi
    @Keep
    void setFullScreenVideoAdInteractionListener(FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener);

    @KsAdSdkApi
    @Keep
    void showFullScreenVideoAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig);
}
