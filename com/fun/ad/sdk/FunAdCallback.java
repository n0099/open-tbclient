package com.fun.ad.sdk;
/* loaded from: classes3.dex */
public interface FunAdCallback {
    void onAdClicked(String str, String str2, String str3);

    void onAdClose(String str, String str2, String str3);

    void onAdLoad(String str, String str2, String str3);

    void onAdLoadError(String str, String str2, String str3, int i2, String str4);

    void onAdLoaded(String str, String str2, String str3);

    void onAdShow(String str, String str2, String str3);

    void onAdShowError(String str, String str2, String str3, int i2, String str4);

    void onRewardedVideo(String str, String str2, String str3);
}
