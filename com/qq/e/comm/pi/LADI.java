package com.qq.e.comm.pi;

import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
import java.util.Map;
/* loaded from: classes8.dex */
public interface LADI extends ApkDownloadComplianceInterface {
    int getECPM();

    String getECPMLevel();

    Map<String, Object> getExtraInfo();

    void sendLossNotification(int i2, int i3, String str);

    void sendWinNotification(int i2);

    void setBidECPM(int i2);
}
