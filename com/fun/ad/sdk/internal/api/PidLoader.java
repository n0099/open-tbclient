package com.fun.ad.sdk.internal.api;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tieba.fl9;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.FunSplashAd;
import com.fun.ad.sdk.internal.api.config.Ssp;
/* loaded from: classes7.dex */
public interface PidLoader {
    void addListener(fl9 fl9Var);

    void destroy();

    void destroy(boolean z);

    int getAdCount();

    FunAdType getAdType();

    double getBiddingOrBasePrices();

    FunNativeAd2 getNativeAd2(Context context, String str);

    Ssp.Pid getPid();

    boolean isLoaded();

    boolean load(Context context, FunAdSlot funAdSlot, SidSessionMeta sidSessionMeta);

    void removeListener(fl9 fl9Var);

    void setBiddingResult(double d, double d2, int i);

    boolean show(Activity activity, ViewGroup viewGroup, String str, SidSessionMeta sidSessionMeta);

    FunSplashAd showSplash(Activity activity, ViewGroup viewGroup, String str, SidSessionMeta sidSessionMeta);
}
