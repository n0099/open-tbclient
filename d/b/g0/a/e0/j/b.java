package d.b.g0.a.e0.j;

import d.b.g0.a.k;
import d.b.g0.a.z0.f;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b {
    static {
        boolean z = k.f45050a;
    }

    public static void a(String str, String str2) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("data", str2);
        f.V().z(f.V().F().c(), new d.b.g0.a.k0.b.b(str, hashMap));
    }

    public static void b() {
        d.b.g0.a.p.d.d j = f.V().j(f.V().p());
        if (j != null) {
            d.b.g0.a.c0.c.g("ConsoleMessageHelper", "send full San request");
            j.handleSchemeDispatchCallback("window.__san_devtool__.retrieveData", null);
        }
    }

    public static void c(String str) {
        a("sanFullData2Console", str);
    }

    public static void d(String str) {
        a("sanIncData2Console", str);
    }
}
