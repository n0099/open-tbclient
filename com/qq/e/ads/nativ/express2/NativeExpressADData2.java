package com.qq.e.ads.nativ.express2;

import android.view.View;
import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
import java.util.Map;
@Deprecated
/* loaded from: classes5.dex */
public interface NativeExpressADData2 extends ApkDownloadComplianceInterface {
    void destroy();

    View getAdView();

    int getECPM();

    String getECPMLevel();

    Map<String, Object> getExtraInfo();

    int getVideoDuration();

    boolean isVideoAd();

    void render();

    void sendLossNotification(int i, int i2, String str);

    void sendWinNotification(int i);

    void setAdEventListener(AdEventListener adEventListener);

    void setBidECPM(int i);

    void setMediaListener(MediaEventListener mediaEventListener);
}
