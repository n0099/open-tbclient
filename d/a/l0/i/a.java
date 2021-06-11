package d.a.l0.i;

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
import d.a.l0.a.c1.d.d;
import d.a.l0.a.k;
import d.a.l0.a.v2.q0;
import java.util.concurrent.TimeUnit;
@Singleton
@Service
/* loaded from: classes3.dex */
public class a implements d.a.l0.a.c1.d.d {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f51488c = k.f46875a;

    /* renamed from: d  reason: collision with root package name */
    public static final long f51489d = TimeUnit.MINUTES.toMillis(3);

    /* renamed from: e  reason: collision with root package name */
    public static final c f51490e = new c(null);

    /* renamed from: a  reason: collision with root package name */
    public LocationClient f51491a;

    /* renamed from: b  reason: collision with root package name */
    public LocationClientOption f51492b;

    /* renamed from: d.a.l0.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1121a implements Runnable {
        public RunnableC1121a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f51491a.requestLocation();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a {
        public b(a aVar) {
        }

        @Override // d.a.l0.a.c1.d.d.a
        public void a(d.a.l0.a.c2.f.k0.b bVar) {
            if (a.f51488c) {
                Log.i("SwanAppLocationImpl", "onWarmUpSuccess::= result=" + bVar);
            }
        }

        @Override // d.a.l0.a.c1.d.d.a
        public void onFailed(int i2) {
            if (a.f51488c) {
                Log.i("SwanAppLocationImpl", "onWarmUpFailed:: errCode=" + i2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends BDAbstractLocationListener {

        /* renamed from: a  reason: collision with root package name */
        public LocationClient f51496a;

        /* renamed from: b  reason: collision with root package name */
        public d.a f51497b;

        /* renamed from: c  reason: collision with root package name */
        public String f51498c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f51499d;

        public d(LocationClient locationClient, d.a aVar, String str, boolean z) {
            this.f51496a = locationClient;
            this.f51497b = aVar;
            this.f51498c = str;
            this.f51499d = z;
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            this.f51496a.unRegisterLocationListener(this);
            int locType = bDLocation.getLocType();
            if (a.q(locType)) {
                a.f51490e.e(bDLocation);
                if (this.f51499d) {
                    return;
                }
                this.f51497b.a(a.o(bDLocation, this.f51498c));
            } else if (this.f51499d) {
            } else {
                this.f51497b.onFailed(locType);
            }
        }
    }

    public static BDLocation m(double d2, double d3, String str) {
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

    public static d.a.l0.a.c2.f.k0.b o(BDLocation bDLocation, String str) {
        double longitude = bDLocation.getLongitude();
        double latitude = bDLocation.getLatitude();
        if (!TextUtils.equals(str, bDLocation.getCoorType())) {
            BDLocation m = m(latitude, longitude, str);
            longitude = m.getLongitude();
            latitude = m.getLatitude();
        }
        return new d.a.l0.a.c2.f.k0.b(str, longitude, latitude, bDLocation.getSpeed(), bDLocation.getRadius(), bDLocation.getAltitude(), bDLocation.getCountry(), bDLocation.getCountryCode(), bDLocation.getCity(), bDLocation.getCityCode(), bDLocation.getProvince(), bDLocation.getDistrict(), bDLocation.getStreet(), bDLocation.getStreetNumber());
    }

    public static boolean q(int i2) {
        return i2 == 65 || i2 == 61 || i2 == 161 || i2 == 66 || i2 == 68;
    }

    @Override // d.a.l0.a.c1.d.d
    public void a() {
    }

    @Override // d.a.l0.a.c1.d.d
    public void b(String str, boolean z, boolean z2, d.a aVar) {
        BDLocation c2 = f51490e.c(p());
        boolean z3 = c2 != null;
        if (z3) {
            aVar.a(o(c2, str));
        }
        if (this.f51491a == null) {
            this.f51491a = new LocationClient(AppRuntime.getAppContext());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setCoorType("gcj02");
            locationClientOption.setScanSpan(0);
            locationClientOption.setIgnoreKillProcess(true);
            locationClientOption.setIsNeedAddress(true);
            this.f51491a.setLocOption(locationClientOption);
            this.f51492b = locationClientOption;
            this.f51491a.start();
        }
        this.f51491a.registerLocationListener(new d(this.f51491a, aVar, str, z3));
        this.f51492b.setIsNeedAltitude(z2);
        this.f51491a.setLocOption(this.f51492b);
        q0.X(new RunnableC1121a());
    }

    @Override // d.a.l0.a.c1.d.d
    public void c() {
    }

    @Override // d.a.l0.a.c1.d.d
    public void d() {
        long p = p();
        if (f51490e.f51495b == null || (p > 0 && !f51490e.d(p))) {
            if (f51488c) {
                Log.i("SwanAppLocationImpl", "onWarmUp");
            }
            b("gcj02", false, true, new b(this));
        }
    }

    @Override // d.a.l0.a.c1.d.d
    public void e() {
    }

    @Override // d.a.l0.a.c1.d.d
    public void f(d.a aVar) {
    }

    @Override // d.a.l0.a.c1.d.d
    public double[] g(@NonNull d.a.l0.a.c2.f.k0.b bVar, @NonNull String str) {
        return n(bVar.f44804b, bVar.f44805c, bVar.f44803a, str);
    }

    @Override // d.a.l0.a.c1.d.d
    public d.a.l0.a.c2.f.k0.b h() {
        BDLocation bDLocation = f51490e.f51495b;
        if (bDLocation == null) {
            return null;
        }
        return o(bDLocation, bDLocation.getCoorType());
    }

    public final double[] n(double d2, double d3, String str, String str2) {
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

    public final long p() {
        return f51489d;
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public long f51494a;

        /* renamed from: b  reason: collision with root package name */
        public BDLocation f51495b;

        public c() {
            this.f51494a = 0L;
        }

        public synchronized BDLocation c(long j) {
            return d(j) ? this.f51495b : null;
        }

        public synchronized boolean d(long j) {
            boolean z;
            long currentTimeMillis = System.currentTimeMillis() - this.f51494a;
            boolean z2 = this.f51495b != null;
            boolean z3 = currentTimeMillis < j;
            z = z2 && z3;
            if (a.f51488c) {
                Log.i("SwanAppLocationImpl", String.format("hitCache[%b] hasInfo[%b] isAgeOk[%b] cacheAge[%d] timeout[%d]", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Long.valueOf(currentTimeMillis), Long.valueOf(j)));
            }
            return z;
        }

        public final synchronized void e(BDLocation bDLocation) {
            this.f51495b = bDLocation;
            this.f51494a = System.currentTimeMillis();
        }

        public /* synthetic */ c(RunnableC1121a runnableC1121a) {
            this();
        }
    }
}
