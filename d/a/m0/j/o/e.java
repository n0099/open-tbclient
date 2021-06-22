package d.a.m0.j.o;

import android.content.Context;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public Context f51689a;

    /* renamed from: b  reason: collision with root package name */
    public BaiduMap f51690b;

    /* renamed from: c  reason: collision with root package name */
    public Marker f51691c;

    /* renamed from: d  reason: collision with root package name */
    public BitmapDescriptor f51692d;

    /* renamed from: e  reason: collision with root package name */
    public b f51693e;

    /* renamed from: f  reason: collision with root package name */
    public LocationClient f51694f;

    /* renamed from: g  reason: collision with root package name */
    public BDLocation f51695g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f51696h = false;

    /* loaded from: classes3.dex */
    public class a extends BDAbstractLocationListener {
        public a() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null) {
                e.this.m();
                return;
            }
            e.this.f51690b.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (e.this.f51691c != null) {
                e.this.f51691c.remove();
                e.this.f51691c = null;
            }
            MarkerOptions icon = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(e.this.f51692d);
            e eVar = e.this;
            eVar.f51691c = (Marker) eVar.f51690b.addOverlay(icon);
            if (e.this.f51695g == null) {
                e.this.f51690b.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())));
                if (e.this.f51693e != null) {
                    e.this.f51693e.a(bDLocation);
                }
            }
            e.this.f51695g = bDLocation;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(BDLocation bDLocation);
    }

    public e(Context context, BaiduMap baiduMap) {
        this.f51689a = context;
        this.f51690b = baiduMap;
    }

    public BDLocation i() {
        return this.f51695g;
    }

    public final void j() {
        if (this.f51694f == null) {
            LocationClient locationClient = new LocationClient(this.f51689a.getApplicationContext());
            this.f51694f = locationClient;
            locationClient.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.f51694f.setLocOption(locationClientOption);
            this.f51692d = BitmapDescriptorFactory.fromResource(d.a.m0.j.d.aiapps_location_my_point);
        }
    }

    public void k(b bVar) {
        this.f51693e = bVar;
    }

    public final void l() {
        if (this.f51696h) {
            return;
        }
        j();
        LocationClient locationClient = this.f51694f;
        if (locationClient == null || locationClient.isStarted()) {
            return;
        }
        this.f51694f.start();
        this.f51696h = true;
    }

    public final void m() {
        LocationClient locationClient;
        if (this.f51696h && (locationClient = this.f51694f) != null && locationClient.isStarted()) {
            this.f51694f.stop();
            this.f51696h = false;
        }
    }

    public void n(boolean z) {
        if (z) {
            l();
        } else {
            m();
        }
    }
}
