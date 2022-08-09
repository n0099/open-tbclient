package com.kwad.sdk.utils;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.baidu.tbadk.core.leveiconlivepolling.PollingModel;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class bi {
    public static boolean apo;
    public static final List<a> app = new ArrayList();

    /* loaded from: classes5.dex */
    public static class a implements com.kwad.sdk.core.b {
        public String apq;
        public String apr;
        public int level;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            r.putValue(jSONObject, PollingModel.LEVEL, this.level);
            r.putValue(jSONObject, "ssid", this.apq);
            r.putValue(jSONObject, "bssid", this.apr);
            return jSONObject;
        }
    }

    public static boolean dA(Context context) {
        return (context.getApplicationInfo().targetSdkVersion < 29 || Build.VERSION.SDK_INT < 29) ? Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.h.g) == -1 && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.h.h) == -1 : ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.h.g) == -1;
    }

    public static List<a> h(Context context, int i) {
        WifiManager wifiManager;
        if (aq.Ad()) {
            return new ArrayList();
        }
        if (apo || !((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getSdkConfig().canReadNearbyWifiList() || !app.isEmpty() || context == null) {
            return app;
        }
        if (((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).i(32L)) {
            return app;
        }
        try {
        } catch (Exception e) {
            apo = true;
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
        }
        if (!dA(context) && (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) != null) {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            List<ScanResult> scanResults = wifiManager.getScanResults();
            if (scanResults != null) {
                for (ScanResult scanResult : scanResults) {
                    a aVar = new a();
                    aVar.apq = scanResult.SSID;
                    aVar.apr = scanResult.BSSID;
                    aVar.level = scanResult.level;
                    if (connectionInfo.getBSSID() == null || scanResult.BSSID == null || !TextUtils.equals(connectionInfo.getBSSID().replace("\"", ""), scanResult.BSSID.replace("\"", "")) || connectionInfo.getSSID() == null || scanResult.SSID == null || !TextUtils.equals(connectionInfo.getSSID().replace("\"", ""), scanResult.SSID.replace("\"", ""))) {
                        app.add(aVar);
                    } else {
                        app.add(0, aVar);
                    }
                    if (app.size() >= i) {
                        return app;
                    }
                }
            }
            return app;
        }
        return app;
    }
}
