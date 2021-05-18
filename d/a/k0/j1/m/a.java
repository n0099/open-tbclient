package d.a.k0.j1.m;

import d.a.j0.c.f;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, d.a.j0.c.e> f56443a;

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f56444a = new a();
    }

    public static a a() {
        return b.f56444a;
    }

    public void b(d.a.j0.c.e eVar) {
        c(eVar.a(), eVar);
    }

    public final void c(String str, d.a.j0.c.e eVar) {
        this.f56443a.put(str, eVar);
    }

    public void d(String str, HashMap<String, String> hashMap, f fVar) {
        d.a.j0.c.e eVar;
        if (str == null || hashMap == null || hashMap.isEmpty() || fVar == null || (eVar = this.f56443a.get(str)) == null) {
            return;
        }
        eVar.b(hashMap, fVar);
    }

    public a() {
        this.f56443a = new HashMap<>();
    }
}
