package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes15.dex */
public class bh {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static class a implements Comparator {
        private a() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((ScanResult) obj2).level - ((ScanResult) obj).level;
        }
    }

    public static String a(Context context) {
        WifiInfo connectionInfo;
        try {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            if (wifiManager != null && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                String ssid = connectionInfo.getSSID();
                try {
                    GDTLogger.d("WifiSsid=" + ssid);
                    return (Build.VERSION.SDK_INT < 17 || ssid == null || !ssid.startsWith("\"") || !ssid.endsWith("\"")) ? ssid : ssid.substring(1, ssid.length() - 1);
                } catch (Exception e) {
                    e = e;
                    GDTLogger.d("get wifi ssid encountered exception: " + e.getMessage());
                    return null;
                }
            }
            return null;
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static List<String> a(Context context, int i) {
        Exception exc;
        ArrayList arrayList;
        if (!v.c(context)) {
            return null;
        }
        try {
            List<ScanResult> scanResults = ((WifiManager) context.getSystemService("wifi")).getScanResults();
            if (scanResults == null || scanResults.size() == 0) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            try {
                Collections.sort(scanResults, new a());
                Iterator<ScanResult> it = scanResults.iterator();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (!it.hasNext()) {
                        break;
                    }
                    ScanResult next = it.next();
                    GDTLogger.d(next.SSID + "|" + next.BSSID + "|" + next.level);
                    arrayList2.add(next.BSSID.replace(":", "").toUpperCase() + "|" + next.level);
                    i2 = i3 + 1;
                    if (i2 == i) {
                        break;
                    }
                }
                return arrayList2;
            } catch (Exception e) {
                exc = e;
                arrayList = arrayList2;
                GDTLogger.d("Get wifi scan result encounter exception: " + exc.getMessage());
                return arrayList;
            }
        } catch (Exception e2) {
            exc = e2;
            arrayList = null;
        }
    }
}
