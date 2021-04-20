package d.b.i0.j1.m;

import d.b.h0.c.f;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, d.b.h0.c.e> f57350a;

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f57351a = new a();
    }

    public static a a() {
        return b.f57351a;
    }

    public void b(d.b.h0.c.e eVar) {
        c(eVar.a(), eVar);
    }

    public final void c(String str, d.b.h0.c.e eVar) {
        this.f57350a.put(str, eVar);
    }

    public void d(String str, HashMap<String, String> hashMap, f fVar) {
        d.b.h0.c.e eVar;
        if (str == null || hashMap == null || hashMap.isEmpty() || fVar == null || (eVar = this.f57350a.get(str)) == null) {
            return;
        }
        eVar.b(hashMap, fVar);
    }

    public a() {
        this.f57350a = new HashMap<>();
    }
}
