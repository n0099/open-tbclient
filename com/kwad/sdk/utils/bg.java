package com.kwad.sdk.utils;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.kuaishou.weapon.adsdk.DeviceInfo;
import com.kwad.sdk.api.SdkConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class bg {
    public static boolean a = true;
    public static boolean b;
    public static final List<com.kwad.sdk.core.request.model.a> c = new ArrayList();

    public static List<com.kwad.sdk.core.request.model.a> a(Context context, int i) {
        WifiManager wifiManager;
        if (ao.k()) {
            return new ArrayList();
        }
        if (b || !a || !c.isEmpty() || context == null) {
            return c;
        }
        if (com.kwad.sdk.core.config.b.a(32L)) {
            return c;
        }
        try {
        } catch (Exception e) {
            b = true;
            com.kwad.sdk.core.d.a.b(e);
        }
        if (!a(context) && (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) != null) {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            List<ScanResult> wifiScanResults = com.kwad.sdk.b.a.booleanValue() ? DeviceInfo.getWifiScanResults(context) : wifiManager.getScanResults();
            if (wifiScanResults != null) {
                for (ScanResult scanResult : wifiScanResults) {
                    com.kwad.sdk.core.request.model.a aVar = new com.kwad.sdk.core.request.model.a();
                    aVar.b = scanResult.SSID;
                    aVar.c = scanResult.BSSID;
                    aVar.a = scanResult.level;
                    if (connectionInfo.getBSSID() == null || scanResult.BSSID == null || !TextUtils.equals(connectionInfo.getBSSID().replace("\"", ""), scanResult.BSSID.replace("\"", "")) || connectionInfo.getSSID() == null || scanResult.SSID == null || !TextUtils.equals(connectionInfo.getSSID().replace("\"", ""), scanResult.SSID.replace("\"", ""))) {
                        c.add(aVar);
                    } else {
                        c.add(0, aVar);
                    }
                    if (c.size() >= i) {
                        return c;
                    }
                }
            }
            return c;
        }
        return c;
    }

    public static void a(SdkConfig sdkConfig) {
        a = sdkConfig.canReadNearbyWifiList();
    }

    public static boolean a(Context context) {
        return (context.getApplicationInfo().targetSdkVersion < 29 || Build.VERSION.SDK_INT < 29) ? Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == -1 && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == -1 : ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == -1;
    }
}
