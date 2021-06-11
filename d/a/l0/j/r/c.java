package d.a.l0.j.r;

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
import d.a.l0.j.d;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Context f51607a;

    /* renamed from: b  reason: collision with root package name */
    public BaiduMap f51608b;

    /* renamed from: c  reason: collision with root package name */
    public Marker f51609c;

    /* renamed from: d  reason: collision with root package name */
    public BitmapDescriptor f51610d;

    /* renamed from: e  reason: collision with root package name */
    public b f51611e;

    /* renamed from: f  reason: collision with root package name */
    public LocationClient f51612f;

    /* renamed from: g  reason: collision with root package name */
    public BDLocation f51613g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f51614h = false;

    /* loaded from: classes3.dex */
    public class a extends BDAbstractLocationListener {
        public a() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null) {
                c.this.m();
                return;
            }
            c.this.f51608b.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (c.this.f51609c != null) {
                c.this.f51609c.remove();
                c.this.f51609c = null;
            }
            MarkerOptions anchor = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(c.this.f51610d).anchor(0.5f, 0.5f);
            c cVar = c.this;
            cVar.f51609c = (Marker) cVar.f51608b.addOverlay(anchor);
            if (c.this.f51613g == null) {
                MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
                if (c.this.f51611e != null) {
                    c.this.f51611e.a(bDLocation);
                }
            }
            c.this.f51613g = bDLocation;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(BDLocation bDLocation);
    }

    public c(Context context, BaiduMap baiduMap) {
        this.f51607a = context;
        this.f51608b = baiduMap;
    }

    public BDLocation i() {
        return this.f51613g;
    }

    public final void j() {
        if (this.f51612f == null) {
            LocationClient locationClient = new LocationClient(this.f51607a.getApplicationContext());
            this.f51612f = locationClient;
            locationClient.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.f51612f.setLocOption(locationClientOption);
            this.f51610d = BitmapDescriptorFactory.fromResource(d.aiapps_location_ding);
        }
    }

    public void k(b bVar) {
        this.f51611e = bVar;
    }

    public final void l() {
        if (this.f51614h) {
            return;
        }
        j();
        LocationClient locationClient = this.f51612f;
        if (locationClient == null || locationClient.isStarted()) {
            return;
        }
        this.f51612f.start();
        this.f51614h = true;
    }

    public final void m() {
        LocationClient locationClient;
        if (this.f51614h && (locationClient = this.f51612f) != null && locationClient.isStarted()) {
            this.f51612f.stop();
            this.f51614h = false;
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
