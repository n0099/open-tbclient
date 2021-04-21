package d.b.h0.a.i2;

import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes3.dex */
public class g0 {
    public static boolean a(long j) {
        SwanCoreVersion T = d.b.h0.a.e0.w.d.L().T();
        long j2 = T != null ? T.swanCoreVersion : 0L;
        d.b.h0.a.c0.c.g("SwanAppSwanCoreUtils", "targetSwanVersionCode =" + j + ";curSwanVersionCode: " + j2);
        return j2 < j;
    }

    public static boolean b(String str) {
        return a(d.b.h0.a.b2.b.h(str));
    }
}
