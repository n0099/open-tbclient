package d.a.l0.j.o;

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
    public Context f51581a;

    /* renamed from: b  reason: collision with root package name */
    public BaiduMap f51582b;

    /* renamed from: c  reason: collision with root package name */
    public Marker f51583c;

    /* renamed from: d  reason: collision with root package name */
    public BitmapDescriptor f51584d;

    /* renamed from: e  reason: collision with root package name */
    public b f51585e;

    /* renamed from: f  reason: collision with root package name */
    public LocationClient f51586f;

    /* renamed from: g  reason: collision with root package name */
    public BDLocation f51587g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f51588h = false;

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
            e.this.f51582b.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (e.this.f51583c != null) {
                e.this.f51583c.remove();
                e.this.f51583c = null;
            }
            MarkerOptions icon = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(e.this.f51584d);
            e eVar = e.this;
            eVar.f51583c = (Marker) eVar.f51582b.addOverlay(icon);
            if (e.this.f51587g == null) {
                e.this.f51582b.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())));
                if (e.this.f51585e != null) {
                    e.this.f51585e.a(bDLocation);
                }
            }
            e.this.f51587g = bDLocation;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(BDLocation bDLocation);
    }

    public e(Context context, BaiduMap baiduMap) {
        this.f51581a = context;
        this.f51582b = baiduMap;
    }

    public BDLocation i() {
        return this.f51587g;
    }

    public final void j() {
        if (this.f51586f == null) {
            LocationClient locationClient = new LocationClient(this.f51581a.getApplicationContext());
            this.f51586f = locationClient;
            locationClient.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.f51586f.setLocOption(locationClientOption);
            this.f51584d = BitmapDescriptorFactory.fromResource(d.a.l0.j.d.aiapps_location_my_point);
        }
    }

    public void k(b bVar) {
        this.f51585e = bVar;
    }

    public final void l() {
        if (this.f51588h) {
            return;
        }
        j();
        LocationClient locationClient = this.f51586f;
        if (locationClient == null || locationClient.isStarted()) {
            return;
        }
        this.f51586f.start();
        this.f51588h = true;
    }

    public final void m() {
        LocationClient locationClient;
        if (this.f51588h && (locationClient = this.f51586f) != null && locationClient.isStarted()) {
            this.f51586f.stop();
            this.f51588h = false;
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
