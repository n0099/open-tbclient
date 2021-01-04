package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.map.geoloclite.tsa.TencentLiteLocation;
import com.tencent.map.geoloclite.tsa.TencentLiteLocationListener;
import com.tencent.map.geoloclite.tsa.TencentLiteLocationManager;
import java.util.Random;
/* loaded from: classes3.dex */
public class v {

    /* renamed from: a  reason: collision with root package name */
    private static volatile v f12890a = null;

    /* renamed from: b  reason: collision with root package name */
    private double f12891b = 0.0d;
    private double c = 0.0d;
    private float d = 0.0f;
    private int e = 0;
    private LocationManager f = null;
    private TencentLiteLocationManager g = null;
    private LocationListener h = new LocationListener() { // from class: com.qq.e.comm.plugin.util.v.2
        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (location != null) {
                GDTLogger.d("--- LocationListener ## onLocationChanged");
                v.this.a(location);
                v.this.f();
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    };
    private TencentLiteLocationListener i = null;

    private v(Context context) {
        d(context);
    }

    public static v a(Context context) {
        if (f12890a == null) {
            synchronized (v.class) {
                try {
                    if (f12890a == null) {
                        f12890a = new v(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f12890a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Location location) {
        this.f12891b = location.getLatitude();
        this.c = location.getLongitude();
        this.d = location.getAccuracy();
        GDTLogger.d("--- Set current location: " + location.toString() + "-timeStamp: " + location.getTime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TencentLiteLocation tencentLiteLocation) {
        this.f12891b = tencentLiteLocation.getLatitude();
        this.c = tencentLiteLocation.getLongitude();
        this.d = tencentLiteLocation.getAccuracy();
        GDTLogger.d("--- Set current location from tencent location: " + ("latitude=" + this.f12891b + ", longitude=" + this.c + ", accuracy=" + this.d + "timeStamp=" + tencentLiteLocation.getTime()));
    }

    public static boolean c(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 || context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0;
    }

    private void d() {
        this.f12891b = 0.0d;
        this.c = 0.0d;
        this.d = 0.0f;
    }

    private void d(Context context) {
        b(context);
    }

    private void e() {
        this.i = new TencentLiteLocationListener() { // from class: com.qq.e.comm.plugin.util.v.3
            @Override // com.tencent.map.geoloclite.tsa.TencentLiteLocationListener
            public void onLocationChanged(TencentLiteLocation tencentLiteLocation, int i, String str) {
                if (i != 0 || tencentLiteLocation == null) {
                    GDTLogger.d("--- TencentLiteLocationListener ## update location failed, error=" + i + "resson is " + str);
                    return;
                }
                GDTLogger.d("--- TencentLiteLocationListener ## onLocationChanged");
                v.this.a(tencentLiteLocation);
                v.this.f();
            }

            @Override // com.tencent.map.geoloclite.tsa.TencentLiteLocationListener
            public void onStatusUpdate(String str, int i, String str2) {
            }
        };
    }

    private void e(Context context) {
        Random random = new Random();
        if (random.nextInt(100) < GDTADManager.getInstance().getSM().getInteger("mapSdkRatio", 0)) {
            f(context);
        } else {
            g(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        GDTLogger.d("stop request location updates.");
        if (this.f != null) {
            this.f.removeUpdates(this.h);
        }
        if (this.g != null) {
            this.g.removeUpdates(this.i);
        }
    }

    private void f(Context context) {
        try {
            this.g = TencentLiteLocationManager.getInstance(context);
            if (this.g == null) {
                GDTLogger.d("### TencentLocationManager unavailable!");
                return;
            }
            if (this.i == null) {
                e();
            }
            GDTLogger.d("use map sdk location");
            this.e = 5;
            this.g.requestLocationUpdates(0L, this.i);
        } catch (Exception e) {
            GDTLogger.w("failed to request map sdk.", e);
        }
    }

    private void g(Context context) {
        this.f = (LocationManager) context.getSystemService("location");
        if (this.f == null) {
            GDTLogger.d("### LocationManager unavailable!");
            return;
        }
        GDTLogger.d("use system location");
        this.e = 4;
        this.f.requestLocationUpdates("network", 0L, 0.0f, this.h);
    }

    public double a() {
        return this.f12891b;
    }

    public double b() {
        return this.c;
    }

    public void b(Context context) {
        if (c(context)) {
            try {
                GDTLogger.d("--- Update Location ---");
                d();
                e(context);
                new ax(30000L, 30000L) { // from class: com.qq.e.comm.plugin.util.v.1
                    @Override // com.qq.e.comm.plugin.util.ax
                    public void a() {
                        GDTLogger.d("--- TikTok: on finish");
                        v.this.f();
                        c();
                    }

                    @Override // com.qq.e.comm.plugin.util.ax
                    public void a(long j) {
                    }
                }.b();
            } catch (Exception e) {
                GDTLogger.d("Update location encounter exception: " + e.getMessage());
            }
        }
    }

    public int c() {
        return this.e;
    }
}
