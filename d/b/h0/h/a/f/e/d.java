package d.b.h0.h.a.f.e;

import android.content.Context;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import d.b.h0.a.k;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends d.b.h0.h.a.f.a<d.b.h0.a.a1.c.b> {
    static {
        boolean z = k.f45772a;
    }

    public static d e() {
        return new d();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.h.a.f.a
    /* renamed from: d */
    public boolean b(Context context, d.b.h0.a.a1.c.b bVar, d.b.h0.a.a1.b bVar2, d.b.h0.a.r1.e eVar, JSONObject jSONObject) {
        return f(context, bVar, bVar2, eVar);
    }

    public final boolean f(Context context, d.b.h0.a.a1.c.b bVar, d.b.h0.a.a1.b bVar2, d.b.h0.a.r1.e eVar) {
        d.b.h0.a.c0.c.g("map", "IncludePointsAction start");
        d.b.h0.a.p.d.d j = d.b.h0.a.z0.f.V().j(bVar.f43835g);
        if (!(j instanceof d.b.h0.a.p.d.b)) {
            d.b.h0.a.c0.c.b("map", "WebViewManager is null");
            return false;
        }
        d.b.h0.h.a.i.c d2 = d.b.h0.h.a.c.b().c((d.b.h0.a.p.d.b) j).d(bVar.f43834f);
        if (d2 == null) {
            d.b.h0.a.c0.c.b("map", "can not find map by id " + bVar.f43834f);
            return false;
        }
        d.b.h0.a.c0.c.g("map", "IncludePointsAction end");
        return g(bVar, d2);
    }

    public final boolean g(d.b.h0.a.a1.c.b bVar, d.b.h0.h.a.i.c cVar) {
        if (bVar == null || !bVar.isValid()) {
            return false;
        }
        BaiduMap map = cVar.l.getMap();
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        Iterator<d.b.h0.a.a1.c.h.c> it = bVar.D.iterator();
        while (it.hasNext()) {
            d.b.h0.a.a1.c.h.c next = it.next();
            builder.include(new LatLng(next.f43912e, next.f43913f));
        }
        LatLngBounds build = builder.build();
        int[] iArr = bVar.E;
        map.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(build, iArr[3], iArr[0], iArr[1], iArr[2]));
        return true;
    }
}
