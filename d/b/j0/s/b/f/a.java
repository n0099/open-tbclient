package d.b.j0.s.b.f;

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
import d.b.h0.a.i2.k0;
import d.b.h0.a.k;
import d.b.h0.a.w0.c.d;
import java.util.concurrent.TimeUnit;
@Singleton
@Service
/* loaded from: classes4.dex */
public class a implements d.b.h0.a.w0.c.d {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f61788c = k.f45772a;

    /* renamed from: d  reason: collision with root package name */
    public static final long f61789d = TimeUnit.MINUTES.toMillis(3);

    /* renamed from: e  reason: collision with root package name */
    public static final c f61790e = new c(null);

    /* renamed from: a  reason: collision with root package name */
    public LocationClient f61791a;

    /* renamed from: b  reason: collision with root package name */
    public LocationClientOption f61792b;

    /* renamed from: d.b.j0.s.b.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1585a implements Runnable {
        public RunnableC1585a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f61791a.requestLocation();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a {
        public b(a aVar) {
        }

        @Override // d.b.h0.a.w0.c.d.a
        public void a(d.b.h0.a.t1.k.k0.b bVar) {
            if (a.f61788c) {
                Log.i("SwanAppLocationImpl", "onWarmUpSuccess::= result=" + bVar);
            }
        }

        @Override // d.b.h0.a.w0.c.d.a
        public void onFailed(int i) {
            if (a.f61788c) {
                Log.i("SwanAppLocationImpl", "onWarmUpFailed:: errCode=" + i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class d extends BDAbstractLocationListener {

        /* renamed from: a  reason: collision with root package name */
        public LocationClient f61796a;

        /* renamed from: b  reason: collision with root package name */
        public d.a f61797b;

        /* renamed from: c  reason: collision with root package name */
        public String f61798c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f61799d;

        public d(LocationClient locationClient, d.a aVar, String str, boolean z) {
            this.f61796a = locationClient;
            this.f61797b = aVar;
            this.f61798c = str;
            this.f61799d = z;
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            this.f61796a.unRegisterLocationListener(this);
            int locType = bDLocation.getLocType();
            if (a.r(locType)) {
                a.f61790e.e(bDLocation);
                if (this.f61799d) {
                    return;
                }
                this.f61797b.a(a.p(bDLocation, this.f61798c));
            } else if (this.f61799d) {
            } else {
                this.f61797b.onFailed(locType);
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

    public static d.b.h0.a.t1.k.k0.b p(BDLocation bDLocation, String str) {
        double longitude = bDLocation.getLongitude();
        double latitude = bDLocation.getLatitude();
        if (!TextUtils.equals(str, bDLocation.getCoorType())) {
            BDLocation n = n(latitude, longitude, str);
            longitude = n.getLongitude();
            latitude = n.getLatitude();
        }
        return new d.b.h0.a.t1.k.k0.b(str, longitude, latitude, bDLocation.getSpeed(), bDLocation.getRadius(), bDLocation.getAltitude(), bDLocation.getCountry(), bDLocation.getCountryCode(), bDLocation.getCity(), bDLocation.getCityCode(), bDLocation.getProvince(), bDLocation.getDistrict(), bDLocation.getStreet(), bDLocation.getStreetNumber());
    }

    public static boolean r(int i) {
        return i == 65 || i == 61 || i == 161 || i == 66 || i == 68;
    }

    @Override // d.b.h0.a.w0.c.d
    public void a() {
    }

    @Override // d.b.h0.a.w0.c.d
    public void b(boolean z) {
    }

    @Override // d.b.h0.a.w0.c.d
    public void c() {
    }

    @Override // d.b.h0.a.w0.c.d
    public void d(String str, boolean z, boolean z2, d.a aVar) {
        BDLocation c2 = f61790e.c(q());
        boolean z3 = c2 != null;
        if (z3) {
            aVar.a(p(c2, str));
        }
        if (this.f61791a == null) {
            this.f61791a = new LocationClient(AppRuntime.getAppContext());
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setCoorType("gcj02");
            locationClientOption.setScanSpan(0);
            locationClientOption.setIgnoreKillProcess(true);
            locationClientOption.setIsNeedAddress(true);
            this.f61791a.setLocOption(locationClientOption);
            this.f61792b = locationClientOption;
            this.f61791a.start();
        }
        this.f61791a.registerLocationListener(new d(this.f61791a, aVar, str, z3));
        this.f61792b.setIsNeedAltitude(z2);
        this.f61791a.setLocOption(this.f61792b);
        k0.T(new RunnableC1585a());
    }

    @Override // d.b.h0.a.w0.c.d
    public void e(d.a aVar) {
    }

    @Override // d.b.h0.a.w0.c.d
    public double[] f(@NonNull d.b.h0.a.t1.k.k0.b bVar, @NonNull String str) {
        return o(bVar.f47172b, bVar.f47173c, bVar.f47171a, str);
    }

    @Override // d.b.h0.a.w0.c.d
    public void g() {
    }

    @Override // d.b.h0.a.w0.c.d
    public void h() {
        long q = q();
        if (f61790e.f61795b == null || (q > 0 && !f61790e.d(q))) {
            if (f61788c) {
                Log.i("SwanAppLocationImpl", "onWarmUp");
            }
            d("gcj02", false, true, new b(this));
        }
    }

    @Override // d.b.h0.a.w0.c.d
    public d.b.h0.a.t1.k.k0.b i() {
        BDLocation bDLocation = f61790e.f61795b;
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
        return f61789d;
    }

    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public long f61794a;

        /* renamed from: b  reason: collision with root package name */
        public BDLocation f61795b;

        public c() {
            this.f61794a = 0L;
        }

        public synchronized BDLocation c(long j) {
            return d(j) ? this.f61795b : null;
        }

        public synchronized boolean d(long j) {
            boolean z;
            long currentTimeMillis = System.currentTimeMillis() - this.f61794a;
            boolean z2 = this.f61795b != null;
            boolean z3 = currentTimeMillis < j;
            z = z2 && z3;
            if (a.f61788c) {
                Log.i("SwanAppLocationImpl", String.format("hitCache[%b] hasInfo[%b] isAgeOk[%b] cacheAge[%d] timeout[%d]", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Long.valueOf(currentTimeMillis), Long.valueOf(j)));
            }
            return z;
        }

        public final synchronized void e(BDLocation bDLocation) {
            this.f61795b = bDLocation;
            this.f61794a = System.currentTimeMillis();
        }

        public /* synthetic */ c(RunnableC1585a runnableC1585a) {
            this();
        }
    }
}
