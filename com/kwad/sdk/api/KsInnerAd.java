package com.kwad.sdk.api;

import com.kwad.sdk.api.core.KsAdSdkApi;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@KsAdSdkApi
/* loaded from: classes7.dex */
public interface KsInnerAd {

    @KsAdSdkApi
    /* loaded from: classes7.dex */
    public interface KsInnerAdInteractionListener {
        @KsAdSdkApi
        void onAdClicked(KsInnerAd ksInnerAd);

        @KsAdSdkApi
        void onAdShow(KsInnerAd ksInnerAd);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface KsInnerAdType {
        public static final int AGGREGATION = 1;
        public static final int REFLOW = 2;
        public static final int UNKNOWN = 0;
    }

    int getType();
}
