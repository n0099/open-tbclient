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
/* loaded from: classes4.dex */
public class bg {
    public static boolean a = true;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f58146b;

    /* renamed from: c  reason: collision with root package name */
    public static final List<com.kwad.sdk.core.request.model.a> f58147c = new ArrayList();

    public static List<com.kwad.sdk.core.request.model.a> a(Context context, int i2) {
        WifiManager wifiManager;
        if (ao.k()) {
            return new ArrayList();
        }
        if (f58146b || !a || !f58147c.isEmpty() || context == null) {
            return f58147c;
        }
        if (com.kwad.sdk.core.config.b.a(32L)) {
            return f58147c;
        }
        try {
        } catch (Exception e2) {
            f58146b = true;
            com.kwad.sdk.core.d.a.b(e2);
        }
        if (!a(context) && (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) != null) {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            List<ScanResult> wifiScanResults = com.kwad.sdk.b.a.booleanValue() ? DeviceInfo.getWifiScanResults(context) : wifiManager.getScanResults();
            if (wifiScanResults != null) {
                for (ScanResult scanResult : wifiScanResults) {
                    com.kwad.sdk.core.request.model.a aVar = new com.kwad.sdk.core.request.model.a();
                    aVar.f56353b = scanResult.SSID;
                    aVar.f56354c = scanResult.BSSID;
                    aVar.a = scanResult.level;
                    if (connectionInfo.getBSSID() == null || scanResult.BSSID == null || !TextUtils.equals(connectionInfo.getBSSID().replace("\"", ""), scanResult.BSSID.replace("\"", "")) || connectionInfo.getSSID() == null || scanResult.SSID == null || !TextUtils.equals(connectionInfo.getSSID().replace("\"", ""), scanResult.SSID.replace("\"", ""))) {
                        f58147c.add(aVar);
                    } else {
                        f58147c.add(0, aVar);
                    }
                    if (f58147c.size() >= i2) {
                        return f58147c;
                    }
                }
            }
            return f58147c;
        }
        return f58147c;
    }

    public static void a(SdkConfig sdkConfig) {
        a = sdkConfig.canReadNearbyWifiList();
    }

    public static boolean a(Context context) {
        return (context.getApplicationInfo().targetSdkVersion < 29 || Build.VERSION.SDK_INT < 29) ? Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.un.s.f55458g) == -1 && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.un.s.f55459h) == -1 : ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.un.s.f55458g) == -1;
    }
}
