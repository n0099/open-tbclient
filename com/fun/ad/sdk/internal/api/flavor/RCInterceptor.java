package com.fun.ad.sdk.internal.api.flavor;

import com.fun.ad.sdk.internal.api.ripper.RippedAd;
/* loaded from: classes6.dex */
public interface RCInterceptor {
    void onAdClick(RippedAd rippedAd);

    void onAdShow(RippedAd rippedAd);

    boolean shouldInterceptLoad();

    boolean shouldInterceptShow(RippedAd rippedAd);
}
