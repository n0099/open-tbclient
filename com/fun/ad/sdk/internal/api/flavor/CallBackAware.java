package com.fun.ad.sdk.internal.api.flavor;

import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.internal.api.ripper.RippedAd;
import java.util.Map;
/* loaded from: classes9.dex */
public interface CallBackAware {
    boolean needRipper();

    void onAdClicked(FunAdInteractionListener funAdInteractionListener, String str, String str2, String str3, RippedAd rippedAd, Map<String, String> map);

    void onAdClose(FunAdInteractionListener funAdInteractionListener, String str, String str2, String str3, Map<String, String> map);

    void onRewardedVideo(FunAdInteractionListener funAdInteractionListener, String str, boolean z, String str2, int i, String str3, Map<String, String> map);

    void show(FunAdInteractionListener funAdInteractionListener, String str, String str2, String str3, RippedAd rippedAd, Map<String, String> map);
}
