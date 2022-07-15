package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.baidu.sofire.utility.PermissionChecker;
import com.kwad.sdk.service.ServiceProvider;
/* loaded from: classes5.dex */
public final class p {
    public static boolean a;
    public static Location b;

    @Nullable
    public static Location a(Context context) {
        if (!an.a() || an.b() == null) {
            if (a || b != null || context == null) {
                return b;
            }
            if (!an.a() && !((com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class)).a(64L)) {
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
                    com.kwad.sdk.core.d.b.b(e);
                }
            }
            return null;
        }
        return an.b();
    }

    @SuppressLint({"MissingPermission"})
    public static Location a(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, PermissionChecker.ACCESS_FINE_LOCATION) == 0) {
                Location lastKnownLocation = locationManager.getLastKnownLocation("gps");
                if (lastKnownLocation == null) {
                    a = true;
                }
                return lastKnownLocation;
            }
            return null;
        } catch (Exception e) {
            a = true;
            com.kwad.sdk.core.d.b.b(e);
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static Location b(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, PermissionChecker.ACCESS_FINE_LOCATION) == 0 || ContextCompat.checkSelfPermission(context, PermissionChecker.ACCESS_COARSE_LOCATION) == 0) {
                Location lastKnownLocation = locationManager.getLastKnownLocation("network");
                if (lastKnownLocation == null) {
                    a = true;
                }
                return lastKnownLocation;
            }
            return null;
        } catch (Exception e) {
            a = true;
            com.kwad.sdk.core.d.b.b(e);
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static Location c(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, PermissionChecker.ACCESS_COARSE_LOCATION) == 0) {
                Location lastKnownLocation = locationManager.getLastKnownLocation("passive");
                if (lastKnownLocation == null) {
                    a = true;
                }
                return lastKnownLocation;
            }
            return null;
        } catch (Exception e) {
            a = true;
            com.kwad.sdk.core.d.b.b(e);
            return null;
        }
    }
}
