package com.fun.ad.sdk;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import java.util.List;
/* loaded from: classes4.dex */
public interface FunAdLoader {
    void destroy();

    List<CacheStatistic> getCacheStatistics(String str);

    @Deprecated
    FunNativeAd getNativeAd(Context context);

    FunNativeAd2 getNativeAd2(Context context);

    boolean isReady();

    void load(Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener);

    void recycleLisener();

    <T extends ViewGroup> boolean show(Activity activity, T t, String str, FunAdInteractionListener funAdInteractionListener, FunNativeAdInflater funNativeAdInflater);

    <T extends ViewGroup> FunSplashAd showSplash(Activity activity, T t, String str, FunAdInteractionListener funAdInteractionListener);
}
