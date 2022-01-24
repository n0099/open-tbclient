package com.qq.e.ads.banner2;

import com.qq.e.comm.util.AdError;
/* loaded from: classes4.dex */
public interface UnifiedBannerADListener {
    void onADClicked();

    @Deprecated
    void onADCloseOverlay();

    void onADClosed();

    void onADExposure();

    void onADLeftApplication();

    @Deprecated
    void onADOpenOverlay();

    void onADReceive();

    void onNoAD(AdError adError);
}
