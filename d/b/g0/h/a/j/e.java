package d.b.g0.h.a.j;

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
public class e {

    /* renamed from: a  reason: collision with root package name */
    public Context f49175a;

    /* renamed from: b  reason: collision with root package name */
    public BaiduMap f49176b;

    /* renamed from: c  reason: collision with root package name */
    public Marker f49177c;

    /* renamed from: d  reason: collision with root package name */
    public BitmapDescriptor f49178d;

    /* renamed from: e  reason: collision with root package name */
    public b f49179e;

    /* renamed from: f  reason: collision with root package name */
    public LocationClient f49180f;

    /* renamed from: g  reason: collision with root package name */
    public BDLocation f49181g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f49182h = false;

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
            e.this.f49176b.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (e.this.f49177c != null) {
                e.this.f49177c.remove();
                e.this.f49177c = null;
            }
            MarkerOptions icon = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(e.this.f49178d);
            e eVar = e.this;
            eVar.f49177c = (Marker) eVar.f49176b.addOverlay(icon);
            if (e.this.f49181g == null) {
                e.this.f49176b.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())));
                if (e.this.f49179e != null) {
                    e.this.f49179e.b(bDLocation);
                }
            }
            e.this.f49181g = bDLocation;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void b(BDLocation bDLocation);
    }

    public e(Context context, BaiduMap baiduMap) {
        this.f49175a = context;
        this.f49176b = baiduMap;
    }

    public BDLocation i() {
        return this.f49181g;
    }

    public final void j() {
        if (this.f49180f == null) {
            LocationClient locationClient = new LocationClient(this.f49175a.getApplicationContext());
            this.f49180f = locationClient;
            locationClient.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.f49180f.setLocOption(locationClientOption);
            this.f49178d = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_my_point);
        }
    }

    public void k(b bVar) {
        this.f49179e = bVar;
    }

    public final void l() {
        if (this.f49182h) {
            return;
        }
        j();
        LocationClient locationClient = this.f49180f;
        if (locationClient == null || locationClient.isStarted()) {
            return;
        }
        this.f49180f.start();
        this.f49182h = true;
    }

    public final void m() {
        LocationClient locationClient;
        if (this.f49182h && (locationClient = this.f49180f) != null && locationClient.isStarted()) {
            this.f49180f.stop();
            this.f49182h = false;
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
