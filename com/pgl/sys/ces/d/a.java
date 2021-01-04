package com.pgl.sys.ces.d;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import java.util.List;
/* loaded from: classes4.dex */
public interface a {
    WifiInfo getConnectionInfo();

    String getDeviceId();

    String getHardwareAddress();

    String getLatitude();

    String getLongitude();

    List<ScanResult> getScanResults();

    String getSubscriberId();
}
