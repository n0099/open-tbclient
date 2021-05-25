package d.a.l0.j.k.e;

import android.content.Context;
import com.baidu.mapapi.map.MapStatus;
import d.a.l0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d.a.l0.j.k.a<d.a.l0.a.h1.c.c> {
    static {
        boolean z = k.f43199a;
    }

    public static b d() {
        return new b();
    }

    @Override // d.a.l0.j.k.a
    public boolean b(Context context, d.a.l0.a.h1.c.c cVar, d.a.l0.a.h1.b bVar, d.a.l0.a.a2.e eVar, JSONObject jSONObject) {
        return e(context, cVar, bVar, eVar, jSONObject);
    }

    public final boolean e(Context context, d.a.l0.a.h1.c.c cVar, d.a.l0.a.h1.b bVar, d.a.l0.a.a2.e eVar, JSONObject jSONObject) {
        d.a.l0.a.e0.d.g("map", "GetRegionAction start");
        d.a.l0.a.p.e.d B = d.a.l0.a.g1.f.V().B(cVar.f40846g);
        if (!(B instanceof d.a.l0.a.p.e.b)) {
            d.a.l0.a.e0.d.b("map", "WebViewManager is null");
            return false;
        }
        d.a.l0.j.n.c d2 = d.a.l0.j.c.b().c((d.a.l0.a.p.e.b) B).d(cVar.f40845f);
        if (d2 == null) {
            d.a.l0.a.e0.d.b("map", "can not find map by id " + cVar.f40845f);
            return false;
        }
        MapStatus mapStatus = d2.l.getMap().getMapStatus();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("latitude", mapStatus.bound.southwest.latitude);
            jSONObject3.put("longitude", mapStatus.bound.southwest.longitude);
            jSONObject2.put("latitude", mapStatus.bound.northeast.latitude);
            jSONObject2.put("longitude", mapStatus.bound.northeast.longitude);
            jSONObject.put("southwest", jSONObject3);
            jSONObject.put("northeast", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        d.a.l0.a.e0.d.g("map", "GetRegionAction end");
        return true;
    }
}
