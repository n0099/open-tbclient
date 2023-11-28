package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.service.ServiceProvider;
/* loaded from: classes10.dex */
public final class r {
    public static boolean aNy;
    public static Location aNz;

    @SuppressLint({"MissingPermission"})
    public static Location a(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.g) == 0) {
                Location lastKnownLocation = locationManager.getLastKnownLocation("gps");
                if (lastKnownLocation == null) {
                    aNy = true;
                }
                return lastKnownLocation;
            }
            return null;
        } catch (Exception e) {
            aNy = true;
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static Location b(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.g) == 0 || ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.h) == 0) {
                Location lastKnownLocation = locationManager.getLastKnownLocation("network");
                if (lastKnownLocation == null) {
                    aNy = true;
                }
                return lastKnownLocation;
            }
            return null;
        } catch (Exception e) {
            aNy = true;
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static Location c(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.h) == 0) {
                Location lastKnownLocation = locationManager.getLastKnownLocation("passive");
                if (lastKnownLocation == null) {
                    aNy = true;
                }
                return lastKnownLocation;
            }
            return null;
        } catch (Exception e) {
            aNy = true;
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            return null;
        }
    }

    @Nullable
    public static Location bV(Context context) {
        if (au.KF() && au.KG() != null) {
            return au.KG();
        }
        if (!aNy && aNz == null && context != null) {
            if (!au.KF() && !((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).T(64L)) {
                try {
                    LocationManager locationManager = (LocationManager) context.getSystemService("location");
                    if (locationManager.isProviderEnabled("gps")) {
                        aNz = a(context, locationManager);
                    }
                    if (aNz == null && locationManager.isProviderEnabled("network")) {
                        aNz = b(context, locationManager);
                    }
                    if (aNz == null && locationManager.isProviderEnabled("passive")) {
                        aNz = c(context, locationManager);
                    }
                    return aNz;
                } catch (Exception e) {
                    aNy = true;
                    com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                }
            }
            return null;
        }
        return aNz;
    }
}
