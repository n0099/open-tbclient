package d.a.h0.a.a2.g;

import d.a.h0.a.k;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, b> f41262a;

    static {
        boolean z = k.f43101a;
        f41262a = new HashMap();
    }

    public static b a() {
        return b("searchbox_webapps_sp");
    }

    public static b b(String str) {
        b bVar = f41262a.get(str);
        if (bVar == null) {
            synchronized (h.class) {
                bVar = f41262a.get(str);
                if (bVar == null) {
                    bVar = new b(str);
                    f41262a.put(str, bVar);
                }
            }
        }
        return bVar;
    }
}
