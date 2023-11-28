package com.kwad.sdk.utils;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.baidu.tbadk.mutiprocess.live.YyLiveRoomConfig;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class bu {
    public static boolean aPB;
    public static final List<a> aPC = new ArrayList();

    /* loaded from: classes10.dex */
    public static class a implements com.kwad.sdk.core.b {
        public String aPD;
        public String aPE;
        public int level;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            t.putValue(jSONObject, "level", this.level);
            t.putValue(jSONObject, YyLiveRoomConfig.KEY_SSID, this.aPD);
            t.putValue(jSONObject, "bssid", this.aPE);
            return jSONObject;
        }
    }

    public static boolean dj(Context context) {
        if (context.getApplicationInfo().targetSdkVersion >= 29 && Build.VERSION.SDK_INT >= 29) {
            if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.g) == -1) {
                return true;
            }
            return false;
        } else if (Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.g) == -1 && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.h) == -1) {
            return true;
        } else {
            return false;
        }
    }

    public static List<a> n(Context context, int i) {
        if (au.KO()) {
            return new ArrayList();
        }
        if (!aPB && ServiceProvider.Jo().canReadNearbyWifiList() && aPC.isEmpty() && context != null) {
            if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).T(32L)) {
                return aPC;
            }
            try {
            } catch (Exception e) {
                aPB = true;
                com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            }
            if (dj(context)) {
                return aPC;
            }
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            if (wifiManager == null) {
                return aPC;
            }
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            List<ScanResult> scanResults = wifiManager.getScanResults();
            if (scanResults != null) {
                for (ScanResult scanResult : scanResults) {
                    a aVar = new a();
                    aVar.aPD = scanResult.SSID;
                    aVar.aPE = scanResult.BSSID;
                    aVar.level = scanResult.level;
                    if (connectionInfo.getBSSID() != null && scanResult.BSSID != null && TextUtils.equals(connectionInfo.getBSSID().replace("\"", ""), scanResult.BSSID.replace("\"", "")) && connectionInfo.getSSID() != null && scanResult.SSID != null && TextUtils.equals(connectionInfo.getSSID().replace("\"", ""), scanResult.SSID.replace("\"", ""))) {
                        aPC.add(0, aVar);
                    } else {
                        aPC.add(aVar);
                    }
                    if (aPC.size() >= i) {
                        return aPC;
                    }
                }
            }
            return aPC;
        }
        return aPC;
    }
}
