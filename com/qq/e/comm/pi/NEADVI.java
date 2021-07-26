package com.qq.e.comm.pi;

import com.qq.e.ads.nativ.ADSize;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
/* loaded from: classes6.dex */
public interface NEADVI extends ApkDownloadComplianceInterface {
    void destroy();

    int getECPM();

    String getECPMLevel();

    void preloadVideo();

    void render();

    void reportAdNegative();

    void setAdListener(ADListener aDListener);

    void setAdSize(ADSize aDSize);
}
