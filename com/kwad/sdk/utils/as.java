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
public class as {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f34126a = true;

    public static List<com.kwad.sdk.core.g.a.a> a(Context context, int i2) {
        WifiManager wifiManager;
        ArrayList arrayList = new ArrayList();
        if (context == null || !f34126a || com.kwad.sdk.core.config.c.a(32L)) {
            return arrayList;
        }
        try {
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        if ((Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == -1 && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == -1) || (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) == null) {
            return arrayList;
        }
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        List<ScanResult> scanResults = wifiManager.getScanResults();
        if (scanResults != null) {
            for (ScanResult scanResult : scanResults) {
                com.kwad.sdk.core.g.a.a aVar = new com.kwad.sdk.core.g.a.a();
                aVar.f32292b = scanResult.SSID;
                aVar.f32293c = scanResult.BSSID;
                aVar.f32291a = scanResult.level;
                if (connectionInfo.getBSSID() == null || scanResult.BSSID == null || !TextUtils.equals(connectionInfo.getBSSID().replace("\"", ""), scanResult.BSSID.replace("\"", "")) || connectionInfo.getSSID() == null || scanResult.SSID == null || !TextUtils.equals(connectionInfo.getSSID().replace("\"", ""), scanResult.SSID.replace("\"", ""))) {
                    arrayList.add(aVar);
                } else {
                    arrayList.add(0, aVar);
                }
                if (arrayList.size() >= i2) {
                    return arrayList;
                }
            }
        }
        return arrayList;
    }

    public static void a(SdkConfig sdkConfig) {
        f34126a = sdkConfig.canReadNearbyWifiList();
    }
}
