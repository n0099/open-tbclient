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
/* loaded from: classes4.dex */
public class at {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f10812a = true;

    public static List<com.kwad.sdk.core.g.a.a> a(Context context, int i) {
        WifiManager wifiManager;
        ArrayList arrayList = new ArrayList();
        if (context == null || !f10812a) {
            return arrayList;
        }
        try {
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
        }
        if ((Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") != -1 || ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") != -1) && (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) != null) {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            List<ScanResult> scanResults = wifiManager.getScanResults();
            if (scanResults != null) {
                for (ScanResult scanResult : scanResults) {
                    com.kwad.sdk.core.g.a.a aVar = new com.kwad.sdk.core.g.a.a();
                    aVar.f9156b = scanResult.SSID;
                    aVar.c = scanResult.BSSID;
                    aVar.f9155a = scanResult.level;
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
            return arrayList;
        }
        return arrayList;
    }

    public static void a(SdkConfig sdkConfig) {
        f10812a = sdkConfig.canReadNearbyWifiList();
    }
}
