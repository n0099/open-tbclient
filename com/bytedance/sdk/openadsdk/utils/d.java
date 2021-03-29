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
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import com.bytedance.sdk.openadsdk.TTLocation;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static long f30400a = 1800000;

    /* renamed from: b  reason: collision with root package name */
    public static c f30401b;

    /* renamed from: c  reason: collision with root package name */
    public static long f30402c;

    /* renamed from: d  reason: collision with root package name */
    public static Handler f30403d = new Handler(Looper.getMainLooper());

    /* loaded from: classes6.dex */
    public static class a implements Callable<TTLocation> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public TTLocation call() throws Exception {
            return com.bytedance.sdk.openadsdk.core.i.d().e().getTTLocation();
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements Callable<Location> {

        /* renamed from: a  reason: collision with root package name */
        public LocationManager f30412a;

        /* renamed from: b  reason: collision with root package name */
        public String f30413b;

        public b(LocationManager locationManager, String str) {
            this.f30412a = locationManager;
            this.f30413b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Location call() throws Exception {
            long currentTimeMillis = System.currentTimeMillis();
            Location lastKnownLocation = this.f30412a.getLastKnownLocation(this.f30413b);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            u.b("AdLocationUtils", "location:" + lastKnownLocation + ",getLastKnownLocation use time :" + currentTimeMillis2);
            return lastKnownLocation;
        }
    }

    public static c c(final Context context) {
        c cVar = null;
        if (!com.bytedance.sdk.openadsdk.core.i.d().e().isCanUseLocation()) {
            try {
                TTLocation b2 = b();
                if (b2 != null) {
                    return new c(Double.valueOf(b2.getLatitude()).floatValue(), Double.valueOf(b2.getLongitude()).floatValue(), System.currentTimeMillis());
                }
            } catch (Throwable unused) {
            }
            return null;
        }
        final LocationManager locationManager = (LocationManager) context.getSystemService("location");
        if (locationManager != null) {
            try {
                Location a2 = a(locationManager);
                if (a2 != null && b(a2)) {
                    cVar = new c((float) a2.getLatitude(), (float) a2.getLongitude(), System.currentTimeMillis());
                }
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.utils.d.2
                        @Override // java.lang.Runnable
                        public void run() {
                            d.b(context, locationManager);
                        }
                    });
                } else {
                    b(context, locationManager);
                }
            } catch (Throwable th) {
                if (u.c()) {
                    th.printStackTrace();
                }
            }
        }
        return cVar;
    }

    public static TTLocation b() {
        try {
            final com.bytedance.sdk.openadsdk.l.f fVar = new com.bytedance.sdk.openadsdk.l.f(new a(), 1, 2);
            com.bytedance.sdk.openadsdk.l.e.a(new com.bytedance.sdk.openadsdk.l.g("getLastKnownLocation") { // from class: com.bytedance.sdk.openadsdk.utils.d.4
                @Override // java.lang.Runnable
                public void run() {
                    fVar.run();
                }
            });
            TTLocation tTLocation = (TTLocation) fVar.get(1L, TimeUnit.SECONDS);
            u.b("AdLocationUtils", "location dev:" + tTLocation);
            return tTLocation;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Nullable
    public static c a(Context context) {
        if (com.bytedance.sdk.openadsdk.core.i.d().e().isCanUseLocation() || com.bytedance.sdk.openadsdk.core.i.d().e().getTTLocation() != null) {
            c cVar = f30401b;
            final Context a2 = context == null ? com.bytedance.sdk.openadsdk.core.p.a() : context.getApplicationContext();
            u.b("AdLocationUtils", "Location cache time =", Long.valueOf(f30400a));
            if (f30401b != null && !a()) {
                return f30401b;
            }
            String a3 = com.bytedance.sdk.openadsdk.core.i.a("sdk_ad_location", f30400a);
            if (!TextUtils.isEmpty(a3)) {
                try {
                    JSONObject jSONObject = new JSONObject(a3);
                    String string = jSONObject.getString("latitude");
                    String string2 = jSONObject.getString("longitude");
                    long j = jSONObject.getLong("lbstime");
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                        f30401b = new c(Float.valueOf(string).floatValue(), Float.valueOf(string2).floatValue(), j);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (a()) {
                f30402c = System.currentTimeMillis();
                u.c("AdLocationUtils", "Locating ...");
                com.bytedance.sdk.openadsdk.l.e.a(new com.bytedance.sdk.openadsdk.l.g("getLocation c") { // from class: com.bytedance.sdk.openadsdk.utils.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c c2 = d.c(a2);
                        if (c2 != null) {
                            try {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("latitude", Float.toString(c2.f30397a));
                                jSONObject2.put("longitude", Float.toString(c2.f30398b));
                                jSONObject2.put("lbstime", c2.f30399c);
                                com.bytedance.sdk.openadsdk.core.i.a("sdk_ad_location", jSONObject2.toString());
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            c unused = d.f30401b = c2;
                        }
                    }
                });
            }
            if (f30401b == null) {
                f30401b = cVar;
                u.c("AdLocationUtils", "Use the last valid location");
            }
            return f30401b;
        }
        return null;
    }

    public static String b(LocationManager locationManager) {
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

    public static void b(Context context, final LocationManager locationManager) {
        if (context == null || locationManager == null) {
            return;
        }
        final LocationListener locationListener = new LocationListener() { // from class: com.bytedance.sdk.openadsdk.utils.d.5
            @Override // android.location.LocationListener
            public void onLocationChanged(Location location) {
                if (location != null) {
                    d.b(location);
                }
                d.b(locationManager, this);
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
        try {
            String b2 = b(locationManager);
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            locationManager.requestSingleUpdate(b2, locationListener, Looper.getMainLooper());
            f30403d.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.utils.d.6
                @Override // java.lang.Runnable
                public void run() {
                    d.b(locationManager, locationListener);
                }
            }, StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD);
        } catch (Throwable th) {
            if (u.c()) {
                th.printStackTrace();
            }
            b(locationManager, locationListener);
        }
    }

    public static void b(LocationManager locationManager, LocationListener locationListener) {
        if (locationManager == null || locationListener == null) {
            return;
        }
        try {
            locationManager.removeUpdates(locationListener);
        } catch (Throwable th) {
            if (u.c()) {
                th.printStackTrace();
            }
        }
    }

    public static boolean b(Location location) {
        return (location.getLatitude() == 0.0d || location.getLongitude() == 0.0d) ? false : true;
    }

    public static boolean a() {
        return System.currentTimeMillis() - f30402c > f30400a;
    }

    public static Location a(LocationManager locationManager) {
        Location a2 = a(locationManager, "gps");
        if (a2 == null) {
            a2 = a(locationManager, "network");
        }
        return a2 == null ? a(locationManager, "passive") : a2;
    }

    public static Location a(LocationManager locationManager, String str) {
        try {
            final com.bytedance.sdk.openadsdk.l.f fVar = new com.bytedance.sdk.openadsdk.l.f(new b(locationManager, str), 1, 2);
            com.bytedance.sdk.openadsdk.l.e.a(new com.bytedance.sdk.openadsdk.l.g("getLastKnownLocation") { // from class: com.bytedance.sdk.openadsdk.utils.d.3
                @Override // java.lang.Runnable
                public void run() {
                    fVar.run();
                }
            });
            return (Location) fVar.get(1L, TimeUnit.SECONDS);
        } catch (Throwable unused) {
            return null;
        }
    }
}
