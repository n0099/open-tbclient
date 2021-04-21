package d.b.h0.h.a.m;

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
    public Context f49566a;

    /* renamed from: b  reason: collision with root package name */
    public BaiduMap f49567b;

    /* renamed from: c  reason: collision with root package name */
    public Marker f49568c;

    /* renamed from: d  reason: collision with root package name */
    public BitmapDescriptor f49569d;

    /* renamed from: e  reason: collision with root package name */
    public b f49570e;

    /* renamed from: f  reason: collision with root package name */
    public LocationClient f49571f;

    /* renamed from: g  reason: collision with root package name */
    public BDLocation f49572g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f49573h = false;

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
            c.this.f49567b.setMyLocationData(new MyLocationData.Builder().direction(bDLocation.getDirection()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).accuracy(bDLocation.getRadius()).satellitesNum(bDLocation.getSatelliteNumber()).build());
            if (c.this.f49568c != null) {
                c.this.f49568c.remove();
                c.this.f49568c = null;
            }
            MarkerOptions anchor = new MarkerOptions().position(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude())).zIndex(66).icon(c.this.f49569d).anchor(0.5f, 0.5f);
            c cVar = c.this;
            cVar.f49568c = (Marker) cVar.f49567b.addOverlay(anchor);
            if (c.this.f49572g == null) {
                MapStatusUpdateFactory.newLatLng(new LatLng(bDLocation.getLatitude(), bDLocation.getLongitude()));
                if (c.this.f49570e != null) {
                    c.this.f49570e.b(bDLocation);
                }
            }
            c.this.f49572g = bDLocation;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void b(BDLocation bDLocation);
    }

    public c(Context context, BaiduMap baiduMap) {
        this.f49566a = context;
        this.f49567b = baiduMap;
    }

    public BDLocation i() {
        return this.f49572g;
    }

    public final void j() {
        if (this.f49571f == null) {
            LocationClient locationClient = new LocationClient(this.f49566a.getApplicationContext());
            this.f49571f = locationClient;
            locationClient.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.f49571f.setLocOption(locationClientOption);
            this.f49569d = BitmapDescriptorFactory.fromResource(R.drawable.aiapps_location_ding);
        }
    }

    public void k(b bVar) {
        this.f49570e = bVar;
    }

    public final void l() {
        if (this.f49573h) {
            return;
        }
        j();
        LocationClient locationClient = this.f49571f;
        if (locationClient == null || locationClient.isStarted()) {
            return;
        }
        this.f49571f.start();
        this.f49573h = true;
    }

    public final void m() {
        LocationClient locationClient;
        if (this.f49573h && (locationClient = this.f49571f) != null && locationClient.isStarted()) {
            this.f49571f.stop();
            this.f49573h = false;
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
