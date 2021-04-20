package d.b.g0.h.a.f;

import android.content.Context;
import d.b.g0.a.k;
import d.b.g0.a.r1.e;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends a<d.b.g0.a.a1.c.c> {
    static {
        boolean z = k.f45443a;
    }

    public static d d() {
        return new d();
    }

    @Override // d.b.g0.h.a.f.a
    public boolean b(Context context, d.b.g0.a.a1.c.c cVar, d.b.g0.a.a1.b bVar, e eVar, JSONObject jSONObject) {
        return e(context, cVar, bVar, eVar);
    }

    public final boolean e(Context context, d.b.g0.a.a1.c.c cVar, d.b.g0.a.a1.b bVar, e eVar) {
        d.b.g0.a.c0.c.g("map", "MapUpdateAction start");
        boolean i = d.b.g0.h.a.c.b().i(context, cVar);
        d.b.g0.a.c0.c.g("map", "MapUpdateAction end");
        return i;
    }
}
