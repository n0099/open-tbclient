package d.a.l0.a.j1.e;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.a.l0.a.g1.f;
import d.a.l0.a.v1.b.d;
import d.a.l0.a.v2.l0;
/* loaded from: classes3.dex */
public class b {
    public static int a(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    return i2 != 3 ? 100 : 118;
                }
                return 112;
            }
            return 100;
        }
        return 82;
    }

    public static int b() {
        Bundle a2 = d.a(c.class, null);
        if (a2 == null) {
            return 1;
        }
        return a2.getInt("font_size_level", 1);
    }

    public static int c() {
        return b() + 1;
    }

    public static boolean d() {
        return l0.f("3.200.101");
    }

    public static boolean e() {
        SwanAppConfigData s = f.V().s();
        if (s == null) {
            return false;
        }
        return TextUtils.equals("none", s.f11311e.q);
    }
}
