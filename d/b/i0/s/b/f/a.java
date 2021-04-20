package d.b.i0.s.b.f;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.b.g0.a.i2.k0;
import d.b.g0.a.k;
import d.b.g0.a.w0.c.d;
import java.util.concurrent.TimeUnit;
@Singleton
@Service
/* loaded from: classes4.dex */
public class a implements d.b.g0.a.w0.c.d {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f61367c = k.f45443a;

    /* renamed from: d  reason: collision with root package name */
    public static final long f61368d = TimeUnit.MINUTES.toMillis(3);

    /* renamed from: e  reason: collision with root package name */
    public static final c f61369e = new c(null);

    /* renamed from: a  reason: collision with root package name */
    public LocationClient f61370a;

    /* renamed from: b  reason: collision with root package name */
    public LocationClientOption f61371b;

    /* renamed from: d.b.i0.s.b.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1562a implements Runnable {
        public RunnableC1562a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f61370a.requestLocation();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a {
        public b(a aVar) {
        }

        @Override // d.b.g0.a.w0.c.d.a
        public void a(d.b.g0.a.t1.k.k0.b bVar) {
            if (a.f61367c) {
                Log.i("SwanAppLocationImpl", "onWarmUpSuccess::= result=" + bVar);
            }
        }

        @Override // d.b.g0.a.w0.c.d.a
        public void onFailed(int i) {
            if (a.f61367c) {
                Log.i("SwanAppLocationImpl", "onWarmUpFailed:: errCode=" + i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class d extends BDAbstractLocationListener {

        /* renamed from: a  reason: collision with root package name */
        public LocationClient f61375a;

        /* renamed from: b  reason: collision with root package name */
        public d.a f61376b;

        /* renamed from: c  reason: collision with root package name */
        public String f61377c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f61378d;

