package com.qq.e.comm.pi;

import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
/* loaded from: classes10.dex */
public interface LADI extends ApkDownloadComplianceInterface {
    int getECPM();

    String getECPMLevel();

    void sendLossNotification(int i2, int i3, String str);

    void sendWinNotification(int i2);
}
