package d.b.h0.h.a.f;

import android.content.Context;
import d.b.h0.a.k;
import d.b.h0.a.r1.e;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends a<d.b.h0.a.a1.c.c> {
    static {
        boolean z = k.f45772a;
    }

    public static b e() {
        return new b();
    }

    @Override // d.b.h0.h.a.f.a
    public boolean b(Context context, d.b.h0.a.a1.c.c cVar, d.b.h0.a.a1.b bVar, e eVar, JSONObject jSONObject) {
        return d(context, cVar, bVar, eVar);
    }

    public final boolean d(Context context, d.b.h0.a.a1.c.c cVar, d.b.h0.a.a1.b bVar, e eVar) {
        d.b.h0.a.c0.c.g("map", "MapCreateAction start");
        boolean a2 = d.b.h0.h.a.c.b().a(context, cVar);
        d.b.h0.a.c0.c.g("map", "MapCreateAction end");
        return a2;
    }
}
