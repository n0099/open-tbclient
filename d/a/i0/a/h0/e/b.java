package d.a.i0.a.h0.e;

import d.a.i0.a.g1.f;
import d.a.i0.a.k;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class b {
    static {
        boolean z = k.f43025a;
    }

    public static void a(String str, String str2) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("data", str2);
        f.V().m(f.V().q().b(), new d.a.i0.a.o0.d.b(str, hashMap));
    }

    public static void b() {
        d.a.i0.a.p.e.d B = f.V().B(f.V().D());
        if (B != null) {
            d.a.i0.a.e0.d.g("ConsoleMessageHelper", "send full San request");
            B.handleSchemeDispatchCallback("window.__san_devtool__.retrieveData", null);
        }
    }

    public static void c(String str) {
        a("sanFullData2Console", str);
    }

    public static void d(String str) {
        a("sanIncData2Console", str);
    }
}
