package com.fun.ad.sdk;
/* loaded from: classes4.dex */
public interface FunAdCallback {
    void onAdClicked(String str, String str2, String str3, String str4);

    void onAdClose(String str, String str2, String str3, String str4);

    void onAdLoad(String str, String str2, String str3, String str4);

    void onAdLoadError(String str, String str2, String str3, String str4, int i, String str5);

    void onAdLoaded(String str, String str2, String str3, String str4);

    void onAdShow(String str, String str2, String str3, String str4);

    void onAdShowError(String str, String str2, String str3, String str4, int i, String str5);

    void onRewardedVideo(String str, String str2, String str3, String str4);
}
