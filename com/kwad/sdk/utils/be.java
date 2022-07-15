package com.kwad.sdk.utils;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.baidu.sofire.utility.PermissionChecker;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class be {
    public static boolean a = true;
    public static boolean b;
    public static final List<a> c = new ArrayList();

    /* loaded from: classes5.dex */
    public static class a implements com.kwad.sdk.core.b {
        public int a;
        public String b;
        public String c;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            r.a(jSONObject, "level", this.a);
            r.a(jSONObject, "ssid", this.b);
            r.a(jSONObject, "bssid", this.c);
            return jSONObject;
        }
    }

    public static List<a> a(Context context, int i) {
        WifiManager wifiManager;
        if (an.k()) {
            return new ArrayList();
        }
        if (b || !a || !c.isEmpty() || context == null) {
            return c;
        }
        if (((com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class)).a(32L)) {
            return c;
        }
        try {
        } catch (Exception e) {
            b = true;
            com.kwad.sdk.core.d.b.b(e);
        }
        if (!a(context) && (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) != null) {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            List<ScanResult> scanResults = wifiManager.getScanResults();
            if (scanResults != null) {
                for (ScanResult scanResult : scanResults) {
                    a aVar = new a();
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
        return (context.getApplicationInfo().targetSdkVersion < 29 || Build.VERSION.SDK_INT < 29) ? Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(context, PermissionChecker.ACCESS_FINE_LOCATION) == -1 && ContextCompat.checkSelfPermission(context, PermissionChecker.ACCESS_COARSE_LOCATION) == -1 : ContextCompat.checkSelfPermission(context, PermissionChecker.ACCESS_FINE_LOCATION) == -1;
    }
}
