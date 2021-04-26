package d.a.h0.h.a.f;

import android.content.Context;
import d.a.h0.a.k;
import d.a.h0.a.r1.e;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends a<d.a.h0.a.a1.c.c> {
    static {
        boolean z = k.f43101a;
    }

    public static d d() {
        return new d();
    }

    @Override // d.a.h0.h.a.f.a
    public boolean b(Context context, d.a.h0.a.a1.c.c cVar, d.a.h0.a.a1.b bVar, e eVar, JSONObject jSONObject) {
        return e(context, cVar, bVar, eVar);
    }

    public final boolean e(Context context, d.a.h0.a.a1.c.c cVar, d.a.h0.a.a1.b bVar, e eVar) {
        d.a.h0.a.c0.c.g("map", "MapUpdateAction start");
        boolean i2 = d.a.h0.h.a.c.b().i(context, cVar);
        d.a.h0.a.c0.c.g("map", "MapUpdateAction end");
        return i2;
    }
}
