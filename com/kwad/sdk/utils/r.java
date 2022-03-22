package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.kuaishou.weapon.adsdk.DeviceInfo;
/* loaded from: classes7.dex */
public class r {
    public static boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static Location f41406b;

    @Nullable
    public static Location a(Context context) {
        if (!ao.a() || ao.b() == null) {
            if (a || f41406b != null || context == null) {
                return f41406b;
            }
            if (!ao.a() && !com.kwad.sdk.core.config.b.a(64L)) {
                if (com.kwad.sdk.b.a.booleanValue()) {
                    return DeviceInfo.getLocation(context);
                }
                try {
                    LocationManager locationManager = (LocationManager) context.getSystemService("location");
                    if (locationManager.isProviderEnabled("gps")) {
                        f41406b = a(context, locationManager);
                    }
                    if (f41406b == null && locationManager.isProviderEnabled("network")) {
                        f41406b = b(context, locationManager);
                    }
                    if (f41406b == null && locationManager.isProviderEnabled("passive")) {
                        f41406b = c(context, locationManager);
                    }
                    return f41406b;
                } catch (Exception e2) {
                    a = true;
                    com.kwad.sdk.core.d.a.b(e2);
                }
            }
            return null;
        }
        return ao.b();
    }

    @SuppressLint({"MissingPermission"})
    public static Location a(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                Location lastKnownLocation = locationManager.getLastKnownLocation("gps");
                if (lastKnownLocation == null) {
                    a = true;
                }
                return lastKnownLocation;
            }
            return null;
        } catch (Exception e2) {
            a = true;
            com.kwad.sdk.core.d.a.b(e2);
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static Location b(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0 || ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                Location lastKnownLocation = locationManager.getLastKnownLocation("network");
                if (lastKnownLocation == null) {
                    a = true;
                }
                return lastKnownLocation;
            }
            return null;
        } catch (Exception e2) {
            a = true;
            com.kwad.sdk.core.d.a.b(e2);
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static Location c(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                Location lastKnownLocation = locationManager.getLastKnownLocation("passive");
                if (lastKnownLocation == null) {
                    a = true;
                }
                return lastKnownLocation;
            }
            return null;
        } catch (Exception e2) {
            a = true;
            com.kwad.sdk.core.d.a.b(e2);
            return null;
        }
    }
}
