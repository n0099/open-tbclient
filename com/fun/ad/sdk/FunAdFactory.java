package com.fun.ad.sdk;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
/* loaded from: classes7.dex */
public interface FunAdFactory {
    void destroyAd(String str);

    @Deprecated
    FunNativeAd getNativeAd(Context context, String str);

    FunNativeAd2 getNativeAd2(Context context, String str);

    boolean isAdReady(String str);

    void loadAd(Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener);

    void showAd(Activity activity, ViewGroup viewGroup, String str, FunAdInteractionListener funAdInteractionListener);

    void showAd(Activity activity, String str, FunAdInteractionListener funAdInteractionListener, FunNativeAdInflater funNativeAdInflater);

    FunSplashAd showSplash(Activity activity, ViewGroup viewGroup, String str, FunAdInteractionListener funAdInteractionListener);
}
