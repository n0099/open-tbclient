package d.b.g0.h.a.f.e;

import android.content.Context;
import d.b.g0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends d.b.g0.h.a.f.a<d.b.g0.a.a1.c.c> {
    static {
        boolean z = k.f45051a;
    }

    public static c d() {
        return new c();
    }

    @Override // d.b.g0.h.a.f.a
    public boolean b(Context context, d.b.g0.a.a1.c.c cVar, d.b.g0.a.a1.b bVar, d.b.g0.a.r1.e eVar, JSONObject jSONObject) {
        return e(context, cVar, bVar, eVar, jSONObject);
    }

    public final boolean e(Context context, d.b.g0.a.a1.c.c cVar, d.b.g0.a.a1.b bVar, d.b.g0.a.r1.e eVar, JSONObject jSONObject) {
        d.b.g0.a.c0.c.g("map", "GetScaleAction start");
        d.b.g0.a.p.d.d j = d.b.g0.a.z0.f.V().j(cVar.f43114g);
        if (!(j instanceof d.b.g0.a.p.d.b)) {
            d.b.g0.a.c0.c.b("map", "WebViewManager is null");
            return false;
        }
        d.b.g0.h.a.i.c d2 = d.b.g0.h.a.c.b().c((d.b.g0.a.p.d.b) j).d(cVar.f43113f);
        if (d2 == null) {
            d.b.g0.a.c0.c.b("map", "can not find map by id " + cVar.f43113f);
            return false;
        }
        try {
            jSONObject.put("scale", d2.l.getMap().getMapStatus().zoom);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        d.b.g0.a.c0.c.g("map", "GetScaleAction end");
        return true;
    }
}
