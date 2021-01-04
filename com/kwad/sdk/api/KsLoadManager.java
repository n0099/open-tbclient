package com.kwad.sdk.api;

import androidx.annotation.Keep;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.KsAdSdkApi;
import java.util.List;
@KsAdSdkApi
@Keep
/* loaded from: classes5.dex */
public interface KsLoadManager {

    @KsAdSdkApi
    @Keep
    /* loaded from: classes5.dex */
    public interface DrawAdListener {
        @KsAdSdkApi
        @Keep
        @MainThread
        void onDrawAdLoad(@Nullable List<KsDrawAd> list);

        @KsAdSdkApi
        @Keep
        @MainThread
        void onError(int i, String str);
    }

    @KsAdSdkApi
    @Keep
    /* loaded from: classes5.dex */
    public interface EntryElementListener<T> {
        @KsAdSdkApi
        @Keep
        @MainThread
        void onEntryLoad(@Nullable T t);

        @KsAdSdkApi
        @Keep
        @MainThread
        void onError(int i, String str);
    }

    @KsAdSdkApi
    @Keep
    /* loaded from: classes5.dex */
    public interface FeedAdListener {
        @KsAdSdkApi
        @Keep
        @MainThread
        void onError(int i, String str);

        @KsAdSdkApi
        @Keep
        @MainThread
        void onFeedAdLoad(@Nullable List<KsFeedAd> list);
    }

    @KsAdSdkApi
    @Keep
    /* loaded from: classes5.dex */
    public interface FullScreenVideoAdListener {
        @KsAdSdkApi
        @Keep
        @MainThread
        void onError(int i, String str);

        @KsAdSdkApi
        @Keep
        @MainThread
        void onFullScreenVideoAdLoad(@Nullable List<KsFullScreenVideoAd> list);
    }

    @KsAdSdkApi
    @Keep
    /* loaded from: classes5.dex */
    public interface NativeAdListener {
        @KsAdSdkApi
        @Keep
        @MainThread
        void onError(int i, String str);

        @KsAdSdkApi
        @Keep
        @MainThread
        void onNativeAdLoad(@Nullable List<KsNativeAd> list);
    }

    @KsAdSdkApi
    @Keep
    /* loaded from: classes5.dex */
    public interface RewardVideoAdListener {
        @KsAdSdkApi
        @Keep
        @MainThread
        void onError(int i, String str);

        @KsAdSdkApi
        @Keep
        @MainThread
        void onRewardVideoAdLoad(@Nullable List<KsRewardVideoAd> list);
    }

    @KsAdSdkApi
    @Keep
    /* loaded from: classes5.dex */
    public interface SplashScreenAdListener {
        @KsAdSdkApi
        @Keep
        @MainThread
        void onError(int i, String str);

        @KsAdSdkApi
        @Keep
        @MainThread
        void onSplashScreenAdLoad(@Nullable KsSplashScreenAd ksSplashScreenAd);
    }

    @KsAdSdkApi
    @Keep
    @MainThread
    void loadConfigFeedAd(KsScene ksScene, @NonNull FeedAdListener feedAdListener);

    @KsAdSdkApi
    @Keep
    @Deprecated
    @MainThread
    KsContentAllianceAd loadContentAllianceAd(KsScene ksScene);

    @KsAdSdkApi
    @Keep
    @MainThread
    KsContentPage loadContentPage(KsScene ksScene);

    @KsAdSdkApi
    @Keep
    @MainThread
    KsContentPage loadContentPageByPush(KsScene ksScene, String str);

    @KsAdSdkApi
    @Keep
    @MainThread
    void loadDrawAd(KsScene ksScene, @NonNull DrawAdListener drawAdListener);

    @KsAdSdkApi
    @Keep
    @MainThread
    void loadEntryElement(KsScene ksScene, @NonNull EntryElementListener<KsEntryElement> entryElementListener);

    @KsAdSdkApi
    @Keep
    @MainThread
    void loadEntryElement(KsScene ksScene, @NonNull EntryElementListener<KsEntryElement> entryElementListener, boolean z);

    @KsAdSdkApi
    @Keep
    @Deprecated
    @MainThread
    void loadFeedAd(KsScene ksScene, @NonNull FeedAdListener feedAdListener);

    @KsAdSdkApi
    @Keep
    @MainThread
    KsFeedPage loadFeedPage(KsScene ksScene);

    @KsAdSdkApi
    @Keep
    void loadFullScreenVideoAd(KsScene ksScene, @NonNull FullScreenVideoAdListener fullScreenVideoAdListener);

    @KsAdSdkApi
    @Keep
    @MainThread
    void loadNativeAd(KsScene ksScene, @NonNull NativeAdListener nativeAdListener);

    @KsAdSdkApi
    @Keep
    @MainThread
    void loadRewardVideoAd(KsScene ksScene, @NonNull RewardVideoAdListener rewardVideoAdListener);

    @KsAdSdkApi
    @Keep
    @MainThread
    void loadSplashScreenAd(@NonNull KsScene ksScene, @NonNull SplashScreenAdListener splashScreenAdListener);
}
