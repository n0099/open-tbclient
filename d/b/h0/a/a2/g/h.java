package d.b.h0.a.a2.g;

import d.b.h0.a.k;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, b> f43992a;

    static {
        boolean z = k.f45772a;
        f43992a = new HashMap();
    }

    public static b a() {
        return b("searchbox_webapps_sp");
    }

    public static b b(String str) {
        b bVar = f43992a.get(str);
        if (bVar == null) {
            synchronized (h.class) {
                bVar = f43992a.get(str);
                if (bVar == null) {
                    bVar = new b(str);
                    f43992a.put(str, bVar);
                }
            }
        }
        return bVar;
    }
}
