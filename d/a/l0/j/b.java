package d.a.l0.j;

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
    public SensorManager f47828b;

    /* renamed from: c  reason: collision with root package name */
    public double f47829c;

    /* renamed from: d  reason: collision with root package name */
    public LocationClient f47830d;

    /* renamed from: f  reason: collision with root package name */
    public BDLocation f47832f;

    /* renamed from: e  reason: collision with root package name */
    public boolean f47831e = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f47833g = false;

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.l0.j.n.c> f47827a = new ArrayList(1);

    /* loaded from: classes3.dex */
    public class a implements BDLocationListener {
        public a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null || b.this.f47827a.size() <= 0) {
                b.this.o();
                return;
            }
            b.this.f47832f = bDLocation;
            for (d.a.l0.j.n.c cVar : b.this.f47827a) {
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

    public d.a.l0.j.n.c d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (d.a.l0.j.n.c cVar : this.f47827a) {
            if (cVar != null && TextUtils.equals(cVar.j, str)) {
                return cVar;
            }
        }
        return null;
    }

    public BDLocation e() {
        return this.f47832f;
    }

    public final void f() {
        if (this.f47830d == null) {
            LocationClient locationClient = new LocationClient(AppRuntime.getAppContext());
            this.f47830d = locationClient;
            locationClient.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.f47830d.setLocOption(locationClientOption);
        }
    }

    public boolean g(d.a.l0.j.n.c cVar) {
        if (cVar == null) {
            return false;
        }
        this.f47827a.add(cVar);
        return true;
    }

    public boolean h() {
        LocationClient locationClient = this.f47830d;
        return locationClient != null && locationClient.isStarted();
    }

    public void i() {
        o();
        for (d.a.l0.j.n.c cVar : this.f47827a) {
            cVar.l.onPause();
        }
    }

    public void j() {
        o();
        this.f47833g = false;
        if (Build.VERSION.SDK_INT > 19) {
            for (d.a.l0.j.n.c cVar : this.f47827a) {
                cVar.l.onDestroy();
            }
        }
        this.f47827a.clear();
    }

    public boolean k(String str) {
        d.a.l0.j.n.c d2 = d(str);
        if (d2 != null) {
            this.f47827a.remove(d2);
            return true;
        }
        return false;
    }

    public void l() {
        m();
        for (d.a.l0.j.n.c cVar : this.f47827a) {
            cVar.l.onResume();
        }
    }

    public final void m() {
        if (this.f47833g) {
            f();
            LocationClient locationClient = this.f47830d;
            if (locationClient == null || locationClient.isStarted()) {
                return;
            }
            this.f47830d.start();
            n();
            d.a.l0.a.e0.d.l("map", "start location");
        }
    }

    public final void n() {
        if (this.f47831e) {
            return;
        }
        SensorManager sensorManager = (SensorManager) AppRuntime.getAppContext().getSystemService("sensor");
        this.f47828b = sensorManager;
        if (sensorManager != null) {
            sensorManager.registerListener(this, sensorManager.getDefaultSensor(3), 2);
            this.f47831e = true;
        }
    }

    public final void o() {
        LocationClient locationClient;
        if (this.f47833g && (locationClient = this.f47830d) != null && locationClient.isStarted()) {
            this.f47830d.stop();
            p();
            d.a.l0.a.e0.d.l("map", "stop location");
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        double d2 = sensorEvent.values[0];
        if (Math.abs(d2 - this.f47829c) > 1.0d) {
            for (d.a.l0.j.n.c cVar : this.f47827a) {
                MyLocationData locationData = cVar.l.getMap().getLocationData();
                if (locationData != null && cVar.k) {
                    cVar.l.getMap().setMyLocationData(new MyLocationData.Builder().direction((float) d2).accuracy(locationData.accuracy).latitude(locationData.latitude).longitude(locationData.longitude).satellitesNum(locationData.satellitesNum).build());
                    f();
                }
            }
        }
        this.f47829c = d2;
    }

    public final void p() {
        SensorManager sensorManager = this.f47828b;
        if (sensorManager == null || !this.f47831e) {
            return;
        }
        sensorManager.unregisterListener(this);
        this.f47831e = false;
    }

    public void q(boolean z) {
        if (z) {
            this.f47833g = true;
            m();
            return;
        }
        o();
        this.f47833g = false;
    }
}
