package com.fun.ad.sdk;
/* loaded from: classes4.dex */
public interface FunAdInteractionListener {
    void onAdClicked(String str);

    void onAdClose(String str);

    void onAdError(String str);

    void onAdShow(String str);

    void onRewardedVideo(String str);
}
