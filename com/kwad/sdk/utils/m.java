package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
/* loaded from: classes6.dex */
public class m {
    @Nullable
    public static Location a(Context context) {
        if (context == null || com.kwad.sdk.core.config.c.a(64L)) {
            return null;
        }
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            Location a2 = locationManager.isProviderEnabled("gps") ? a(context, locationManager) : null;
            if (a2 == null && locationManager.isProviderEnabled("network")) {
                a2 = b(context, locationManager);
            }
            return (a2 == null && locationManager.isProviderEnabled("passive")) ? c(context, locationManager) : a2;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static Location a(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                return locationManager.getLastKnownLocation("gps");
            }
            return null;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static Location b(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0 || ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                return locationManager.getLastKnownLocation("network");
            }
            return null;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static Location c(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                return locationManager.getLastKnownLocation("passive");
            }
            return null;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
            return null;
        }
    }
}
