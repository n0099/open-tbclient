package d.a.h0.a.i2;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
/* loaded from: classes3.dex */
public class b0 {
    public static String a(String str) {
        d.a.h0.a.r1.e h2 = d.a.h0.a.r1.e.h();
        return h2 != null ? String.format(str, h2.B(), h2.I()) : "";
    }

    public static String b() {
        if (d.a.h0.a.k.f43101a) {
            Log.d("SwanAppRefererUtils", "getFixedReferer: " + a("https://smartapps.cn/%s/%s/page-frame.html"));
        }
        return a("https://smartapps.cn/%s/%s/page-frame.html");
    }

    public static boolean c(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("https://");
    }

    public static void d() {
        String b2 = b();
        if (TextUtils.isEmpty(b2)) {
            return;
        }
        if (d.a.h0.a.k.f43101a) {
            Log.d("SwanAppRefererUtils", "call setRefererPattern for Slave Webview; referer is " + b2);
        }
        WebSettingsGlobalBlink.setRefererPattern(b2, d.a.h0.a.u0.d.e());
    }
}
