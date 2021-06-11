package d.a.n0.k1.m;

import d.a.m0.c.f;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, d.a.m0.c.e> f60312a;

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f60313a = new a();
    }

    public static a a() {
        return b.f60313a;
    }

    public void b(d.a.m0.c.e eVar) {
        c(eVar.a(), eVar);
    }

    public final void c(String str, d.a.m0.c.e eVar) {
        this.f60312a.put(str, eVar);
    }

    public void d(String str, HashMap<String, String> hashMap, f fVar) {
        d.a.m0.c.e eVar;
        if (str == null || hashMap == null || hashMap.isEmpty() || fVar == null || (eVar = this.f60312a.get(str)) == null) {
            return;
        }
        eVar.b(hashMap, fVar);
    }

    public a() {
        this.f60312a = new HashMap<>();
    }
}
