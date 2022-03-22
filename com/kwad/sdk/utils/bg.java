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
/* loaded from: classes7.dex */
public class bg {
    public static boolean a = true;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f41383b;

    /* renamed from: c  reason: collision with root package name */
    public static final List<com.kwad.sdk.core.request.model.a> f41384c = new ArrayList();

    public static List<com.kwad.sdk.core.request.model.a> a(Context context, int i) {
        WifiManager wifiManager;
        if (ao.k()) {
            return new ArrayList();
        }
        if (f41383b || !a || !f41384c.isEmpty() || context == null) {
            return f41384c;
        }
        if (com.kwad.sdk.core.config.b.a(32L)) {
            return f41384c;
        }
        try {
        } catch (Exception e2) {
            f41383b = true;
            com.kwad.sdk.core.d.a.b(e2);
        }
        if (!a(context) && (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) != null) {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            List<ScanResult> wifiScanResults = com.kwad.sdk.b.a.booleanValue() ? DeviceInfo.getWifiScanResults(context) : wifiManager.getScanResults();
            if (wifiScanResults != null) {
                for (ScanResult scanResult : wifiScanResults) {
                    com.kwad.sdk.core.request.model.a aVar = new com.kwad.sdk.core.request.model.a();
                    aVar.f39810b = scanResult.SSID;
                    aVar.f39811c = scanResult.BSSID;
                    aVar.a = scanResult.level;
                    if (connectionInfo.getBSSID() == null || scanResult.BSSID == null || !TextUtils.equals(connectionInfo.getBSSID().replace("\"", ""), scanResult.BSSID.replace("\"", "")) || connectionInfo.getSSID() == null || scanResult.SSID == null || !TextUtils.equals(connectionInfo.getSSID().replace("\"", ""), scanResult.SSID.replace("\"", ""))) {
                        f41384c.add(aVar);
                    } else {
                        f41384c.add(0, aVar);
                    }
                    if (f41384c.size() >= i) {
                        return f41384c;
                    }
                }
            }
            return f41384c;
        }
        return f41384c;
    }

    public static void a(SdkConfig sdkConfig) {
        a = sdkConfig.canReadNearbyWifiList();
    }

    public static boolean a(Context context) {
        return (context.getApplicationInfo().targetSdkVersion < 29 || Build.VERSION.SDK_INT < 29) ? Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == -1 && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == -1 : ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == -1;
    }
}
