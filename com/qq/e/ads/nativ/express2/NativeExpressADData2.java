package com.qq.e.ads.nativ.express2;

import android.view.View;
import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
/* loaded from: classes6.dex */
public interface NativeExpressADData2 extends ApkDownloadComplianceInterface {
    void destroy();

    View getAdView();

    String getECPMLevel();

    int getVideoDuration();

    boolean isVideoAd();

    void render();

    void setAdEventListener(AdEventListener adEventListener);

    void setMediaListener(MediaEventListener mediaEventListener);
}
