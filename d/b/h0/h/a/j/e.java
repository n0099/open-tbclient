package d.b.h0.h.a.j;

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
    public Context f49504a;

    /* renamed from: b  reason: collision with root package name */
    public BaiduMap f49505b;

    /* renamed from: c  reason: collision with root package name */
    public Marker f49506c;

    /* renamed from: d  reason: collision with root package name */
    public BitmapDescriptor f49507d;

    /* renamed from: e  reason: collision with root package name */
    public b f49508e;

    /* renamed from: f  reason: collision with root package name */
    public LocationClient f49509f;

    /* renamed from: g  reason: collision with root package name */
    public BDLocation f49510g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f49511h = false;

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
            e.this.f49505b.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (e.this.f49506c != null) {
                e.this.f49506c.remove();
                e.this.f49506c = null;
            }
            MarkerOptions icon = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(e.this.f49507d);
            e eVar = e.this;
            eVar.f49506c = (Marker) eVar.f49505b.addOverlay(icon);
            if (e.this.f49510g == null) {
                e.this.f49505b.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())));
                if (e.this.f49508e != null) {
                    e.this.f49508e.b(bDLocation);
                }
            }
            e.this.f49510g = bDLocation;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void b(BDLocation bDLocation);
    }

    public e(Context context, BaiduMap baiduMap) {
        this.f49504a = context;
        this.f49505b = baiduMap;
    }

    public BDLocation i() {
        return this.f49510g;
    }

    public final void j() {
        if (this.f49509f == null) {
            LocationClient locationClient = new LocationClient(this.f49504a.getApplicationContext());
            this.f49509f = locationClient;
            locationClient.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.f49509f.setLocOption(locationClientOption);
            this.f49507d = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_my_point);
        }
    }

    public void k(b bVar) {
        this.f49508e = bVar;
    }

    public final void l() {
        if (this.f49511h) {
            return;
        }
        j();
        LocationClient locationClient = this.f49509f;
        if (locationClient == null || locationClient.isStarted()) {
            return;
        }
        this.f49509f.start();
        this.f49511h = true;
    }

    public final void m() {
        LocationClient locationClient;
        if (this.f49511h && (locationClient = this.f49509f) != null && locationClient.isStarted()) {
            this.f49509f.stop();
            this.f49511h = false;
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
