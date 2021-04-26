package d.a.j0.s.b.f;

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
import d.a.h0.a.i2.k0;
import d.a.h0.a.k;
import d.a.h0.a.w0.c.d;
import java.util.concurrent.TimeUnit;
@Singleton
@Service
/* loaded from: classes4.dex */
public class a implements d.a.h0.a.w0.c.d {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f59946c = k.f43101a;

    /* renamed from: d  reason: collision with root package name */
    public static final long f59947d = TimeUnit.MINUTES.toMillis(3);

    /* renamed from: e  reason: collision with root package name */
    public static final c f59948e = new c(null);

    /* renamed from: a  reason: collision with root package name */
    public LocationClient f59949a;

    /* renamed from: b  reason: collision with root package name */
    public LocationClientOption f59950b;

    /* renamed from: d.a.j0.s.b.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1524a implements Runnable {
        public RunnableC1524a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f59949a.requestLocation();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a {
        public b(a aVar) {
        }

        @Override // d.a.h0.a.w0.c.d.a
        public void a(d.a.h0.a.t1.k.k0.b bVar) {
            if (a.f59946c) {
                Log.i("SwanAppLocationImpl", "onWarmUpSuccess::= result=" + bVar);
            }
        }

        @Override // d.a.h0.a.w0.c.d.a
        public void onFailed(int i2) {
            if (a.f59946c) {
                Log.i("SwanAppLocationImpl", "onWarmUpFailed:: errCode=" + i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class d extends BDAbstractLocationListener {

        /* renamed from: a  reason: collision with root package name */
        public LocationClient f59954a;

        /* renamed from: b  reason: collision with root package name */
        public d.a f59955b;

        /* renamed from: c  reason: collision with root package name */
        public String f59956c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f59957d;

        public d(LocationClient locationClient, d.a aVar, String str, boolean z) {
            this.f59954a = locationClient;
            this.f59955b = aVar;
            this.f59956c = str;
            this.f59957d = z;
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            this.f59954a.unRegisterLocationListener(this);
            int locType = bDLocation.getLocType();
            if (a.r(locType)) {
                a.f59948e.e(bDLocation);
                if (this.f59957d) {
                    return;
                }
                this.f59955b.a(a.p(bDLocation, this.f59956c));
            } else if (this.f59957d) {
            } else {
                this.f59955b.onFailed(locType);
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

    public static d.a.h0.a.t1.k.k0.b p(BDLocation bDLocation, String str) {
        double longitude = bDLocation.getLongitude();
        double latitude = bDLocation.getLatitude();
        if (!TextUtils.equals(str, bDLocation.getCoorType())) {
            BDLocation n = n(latitude, longitude, str);
            longitude = n.getLongitude();
            latitude = n.getLatitude();
        }
        return new d.a.h0.a.t1.k.k0.b(str, longitude, latitude, bDLocation.getSpeed(), bDLocation.getRadius(), bDLocation.getAltitude(), bDLocation.getCountry(), bDLocation.getCountryCode(), bDLocation.getCity(), bDLocation.getCityCode(), bDLocation.getProvince(), bDLocation.getDistrict(), bDLocation.getStreet(), bDLocation.getStreetNumber());
    }

    public static boolean r(int i2) {
        return i2 == 65 || i2 == 61 || i2 == 161 || i2 == 66 || i2 == 68;
    }

    @Override // d.a.h0.a.w0.c.d
    public void a() {
    }

    @Override // d.a.h0.a.w0.c.d
    public void b(String str, boolean z, boolean z2, d.a aVar) {
        BDLocation c2 = f59948e.c(q());
        boolean z3 = c2 != null;
        if (z3) {
            aVar.a(p(c2, str));
        }
        if (this.f59949a == null) {
            this.f59949a = new LocationClient(AppRuntime.getAppContext());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setCoorType("gcj02");
            locationClientOption.setScanSpan(0);
            locationClientOption.setIgnoreKillProcess(true);
            locationClientOption.setIsNeedAddress(true);
            this.f59949a.setLocOption(locationClientOption);
            this.f59950b = locationClientOption;
            this.f59949a.start();
        }
        this.f59949a.registerLocationListener(new d(this.f59949a, aVar, str, z3));
        this.f59950b.setIsNeedAltitude(z2);
        this.f59949a.setLocOption(this.f59950b);
        k0.T(new RunnableC1524a());
    }

    @Override // d.a.h0.a.w0.c.d
    public void c() {
    }

    @Override // d.a.h0.a.w0.c.d
    public void d() {
        long q = q();
        if (f59948e.f59953b == null || (q > 0 && !f59948e.d(q))) {
            if (f59946c) {
                Log.i("SwanAppLocationImpl", "onWarmUp");
            }
            b("gcj02", false, true, new b(this));
        }
    }

    @Override // d.a.h0.a.w0.c.d
    public void e(boolean z) {
    }

    @Override // d.a.h0.a.w0.c.d
    public void f() {
    }

    @Override // d.a.h0.a.w0.c.d
    public void g(d.a aVar) {
    }

    @Override // d.a.h0.a.w0.c.d
    public double[] h(@NonNull d.a.h0.a.t1.k.k0.b bVar, @NonNull String str) {
        return o(bVar.f44572b, bVar.f44573c, bVar.f44571a, str);
    }

    @Override // d.a.h0.a.w0.c.d
    public d.a.h0.a.t1.k.k0.b i() {
        BDLocation bDLocation = f59948e.f59953b;
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
        return f59947d;
    }

    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public long f59952a;

        /* renamed from: b  reason: collision with root package name */
        public BDLocation f59953b;

        public c() {
            this.f59952a = 0L;
        }

        public synchronized BDLocation c(long j) {
            return d(j) ? this.f59953b : null;
        }

        public synchronized boolean d(long j) {
            boolean z;
            long currentTimeMillis = System.currentTimeMillis() - this.f59952a;
            boolean z2 = this.f59953b != null;
            boolean z3 = currentTimeMillis < j;
            z = z2 && z3;
            if (a.f59946c) {
                Log.i("SwanAppLocationImpl", String.format("hitCache[%b] hasInfo[%b] isAgeOk[%b] cacheAge[%d] timeout[%d]", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Long.valueOf(currentTimeMillis), Long.valueOf(j)));
            }
            return z;
        }

        public final synchronized void e(BDLocation bDLocation) {
            this.f59953b = bDLocation;
            this.f59952a = System.currentTimeMillis();
        }

        public /* synthetic */ c(RunnableC1524a runnableC1524a) {
            this();
        }
    }
}
