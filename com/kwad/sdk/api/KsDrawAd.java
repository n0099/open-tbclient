package com.kwad.sdk.api;

import android.content.Context;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.model.AdExposureFailedReason;
@KsAdSdkApi
@Keep
/* loaded from: classes2.dex */
public interface KsDrawAd {

    @KsAdSdkApi
    @Keep
    /* loaded from: classes2.dex */
    public interface AdInteractionListener {
        @KsAdSdkApi
        @Keep
        void onAdClicked();

        @KsAdSdkApi
        @Keep
        void onAdShow();

        @KsAdSdkApi
        @Keep
        void onVideoPlayEnd();

        @KsAdSdkApi
        @Keep
        void onVideoPlayError();

        @KsAdSdkApi
        @Keep
        void onVideoPlayPause();

        @KsAdSdkApi
        @Keep
        void onVideoPlayResume();

        @KsAdSdkApi
        @Keep
        void onVideoPlayStart();
    }

    @Nullable
    @KsAdSdkApi
    @Keep
    View getDrawView(Context context);

    @KsAdSdkApi
    @Keep
    int getECPM();

    @KsAdSdkApi
    @Keep
    int getInteractionType();

    @KsAdSdkApi
    @Keep
    int getMaterialType();

    @KsAdSdkApi
    @Keep
    void reportAdExposureFailed(int i2, AdExposureFailedReason adExposureFailedReason);

    @KsAdSdkApi
    @Keep
    void setAdInteractionListener(AdInteractionListener adInteractionListener);

    @KsAdSdkApi
    @Keep
    void setBidEcpm(int i2);
}
