package com.fun.ad.sdk;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
/* loaded from: classes6.dex */
public interface FunAdFactory {
    void destroyAd(String str);

    FunNativeAd getNativeAd(Context context, String str);

    boolean isAdReady(String str);

    void loadAd(Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener);

    void showAd(Activity activity, ViewGroup viewGroup, String str, FunAdInteractionListener funAdInteractionListener);

    void showAd(Activity activity, String str, FunAdInteractionListener funAdInteractionListener, FunNativeAdInflater funNativeAdInflater);
}
