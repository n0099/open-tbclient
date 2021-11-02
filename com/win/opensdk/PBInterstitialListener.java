package com.win.opensdk;
/* loaded from: classes2.dex */
public interface PBInterstitialListener extends PBListener {
    void onInterstitialDismissed();

    void onInterstitialDisplayed();

    void onInterstitialShowFail(String str);
}
