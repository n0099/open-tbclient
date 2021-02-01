package com.fun.ad.sdk;
/* loaded from: classes6.dex */
public interface FunDrawVideoAdInteractionListener {
    void onAdClick(String str);

    void onAdError(String str, int i, String str2);

    void onAdShow(String str);

    void onClickRetry(String str);

    void onProgressUpdate(String str, long j, long j2);

    void onVideoAdComplete(String str);

    void onVideoAdContinuePlay(String str);

    void onVideoAdPaused(String str);

    void onVideoAdStartPlay(String str);

    void onVideoError(String str, int i, int i2);

    void onVideoLoad(String str);
}
