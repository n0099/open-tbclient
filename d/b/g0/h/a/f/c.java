package d.b.g0.h.a.f;

import android.content.Context;
import d.b.g0.a.k;
import d.b.g0.a.r1.e;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends a<d.b.g0.a.a1.c.c> {
    static {
        boolean z = k.f45050a;
    }

    public static c d() {
        return new c();
    }

    @Override // d.b.g0.h.a.f.a
    public boolean b(Context context, d.b.g0.a.a1.c.c cVar, d.b.g0.a.a1.b bVar, e eVar, JSONObject jSONObject) {
        return e(context, cVar, bVar, eVar);
    }

    public final boolean e(Context context, d.b.g0.a.a1.c.c cVar, d.b.g0.a.a1.b bVar, e eVar) {
        d.b.g0.a.c0.c.g("map", "MapRemoveAction start");
        boolean g2 = d.b.g0.h.a.c.b().g(cVar);
        d.b.g0.a.c0.c.g("map", "MapRemoveAction end");
        return g2;
    }
}
