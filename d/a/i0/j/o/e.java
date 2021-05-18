package d.a.i0.j.o;

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
    public Context f47731a;

    /* renamed from: b  reason: collision with root package name */
    public BaiduMap f47732b;

    /* renamed from: c  reason: collision with root package name */
    public Marker f47733c;

    /* renamed from: d  reason: collision with root package name */
    public BitmapDescriptor f47734d;

    /* renamed from: e  reason: collision with root package name */
    public b f47735e;

    /* renamed from: f  reason: collision with root package name */
    public LocationClient f47736f;

    /* renamed from: g  reason: collision with root package name */
    public BDLocation f47737g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f47738h = false;

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
            e.this.f47732b.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (e.this.f47733c != null) {
                e.this.f47733c.remove();
                e.this.f47733c = null;
            }
            MarkerOptions icon = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(e.this.f47734d);
            e eVar = e.this;
            eVar.f47733c = (Marker) eVar.f47732b.addOverlay(icon);
            if (e.this.f47737g == null) {
                e.this.f47732b.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())));
                if (e.this.f47735e != null) {
                    e.this.f47735e.a(bDLocation);
                }
            }
            e.this.f47737g = bDLocation;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(BDLocation bDLocation);
    }

    public e(Context context, BaiduMap baiduMap) {
        this.f47731a = context;
        this.f47732b = baiduMap;
    }

    public BDLocation i() {
        return this.f47737g;
    }

    public final void j() {
        if (this.f47736f == null) {
            LocationClient locationClient = new LocationClient(this.f47731a.getApplicationContext());
            this.f47736f = locationClient;
            locationClient.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.f47736f.setLocOption(locationClientOption);
            this.f47734d = BitmapDescriptorFactory.fromResource(d.a.i0.j.d.aiapps_location_my_point);
        }
    }

    public void k(b bVar) {
        this.f47735e = bVar;
    }

    public final void l() {
        if (this.f47738h) {
            return;
        }
        j();
        LocationClient locationClient = this.f47736f;
        if (locationClient == null || locationClient.isStarted()) {
            return;
        }
        this.f47736f.start();
        this.f47738h = true;
    }

    public final void m() {
        LocationClient locationClient;
        if (this.f47738h && (locationClient = this.f47736f) != null && locationClient.isStarted()) {
            this.f47736f.stop();
            this.f47738h = false;
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
