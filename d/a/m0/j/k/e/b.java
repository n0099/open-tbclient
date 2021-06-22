package d.a.m0.j.k.e;

import android.content.Context;
import com.baidu.mapapi.map.MapStatus;
import d.a.m0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d.a.m0.j.k.a<d.a.m0.a.h1.c.c> {
    static {
        boolean z = k.f46983a;
    }

    public static b d() {
        return new b();
    }

    @Override // d.a.m0.j.k.a
    public boolean b(Context context, d.a.m0.a.h1.c.c cVar, d.a.m0.a.h1.b bVar, d.a.m0.a.a2.e eVar, JSONObject jSONObject) {
        return e(context, cVar, bVar, eVar, jSONObject);
    }

    public final boolean e(Context context, d.a.m0.a.h1.c.c cVar, d.a.m0.a.h1.b bVar, d.a.m0.a.a2.e eVar, JSONObject jSONObject) {
        d.a.m0.a.e0.d.g("map", "GetRegionAction start");
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
        d.a.m0.a.e0.d.g("map", "GetRegionAction end");
        return true;
    }
}
