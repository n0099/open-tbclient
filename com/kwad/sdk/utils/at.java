package com.kwad.sdk.utils;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.api.SdkConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class at {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f36762a = true;

    public static List<com.kwad.sdk.core.g.a.a> a(Context context, int i) {
        WifiManager wifiManager;
        ArrayList arrayList = new ArrayList();
        if (context != null && f36762a) {
            try {
                if ((Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == -1 && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == -1) || (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) == null) {
                    return arrayList;
                }
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                List<ScanResult> scanResults = wifiManager.getScanResults();
                if (scanResults != null) {
                    for (ScanResult scanResult : scanResults) {
                        com.kwad.sdk.core.g.a.a aVar = new com.kwad.sdk.core.g.a.a();
                        aVar.f33631b = scanResult.SSID;
                        aVar.f33632c = scanResult.BSSID;
                        aVar.f33630a = scanResult.level;
                        if (connectionInfo.getBSSID() == null || scanResult.BSSID == null || !TextUtils.equals(connectionInfo.getBSSID().replace("\"", ""), scanResult.BSSID.replace("\"", "")) || connectionInfo.getSSID() == null || scanResult.SSID == null || !TextUtils.equals(connectionInfo.getSSID().replace("\"", ""), scanResult.SSID.replace("\"", ""))) {
                            arrayList.add(aVar);
                        } else {
                            arrayList.add(0, aVar);
                        }
                        if (arrayList.size() >= i) {
                            return arrayList;
                        }
                    }
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }
        return arrayList;
    }

    public static void a(SdkConfig sdkConfig) {
        f36762a = sdkConfig.canReadNearbyWifiList();
    }
}
