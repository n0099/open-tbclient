package com.fun.ad.sdk.internal.api;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import c.d.n0;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.FunNativeAdInflater;
import com.fun.ad.sdk.FunSplashAd;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.ripper.RippedAd;
/* loaded from: classes6.dex */
public interface PidLoader {
    void addListener(n0 n0Var);

    void destroy();

    void destroy(boolean z);

    int getAdCount();

    FunAdType getAdType();

    @Deprecated
    FunNativeAd getNativeAd(Context context, String str);

    FunNativeAd2 getNativeAd2(Context context, String str);

    Ssp.Pid getPid();

    RippedAd getRippedAd();

    boolean isLoaded();

    boolean load(Context context, FunAdSlot funAdSlot);

    void removeListener(n0 n0Var);

    boolean show(Activity activity, ViewGroup viewGroup, String str, FunNativeAdInflater funNativeAdInflater);

    FunSplashAd showSplash(Activity activity, ViewGroup viewGroup, String str);
}
