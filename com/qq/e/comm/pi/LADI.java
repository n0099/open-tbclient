package com.qq.e.comm.pi;

import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
import java.util.Map;
/* loaded from: classes7.dex */
public interface LADI extends ApkDownloadComplianceInterface {
    int getECPM();

    String getECPMLevel();

    Map<String, Object> getExtraInfo();

    void sendLossNotification(int i, int i2, String str);

    void sendWinNotification(int i);

    void setBidECPM(int i);
}
