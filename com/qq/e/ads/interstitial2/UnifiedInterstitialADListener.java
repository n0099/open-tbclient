package com.qq.e.ads.interstitial2;

import com.qq.e.comm.util.AdError;
/* loaded from: classes4.dex */
public interface UnifiedInterstitialADListener {
    void onADClicked();

    void onADClosed();

    void onADExposure();

    void onADLeftApplication();

    void onADOpened();

    void onADReceive();

    void onNoAD(AdError adError);

    void onVideoCached();
}
