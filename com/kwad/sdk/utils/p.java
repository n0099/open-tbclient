package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.service.ServiceProvider;
/* loaded from: classes8.dex */
public final class p {
    public static boolean anx;
    public static Location any;

    @SuppressLint({"MissingPermission"})
    public static Location a(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.h.g) == 0) {
                Location lastKnownLocation = locationManager.getLastKnownLocation("gps");
                if (lastKnownLocation == null) {
                    anx = true;
                }
                return lastKnownLocation;
            }
            return null;
        } catch (Exception e) {
            anx = true;
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static Location b(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.h.g) == 0 || ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.h.h) == 0) {
                Location lastKnownLocation = locationManager.getLastKnownLocation("network");
                if (lastKnownLocation == null) {
                    anx = true;
                }
                return lastKnownLocation;
            }
            return null;
        } catch (Exception e) {
            anx = true;
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static Location c(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.h.h) == 0) {
                Location lastKnownLocation = locationManager.getLastKnownLocation("passive");
                if (lastKnownLocation == null) {
                    anx = true;
                }
                return lastKnownLocation;
            }
            return null;
        } catch (Exception e) {
            anx = true;
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            return null;
        }
    }

    @Nullable
    public static Location cg(Context context) {
        if (!aq.zT() || aq.zU() == null) {
            if (anx || any != null || context == null) {
                return any;
            }
            if (!aq.zT() && !((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).i(64L)) {
                try {
                    LocationManager locationManager = (LocationManager) context.getSystemService("location");
                    if (locationManager.isProviderEnabled("gps")) {
                        any = a(context, locationManager);
                    }
                    if (any == null && locationManager.isProviderEnabled("network")) {
                        any = b(context, locationManager);
                    }
                    if (any == null && locationManager.isProviderEnabled("passive")) {
                        any = c(context, locationManager);
                    }
                    return any;
                } catch (Exception e) {
                    anx = true;
                    com.kwad.sdk.core.e.b.printStackTraceOnly(e);
                }
            }
            return null;
        }
        return aq.zU();
    }
}
