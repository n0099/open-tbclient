package d.a.l0.j.k.e;

import android.content.Context;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.model.LatLng;
import d.a.l0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d.a.l0.j.k.a<d.a.l0.a.h1.c.c> {
    static {
        boolean z = k.f43199a;
    }

    public static a d() {
        return new a();
    }

    @Override // d.a.l0.j.k.a
    public boolean b(Context context, d.a.l0.a.h1.c.c cVar, d.a.l0.a.h1.b bVar, d.a.l0.a.a2.e eVar, JSONObject jSONObject) {
        return e(context, cVar, bVar, eVar, jSONObject);
    }

    public final boolean e(Context context, d.a.l0.a.h1.c.c cVar, d.a.l0.a.h1.b bVar, d.a.l0.a.a2.e eVar, JSONObject jSONObject) {
        d.a.l0.a.e0.d.g("map", "GetCenterLcationAction start");
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
        d.a.l0.a.h1.c.h.c cVar2 = new d.a.l0.a.h1.c.h.c();
        LatLng latLng = mapStatus.target;
        double d3 = latLng.latitude;
        cVar2.f42673e = d3;
        cVar2.f42674f = latLng.longitude;
        try {
            jSONObject.put("latitude", d3);
            jSONObject.put("longitude", cVar2.f42674f);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        d.a.l0.a.e0.d.g("map", "GetCenterLocationAction end");
        return true;
    }
}
