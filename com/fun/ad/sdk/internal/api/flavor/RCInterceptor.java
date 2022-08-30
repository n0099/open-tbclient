package com.fun.ad.sdk.internal.api.flavor;

import com.fun.ad.sdk.internal.api.ripper.RippedAd;
/* loaded from: classes7.dex */
public interface RCInterceptor {
    boolean needRipper();

    void onAdClick(RippedAd rippedAd);

    void onAdShow(RippedAd rippedAd);

    boolean shouldInterceptLoad();

    boolean shouldInterceptShow(RippedAd rippedAd);
}
