package d.a.h0.h.a.j;

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
    public Context f47006a;

    /* renamed from: b  reason: collision with root package name */
    public BaiduMap f47007b;

    /* renamed from: c  reason: collision with root package name */
    public Marker f47008c;

    /* renamed from: d  reason: collision with root package name */
    public BitmapDescriptor f47009d;

    /* renamed from: e  reason: collision with root package name */
    public b f47010e;

    /* renamed from: f  reason: collision with root package name */
    public LocationClient f47011f;

    /* renamed from: g  reason: collision with root package name */
    public BDLocation f47012g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f47013h = false;

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
            e.this.f47007b.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (e.this.f47008c != null) {
                e.this.f47008c.remove();
                e.this.f47008c = null;
            }
            MarkerOptions icon = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(e.this.f47009d);
            e eVar = e.this;
            eVar.f47008c = (Marker) eVar.f47007b.addOverlay(icon);
            if (e.this.f47012g == null) {
                e.this.f47007b.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())));
                if (e.this.f47010e != null) {
                    e.this.f47010e.b(bDLocation);
                }
            }
            e.this.f47012g = bDLocation;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void b(BDLocation bDLocation);
    }

    public e(Context context, BaiduMap baiduMap) {
        this.f47006a = context;
        this.f47007b = baiduMap;
    }

    public BDLocation i() {
        return this.f47012g;
    }

    public final void j() {
        if (this.f47011f == null) {
            LocationClient locationClient = new LocationClient(this.f47006a.getApplicationContext());
            this.f47011f = locationClient;
            locationClient.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.f47011f.setLocOption(locationClientOption);
            this.f47009d = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_my_point);
        }
    }

    public void k(b bVar) {
        this.f47010e = bVar;
    }

    public final void l() {
        if (this.f47013h) {
            return;
        }
        j();
        LocationClient locationClient = this.f47011f;
        if (locationClient == null || locationClient.isStarted()) {
            return;
        }
        this.f47011f.start();
        this.f47013h = true;
    }

    public final void m() {
        LocationClient locationClient;
        if (this.f47013h && (locationClient = this.f47011f) != null && locationClient.isStarted()) {
            this.f47011f.stop();
            this.f47013h = false;
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
