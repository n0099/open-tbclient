package d.a.m0.j.r;

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
import d.a.m0.j.d;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Context f51715a;

    /* renamed from: b  reason: collision with root package name */
    public BaiduMap f51716b;

    /* renamed from: c  reason: collision with root package name */
    public Marker f51717c;

    /* renamed from: d  reason: collision with root package name */
    public BitmapDescriptor f51718d;

    /* renamed from: e  reason: collision with root package name */
    public b f51719e;

    /* renamed from: f  reason: collision with root package name */
    public LocationClient f51720f;

    /* renamed from: g  reason: collision with root package name */
    public BDLocation f51721g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f51722h = false;

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
            c.this.f51716b.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (c.this.f51717c != null) {
                c.this.f51717c.remove();
                c.this.f51717c = null;
            }
            MarkerOptions anchor = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(c.this.f51718d).anchor(0.5f, 0.5f);
            c cVar = c.this;
            cVar.f51717c = (Marker) cVar.f51716b.addOverlay(anchor);
            if (c.this.f51721g == null) {
                MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
                if (c.this.f51719e != null) {
                    c.this.f51719e.a(bDLocation);
                }
            }
            c.this.f51721g = bDLocation;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(BDLocation bDLocation);
    }

    public c(Context context, BaiduMap baiduMap) {
        this.f51715a = context;
        this.f51716b = baiduMap;
    }

    public BDLocation i() {
        return this.f51721g;
    }

    public final void j() {
        if (this.f51720f == null) {
            LocationClient locationClient = new LocationClient(this.f51715a.getApplicationContext());
            this.f51720f = locationClient;
            locationClient.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.f51720f.setLocOption(locationClientOption);
            this.f51718d = BitmapDescriptorFactory.fromResource(d.aiapps_location_ding);
        }
    }

    public void k(b bVar) {
        this.f51719e = bVar;
    }

    public final void l() {
        if (this.f51722h) {
            return;
        }
        j();
        LocationClient locationClient = this.f51720f;
        if (locationClient == null || locationClient.isStarted()) {
            return;
        }
        this.f51720f.start();
        this.f51722h = true;
    }

    public final void m() {
        LocationClient locationClient;
        if (this.f51722h && (locationClient = this.f51720f) != null && locationClient.isStarted()) {
            this.f51720f.stop();
            this.f51722h = false;
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
