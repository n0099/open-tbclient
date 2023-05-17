package com.fun.ad.sdk.internal.api.ripper;
/* loaded from: classes9.dex */
public interface AdRipper {
    void destroy(Object obj);

    RippedAd getRippedAd(Object obj);

    RippedAd getRippedAd(Object obj, boolean z);

    void preParseRippedAd(Object obj);

    void report(Object obj, String str, long j);
}
