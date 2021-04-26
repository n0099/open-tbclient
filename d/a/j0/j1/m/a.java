package d.a.j0.j1.m;

import d.a.i0.c.f;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, d.a.i0.c.e> f55736a;

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f55737a = new a();
    }

    public static a a() {
        return b.f55737a;
    }

    public void b(d.a.i0.c.e eVar) {
        c(eVar.a(), eVar);
    }

    public final void c(String str, d.a.i0.c.e eVar) {
        this.f55736a.put(str, eVar);
    }

    public void d(String str, HashMap<String, String> hashMap, f fVar) {
        d.a.i0.c.e eVar;
        if (str == null || hashMap == null || hashMap.isEmpty() || fVar == null || (eVar = this.f55736a.get(str)) == null) {
            return;
        }
        eVar.b(hashMap, fVar);
    }

    public a() {
        this.f55736a = new HashMap<>();
    }
}
