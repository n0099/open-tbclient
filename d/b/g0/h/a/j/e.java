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
    public Context f48782a;

    /* renamed from: b  reason: collision with root package name */
    public BaiduMap f48783b;

    /* renamed from: c  reason: collision with root package name */
    public Marker f48784c;

    /* renamed from: d  reason: collision with root package name */
    public BitmapDescriptor f48785d;

    /* renamed from: e  reason: collision with root package name */
    public b f48786e;

    /* renamed from: f  reason: collision with root package name */
    public LocationClient f48787f;

    /* renamed from: g  reason: collision with root package name */
    public BDLocation f48788g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f48789h = false;

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
            e.this.f48783b.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (e.this.f48784c != null) {
                e.this.f48784c.remove();
                e.this.f48784c = null;
            }
            MarkerOptions icon = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(e.this.f48785d);
            e eVar = e.this;
            eVar.f48784c = (Marker) eVar.f48783b.addOverlay(icon);
            if (e.this.f48788g == null) {
                e.this.f48783b.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())));
                if (e.this.f48786e != null) {
                    e.this.f48786e.b(bDLocation);
                }
            }
            e.this.f48788g = bDLocation;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void b(BDLocation bDLocation);
    }

    public e(Context context, BaiduMap baiduMap) {
        this.f48782a = context;
        this.f48783b = baiduMap;
    }

    public BDLocation i() {
        return this.f48788g;
    }

    public final void j() {
        if (this.f48787f == null) {
            LocationClient locationClient = new LocationClient(this.f48782a.getApplicationContext());
            this.f48787f = locationClient;
            locationClient.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.f48787f.setLocOption(locationClientOption);
            this.f48785d = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_my_point);
        }
    }

    public void k(b bVar) {
        this.f48786e = bVar;
    }

    public final void l() {
        if (this.f48789h) {
            return;
        }
        j();
        LocationClient locationClient = this.f48787f;
        if (locationClient == null || locationClient.isStarted()) {
            return;
        }
        this.f48787f.start();
        this.f48789h = true;
    }

    public final void m() {
        LocationClient locationClient;
        if (this.f48789h && (locationClient = this.f48787f) != null && locationClient.isStarted()) {
            this.f48787f.stop();
            this.f48789h = false;
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
