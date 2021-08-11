package com.qq.e.ads.splash;

import com.qq.e.comm.util.AdError;
/* loaded from: classes10.dex */
public interface SplashADListener {
    void onADClicked();

    void onADDismissed();

    void onADExposure();

    void onADLoaded(long j2);

    void onADPresent();

    void onADTick(long j2);

    void onNoAD(AdError adError);
}
