package com.fun.ad.sdk;
/* loaded from: classes6.dex */
public interface FunAdInteractionListener {
    void onAdClicked(String str, String str2, String str3);

    void onAdClose(String str);

    void onAdError(String str);

    void onAdShow(String str, String str2, String str3);

    void onRewardedVideo(String str);
}
