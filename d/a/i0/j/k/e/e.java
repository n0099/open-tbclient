package d.a.i0.j.k.e;

import android.content.Context;
import com.baidu.location.BDLocation;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import d.a.i0.a.c1.d.d;
import d.a.i0.a.k;
import d.a.i0.j.k.f.d;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends d.a.i0.j.k.a<d.a.i0.a.h1.c.c> {

    /* loaded from: classes3.dex */
    public class a implements d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f47665a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.j.n.c f47666b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.j.b f47667c;

        public a(Context context, d.a.i0.j.n.c cVar, d.a.i0.j.b bVar) {
            this.f47665a = context;
            this.f47666b = cVar;
            this.f47667c = bVar;
        }

        @Override // d.a.i0.j.k.f.d.c
        public void onFail() {
            d.a.i0.a.e0.d.l("map", "location permission fail");
        }

        @Override // d.a.i0.j.k.f.d.c
        public void onSuccess() {
            d.a.i0.a.e0.d.l("map", "location permission success");
            e.this.e(this.f47665a, this.f47666b, this.f47667c);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.j.n.c f47669a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.j.b f47670b;

        public b(e eVar, d.a.i0.j.n.c cVar, d.a.i0.j.b bVar) {
            this.f47669a = cVar;
            this.f47670b = bVar;
        }

        @Override // d.a.i0.a.c1.d.d.a
        public void a(d.a.i0.a.c2.f.k0.b bVar) {
            d.a.i0.a.e0.d.g("map", "get location " + bVar.a().toString());
            BaiduMap map = this.f47669a.l.getMap();
            map.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bVar.f40955c, bVar.f40954b)));
            map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
            map.setMyLocationEnabled(true);
            map.setMyLocationData(new MyLocationData.Builder().accuracy((float) bVar.f40957e).latitude(bVar.f40955c).longitude(bVar.f40954b).build());
            this.f47670b.q(true);
        }

        @Override // d.a.i0.a.c1.d.d.a
        public void onFailed(int i2) {
            d.a.i0.a.e0.d.g("map", "get location error " + i2);
        }
    }

    static {
        boolean z = k.f43025a;
    }

    public static e f() {
        return new e();
    }

    @Override // d.a.i0.j.k.a
    public boolean b(Context context, d.a.i0.a.h1.c.c cVar, d.a.i0.a.h1.b bVar, d.a.i0.a.a2.e eVar, JSONObject jSONObject) {
        return g(context, cVar, bVar, eVar);
    }

    public final void e(Context context, d.a.i0.j.n.c cVar, d.a.i0.j.b bVar) {
        d.a.i0.a.c1.a.E().b("gcj02", true, false, new b(this, cVar, bVar));
    }

    public final boolean g(Context context, d.a.i0.a.h1.c.c cVar, d.a.i0.a.h1.b bVar, d.a.i0.a.a2.e eVar) {
        d.a.i0.a.e0.d.g("map", "MoveToLocationAction start");
        d.a.i0.a.p.e.d B = d.a.i0.a.g1.f.V().B(cVar.f40672g);
        if (!(B instanceof d.a.i0.a.p.e.b)) {
            d.a.i0.a.e0.d.b("map", "WebViewManager is null");
            return false;
        }
        d.a.i0.j.b c2 = d.a.i0.j.c.b().c((d.a.i0.a.p.e.b) B);
        d.a.i0.j.n.c d2 = c2.d(cVar.f40671f);
        if (d2 == null) {
            d.a.i0.a.e0.d.b("map", "can not find map by id " + cVar.f40671f);
            return false;
        } else if (!d2.k) {
            d.a.i0.a.e0.d.l("map", "can not move to location because showLocation is not set");
            return false;
        } else {
            BDLocation e2 = c2.e();
            if (e2 != null && c2.h()) {
                d2.l.getMap().animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(e2.getLatitude(), e2.getLongitude())));
                d2.l.getMap().setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                d2.l.getMap().setMyLocationEnabled(true);
                d2.l.getMap().setMyLocationData(new MyLocationData.Builder().accuracy(e2.getRadius()).latitude(e2.getLatitude()).longitude(e2.getLongitude()).build());
                d.a.i0.a.e0.d.g("map", "MoveToLocationAction end");
                return true;
            }
            d.a.i0.j.k.f.d.b(context, new a(context, d2, c2));
            return true;
        }
    }
}
