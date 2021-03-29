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
    public Context f48783a;

    /* renamed from: b  reason: collision with root package name */
    public BaiduMap f48784b;

    /* renamed from: c  reason: collision with root package name */
    public Marker f48785c;

    /* renamed from: d  reason: collision with root package name */
    public BitmapDescriptor f48786d;

    /* renamed from: e  reason: collision with root package name */
    public b f48787e;

    /* renamed from: f  reason: collision with root package name */
    public LocationClient f48788f;

    /* renamed from: g  reason: collision with root package name */
    public BDLocation f48789g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f48790h = false;

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
            e.this.f48784b.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (e.this.f48785c != null) {
                e.this.f48785c.remove();
                e.this.f48785c = null;
            }
            MarkerOptions icon = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(e.this.f48786d);
            e eVar = e.this;
            eVar.f48785c = (Marker) eVar.f48784b.addOverlay(icon);
            if (e.this.f48789g == null) {
                e.this.f48784b.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())));
                if (e.this.f48787e != null) {
                    e.this.f48787e.b(bDLocation);
                }
            }
            e.this.f48789g = bDLocation;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void b(BDLocation bDLocation);
    }

    public e(Context context, BaiduMap baiduMap) {
        this.f48783a = context;
        this.f48784b = baiduMap;
    }

    public BDLocation i() {
        return this.f48789g;
    }

    public final void j() {
        if (this.f48788f == null) {
            LocationClient locationClient = new LocationClient(this.f48783a.getApplicationContext());
            this.f48788f = locationClient;
            locationClient.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.f48788f.setLocOption(locationClientOption);
            this.f48786d = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_my_point);
        }
    }

    public void k(b bVar) {
        this.f48787e = bVar;
    }

    public final void l() {
        if (this.f48790h) {
            return;
        }
        j();
        LocationClient locationClient = this.f48788f;
        if (locationClient == null || locationClient.isStarted()) {
            return;
        }
        this.f48788f.start();
        this.f48790h = true;
    }

    public final void m() {
        LocationClient locationClient;
        if (this.f48790h && (locationClient = this.f48788f) != null && locationClient.isStarted()) {
            this.f48788f.stop();
            this.f48790h = false;
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
