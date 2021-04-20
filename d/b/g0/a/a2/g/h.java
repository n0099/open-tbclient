package d.b.g0.a.a2.g;

import d.b.g0.a.k;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, b> f43663a;

    static {
        boolean z = k.f45443a;
        f43663a = new HashMap();
    }

    public static b a() {
        return b("searchbox_webapps_sp");
    }

    public static b b(String str) {
        b bVar = f43663a.get(str);
        if (bVar == null) {
            synchronized (h.class) {
                bVar = f43663a.get(str);
                if (bVar == null) {
                    bVar = new b(str);
                    f43663a.put(str, bVar);
                }
            }
        }
        return bVar;
    }
}
