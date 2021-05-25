package d.a.l0.a.c2.f.p0;

import android.text.TextUtils;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.a.l0.a.v2.o0;
import java.util.Map;
/* loaded from: classes3.dex */
public class j {
    public static void a(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str) || map == null) {
            return;
        }
        String f2 = o0.f(str);
        String o = o0.o(str);
        String b2 = b(f2);
        if (TextUtils.equals(f2, b2)) {
            return;
        }
        if (!TextUtils.isEmpty(o)) {
            b2 = b2 + "?" + o;
        }
        map.put("pageRoutePath", b2);
    }

    public static String b(String str) {
        return c(str, d.a.l0.a.a2.d.g().r().F());
    }

    public static String c(String str, SwanAppConfigData swanAppConfigData) {
        return swanAppConfigData == null ? str : swanAppConfigData.i(str);
    }
}
