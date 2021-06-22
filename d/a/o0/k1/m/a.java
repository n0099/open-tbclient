package d.a.o0.k1.m;

import d.a.n0.c.f;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, d.a.n0.c.e> f60437a;

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f60438a = new a();
    }

    public static a a() {
        return b.f60438a;
    }

    public void b(d.a.n0.c.e eVar) {
        c(eVar.a(), eVar);
    }

    public final void c(String str, d.a.n0.c.e eVar) {
        this.f60437a.put(str, eVar);
    }

    public void d(String str, HashMap<String, String> hashMap, f fVar) {
        d.a.n0.c.e eVar;
        if (str == null || hashMap == null || hashMap.isEmpty() || fVar == null || (eVar = this.f60437a.get(str)) == null) {
            return;
        }
        eVar.b(hashMap, fVar);
    }

    public a() {
        this.f60437a = new HashMap<>();
    }
}
