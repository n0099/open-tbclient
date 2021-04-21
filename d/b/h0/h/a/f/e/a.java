package d.b.h0.h.a.f.e;

import android.content.Context;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.model.LatLng;
import d.b.h0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d.b.h0.h.a.f.a<d.b.h0.a.a1.c.c> {
    static {
        boolean z = k.f45772a;
    }

    public static a d() {
        return new a();
    }

    @Override // d.b.h0.h.a.f.a
    public boolean b(Context context, d.b.h0.a.a1.c.c cVar, d.b.h0.a.a1.b bVar, d.b.h0.a.r1.e eVar, JSONObject jSONObject) {
        return e(context, cVar, bVar, eVar, jSONObject);
    }

    public final boolean e(Context context, d.b.h0.a.a1.c.c cVar, d.b.h0.a.a1.b bVar, d.b.h0.a.r1.e eVar, JSONObject jSONObject) {
        d.b.h0.a.c0.c.g("map", "GetCenterLcationAction start");
        d.b.h0.a.p.d.d j = d.b.h0.a.z0.f.V().j(cVar.f43835g);
        if (!(j instanceof d.b.h0.a.p.d.b)) {
            d.b.h0.a.c0.c.b("map", "WebViewManager is null");
            return false;
        }
        d.b.h0.h.a.i.c d2 = d.b.h0.h.a.c.b().c((d.b.h0.a.p.d.b) j).d(cVar.f43834f);
        if (d2 == null) {
            d.b.h0.a.c0.c.b("map", "can not find map by id " + cVar.f43834f);
            return false;
        }
        MapStatus mapStatus = d2.l.getMap().getMapStatus();
        d.b.h0.a.a1.c.h.c cVar2 = new d.b.h0.a.a1.c.h.c();
        LatLng latLng = mapStatus.target;
        double d3 = latLng.latitude;
        cVar2.f43912e = d3;
        cVar2.f43913f = latLng.longitude;
        try {
            jSONObject.put("latitude", d3);
            jSONObject.put("longitude", cVar2.f43913f);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        d.b.h0.a.c0.c.g("map", "GetCenterLocationAction end");
        return true;
    }
}
