package com.fun.ad.sdk;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import java.util.List;
/* loaded from: classes9.dex */
public interface FunAdFactory {
    void destroyAd(String str);

    List<CacheStatistic> getCacheStatistics(String str);

    FunNativeAd2 getNativeAd2(Context context, String str);

    boolean isAdReady(String str);

    void loadAd(Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener);

    void showAd(Activity activity, ViewGroup viewGroup, String str, FunAdInteractionListener funAdInteractionListener);

    FunSplashAd showSplash(Activity activity, ViewGroup viewGroup, String str, FunAdInteractionListener funAdInteractionListener);
}
