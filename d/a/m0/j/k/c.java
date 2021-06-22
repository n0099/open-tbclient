package d.a.m0.j.k;

import android.content.Context;
import d.a.m0.a.a2.e;
import d.a.m0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends a<d.a.m0.a.h1.c.c> {
    static {
        boolean z = k.f46983a;
    }

    public static c d() {
        return new c();
    }

    @Override // d.a.m0.j.k.a
    public boolean b(Context context, d.a.m0.a.h1.c.c cVar, d.a.m0.a.h1.b bVar, e eVar, JSONObject jSONObject) {
        return e(context, cVar, bVar, eVar);
    }

    public final boolean e(Context context, d.a.m0.a.h1.c.c cVar, d.a.m0.a.h1.b bVar, e eVar) {
        d.a.m0.a.e0.d.g("map", "MapRemoveAction start");
        boolean g2 = d.a.m0.j.c.b().g(cVar);
        d.a.m0.a.e0.d.g("map", "MapRemoveAction end");
        return g2;
    }
}
