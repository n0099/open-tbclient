package d.a.h0.h.a.f.e;

import android.content.Context;
import com.baidu.location.BDLocation;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import d.a.h0.a.k;
import d.a.h0.a.w0.c.d;
import d.a.h0.h.a.f.f.d;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends d.a.h0.h.a.f.a<d.a.h0.a.a1.c.c> {

    /* loaded from: classes3.dex */
    public class a implements d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f46942a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.h.a.i.c f46943b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.h.a.b f46944c;

        public a(Context context, d.a.h0.h.a.i.c cVar, d.a.h0.h.a.b bVar) {
            this.f46942a = context;
            this.f46943b = cVar;
            this.f46944c = bVar;
        }

        @Override // d.a.h0.h.a.f.f.d.c
        public void onFail() {
            d.a.h0.a.c0.c.l("map", "location permission fail");
        }

        @Override // d.a.h0.h.a.f.f.d.c
        public void onSuccess() {
            d.a.h0.a.c0.c.l("map", "location permission success");
            e.this.e(this.f46942a, this.f46943b, this.f46944c);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.h.a.i.c f46946a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.h.a.b f46947b;

        public b(e eVar, d.a.h0.h.a.i.c cVar, d.a.h0.h.a.b bVar) {
            this.f46946a = cVar;
            this.f46947b = bVar;
        }

        @Override // d.a.h0.a.w0.c.d.a
        public void a(d.a.h0.a.t1.k.k0.b bVar) {
            d.a.h0.a.c0.c.g("map", "get location " + bVar.a().toString());
            BaiduMap map = this.f46946a.l.getMap();
            map.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bVar.f44573c, bVar.f44572b)));
            map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
            map.setMyLocationEnabled(true);
            map.setMyLocationData(new MyLocationData.Builder().accuracy((float) bVar.f44575e).latitude(bVar.f44573c).longitude(bVar.f44572b).build());
            this.f46947b.q(true);
        }

        @Override // d.a.h0.a.w0.c.d.a
        public void onFailed(int i2) {
            d.a.h0.a.c0.c.g("map", "get location error " + i2);
        }
    }

    static {
        boolean z = k.f43101a;
    }

    public static e f() {
        return new e();
    }

    @Override // d.a.h0.h.a.f.a
    public boolean b(Context context, d.a.h0.a.a1.c.c cVar, d.a.h0.a.a1.b bVar, d.a.h0.a.r1.e eVar, JSONObject jSONObject) {
        return g(context, cVar, bVar, eVar);
    }

    public final void e(Context context, d.a.h0.h.a.i.c cVar, d.a.h0.h.a.b bVar) {
        d.a.h0.a.w0.a.w().b("gcj02", true, false, new b(this, cVar, bVar));
    }

    public final boolean g(Context context, d.a.h0.a.a1.c.c cVar, d.a.h0.a.a1.b bVar, d.a.h0.a.r1.e eVar) {
        d.a.h0.a.c0.c.g("map", "MoveToLocationAction start");
        d.a.h0.a.p.d.d B = d.a.h0.a.z0.f.V().B(cVar.f41093g);
        if (!(B instanceof d.a.h0.a.p.d.b)) {
            d.a.h0.a.c0.c.b("map", "WebViewManager is null");
            return false;
        }
        d.a.h0.h.a.b c2 = d.a.h0.h.a.c.b().c((d.a.h0.a.p.d.b) B);
        d.a.h0.h.a.i.c d2 = c2.d(cVar.f41092f);
        if (d2 == null) {
            d.a.h0.a.c0.c.b("map", "can not find map by id " + cVar.f41092f);
            return false;
        } else if (!d2.k) {
            d.a.h0.a.c0.c.l("map", "can not move to location because showLocation is not set");
            return false;
        } else {
            BDLocation e2 = c2.e();
            if (e2 != null && c2.h()) {
                d2.l.getMap().animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(e2.getLatitude(), e2.getLongitude())));
                d2.l.getMap().setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                d2.l.getMap().setMyLocationEnabled(true);
                d2.l.getMap().setMyLocationData(new MyLocationData.Builder().accuracy(e2.getRadius()).latitude(e2.getLatitude()).longitude(e2.getLongitude()).build());
                d.a.h0.a.c0.c.g("map", "MoveToLocationAction end");
                return true;
            }
            d.a.h0.h.a.f.f.d.b(context, new a(context, d2, c2));
            return true;
        }
    }
}
