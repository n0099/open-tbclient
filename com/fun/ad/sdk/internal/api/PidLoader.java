package com.fun.ad.sdk.internal.api;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tieba.c6b;
import com.baidu.tieba.e6b;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.FunSplashAd;
import com.fun.ad.sdk.internal.api.config.Ssp;
/* loaded from: classes9.dex */
public interface PidLoader {
    void addListener(e6b e6bVar);

    void destroy();

    void destroy(boolean z);

    int getAdCount();

    FunAdType getAdType();

    double getBiddingOrBasePrices();

    FunNativeAd2 getNativeAd2(Context context, String str);

    Ssp.Pid getPid();

    c6b getSubAidInfo();

    boolean isLoaded();

    boolean load(Context context, FunAdSlot funAdSlot, SidSessionMeta sidSessionMeta);

    void removeListener(e6b e6bVar);

    void setBiddingResult(String str, double d, double d2, int i);

    boolean show(Activity activity, ViewGroup viewGroup, String str, SidSessionMeta sidSessionMeta);

    FunSplashAd showSplash(Activity activity, ViewGroup viewGroup, String str, SidSessionMeta sidSessionMeta);
}
