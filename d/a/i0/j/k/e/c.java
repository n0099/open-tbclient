package d.a.i0.j.k.e;

import android.content.Context;
import d.a.i0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends d.a.i0.j.k.a<d.a.i0.a.h1.c.c> {
    static {
        boolean z = k.f43025a;
    }

    public static c d() {
        return new c();
    }

    @Override // d.a.i0.j.k.a
    public boolean b(Context context, d.a.i0.a.h1.c.c cVar, d.a.i0.a.h1.b bVar, d.a.i0.a.a2.e eVar, JSONObject jSONObject) {
        return e(context, cVar, bVar, eVar, jSONObject);
    }

    public final boolean e(Context context, d.a.i0.a.h1.c.c cVar, d.a.i0.a.h1.b bVar, d.a.i0.a.a2.e eVar, JSONObject jSONObject) {
        d.a.i0.a.e0.d.g("map", "GetScaleAction start");
        d.a.i0.a.p.e.d B = d.a.i0.a.g1.f.V().B(cVar.f40672g);
        if (!(B instanceof d.a.i0.a.p.e.b)) {
            d.a.i0.a.e0.d.b("map", "WebViewManager is null");
            return false;
        }
        d.a.i0.j.n.c d2 = d.a.i0.j.c.b().c((d.a.i0.a.p.e.b) B).d(cVar.f40671f);
        if (d2 == null) {
            d.a.i0.a.e0.d.b("map", "can not find map by id " + cVar.f40671f);
            return false;
        }
        try {
            jSONObject.put("scale", d2.l.getMap().getMapStatus().zoom);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        d.a.i0.a.e0.d.g("map", "GetScaleAction end");
        return true;
    }
}
