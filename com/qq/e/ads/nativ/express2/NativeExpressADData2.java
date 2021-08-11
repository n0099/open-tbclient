package com.qq.e.ads.nativ.express2;

import android.view.View;
import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
@Deprecated
/* loaded from: classes10.dex */
public interface NativeExpressADData2 extends ApkDownloadComplianceInterface {
    void destroy();

    View getAdView();

    int getECPM();

    String getECPMLevel();

    int getVideoDuration();

    boolean isVideoAd();

    void render();

    void setAdEventListener(AdEventListener adEventListener);

    void setMediaListener(MediaEventListener mediaEventListener);
}
