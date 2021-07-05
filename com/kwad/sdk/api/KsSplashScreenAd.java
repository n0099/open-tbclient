package com.kwad.sdk.api;

import android.content.Context;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.kwad.sdk.api.core.KsAdSdkApi;
@KsAdSdkApi
@Keep
/* loaded from: classes7.dex */
public interface KsSplashScreenAd {

    @KsAdSdkApi
    @Keep
    /* loaded from: classes7.dex */
    public interface SplashScreenAdInteractionListener {
        @KsAdSdkApi
        @Keep
        void onAdClicked();

        @KsAdSdkApi
        @Keep
        void onAdShowEnd();

        @KsAdSdkApi
        @Keep
        void onAdShowError(int i2, String str);

        @KsAdSdkApi
        @Keep
        void onAdShowStart();

        @KsAdSdkApi
        @Keep
        void onSkippedAd();
    }

    @Nullable
    @KsAdSdkApi
    @Keep
    Fragment getFragment(SplashScreenAdInteractionListener splashScreenAdInteractionListener);

    @KsAdSdkApi
    @Keep
    View getView(Context context, SplashScreenAdInteractionListener splashScreenAdInteractionListener);

    @KsAdSdkApi
    @Keep
    boolean isAdEnable();

    @KsAdSdkApi
    @Keep
    boolean isVideo();
}
