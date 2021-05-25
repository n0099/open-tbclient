package d.a.l0.j.k;

import android.content.Context;
import d.a.l0.a.a2.e;
import d.a.l0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends a<d.a.l0.a.h1.c.c> {
    static {
        boolean z = k.f43199a;
    }

    public static d d() {
        return new d();
    }

    @Override // d.a.l0.j.k.a
    public boolean b(Context context, d.a.l0.a.h1.c.c cVar, d.a.l0.a.h1.b bVar, e eVar, JSONObject jSONObject) {
        return e(context, cVar, bVar, eVar);
    }

    public final boolean e(Context context, d.a.l0.a.h1.c.c cVar, d.a.l0.a.h1.b bVar, e eVar) {
        d.a.l0.a.e0.d.g("map", "MapUpdateAction start");
        boolean i2 = d.a.l0.j.c.b().i(context, cVar);
        d.a.l0.a.e0.d.g("map", "MapUpdateAction end");
        return i2;
    }
}
