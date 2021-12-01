package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kuaishou.weapon.adsdk.DeviceInfo;
/* loaded from: classes2.dex */
public class r {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static Location f59662b;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static Location a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (!ao.a() || ao.b() == null) {
                if (a || f59662b != null || context == null) {
                    return f59662b;
                }
                if (!ao.a() && !com.kwad.sdk.core.config.b.a(64L)) {
                    if (com.kwad.sdk.b.a.booleanValue()) {
                        return DeviceInfo.getLocation(context);
                    }
                    try {
                        LocationManager locationManager = (LocationManager) context.getSystemService("location");
                        if (locationManager.isProviderEnabled("gps")) {
                            f59662b = a(context, locationManager);
                        }
                        if (f59662b == null && locationManager.isProviderEnabled("network")) {
                            f59662b = b(context, locationManager);
                        }
                        if (f59662b == null && locationManager.isProviderEnabled("passive")) {
                            f59662b = c(context, locationManager);
                        }
                        return f59662b;
                    } catch (Exception e2) {
                        a = true;
                        com.kwad.sdk.core.d.a.b(e2);
                    }
                }
                return null;
            }
            return ao.b();
        }
        return (Location) invokeL.objValue;
    }

    @SuppressLint({"MissingPermission"})
    public static Location a(Context context, LocationManager locationManager) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, locationManager)) == null) {
            try {
                if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.un.s.f56842g) == 0) {
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
        return (Location) invokeLL.objValue;
    }

    @SuppressLint({"MissingPermission"})
    public static Location b(Context context, LocationManager locationManager) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, locationManager)) == null) {
            try {
                if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.un.s.f56842g) == 0 || ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.un.s.f56843h) == 0) {
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
        return (Location) invokeLL.objValue;
    }

    @SuppressLint({"MissingPermission"})
    public static Location c(Context context, LocationManager locationManager) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, locationManager)) == null) {
            try {
                if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.un.s.f56843h) == 0) {
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
        return (Location) invokeLL.objValue;
    }
}
