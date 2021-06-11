package d.a.l0.j.k;

import android.content.Context;
import d.a.l0.a.a2.e;
import d.a.l0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends a<d.a.l0.a.h1.c.c> {
    static {
        boolean z = k.f46875a;
    }

    public static b e() {
        return new b();
    }

    @Override // d.a.l0.j.k.a
    public boolean b(Context context, d.a.l0.a.h1.c.c cVar, d.a.l0.a.h1.b bVar, e eVar, JSONObject jSONObject) {
        return d(context, cVar, bVar, eVar);
    }

    public final boolean d(Context context, d.a.l0.a.h1.c.c cVar, d.a.l0.a.h1.b bVar, e eVar) {
        d.a.l0.a.e0.d.g("map", "MapCreateAction start");
        boolean a2 = d.a.l0.j.c.b().a(context, cVar);
        d.a.l0.a.e0.d.g("map", "MapCreateAction end");
        return a2;
    }
}
