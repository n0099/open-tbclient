package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.net.http.Headers;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
/* loaded from: classes4.dex */
public class l {
    @Nullable
    public static Location a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService(Headers.LOCATION);
            Location a2 = locationManager.isProviderEnabled("gps") ? a(context, locationManager) : null;
            if (a2 == null && locationManager.isProviderEnabled("network")) {
                a2 = b(context, locationManager);
            }
            return (a2 == null && locationManager.isProviderEnabled("passive")) ? c(context, locationManager) : a2;
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    private static Location a(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                return locationManager.getLastKnownLocation("gps");
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
        }
        return null;
    }

    @SuppressLint({"MissingPermission"})
    private static Location b(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0 || ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                return locationManager.getLastKnownLocation("network");
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
        }
        return null;
    }

    @SuppressLint({"MissingPermission"})
    private static Location c(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                return locationManager.getLastKnownLocation("passive");
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
        }
        return null;
    }
}
