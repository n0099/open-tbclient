package d.a.h0.h.a.f;

import android.content.Context;
import d.a.h0.a.k;
import d.a.h0.a.r1.e;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends a<d.a.h0.a.a1.c.c> {
    static {
        boolean z = k.f43101a;
    }

    public static b e() {
        return new b();
    }

    @Override // d.a.h0.h.a.f.a
    public boolean b(Context context, d.a.h0.a.a1.c.c cVar, d.a.h0.a.a1.b bVar, e eVar, JSONObject jSONObject) {
        return d(context, cVar, bVar, eVar);
    }

    public final boolean d(Context context, d.a.h0.a.a1.c.c cVar, d.a.h0.a.a1.b bVar, e eVar) {
        d.a.h0.a.c0.c.g("map", "MapCreateAction start");
        boolean a2 = d.a.h0.h.a.c.b().a(context, cVar);
        d.a.h0.a.c0.c.g("map", "MapCreateAction end");
        return a2;
    }
}
