package com.fun.ad.sdk.internal.api.ripper;
/* loaded from: classes3.dex */
public interface AdRipper {
    void destroy(Object obj);

    RippedAd getRippedAd(Object obj);

    void preParseRippedAd(Object obj);

    void report(Object obj, String str, long j2);
}
