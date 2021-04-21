package d.b.j0.j1.m;

import d.b.i0.c.f;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, d.b.i0.c.e> f57771a;

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f57772a = new a();
    }

    public static a a() {
        return b.f57772a;
    }

    public void b(d.b.i0.c.e eVar) {
        c(eVar.a(), eVar);
    }

    public final void c(String str, d.b.i0.c.e eVar) {
        this.f57771a.put(str, eVar);
    }

    public void d(String str, HashMap<String, String> hashMap, f fVar) {
        d.b.i0.c.e eVar;
        if (str == null || hashMap == null || hashMap.isEmpty() || fVar == null || (eVar = this.f57771a.get(str)) == null) {
            return;
        }
        eVar.b(hashMap, fVar);
    }

    public a() {
        this.f57771a = new HashMap<>();
    }
}
