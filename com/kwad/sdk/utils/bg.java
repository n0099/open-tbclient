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
/* loaded from: classes3.dex */
public class bg {
    public static boolean a = true;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f57979b;

    /* renamed from: c  reason: collision with root package name */
    public static final List<com.kwad.sdk.core.request.model.a> f57980c = new ArrayList();

    public static List<com.kwad.sdk.core.request.model.a> a(Context context, int i2) {
        WifiManager wifiManager;
        if (ao.k()) {
            return new ArrayList();
        }
        if (f57979b || !a || !f57980c.isEmpty() || context == null) {
            return f57980c;
        }
        if (com.kwad.sdk.core.config.b.a(32L)) {
            return f57980c;
        }
        try {
        } catch (Exception e2) {
            f57979b = true;
            com.kwad.sdk.core.d.a.b(e2);
        }
        if (!a(context) && (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) != null) {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            List<ScanResult> wifiScanResults = com.kwad.sdk.b.a.booleanValue() ? DeviceInfo.getWifiScanResults(context) : wifiManager.getScanResults();
            if (wifiScanResults != null) {
                for (ScanResult scanResult : wifiScanResults) {
                    com.kwad.sdk.core.request.model.a aVar = new com.kwad.sdk.core.request.model.a();
                    aVar.f56186b = scanResult.SSID;
                    aVar.f56187c = scanResult.BSSID;
                    aVar.a = scanResult.level;
                    if (connectionInfo.getBSSID() == null || scanResult.BSSID == null || !TextUtils.equals(connectionInfo.getBSSID().replace("\"", ""), scanResult.BSSID.replace("\"", "")) || connectionInfo.getSSID() == null || scanResult.SSID == null || !TextUtils.equals(connectionInfo.getSSID().replace("\"", ""), scanResult.SSID.replace("\"", ""))) {
                        f57980c.add(aVar);
                    } else {
                        f57980c.add(0, aVar);
                    }
                    if (f57980c.size() >= i2) {
                        return f57980c;
                    }
                }
            }
            return f57980c;
        }
        return f57980c;
    }

    public static void a(SdkConfig sdkConfig) {
        a = sdkConfig.canReadNearbyWifiList();
    }

    public static boolean a(Context context) {
        return (context.getApplicationInfo().targetSdkVersion < 29 || Build.VERSION.SDK_INT < 29) ? Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.un.s.f55291g) == -1 && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.un.s.f55292h) == -1 : ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.un.s.f55291g) == -1;
    }
}
