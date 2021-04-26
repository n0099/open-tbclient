package d.a.h0.a.t1.k.p0;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.a.h0.a.i2.i0;
import java.util.Map;
/* loaded from: classes3.dex */
public class j {
    public static void a(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str) || map == null) {
            return;
        }
        String d2 = i0.d(str);
        String n = i0.n(str);
        String b2 = b(d2);
        if (TextUtils.equals(d2, b2)) {
            return;
        }
        if (!TextUtils.isEmpty(n)) {
            b2 = b2 + "?" + n;
        }
        map.put("pageRoutePath", b2);
    }

    public static String b(String str) {
        return c(str, d.a.h0.a.r1.d.e().p().D());
    }

    public static String c(String str, SwanAppConfigData swanAppConfigData) {
        return swanAppConfigData == null ? str : swanAppConfigData.i(str);
    }
}
