package d.a.m0.j.k.e;

import android.content.Context;
import d.a.m0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends d.a.m0.j.k.a<d.a.m0.a.h1.c.c> {
    static {
        boolean z = k.f46983a;
    }

    public static c d() {
        return new c();
    }

    @Override // d.a.m0.j.k.a
    public boolean b(Context context, d.a.m0.a.h1.c.c cVar, d.a.m0.a.h1.b bVar, d.a.m0.a.a2.e eVar, JSONObject jSONObject) {
        return e(context, cVar, bVar, eVar, jSONObject);
    }

    public final boolean e(Context context, d.a.m0.a.h1.c.c cVar, d.a.m0.a.h1.b bVar, d.a.m0.a.a2.e eVar, JSONObject jSONObject) {
        d.a.m0.a.e0.d.g("map", "GetScaleAction start");
        d.a.m0.a.p.e.d B = d.a.m0.a.g1.f.V().B(cVar.f44630g);
        if (!(B instanceof d.a.m0.a.p.e.b)) {
            d.a.m0.a.e0.d.b("map", "WebViewManager is null");
            return false;
        }
        d.a.m0.j.n.c d2 = d.a.m0.j.c.b().c((d.a.m0.a.p.e.b) B).d(cVar.f44629f);
        if (d2 == null) {
            d.a.m0.a.e0.d.b("map", "can not find map by id " + cVar.f44629f);
            return false;
        }
        try {
            jSONObject.put("scale", d2.l.getMap().getMapStatus().zoom);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        d.a.m0.a.e0.d.g("map", "GetScaleAction end");
        return true;
    }
}
