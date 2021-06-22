package d.a.m0.i;

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
import d.a.m0.a.c1.d.d;
import d.a.m0.a.k;
import d.a.m0.a.v2.q0;
import java.util.concurrent.TimeUnit;
@Singleton
@Service
/* loaded from: classes3.dex */
public class a implements d.a.m0.a.c1.d.d {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f51596c = k.f46983a;

    /* renamed from: d  reason: collision with root package name */
    public static final long f51597d = TimeUnit.MINUTES.toMillis(3);

    /* renamed from: e  reason: collision with root package name */
    public static final c f51598e = new c(null);

    /* renamed from: a  reason: collision with root package name */
    public LocationClient f51599a;

    /* renamed from: b  reason: collision with root package name */
    public LocationClientOption f51600b;

    /* renamed from: d.a.m0.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1124a implements Runnable {
        public RunnableC1124a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f51599a.requestLocation();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a {
        public b(a aVar) {
        }

        @Override // d.a.m0.a.c1.d.d.a
        public void a(d.a.m0.a.c2.f.k0.b bVar) {
            if (a.f51596c) {
                Log.i("SwanAppLocationImpl", "onWarmUpSuccess::= result=" + bVar);
            }
        }

        @Override // d.a.m0.a.c1.d.d.a
        public void onFailed(int i2) {
            if (a.f51596c) {
                Log.i("SwanAppLocationImpl", "onWarmUpFailed:: errCode=" + i2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends BDAbstractLocationListener {

        /* renamed from: a  reason: collision with root package name */
        public LocationClient f51604a;

        /* renamed from: b  reason: collision with root package name */
        public d.a f51605b;

        /* renamed from: c  reason: collision with root package name */
        public String f51606c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f51607d;

        public d(LocationClient locationClient, d.a aVar, String str, boolean z) {
            this.f51604a = locationClient;
            this.f51605b = aVar;
            this.f51606c = str;
            this.f51607d = z;
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            this.f51604a.unRegisterLocationListener(this);
            int locType = bDLocation.getLocType();
            if (a.q(locType)) {
                a.f51598e.e(bDLocation);
                if (this.f51607d) {
                    return;
                }
                this.f51605b.a(a.o(bDLocation, this.f51606c));
            } else if (this.f51607d) {
            } else {
                this.f51605b.onFailed(locType);
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

    public static d.a.m0.a.c2.f.k0.b o(BDLocation bDLocation, String str) {
        double longitude = bDLocation.getLongitude();
        double latitude = bDLocation.getLatitude();
        if (!TextUtils.equals(str, bDLocation.getCoorType())) {
            BDLocation m = m(latitude, longitude, str);
            longitude = m.getLongitude();
            latitude = m.getLatitude();
        }
        return new d.a.m0.a.c2.f.k0.b(str, longitude, latitude, bDLocation.getSpeed(), bDLocation.getRadius(), bDLocation.getAltitude(), bDLocation.getCountry(), bDLocation.getCountryCode(), bDLocation.getCity(), bDLocation.getCityCode(), bDLocation.getProvince(), bDLocation.getDistrict(), bDLocation.getStreet(), bDLocation.getStreetNumber());
    }

    public static boolean q(int i2) {
        return i2 == 65 || i2 == 61 || i2 == 161 || i2 == 66 || i2 == 68;
    }

    @Override // d.a.m0.a.c1.d.d
    public void a() {
    }

    @Override // d.a.m0.a.c1.d.d
    public void b(String str, boolean z, boolean z2, d.a aVar) {
        BDLocation c2 = f51598e.c(p());
        boolean z3 = c2 != null;
        if (z3) {
            aVar.a(o(c2, str));
        }
        if (this.f51599a == null) {
            this.f51599a = new LocationClient(AppRuntime.getAppContext());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setCoorType("gcj02");
            locationClientOption.setScanSpan(0);
            locationClientOption.setIgnoreKillProcess(true);
            locationClientOption.setIsNeedAddress(true);
            this.f51599a.setLocOption(locationClientOption);
            this.f51600b = locationClientOption;
            this.f51599a.start();
        }
        this.f51599a.registerLocationListener(new d(this.f51599a, aVar, str, z3));
        this.f51600b.setIsNeedAltitude(z2);
        this.f51599a.setLocOption(this.f51600b);
        q0.X(new RunnableC1124a());
    }

    @Override // d.a.m0.a.c1.d.d
    public void c() {
    }

    @Override // d.a.m0.a.c1.d.d
    public void d() {
        long p = p();
        if (f51598e.f51603b == null || (p > 0 && !f51598e.d(p))) {
            if (f51596c) {
                Log.i("SwanAppLocationImpl", "onWarmUp");
            }
            b("gcj02", false, true, new b(this));
        }
    }

    @Override // d.a.m0.a.c1.d.d
    public void e() {
    }

    @Override // d.a.m0.a.c1.d.d
    public void f(d.a aVar) {
    }

    @Override // d.a.m0.a.c1.d.d
    public double[] g(@NonNull d.a.m0.a.c2.f.k0.b bVar, @NonNull String str) {
        return n(bVar.f44912b, bVar.f44913c, bVar.f44911a, str);
    }

    @Override // d.a.m0.a.c1.d.d
    public d.a.m0.a.c2.f.k0.b h() {
        BDLocation bDLocation = f51598e.f51603b;
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
        return f51597d;
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public long f51602a;

        /* renamed from: b  reason: collision with root package name */
        public BDLocation f51603b;

        public c() {
            this.f51602a = 0L;
        }

        public synchronized BDLocation c(long j) {
            return d(j) ? this.f51603b : null;
        }

        public synchronized boolean d(long j) {
            boolean z;
            long currentTimeMillis = System.currentTimeMillis() - this.f51602a;
            boolean z2 = this.f51603b != null;
            boolean z3 = currentTimeMillis < j;
            z = z2 && z3;
            if (a.f51596c) {
                Log.i("SwanAppLocationImpl", String.format("hitCache[%b] hasInfo[%b] isAgeOk[%b] cacheAge[%d] timeout[%d]", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Long.valueOf(currentTimeMillis), Long.valueOf(j)));
            }
            return z;
        }

        public final synchronized void e(BDLocation bDLocation) {
            this.f51603b = bDLocation;
            this.f51602a = System.currentTimeMillis();
        }

        public /* synthetic */ c(RunnableC1124a runnableC1124a) {
            this();
        }
    }
}
