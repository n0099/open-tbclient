package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.TTLocation;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static long f7866a = 1800000;

    /* renamed from: b  reason: collision with root package name */
    private static Handler f7867b = new Handler(Looper.getMainLooper());

    @Nullable
    public static c a(Context context) {
        if (!com.bytedance.sdk.openadsdk.core.i.c().d().isCanUseLocation() && com.bytedance.sdk.openadsdk.core.i.c().d().getTTLocation() == null) {
            return null;
        }
        Context a2 = context == null ? com.bytedance.sdk.openadsdk.core.p.a() : context.getApplicationContext();
        f7866a = com.bytedance.sdk.openadsdk.core.p.h().m() * 60 * 1000;
        return !b(a2) ? c(a2) : d(a2);
    }

    private static boolean b(Context context) {
        long longValue = com.bytedance.sdk.openadsdk.core.d.a(context).b("lbstime", -1L).longValue();
        return longValue == -1 || System.currentTimeMillis() - longValue > f7866a;
    }

    @Nullable
    private static c c(Context context) {
        com.bytedance.sdk.openadsdk.core.d a2 = com.bytedance.sdk.openadsdk.core.d.a(context);
        float b2 = a2.b("latitude", -1.0f);
        float b3 = a2.b("longitude", -1.0f);
        if (b2 == -1.0f || b3 == -1.0f) {
            return null;
        }
        return new c(b2, b3);
    }

    private static c d(final Context context) {
        c cVar;
        c cVar2 = null;
        if (!com.bytedance.sdk.openadsdk.core.i.c().d().isCanUseLocation()) {
            try {
                TTLocation a2 = a();
                if (a2 != null) {
                    a(context, a2);
                    return new c(Double.valueOf(a2.getLatitude()).floatValue(), Double.valueOf(a2.getLongitude()).floatValue());
                }
                return null;
            } catch (Throwable th) {
                return null;
            }
        }
        final LocationManager locationManager = (LocationManager) context.getSystemService("location");
        if (locationManager != null) {
            try {
                Location a3 = a(locationManager);
                if (a3 != null && b(a3)) {
                    b(context, a3);
                    cVar2 = new c((float) a3.getLatitude(), (float) a3.getLongitude());
                }
            } catch (Throwable th2) {
                th = th2;
                cVar = null;
            }
            try {
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.utils.d.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.b(context, locationManager);
                        }
                    });
                } else {
                    b(context, locationManager);
                }
                cVar = cVar2;
            } catch (Throwable th3) {
                th = th3;
                cVar = cVar2;
                if (u.c()) {
                    th.printStackTrace();
                }
                return cVar;
            }
        } else {
            cVar = null;
        }
        return cVar;
    }

    private static Location a(LocationManager locationManager) {
        Location a2 = a(locationManager, "gps");
        if (a2 == null) {
            a2 = a(locationManager, "network");
        }
        if (a2 == null) {
            return a(locationManager, "passive");
        }
        return a2;
    }

    private static Location a(LocationManager locationManager, String str) {
        try {
            final com.bytedance.sdk.openadsdk.k.b bVar = new com.bytedance.sdk.openadsdk.k.b(new b(locationManager, str), 1, 2);
            com.bytedance.sdk.openadsdk.k.a.a().b(new com.bytedance.sdk.openadsdk.k.c() { // from class: com.bytedance.sdk.openadsdk.utils.d.2
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.k.b.this.run();
                }
            });
            return (Location) bVar.get(1L, TimeUnit.SECONDS);
        } catch (Throwable th) {
            return null;
        }
    }

    private static TTLocation a() {
        try {
            final com.bytedance.sdk.openadsdk.k.b bVar = new com.bytedance.sdk.openadsdk.k.b(new a(), 1, 2);
            com.bytedance.sdk.openadsdk.k.a.a().b(new com.bytedance.sdk.openadsdk.k.c() { // from class: com.bytedance.sdk.openadsdk.utils.d.3
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.k.b.this.run();
                }
            });
            TTLocation tTLocation = (TTLocation) bVar.get(1L, TimeUnit.SECONDS);
            u.b("AdLocationUtils", "location dev:" + tTLocation);
            return tTLocation;
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b implements Callable<Location> {

        /* renamed from: a  reason: collision with root package name */
        private LocationManager f7876a;

        /* renamed from: b  reason: collision with root package name */
        private String f7877b;

        public b(LocationManager locationManager, String str) {
            this.f7876a = locationManager;
            this.f7877b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Location call() throws Exception {
            long currentTimeMillis = System.currentTimeMillis();
            Location lastKnownLocation = this.f7876a.getLastKnownLocation(this.f7877b);
            u.b("AdLocationUtils", "location:" + lastKnownLocation + ",getLastKnownLocation use time :" + (System.currentTimeMillis() - currentTimeMillis));
            return lastKnownLocation;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a implements Callable<TTLocation> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public TTLocation call() throws Exception {
            return com.bytedance.sdk.openadsdk.core.i.c().d().getTTLocation();
        }
    }

    private static String b(LocationManager locationManager) {
        if (locationManager.isProviderEnabled("gps")) {
            return "gps";
        }
        if (locationManager.isProviderEnabled("network")) {
            return "network";
        }
        if (locationManager.isProviderEnabled("passive")) {
            return "passive";
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final Context context, final LocationManager locationManager) {
        if (context != null && locationManager != null) {
            final LocationListener locationListener = new LocationListener() { // from class: com.bytedance.sdk.openadsdk.utils.d.4
                @Override // android.location.LocationListener
                public void onLocationChanged(Location location) {
                    if (location != null && d.b(location)) {
                        d.b(context, location);
                    }
                    d.b(locationManager, this);
                }

                @Override // android.location.LocationListener
                public void onStatusChanged(String str, int i, Bundle bundle) {
                }

                @Override // android.location.LocationListener
                public void onProviderEnabled(String str) {
                }

                @Override // android.location.LocationListener
                public void onProviderDisabled(String str) {
                }
            };
            try {
                String b2 = b(locationManager);
                if (!TextUtils.isEmpty(b2)) {
                    locationManager.requestSingleUpdate(b2, locationListener, Looper.getMainLooper());
                    f7867b.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.utils.d.5
                        @Override // java.lang.Runnable
                        public void run() {
                            d.b(locationManager, locationListener);
                        }
                    }, 30000L);
                }
            } catch (Throwable th) {
                if (u.c()) {
                    th.printStackTrace();
                }
                b(locationManager, locationListener);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(LocationManager locationManager, LocationListener locationListener) {
        if (locationManager != null && locationListener != null) {
            try {
                locationManager.removeUpdates(locationListener);
            } catch (Throwable th) {
                if (u.c()) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, Location location) {
        if (b(location)) {
            com.bytedance.sdk.openadsdk.core.d a2 = com.bytedance.sdk.openadsdk.core.d.a(context);
            a2.a("latitude", (float) location.getLatitude());
            a2.a("longitude", (float) location.getLongitude());
            a2.a("lbstime", System.currentTimeMillis());
        }
    }

    private static void a(Context context, TTLocation tTLocation) {
        if (tTLocation != null && tTLocation.getLatitude() != 0.0d && tTLocation.getLongitude() != 0.0d) {
            com.bytedance.sdk.openadsdk.core.d a2 = com.bytedance.sdk.openadsdk.core.d.a(context);
            a2.a("latitude", (float) tTLocation.getLatitude());
            a2.a("longitude", (float) tTLocation.getLongitude());
            a2.a("lbstime", System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Location location) {
        return (location.getLatitude() == 0.0d || location.getLongitude() == 0.0d) ? false : true;
    }
}
