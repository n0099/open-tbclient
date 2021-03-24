package d.b.g0.a.i2;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
/* loaded from: classes3.dex */
public class b0 {
    public static String a(String str) {
        d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
        return y != null ? String.format(str, y.B(), y.I()) : "";
    }

    public static String b() {
        if (d.b.g0.a.k.f45050a) {
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
        if (d.b.g0.a.k.f45050a) {
            Log.d("SwanAppRefererUtils", "call setRefererPattern for Slave Webview; referer is " + b2);
        }
        WebSettingsGlobalBlink.setRefererPattern(b2, d.b.g0.a.u0.d.e());
    }
}
