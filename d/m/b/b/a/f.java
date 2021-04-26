package d.m.b.b.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.text.Typography;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f {

    /* loaded from: classes6.dex */
    public static class a implements Comparator<Object> {
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
        String str = null;
        try {
            d.m.b.b.d.a e2 = com.pgl.sys.ces.b.e();
            if (e2 != null) {
                WifiInfo c2 = e2.c();
                String bssid = c2.getBSSID();
                String trim = bssid == null ? "" : bssid.trim();
                String ssid = c2.getSSID();
                String replace = (ssid == null ? "" : ssid.trim()).replace(' ', ' ').replace('\'', ' ').replace(Typography.quote, ' ');
                String num = Integer.toString(c2.getIpAddress());
                str = trim + "[<!>]" + replace + "[<!>]" + (num == null ? "" : num.trim()) + "[<!>]";
            }
        } catch (Throwable unused) {
        }
        return str == null ? "" : str.trim();
    }

    public static String b(Context context) {
        List<ScanResult> d2;
        JSONArray jSONArray = new JSONArray();
        if (context == null) {
            return jSONArray.toString();
        }
        String str = null;
        try {
            d.m.b.b.d.a e2 = com.pgl.sys.ces.b.e();
            d2 = e2 != null ? e2.d() : null;
        } catch (Throwable unused) {
        }
        if (d2 != null && d2.size() > 0) {
            Collections.sort(d2, new a());
            for (int i2 = 0; i2 < d2.size() && i2 < 10; i2++) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("ss", d2.get(i2).SSID.replaceAll("\"", "_"));
                    jSONObject.put("bs", d2.get(i2).BSSID.replaceAll("\"", "_"));
                    jSONArray.put(jSONObject);
                } catch (JSONException unused2) {
                }
            }
            str = jSONArray.toString();
            return str == null ? "[]" : str.trim();
        }
        return jSONArray.toString();
    }

    @SuppressLint({"MissingPermission"})
    public static String c(Context context) {
        d.m.b.b.d.a e2;
        String str = null;
        try {
            if (com.pgl.sys.ces.b.f() == 1 && (e2 = com.pgl.sys.ces.b.e()) != null) {
                str = "" + e2.f() + "," + e2.g();
            }
        } catch (Throwable unused) {
        }
        return str == null ? "" : str.trim();
    }
}
