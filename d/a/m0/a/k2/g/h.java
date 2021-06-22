package d.a.m0.a.k2.g;

import d.a.m0.a.k;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, b> f47060a;

    static {
        boolean z = k.f46983a;
        f47060a = new HashMap();
    }

    public static b a() {
        return b("searchbox_webapps_sp");
    }

    public static b b(String str) {
        b bVar = f47060a.get(str);
        if (bVar == null) {
            synchronized (h.class) {
                bVar = f47060a.get(str);
                if (bVar == null) {
                    bVar = new b(str);
                    f47060a.put(str, bVar);
                }
            }
        }
        return bVar;
    }
}
