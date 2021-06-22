package d.a.m0.a.v2;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
/* loaded from: classes3.dex */
public class d0 {
    public static String a(String str) {
        d.a.m0.a.a2.e i2 = d.a.m0.a.a2.e.i();
        return i2 != null ? String.format(str, i2.D(), i2.K()) : "";
    }

    public static String b() {
        String a2 = a("https://smartapps.cn/%s/%s/page-frame.html");
        if (d.a.m0.a.k.f46983a) {
            Log.d("SwanAppRefererUtils", "getFixedReferer: " + a2);
        }
        return a2;
    }

    public static boolean c(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("https://");
    }

    public static void d() {
        String b2 = b();
        if (TextUtils.isEmpty(b2)) {
            return;
        }
        if (d.a.m0.a.k.f46983a) {
            Log.d("SwanAppRefererUtils", "call setRefererPattern for Slave Webview; referer is " + b2);
        }
        WebSettingsGlobalBlink.setRefererPattern(b2, d.a.m0.a.a1.e.i());
    }
}
