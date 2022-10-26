package com.kwad.sdk.api;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import java.util.List;
import java.util.Map;
@KsAdSdkApi
/* loaded from: classes7.dex */
public interface KsNativeAd {

    @KsAdSdkApi
    /* loaded from: classes7.dex */
    public interface AdInteractionListener {
        boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener);

        @KsAdSdkApi
        void onAdClicked(View view2, KsNativeAd ksNativeAd);

        @KsAdSdkApi
        void onAdShow(KsNativeAd ksNativeAd);

        @KsAdSdkApi
        void onDownloadTipsDialogDismiss();

        @KsAdSdkApi
        void onDownloadTipsDialogShow();
    }

    @KsAdSdkApi
    /* loaded from: classes7.dex */
    public interface VideoPlayListener {
        @KsAdSdkApi
        void onVideoPlayComplete();

        @KsAdSdkApi
        void onVideoPlayError(int i, int i2);

        @KsAdSdkApi
        void onVideoPlayPause();

        @KsAdSdkApi
        void onVideoPlayReady();

        @KsAdSdkApi
        void onVideoPlayResume();

        @KsAdSdkApi
        void onVideoPlayStart();
    }

    @KsAdSdkApi
    String getActionDescription();

    @KsAdSdkApi
    String getAdDescription();

    @KsAdSdkApi
    String getAdSource();

    @KsAdSdkApi
    String getAdSourceLogoUrl(int i);

    @KsAdSdkApi
    String getAppDownloadCountDes();

    @KsAdSdkApi
    String getAppIconUrl();

    @KsAdSdkApi
    String getAppName();

    @KsAdSdkApi
    String getAppPackageName();

    @KsAdSdkApi
    long getAppPackageSize();

    @KsAdSdkApi
    String getAppPrivacyUrl();

    @KsAdSdkApi
    float getAppScore();

    @KsAdSdkApi
    String getAppVersion();

    @KsAdSdkApi
    String getCorporationName();

    @KsAdSdkApi
    int getECPM();

    @KsAdSdkApi
    List getImageList();

    @KsAdSdkApi
    int getInteractionType();

    @KsAdSdkApi
    int getMaterialType();

    @KsAdSdkApi
    String getPermissionInfo();

    @KsAdSdkApi
    String getPermissionInfoUrl();

    @KsAdSdkApi
    String getProductName();

    @KsAdSdkApi
    KsImage getVideoCoverImage();

    @KsAdSdkApi
    int getVideoDuration();

    @KsAdSdkApi
    int getVideoHeight();

    @KsAdSdkApi
    String getVideoUrl();

    @KsAdSdkApi
    View getVideoView(Context context, KsAdVideoPlayConfig ksAdVideoPlayConfig);

    @KsAdSdkApi
    @Deprecated
    View getVideoView(Context context, boolean z);

    @KsAdSdkApi
    int getVideoWidth();

    @KsAdSdkApi
    @Deprecated
    void registerViewForInteraction(Activity activity, ViewGroup viewGroup, List list, AdInteractionListener adInteractionListener);

    @KsAdSdkApi
    void registerViewForInteraction(Activity activity, ViewGroup viewGroup, Map map, AdInteractionListener adInteractionListener);

    @KsAdSdkApi
    @Deprecated
    void registerViewForInteraction(ViewGroup viewGroup, List list, AdInteractionListener adInteractionListener);

    @KsAdSdkApi
    void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason);

    @KsAdSdkApi
    void reportAdVideoPlayEnd();

    @KsAdSdkApi
    void reportAdVideoPlayStart();

    @KsAdSdkApi
    void setBidEcpm(int i);

    @KsAdSdkApi
    void setDownloadListener(KsAppDownloadListener ksAppDownloadListener);

    @KsAdSdkApi
    void setVideoPlayListener(VideoPlayListener videoPlayListener);
}
