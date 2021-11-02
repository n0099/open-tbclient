package com.qq.e.ads.banner2;

import com.qq.e.comm.util.AdError;
/* loaded from: classes2.dex */
public interface UnifiedBannerADListener {
    void onADClicked();

    void onADCloseOverlay();

    void onADClosed();

    void onADExposure();

    void onADLeftApplication();

    void onADOpenOverlay();

    void onADReceive();

    void onNoAD(AdError adError);
}
