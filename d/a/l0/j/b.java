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
    public SensorManager f51502b;

    /* renamed from: c  reason: collision with root package name */
    public double f51503c;

    /* renamed from: d  reason: collision with root package name */
    public LocationClient f51504d;

    /* renamed from: f  reason: collision with root package name */
    public BDLocation f51506f;

    /* renamed from: e  reason: collision with root package name */
    public boolean f51505e = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51507g = false;

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.l0.j.n.c> f51501a = new ArrayList(1);

    /* loaded from: classes3.dex */
    public class a implements BDLocationListener {
        public a() {
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            if (bDLocation == null || b.this.f51501a.size() <= 0) {
                b.this.o();
                return;
            }
            b.this.f51506f = bDLocation;
            for (d.a.l0.j.n.c cVar : b.this.f51501a) {
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
        for (d.a.l0.j.n.c cVar : this.f51501a) {
            if (cVar != null && TextUtils.equals(cVar.j, str)) {
                return cVar;
            }
        }
        return null;
    }

    public BDLocation e() {
        return this.f51506f;
    }

    public final void f() {
        if (this.f51504d == null) {
            LocationClient locationClient = new LocationClient(AppRuntime.getAppContext());
            this.f51504d = locationClient;
            locationClient.registerLocationListener(new a());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.f51504d.setLocOption(locationClientOption);
        }
    }

    public boolean g(d.a.l0.j.n.c cVar) {
        if (cVar == null) {
            return false;
        }
        this.f51501a.add(cVar);
        return true;
    }

    public boolean h() {
        LocationClient locationClient = this.f51504d;
        return locationClient != null && locationClient.isStarted();
    }

    public void i() {
        o();
        for (d.a.l0.j.n.c cVar : this.f51501a) {
            cVar.l.onPause();
        }
    }

    public void j() {
        o();
        this.f51507g = false;
        if (Build.VERSION.SDK_INT > 19) {
            for (d.a.l0.j.n.c cVar : this.f51501a) {
                cVar.l.onDestroy();
            }
        }
        this.f51501a.clear();
    }

    public boolean k(String str) {
        d.a.l0.j.n.c d2 = d(str);
        if (d2 != null) {
            this.f51501a.remove(d2);
            return true;
        }
        return false;
    }

    public void l() {
        m();
        for (d.a.l0.j.n.c cVar : this.f51501a) {
            cVar.l.onResume();
        }
    }

    public final void m() {
        if (this.f51507g) {
            f();
            LocationClient locationClient = this.f51504d;
            if (locationClient == null || locationClient.isStarted()) {
                return;
            }
            this.f51504d.start();
            n();
            d.a.l0.a.e0.d.l("map", "start location");
        }
    }

    public final void n() {
        if (this.f51505e) {
            return;
        }
        SensorManager sensorManager = (SensorManager) AppRuntime.getAppContext().getSystemService("sensor");
        this.f51502b = sensorManager;
        if (sensorManager != null) {
            sensorManager.registerListener(this, sensorManager.getDefaultSensor(3), 2);
            this.f51505e = true;
        }
    }

    public final void o() {
        LocationClient locationClient;
        if (this.f51507g && (locationClient = this.f51504d) != null && locationClient.isStarted()) {
            this.f51504d.stop();
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
        if (Math.abs(d2 - this.f51503c) > 1.0d) {
            for (d.a.l0.j.n.c cVar : this.f51501a) {
                MyLocationData locationData = cVar.l.getMap().getLocationData();
                if (locationData != null && cVar.k) {
                    cVar.l.getMap().setMyLocationData(new MyLocationData.Builder().direction((float) d2).accuracy(locationData.accuracy).latitude(locationData.latitude).longitude(locationData.longitude).satellitesNum(locationData.satellitesNum).build());
                    f();
                }
            }
        }
        this.f51503c = d2;
    }

    public final void p() {
        SensorManager sensorManager = this.f51502b;
        if (sensorManager == null || !this.f51505e) {
            return;
        }
        sensorManager.unregisterListener(this);
        this.f51505e = false;
    }

    public void q(boolean z) {
        if (z) {
            this.f51507g = true;
            m();
            return;
        }
        o();
        this.f51507g = false;
    }
}
