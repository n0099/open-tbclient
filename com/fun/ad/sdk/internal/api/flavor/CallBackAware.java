package com.fun.ad.sdk.internal.api.flavor;

import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.internal.api.ripper.RippedAd;
/* loaded from: classes7.dex */
public interface CallBackAware {
    boolean needRipper();

    void show(FunAdInteractionListener funAdInteractionListener, String str, String str2, String str3, double d2, RippedAd rippedAd);
}
