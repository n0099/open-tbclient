package d.a.i0.j.r;

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
import d.a.i0.j.d;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Context f47757a;

    /* renamed from: b  reason: collision with root package name */
    public BaiduMap f47758b;

    /* renamed from: c  reason: collision with root package name */
    public Marker f47759c;

    /* renamed from: d  reason: collision with root package name */
    public BitmapDescriptor f47760d;

    /* renamed from: e  reason: collision with root package name */
    public b f47761e;

    /* renamed from: f  reason: collision with root package name */
    public LocationClient f47762f;

    /* renamed from: g  reason: collision with root package name */
    public BDLocation f47763g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f47764h = false;

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
            c.this.f47758b.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (c.this.f47759c != null) {
                c.this.f47759c.remove();
                c.this.f47759c = null;
            }
            MarkerOptions anchor = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(c.this.f47760d).anchor(0.5f, 0.5f);
            c cVar = c.this;
            cVar.f47759c = (Marker) cVar.f47758b.addOverlay(anchor);
            if (c.this.f47763g == null) {
                MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
                if (c.this.f47761e != null) {
                    c.this.f47761e.a(bDLocation);
                }
            }
            c.this.f47763g = bDLocation;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(BDLocation bDLocation);
    }

    public c(Context context, BaiduMap baiduMap) {
        this.f47757a = context;
        this.f47758b = baiduMap;
    }

    public BDLocation i() {
        return this.f47763g;
    }

    public final void j() {
        if (this.f47762f == null) {
            LocationClient locationClient = new LocationClient(this.f47757a.getApplicationContext());
            this.f47762f = locationClient;
            locationClient.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.f47762f.setLocOption(locationClientOption);
            this.f47760d = BitmapDescriptorFactory.fromResource(d.aiapps_location_ding);
        }
    }

    public void k(b bVar) {
        this.f47761e = bVar;
    }

    public final void l() {
        if (this.f47764h) {
            return;
        }
        j();
        LocationClient locationClient = this.f47762f;
        if (locationClient == null || locationClient.isStarted()) {
            return;
        }
        this.f47762f.start();
        this.f47764h = true;
    }

    public final void m() {
        LocationClient locationClient;
        if (this.f47764h && (locationClient = this.f47762f) != null && locationClient.isStarted()) {
            this.f47762f.stop();
            this.f47764h = false;
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
