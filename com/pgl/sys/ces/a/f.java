package com.pgl.sys.ces.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a implements Comparator<Object> {
        a() {
        }

        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int abs = Math.abs(((ScanResult) obj).level);
            int abs2 = Math.abs(((ScanResult) obj2).level);
            if (abs > abs2) {
                return 1;
            }
            return abs == abs2 ? 0 : -1;
        }
    }

    public static String a(Context context) {
        String num;
        String str = null;
        try {
            com.pgl.sys.ces.d.a e = com.pgl.sys.ces.b.e();
            if (e != null) {
                WifiInfo connectionInfo = e.getConnectionInfo();
                String bssid = connectionInfo.getBSSID();
                String trim = bssid == null ? "" : bssid.trim();
                String ssid = connectionInfo.getSSID();
                str = trim + "[<!>]" + (ssid == null ? "" : ssid.trim()).replace(' ', ' ').replace('\'', ' ').replace('\"', ' ') + "[<!>]" + (Integer.toString(connectionInfo.getIpAddress()) == null ? "" : num.trim()) + "[<!>]";
            }
        } catch (Throwable th) {
        }
        return str == null ? "" : str.trim();
    }

    public static String b(Context context) {
        String str;
        List<ScanResult> scanResults;
        JSONArray jSONArray = new JSONArray();
        if (context == null) {
            return jSONArray.toString();
        }
        try {
            com.pgl.sys.ces.d.a e = com.pgl.sys.ces.b.e();
            scanResults = e != null ? e.getScanResults() : null;
        } catch (Throwable th) {
            str = null;
        }
        if (scanResults == null || scanResults.size() <= 0) {
            return jSONArray.toString();
        }
        Collections.sort(scanResults, new a());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= scanResults.size() || i2 >= 10) {
                break;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ss", scanResults.get(i2).SSID.replaceAll("\"", PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS));
                jSONObject.put("bs", scanResults.get(i2).BSSID.replaceAll("\"", PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS));
                jSONArray.put(jSONObject);
            } catch (JSONException e2) {
            }
            i = i2 + 1;
        }
        str = jSONArray.toString();
        return str == null ? "[]" : str.trim();
    }

    @SuppressLint({"MissingPermission"})
    public static String c(Context context) {
        com.pgl.sys.ces.d.a e;
        String str = null;
        try {
            if (com.pgl.sys.ces.b.f() == 1 && (e = com.pgl.sys.ces.b.e()) != null) {
                str = "" + e.getLongitude() + "," + e.getLatitude();
            }
        } catch (Throwable th) {
        }
        return str == null ? "" : str.trim();
    }
}
