package d.a.l0.j.k.e;

import android.content.Context;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import d.a.l0.a.k;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends d.a.l0.j.k.a<d.a.l0.a.h1.c.b> {
    static {
        boolean z = k.f46875a;
    }

    public static d e() {
        return new d();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.j.k.a
    /* renamed from: d */
    public boolean b(Context context, d.a.l0.a.h1.c.b bVar, d.a.l0.a.h1.b bVar2, d.a.l0.a.a2.e eVar, JSONObject jSONObject) {
        return f(context, bVar, bVar2, eVar);
    }

    public final boolean f(Context context, d.a.l0.a.h1.c.b bVar, d.a.l0.a.h1.b bVar2, d.a.l0.a.a2.e eVar) {
        d.a.l0.a.e0.d.g("map", "IncludePointsAction start");
        d.a.l0.a.p.e.d B = d.a.l0.a.g1.f.V().B(bVar.f44522g);
        if (!(B instanceof d.a.l0.a.p.e.b)) {
            d.a.l0.a.e0.d.b("map", "WebViewManager is null");
            return false;
        }
        d.a.l0.j.n.c d2 = d.a.l0.j.c.b().c((d.a.l0.a.p.e.b) B).d(bVar.f44521f);
        if (d2 == null) {
            d.a.l0.a.e0.d.b("map", "can not find map by id " + bVar.f44521f);
            return false;
        }
        d.a.l0.a.e0.d.g("map", "IncludePointsAction end");
        return g(bVar, d2);
    }

    public final boolean g(d.a.l0.a.h1.c.b bVar, d.a.l0.j.n.c cVar) {
        if (bVar == null || !bVar.isValid()) {
            return false;
        }
        BaiduMap map = cVar.l.getMap();
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        Iterator<d.a.l0.a.h1.c.h.c> it = bVar.D.iterator();
        while (it.hasNext()) {
            d.a.l0.a.h1.c.h.c next = it.next();
            builder.include(new LatLng(next.f46349e, next.f46350f));
        }
        LatLngBounds build = builder.build();
        int[] iArr = bVar.E;
        map.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(build, iArr[3], iArr[0], iArr[1], iArr[2]));
        return true;
    }
}
