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
    public Context f47907a;

    /* renamed from: b  reason: collision with root package name */
    public BaiduMap f47908b;

    /* renamed from: c  reason: collision with root package name */
    public Marker f47909c;

    /* renamed from: d  reason: collision with root package name */
    public BitmapDescriptor f47910d;

    /* renamed from: e  reason: collision with root package name */
    public b f47911e;

    /* renamed from: f  reason: collision with root package name */
    public LocationClient f47912f;

    /* renamed from: g  reason: collision with root package name */
    public BDLocation f47913g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f47914h = false;

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
            e.this.f47908b.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (e.this.f47909c != null) {
                e.this.f47909c.remove();
                e.this.f47909c = null;
            }
            MarkerOptions icon = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(e.this.f47910d);
            e eVar = e.this;
            eVar.f47909c = (Marker) eVar.f47908b.addOverlay(icon);
            if (e.this.f47913g == null) {
                e.this.f47908b.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())));
                if (e.this.f47911e != null) {
                    e.this.f47911e.a(bDLocation);
                }
            }
            e.this.f47913g = bDLocation;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(BDLocation bDLocation);
    }

    public e(Context context, BaiduMap baiduMap) {
        this.f47907a = context;
        this.f47908b = baiduMap;
    }

    public BDLocation i() {
        return this.f47913g;
    }

    public final void j() {
        if (this.f47912f == null) {
            LocationClient locationClient = new LocationClient(this.f47907a.getApplicationContext());
            this.f47912f = locationClient;
            locationClient.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.f47912f.setLocOption(locationClientOption);
            this.f47910d = BitmapDescriptorFactory.fromResource(d.a.l0.j.d.aiapps_location_my_point);
        }
    }

    public void k(b bVar) {
        this.f47911e = bVar;
    }

    public final void l() {
        if (this.f47914h) {
            return;
        }
        j();
        LocationClient locationClient = this.f47912f;
        if (locationClient == null || locationClient.isStarted()) {
            return;
        }
        this.f47912f.start();
        this.f47914h = true;
    }

    public final void m() {
        LocationClient locationClient;
        if (this.f47914h && (locationClient = this.f47912f) != null && locationClient.isStarted()) {
            this.f47912f.stop();
            this.f47914h = false;
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
