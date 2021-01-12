package com.win.opensdk;
/* loaded from: classes3.dex */
public interface PBInterstitialListener extends PBListener {
    void onInterstitialDismissed();

    void onInterstitialDisplayed();

    void onInterstitialShowFail(String str);
}
