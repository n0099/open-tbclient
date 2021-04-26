package d.a.h0.h.a.f.e;

import android.content.Context;
import d.a.h0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends d.a.h0.h.a.f.a<d.a.h0.a.a1.c.c> {
    static {
        boolean z = k.f43101a;
    }

    public static c d() {
        return new c();
    }

    @Override // d.a.h0.h.a.f.a
    public boolean b(Context context, d.a.h0.a.a1.c.c cVar, d.a.h0.a.a1.b bVar, d.a.h0.a.r1.e eVar, JSONObject jSONObject) {
        return e(context, cVar, bVar, eVar, jSONObject);
    }

    public final boolean e(Context context, d.a.h0.a.a1.c.c cVar, d.a.h0.a.a1.b bVar, d.a.h0.a.r1.e eVar, JSONObject jSONObject) {
        d.a.h0.a.c0.c.g("map", "GetScaleAction start");
        d.a.h0.a.p.d.d B = d.a.h0.a.z0.f.V().B(cVar.f41093g);
        if (!(B instanceof d.a.h0.a.p.d.b)) {
            d.a.h0.a.c0.c.b("map", "WebViewManager is null");
            return false;
        }
        d.a.h0.h.a.i.c d2 = d.a.h0.h.a.c.b().c((d.a.h0.a.p.d.b) B).d(cVar.f41092f);
        if (d2 == null) {
            d.a.h0.a.c0.c.b("map", "can not find map by id " + cVar.f41092f);
            return false;
        }
        try {
            jSONObject.put("scale", d2.l.getMap().getMapStatus().zoom);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        d.a.h0.a.c0.c.g("map", "GetScaleAction end");
        return true;
    }
}
