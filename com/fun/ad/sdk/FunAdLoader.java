package com.fun.ad.sdk;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import java.util.List;
/* loaded from: classes7.dex */
public interface FunAdLoader {
    void destroy();

    List getCacheStatistics(String str);

    FunNativeAd2 getNativeAd2(Context context);

    boolean isReady();

    void load(Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener);

    void recycleListener();

    boolean show(Activity activity, ViewGroup viewGroup, String str, FunAdInteractionListener funAdInteractionListener);

    FunSplashAd showSplash(Activity activity, ViewGroup viewGroup, String str, FunAdInteractionListener funAdInteractionListener);
}
