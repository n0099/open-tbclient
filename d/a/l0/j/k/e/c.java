package d.a.l0.j.k.e;

import android.content.Context;
import d.a.l0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends d.a.l0.j.k.a<d.a.l0.a.h1.c.c> {
    static {
        boolean z = k.f46875a;
    }

    public static c d() {
        return new c();
    }

    @Override // d.a.l0.j.k.a
    public boolean b(Context context, d.a.l0.a.h1.c.c cVar, d.a.l0.a.h1.b bVar, d.a.l0.a.a2.e eVar, JSONObject jSONObject) {
        return e(context, cVar, bVar, eVar, jSONObject);
    }

    public final boolean e(Context context, d.a.l0.a.h1.c.c cVar, d.a.l0.a.h1.b bVar, d.a.l0.a.a2.e eVar, JSONObject jSONObject) {
        d.a.l0.a.e0.d.g("map", "GetScaleAction start");
        d.a.l0.a.p.e.d B = d.a.l0.a.g1.f.V().B(cVar.f44522g);
        if (!(B instanceof d.a.l0.a.p.e.b)) {
            d.a.l0.a.e0.d.b("map", "WebViewManager is null");
            return false;
        }
        d.a.l0.j.n.c d2 = d.a.l0.j.c.b().c((d.a.l0.a.p.e.b) B).d(cVar.f44521f);
        if (d2 == null) {
            d.a.l0.a.e0.d.b("map", "can not find map by id " + cVar.f44521f);
            return false;
        }
        try {
            jSONObject.put("scale", d2.l.getMap().getMapStatus().zoom);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        d.a.l0.a.e0.d.g("map", "GetScaleAction end");
        return true;
    }
}
