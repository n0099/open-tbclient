package com.kwad.sdk.api;

import android.content.Context;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.KsAdSdkApi;
@KsAdSdkApi
@Keep
/* loaded from: classes10.dex */
public interface KsFeedAd {

    @KsAdSdkApi
    @Keep
    /* loaded from: classes10.dex */
    public interface AdInteractionListener {
        @KsAdSdkApi
        @Keep
        void onAdClicked();

        @KsAdSdkApi
        @Keep
        void onAdShow();

        @KsAdSdkApi
        @Keep
        void onDislikeClicked();
    }

    @KsAdSdkApi
    @Keep
    int getECPM();

    @Nullable
    @KsAdSdkApi
    @Keep
    View getFeedView(Context context);

    @KsAdSdkApi
    @Keep
    int getInteractionType();

    @KsAdSdkApi
    @Keep
    int getMaterialType();

    @KsAdSdkApi
    @Keep
    void setAdInteractionListener(AdInteractionListener adInteractionListener);

    @KsAdSdkApi
    @Keep
    void setBidEcpm(int i2);

    @KsAdSdkApi
    @Keep
    void setVideoPlayConfig(@Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig);

    @KsAdSdkApi
    @Keep
    void setVideoSoundEnable(boolean z);
}
