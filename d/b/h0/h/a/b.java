package d.b.h0.h.a;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements SensorEventListener {

    /* renamed from: b  reason: collision with root package name */
    public SensorManager f49430b;

    /* renamed from: c  reason: collision with root package name */
    public double f49431c;

    /* renamed from: d  reason: collision with root package name */
    public LocationClient f49432d;

    /* renamed from: f  reason: collision with root package name */
    public BDLocation f49434f;

    /* renamed from: e  reason: collision with root package name */
    public boolean f49433e = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f49435g = false;

    /* renamed from: a  reason: collision with root package name */
    public List<d.b.h0.h.a.i.c> f49429a = new ArrayList(1);

    /* loaded from: classes3.dex */
    public class a implements BDLocationListener {
        public a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null || b.this.f49429a.size() <= 0) {
                b.this.o();
                return;
            }
            b.this.f49434f = bDLocation;
            for (d.b.h0.h.a.i.c cVar : b.this.f49429a) {
                if (cVar.k) {
                    MyLocationData build = new MyLocationData.Builder().direction(bDLocation.getDirection()).accuracy(bDLocation.getGpsAccuracyStatus()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).satellitesNum(bDLocation.getSatelliteNumber()).build();
                    BaiduMap map = cVar.l.getMap();
                    map.setMyLocationEnabled(true);
                    map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                    map.setMyLocationData(build);
                }
            }
        }
    }

    public b() {
        m();
    }

    public d.b.h0.h.a.i.c d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (d.b.h0.h.a.i.c cVar : this.f49429a) {
            if (cVar != null && TextUtils.equals(cVar.j, str)) {
                return cVar;
            }
        }
        return null;
    }

    public BDLocation e() {
        return this.f49434f;
    }

    public final void f() {
        if (this.f49432d == null) {
            LocationClient locationClient = new LocationClient(AppRuntime.getAppContext());
            this.f49432d = locationClient;
            locationClient.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.f49432d.setLocOption(locationClientOption);
        }
    }

    public boolean g(d.b.h0.h.a.i.c cVar) {
        if (cVar == null) {
            return false;
        }
        this.f49429a.add(cVar);
        return true;
    }

    public boolean h() {
        LocationClient locationClient = this.f49432d;
        return locationClient != null && locationClient.isStarted();
    }

    public void i() {
        o();
        for (d.b.h0.h.a.i.c cVar : this.f49429a) {
            cVar.l.onPause();
        }
    }

    public void j() {
        o();
        this.f49435g = false;
        if (Build.VERSION.SDK_INT > 19) {
            for (d.b.h0.h.a.i.c cVar : this.f49429a) {
                cVar.l.onDestroy();
            }
        }
        this.f49429a.clear();
    }

    public boolean k(String str) {
        d.b.h0.h.a.i.c d2 = d(str);
        if (d2 != null) {
            this.f49429a.remove(d2);
            return true;
        }
        return false;
    }

    public void l() {
        m();
        for (d.b.h0.h.a.i.c cVar : this.f49429a) {
            cVar.l.onResume();
        }
    }

    public final void m() {
        if (this.f49435g) {
            f();
            LocationClient locationClient = this.f49432d;
            if (locationClient == null || locationClient.isStarted()) {
                return;
            }
            this.f49432d.start();
            n();
            d.b.h0.a.c0.c.l("map", "start location");
        }
    }

    public final void n() {
        if (this.f49433e) {
            return;
        }
        SensorManager sensorManager = (SensorManager) AppRuntime.getAppContext().getSystemService("sensor");
        this.f49430b = sensorManager;
        if (sensorManager != null) {
            sensorManager.registerListener(this, sensorManager.getDefaultSensor(3), 2);
            this.f49433e = true;
        }
    }

    public final void o() {
        LocationClient locationClient;
        if (this.f49435g && (locationClient = this.f49432d) != null && locationClient.isStarted()) {
            this.f49432d.stop();
            p();
            d.b.h0.a.c0.c.l("map", "stop location");
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        double d2 = sensorEvent.values[0];
        if (Math.abs(d2 - this.f49431c) > 1.0d) {
            for (d.b.h0.h.a.i.c cVar : this.f49429a) {
                MyLocationData locationData = cVar.l.getMap().getLocationData();
                if (locationData != null && cVar.k) {
                    cVar.l.getMap().setMyLocationData(new MyLocationData.Builder().direction((float) d2).accuracy(locationData.accuracy).latitude(locationData.latitude).longitude(locationData.longitude).satellitesNum(locationData.satellitesNum).build());
                    f();
                }
            }
        }
        this.f49431c = d2;
    }

    public final void p() {
        SensorManager sensorManager = this.f49430b;
        if (sensorManager == null || !this.f49433e) {
            return;
        }
        sensorManager.unregisterListener(this);
        this.f49433e = false;
    }

    public void q(boolean z) {
        if (z) {
            this.f49435g = true;
            m();
            return;
        }
        o();
        this.f49435g = false;
    }
}
