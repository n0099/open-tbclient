package d.b.g0.h.a.m;

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
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Context f48845a;

    /* renamed from: b  reason: collision with root package name */
    public BaiduMap f48846b;

    /* renamed from: c  reason: collision with root package name */
    public Marker f48847c;

    /* renamed from: d  reason: collision with root package name */
    public BitmapDescriptor f48848d;

    /* renamed from: e  reason: collision with root package name */
    public b f48849e;

    /* renamed from: f  reason: collision with root package name */
    public LocationClient f48850f;

    /* renamed from: g  reason: collision with root package name */
    public BDLocation f48851g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f48852h = false;

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
            c.this.f48846b.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (c.this.f48847c != null) {
                c.this.f48847c.remove();
                c.this.f48847c = null;
            }
            MarkerOptions anchor = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(c.this.f48848d).anchor(0.5f, 0.5f);
            c cVar = c.this;
            cVar.f48847c = (Marker) cVar.f48846b.addOverlay(anchor);
            if (c.this.f48851g == null) {
                MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
                if (c.this.f48849e != null) {
                    c.this.f48849e.b(bDLocation);
                }
            }
            c.this.f48851g = bDLocation;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void b(BDLocation bDLocation);
    }

    public c(Context context, BaiduMap baiduMap) {
        this.f48845a = context;
        this.f48846b = baiduMap;
    }

    public BDLocation i() {
        return this.f48851g;
    }

    public final void j() {
        if (this.f48850f == null) {
            LocationClient locationClient = new LocationClient(this.f48845a.getApplicationContext());
            this.f48850f = locationClient;
            locationClient.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.f48850f.setLocOption(locationClientOption);
            this.f48848d = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding);
        }
    }

    public void k(b bVar) {
        this.f48849e = bVar;
    }

    public final void l() {
        if (this.f48852h) {
            return;
        }
        j();
        LocationClient locationClient = this.f48850f;
        if (locationClient == null || locationClient.isStarted()) {
            return;
        }
        this.f48850f.start();
        this.f48852h = true;
    }

    public final void m() {
        LocationClient locationClient;
        if (this.f48852h && (locationClient = this.f48850f) != null && locationClient.isStarted()) {
            this.f48850f.stop();
            this.f48852h = false;
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
