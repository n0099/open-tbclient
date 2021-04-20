package d.b.g0.h.a.f.e;

import android.content.Context;
import com.baidu.location.BDLocation;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import d.b.g0.a.k;
import d.b.g0.a.w0.c.d;
import d.b.g0.h.a.f.f.d;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends d.b.g0.h.a.f.a<d.b.g0.a.a1.c.c> {

    /* loaded from: classes3.dex */
    public class a implements d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f49113a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.h.a.i.c f49114b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.h.a.b f49115c;

        public a(Context context, d.b.g0.h.a.i.c cVar, d.b.g0.h.a.b bVar) {
            this.f49113a = context;
            this.f49114b = cVar;
            this.f49115c = bVar;
        }

        @Override // d.b.g0.h.a.f.f.d.c
        public void onFail() {
            d.b.g0.a.c0.c.l("map", "location permission fail");
        }

        @Override // d.b.g0.h.a.f.f.d.c
        public void onSuccess() {
            d.b.g0.a.c0.c.l("map", "location permission success");
            e.this.e(this.f49113a, this.f49114b, this.f49115c);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.h.a.i.c f49117a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.h.a.b f49118b;

        public b(e eVar, d.b.g0.h.a.i.c cVar, d.b.g0.h.a.b bVar) {
            this.f49117a = cVar;
            this.f49118b = bVar;
        }

        @Override // d.b.g0.a.w0.c.d.a
        public void a(d.b.g0.a.t1.k.k0.b bVar) {
            d.b.g0.a.c0.c.g("map", "get location " + bVar.a().toString());
            BaiduMap map = this.f49117a.l.getMap();
            map.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bVar.f46844c, bVar.f46843b)));
            map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
            map.setMyLocationEnabled(true);
            map.setMyLocationData(new MyLocationData.Builder().accuracy((float) bVar.f46846e).latitude(bVar.f46844c).longitude(bVar.f46843b).build());
            this.f49118b.q(true);
        }

        @Override // d.b.g0.a.w0.c.d.a
        public void onFailed(int i) {
            d.b.g0.a.c0.c.g("map", "get location error " + i);
        }
    }

    static {
        boolean z = k.f45443a;
    }

    public static e f() {
        return new e();
    }

    @Override // d.b.g0.h.a.f.a
    public boolean b(Context context, d.b.g0.a.a1.c.c cVar, d.b.g0.a.a1.b bVar, d.b.g0.a.r1.e eVar, JSONObject jSONObject) {
        return g(context, cVar, bVar, eVar);
    }

    public final void e(Context context, d.b.g0.h.a.i.c cVar, d.b.g0.h.a.b bVar) {
        d.b.g0.a.w0.a.w().d("gcj02", true, false, new b(this, cVar, bVar));
    }

    public final boolean g(Context context, d.b.g0.a.a1.c.c cVar, d.b.g0.a.a1.b bVar, d.b.g0.a.r1.e eVar) {
        d.b.g0.a.c0.c.g("map", "MoveToLocationAction start");
        d.b.g0.a.p.d.d j = d.b.g0.a.z0.f.V().j(cVar.f43506g);
        if (!(j instanceof d.b.g0.a.p.d.b)) {
            d.b.g0.a.c0.c.b("map", "WebViewManager is null");
            return false;
        }
        d.b.g0.h.a.b c2 = d.b.g0.h.a.c.b().c((d.b.g0.a.p.d.b) j);
        d.b.g0.h.a.i.c d2 = c2.d(cVar.f43505f);
        if (d2 == null) {
            d.b.g0.a.c0.c.b("map", "can not find map by id " + cVar.f43505f);
            return false;
        } else if (!d2.k) {
            d.b.g0.a.c0.c.l("map", "can not move to location because showLocation is not set");
            return false;
        } else {
            BDLocation e2 = c2.e();
            if (e2 != null && c2.h()) {
                d2.l.getMap().animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(e2.getLatitude(), e2.getLongitude())));
                d2.l.getMap().setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                d2.l.getMap().setMyLocationEnabled(true);
                d2.l.getMap().setMyLocationData(new MyLocationData.Builder().accuracy(e2.getRadius()).latitude(e2.getLatitude()).longitude(e2.getLongitude()).build());
                d.b.g0.a.c0.c.g("map", "MoveToLocationAction end");
                return true;
            }
            d.b.g0.h.a.f.f.d.b(context, new a(context, d2, c2));
            return true;
        }
    }
}
