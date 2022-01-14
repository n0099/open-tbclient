package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.kuaishou.weapon.adsdk.DeviceInfo;
/* loaded from: classes3.dex */
public class r {
    public static boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static Location f57957b;

    @Nullable
    public static Location a(Context context) {
        if (!ao.a() || ao.b() == null) {
            if (a || f57957b != null || context == null) {
                return f57957b;
            }
            if (!ao.a() && !com.kwad.sdk.core.config.b.a(64L)) {
                if (com.kwad.sdk.b.a.booleanValue()) {
                    return DeviceInfo.getLocation(context);
                }
                try {
                    LocationManager locationManager = (LocationManager) context.getSystemService("location");
                    if (locationManager.isProviderEnabled("gps")) {
                        f57957b = a(context, locationManager);
                    }
                    if (f57957b == null && locationManager.isProviderEnabled("network")) {
                        f57957b = b(context, locationManager);
                    }
                    if (f57957b == null && locationManager.isProviderEnabled("passive")) {
                        f57957b = c(context, locationManager);
                    }
                    return f57957b;
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
            if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.un.s.f55246g) == 0) {
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
            if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.un.s.f55246g) == 0 || ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.un.s.f55247h) == 0) {
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
            if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.un.s.f55247h) == 0) {
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
