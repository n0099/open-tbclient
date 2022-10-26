package com.kwad.sdk.api;

import android.content.Context;
import android.view.View;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.model.AdExposureFailedReason;
@KsAdSdkApi
/* loaded from: classes7.dex */
public interface KsFeedAd {

    @KsAdSdkApi
    /* loaded from: classes7.dex */
    public interface AdInteractionListener {
        @KsAdSdkApi
        void onAdClicked();

        @KsAdSdkApi
        void onAdShow();

        @KsAdSdkApi
        void onDislikeClicked();

        @KsAdSdkApi
        void onDownloadTipsDialogDismiss();

        @KsAdSdkApi
        void onDownloadTipsDialogShow();
    }

    @KsAdSdkApi
    int getECPM();

    @KsAdSdkApi
    View getFeedView(Context context);

    @KsAdSdkApi
    int getInteractionType();

    @KsAdSdkApi
    int getMaterialType();

    @KsAdSdkApi
    void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason);

    @KsAdSdkApi
    void setAdInteractionListener(AdInteractionListener adInteractionListener);

    @KsAdSdkApi
    void setBidEcpm(int i);

    @KsAdSdkApi
    void setVideoPlayConfig(KsAdVideoPlayConfig ksAdVideoPlayConfig);

    @KsAdSdkApi
    void setVideoSoundEnable(boolean z);
}
