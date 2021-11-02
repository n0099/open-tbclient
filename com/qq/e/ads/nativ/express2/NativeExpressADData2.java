package com.qq.e.ads.nativ.express2;

import android.view.View;
import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
import java.util.Map;
@Deprecated
/* loaded from: classes2.dex */
public interface NativeExpressADData2 extends ApkDownloadComplianceInterface {
    void destroy();

    View getAdView();

    int getECPM();

    String getECPMLevel();

    Map<String, Object> getExtraInfo();

    int getVideoDuration();

    boolean isVideoAd();

    void render();

    void sendLossNotification(int i2, int i3, String str);

    void sendWinNotification(int i2);

    void setAdEventListener(AdEventListener adEventListener);

    void setBidECPM(int i2);

    void setMediaListener(MediaEventListener mediaEventListener);
}
