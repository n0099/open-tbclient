package com.fun.ad.sdk;

import java.util.List;
/* loaded from: classes15.dex */
public interface FunNativeAdLoadListener {
    void onError(String str, int i, String str2);

    void onNativeAdLoaded(String str, List<FunNativeAd> list);
}
