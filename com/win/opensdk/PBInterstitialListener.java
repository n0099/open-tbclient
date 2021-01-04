package com.win.opensdk;
/* loaded from: classes4.dex */
public interface PBInterstitialListener extends PBListener {
    void onInterstitialDismissed();

    void onInterstitialDisplayed();

    void onInterstitialShowFail(String str);
}
