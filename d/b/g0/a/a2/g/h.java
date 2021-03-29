package d.b.g0.a.a2.g;

import d.b.g0.a.k;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, b> f43271a;

    static {
        boolean z = k.f45051a;
        f43271a = new HashMap();
    }

    public static b a() {
        return b("searchbox_webapps_sp");
    }

    public static b b(String str) {
        b bVar = f43271a.get(str);
        if (bVar == null) {
            synchronized (h.class) {
                bVar = f43271a.get(str);
                if (bVar == null) {
                    bVar = new b(str);
                    f43271a.put(str, bVar);
                }
            }
        }
        return bVar;
    }
}
