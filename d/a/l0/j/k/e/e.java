package d.a.l0.j.k.e;

import android.content.Context;
import com.baidu.location.BDLocation;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import d.a.l0.a.c1.d.d;
import d.a.l0.a.k;
import d.a.l0.j.k.f.d;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends d.a.l0.j.k.a<d.a.l0.a.h1.c.c> {

    /* loaded from: classes3.dex */
    public class a implements d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f51515a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.j.n.c f51516b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.j.b f51517c;

        public a(Context context, d.a.l0.j.n.c cVar, d.a.l0.j.b bVar) {
            this.f51515a = context;
            this.f51516b = cVar;
            this.f51517c = bVar;
        }

        @Override // d.a.l0.j.k.f.d.c
        public void onFail() {
            d.a.l0.a.e0.d.l("map", "location permission fail");
        }

        @Override // d.a.l0.j.k.f.d.c
        public void onSuccess() {
            d.a.l0.a.e0.d.l("map", "location permission success");
            e.this.e(this.f51515a, this.f51516b, this.f51517c);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.j.n.c f51519a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.j.b f51520b;

        public b(e eVar, d.a.l0.j.n.c cVar, d.a.l0.j.b bVar) {
            this.f51519a = cVar;
            this.f51520b = bVar;
        }

        @Override // d.a.l0.a.c1.d.d.a
        public void a(d.a.l0.a.c2.f.k0.b bVar) {
            d.a.l0.a.e0.d.g("map", "get location " + bVar.a().toString());
            BaiduMap map = this.f51519a.l.getMap();
            map.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bVar.f44805c, bVar.f44804b)));
            map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
            map.setMyLocationEnabled(true);
            map.setMyLocationData(new MyLocationData.Builder().accuracy((float) bVar.f44807e).latitude(bVar.f44805c).longitude(bVar.f44804b).build());
            this.f51520b.q(true);
        }

        @Override // d.a.l0.a.c1.d.d.a
        public void onFailed(int i2) {
            d.a.l0.a.e0.d.g("map", "get location error " + i2);
        }
    }

    static {
        boolean z = k.f46875a;
    }

    public static e f() {
        return new e();
    }

    @Override // d.a.l0.j.k.a
    public boolean b(Context context, d.a.l0.a.h1.c.c cVar, d.a.l0.a.h1.b bVar, d.a.l0.a.a2.e eVar, JSONObject jSONObject) {
        return g(context, cVar, bVar, eVar);
    }

    public final void e(Context context, d.a.l0.j.n.c cVar, d.a.l0.j.b bVar) {
        d.a.l0.a.c1.a.E().b("gcj02", true, false, new b(this, cVar, bVar));
    }

    public final boolean g(Context context, d.a.l0.a.h1.c.c cVar, d.a.l0.a.h1.b bVar, d.a.l0.a.a2.e eVar) {
        d.a.l0.a.e0.d.g("map", "MoveToLocationAction start");
        d.a.l0.a.p.e.d B = d.a.l0.a.g1.f.V().B(cVar.f44522g);
        if (!(B instanceof d.a.l0.a.p.e.b)) {
            d.a.l0.a.e0.d.b("map", "WebViewManager is null");
            return false;
        }
        d.a.l0.j.b c2 = d.a.l0.j.c.b().c((d.a.l0.a.p.e.b) B);
        d.a.l0.j.n.c d2 = c2.d(cVar.f44521f);
        if (d2 == null) {
            d.a.l0.a.e0.d.b("map", "can not find map by id " + cVar.f44521f);
            return false;
        } else if (!d2.k) {
            d.a.l0.a.e0.d.l("map", "can not move to location because showLocation is not set");
            return false;
        } else {
            BDLocation e2 = c2.e();
            if (e2 != null && c2.h()) {
                d2.l.getMap().animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(e2.getLatitude(), e2.getLongitude())));
                d2.l.getMap().setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                d2.l.getMap().setMyLocationEnabled(true);
                d2.l.getMap().setMyLocationData(new MyLocationData.Builder().accuracy(e2.getRadius()).latitude(e2.getLatitude()).longitude(e2.getLongitude()).build());
                d.a.l0.a.e0.d.g("map", "MoveToLocationAction end");
                return true;
            }
            d.a.l0.j.k.f.d.b(context, new a(context, d2, c2));
            return true;
        }
    }
}
