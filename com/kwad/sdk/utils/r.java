package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.kuaishou.weapon.adsdk.DeviceInfo;
/* loaded from: classes5.dex */
public class r {
    public static boolean a;
    public static Location b;

    @Nullable
    public static Location a(Context context) {
        if (!ao.a() || ao.b() == null) {
            if (a || b != null || context == null) {
                return b;
            }
            if (!ao.a() && !com.kwad.sdk.core.config.b.a(64L)) {
                if (com.kwad.sdk.b.a.booleanValue()) {
                    return DeviceInfo.getLocation(context);
                }
                try {
                    LocationManager locationManager = (LocationManager) context.getSystemService("location");
                    if (locationManager.isProviderEnabled("gps")) {
                        b = a(context, locationManager);
                    }
                    if (b == null && locationManager.isProviderEnabled("network")) {
                        b = b(context, locationManager);
                    }
                    if (b == null && locationManager.isProviderEnabled("passive")) {
                        b = c(context, locationManager);
                    }
                    return b;
                } catch (Exception e) {
                    a = true;
                    com.kwad.sdk.core.d.a.b(e);
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
        } catch (Exception e) {
            a = true;
            com.kwad.sdk.core.d.a.b(e);
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
        } catch (Exception e) {
            a = true;
            com.kwad.sdk.core.d.a.b(e);
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
        } catch (Exception e) {
            a = true;
            com.kwad.sdk.core.d.a.b(e);
            return null;
        }
    }
}