        public d(LocationClient locationClient, d.a aVar, String str, boolean z) {
            this.f61375a = locationClient;
            this.f61376b = aVar;
            this.f61377c = str;
            this.f61378d = z;
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            this.f61375a.unRegisterLocationListener(this);
            int locType = bDLocation.getLocType();
            if (a.r(locType)) {
                a.f61369e.e(bDLocation);
                if (this.f61378d) {
                    return;
                }
                this.f61376b.a(a.p(bDLocation, this.f61377c));
            } else if (this.f61378d) {
            } else {
                this.f61376b.onFailed(locType);
            }
        }
    }

    public static BDLocation n(double d2, double d3, String str) {
        BDLocation bDLocation = new BDLocation();
        bDLocation.setLongitude(d3);
        bDLocation.setLatitude(d2);
        if (TextUtils.equals(str, "gcj02")) {
            return bDLocation;
        }
        if (TextUtils.equals(str, BDLocation.BDLOCATION_GCJ02_TO_BD09)) {
            return LocationClient.getBDLocationInCoorType(bDLocation, BDLocation.BDLOCATION_GCJ02_TO_BD09);
        }
        if (TextUtils.equals(str, "bd09ll")) {
            return LocationClient.getBDLocationInCoorType(bDLocation, "bd09ll");
        }
        return TextUtils.equals(str, CoordinateType.WGS84) ? LocationClient.getBDLocationInCoorType(bDLocation, "gcj2wgs") : bDLocation;
    }

    public static d.b.g0.a.t1.k.k0.b p(BDLocation bDLocation, String str) {
        double longitude = bDLocation.getLongitude();
        double latitude = bDLocation.getLatitude();
        if (!TextUtils.equals(str, bDLocation.getCoorType())) {
            BDLocation n = n(latitude, longitude, str);
            longitude = n.getLongitude();
            latitude = n.getLatitude();
        }
        return new d.b.g0.a.t1.k.k0.b(str, longitude, latitude, bDLocation.getSpeed(), bDLocation.getRadius(), bDLocation.getAltitude(), bDLocation.getCountry(), bDLocation.getCountryCode(), bDLocation.getCity(), bDLocation.getCityCode(), bDLocation.getProvince(), bDLocation.getDistrict(), bDLocation.getStreet(), bDLocation.getStreetNumber());
    }

    public static boolean r(int i) {
        return i == 65 || i == 61 || i == 161 || i == 66 || i == 68;
    }

    @Override // d.b.g0.a.w0.c.d
    public void a() {
    }

    @Override // d.b.g0.a.w0.c.d
    public void b(boolean z) {
    }

    @Override // d.b.g0.a.w0.c.d
    public void c() {
    }

    @Override // d.b.g0.a.w0.c.d
    public void d(String str, boolean z, boolean z2, d.a aVar) {
        BDLocation c2 = f61369e.c(q());
        boolean z3 = c2 != null;
        if (z3) {
            aVar.a(p(c2, str));
        }
        if (this.f61370a == null) {
            this.f61370a = new LocationClient(AppRuntime.getAppContext());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setCoorType("gcj02");
            locationClientOption.setScanSpan(0);
            locationClientOption.setIgnoreKillProcess(true);
            locationClientOption.setIsNeedAddress(true);
            this.f61370a.setLocOption(locationClientOption);
            this.f61371b = locationClientOption;
            this.f61370a.start();
        }
        this.f61370a.registerLocationListener(new d(this.f61370a, aVar, str, z3));
        this.f61371b.setIsNeedAltitude(z2);
        this.f61370a.setLocOption(this.f61371b);
        k0.T(new RunnableC1562a());
    }

    @Override // d.b.g0.a.w0.c.d
    public void e(d.a aVar) {
    }

    @Override // d.b.g0.a.w0.c.d
    public double[] f(@NonNull d.b.g0.a.t1.k.k0.b bVar, @NonNull String str) {
        return o(bVar.f46843b, bVar.f46844c, bVar.f46842a, str);
    }

    @Override // d.b.g0.a.w0.c.d
    public void g() {
    }

    @Override // d.b.g0.a.w0.c.d
    public void h() {
        long q = q();
        if (f61369e.f61374b == null || (q > 0 && !f61369e.d(q))) {
            if (f61367c) {
                Log.i("SwanAppLocationImpl", "onWarmUp");
            }
            d("gcj02", false, true, new b(this));
        }
    }

    @Override // d.b.g0.a.w0.c.d
    public d.b.g0.a.t1.k.k0.b i() {
        BDLocation bDLocation = f61369e.f61374b;
        if (bDLocation == null) {
            return null;
        }
        return p(bDLocation, bDLocation.getCoorType());
    }

    public final double[] o(double d2, double d3, String str, String str2) {
        double[] dArr = new double[2];
        if (TextUtils.equals(str2, "gcj02")) {
            return dArr;
        }
        BDLocation bDLocation = new BDLocation();
        bDLocation.setLongitude(d2);
        bDLocation.setLatitude(d3);
        if (TextUtils.equals(str2, BDLocation.BDLOCATION_GCJ02_TO_BD09)) {
            bDLocation = LocationClient.getBDLocationInCoorType(bDLocation, BDLocation.BDLOCATION_GCJ02_TO_BD09);
        } else if (TextUtils.equals(str2, "bd09ll")) {
            bDLocation = LocationClient.getBDLocationInCoorType(bDLocation, "bd09ll");
        } else if (TextUtils.equals(str2, CoordinateType.WGS84)) {
            bDLocation = LocationClient.getBDLocationInCoorType(bDLocation, "gcj2wgs");
        }
        dArr[0] = bDLocation.getLongitude();
        dArr[1] = bDLocation.getLatitude();
        return dArr;
    }

    public final long q() {
        return f61368d;
    }

    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public long f61373a;

        /* renamed from: b  reason: collision with root package name */
        public BDLocation f61374b;

        public c() {
            this.f61373a = 0L;
        }

        public synchronized BDLocation c(long j) {
            return d(j) ? this.f61374b : null;
        }

        public synchronized boolean d(long j) {
            boolean z;
            long currentTimeMillis = System.currentTimeMillis() - this.f61373a;
            boolean z2 = this.f61374b != null;
            boolean z3 = currentTimeMillis < j;
            z = z2 && z3;
            if (a.f61367c) {
                Log.i("SwanAppLocationImpl", String.format("hitCache[%b] hasInfo[%b] isAgeOk[%b] cacheAge[%d] timeout[%d]", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Long.valueOf(currentTimeMillis), Long.valueOf(j)));
            }
            return z;
        }

        public final synchronized void e(BDLocation bDLocation) {
            this.f61374b = bDLocation;
            this.f61373a = System.currentTimeMillis();
        }

        public /* synthetic */ c(RunnableC1562a runnableC1562a) {
            this();
        }
    }
}
