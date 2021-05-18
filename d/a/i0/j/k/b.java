package d.a.i0.j.k;

import android.content.Context;
import d.a.i0.a.a2.e;
import d.a.i0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends a<d.a.i0.a.h1.c.c> {
    static {
        boolean z = k.f43025a;
    }

    public static b e() {
        return new b();
    }

    @Override // d.a.i0.j.k.a
    public boolean b(Context context, d.a.i0.a.h1.c.c cVar, d.a.i0.a.h1.b bVar, e eVar, JSONObject jSONObject) {
        return d(context, cVar, bVar, eVar);
    }

    public final boolean d(Context context, d.a.i0.a.h1.c.c cVar, d.a.i0.a.h1.b bVar, e eVar) {
        d.a.i0.a.e0.d.g("map", "MapCreateAction start");
        boolean a2 = d.a.i0.j.c.b().a(context, cVar);
        d.a.i0.a.e0.d.g("map", "MapCreateAction end");
        return a2;
    }
}
